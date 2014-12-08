package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukasz Waclawski
 * @since 2014-12-05
 *
 */

public class AI
{
	static public Point MinMaxDecision(Board board, Integer playerScore, Integer AIScore)
	{
		GameState state = new GameState(board, playerScore, AIScore, true);
		Integer maxValue = Integer.MIN_VALUE;
		Point maxArgument = null;
    	
		if (state.isGameOver())
		{
			System.out.println("MinMaxCalled for game over!");
		}
		
    	for (Point move : state.listMoves())
    	{
    		Integer currentValue = MinValue(state.makeMove(move), 8);
    		if (currentValue > maxValue)
    		{
    			maxValue = currentValue;
    			maxArgument = move;
    		}
    	}
    	
    	return maxArgument;
	}
	
    static private Integer MaxValue(GameState state, Integer depth)
    {
    	System.out.println("Max");
    	if (state.isGameOver() || depth == 0)
    	{
    		return state.getScoresDifference();
    	}
    	
    	Integer maxValue = Integer.MIN_VALUE;
    	
    	for (Point move : state.listMoves())
    	{
    		maxValue = Math.max(maxValue, MinValue(state.makeMove(move), depth-1));
    	}
    	
    	return maxValue;
    }
    
    static private Integer MinValue(GameState state, Integer depth)
    {
    	System.out.println("Min");
    	if (state.isGameOver() || depth == 0)
    	{
    		return state.getScoresDifference();
    	}
    	
    	Integer minValue = Integer.MAX_VALUE;
    	
    	for (Point move : state.listMoves())
    	{
    		minValue = Math.min(minValue, MaxValue(state.makeMove(move), depth-1));
    	}
    	
    	return minValue;
    }
    
}

class GameState
{
	private final Board board;
	private final Integer playerScore;
	private final Integer AIScore;
	private final Boolean AITurn;
	
	public GameState(Board board, Integer playerScore, Integer AIScore, Boolean AITurn)
	{
		this.board = board;
		this.playerScore = playerScore;
		this.AIScore = AIScore;
		this.AITurn = AITurn;
	}
	
	public GameState makeMove(Point position)
	{
		Board newBoard = (Board) board.clone();
    	Integer newPlayerScore = playerScore;
    	Integer newAIScore = AIScore;
    	Integer x = (int) position.getX();
    	Integer y = (int) position.getY();
    	
    	if(AITurn){
    		 newAIScore += board.getPoints(x,y);
			 newBoard.setColumnInactive(y);
			 newBoard.setRowActive(x);
			 newBoard.hideBoardItem(x,y);	 
		}
		else
		{
			 newPlayerScore += board.getPoints(x,y);
			 newBoard.setRowInactive(x);
			 newBoard.setColumnActive(y);
			 newBoard.hideBoardItem(x,y);	 
		}
    	
    	return new GameState(newBoard, newPlayerScore, newAIScore, !AITurn);
	}
	
	public List<Point> listMoves()
    {
        List<Point> result = new ArrayList<Point>();
        Boolean[][] visible = board.getVisibilityMock();
        Boolean[][] active = board.getActivityMock();

        for (Integer i = 0; i < visible.length; ++i)
        {
            for (Integer j = 0; j < visible[i].length; ++j)
            {
                if (visible[i][j] && active[i][j])
                {
                    result.add(new Point(i, j));
                }
            }
        }

        return result;
    }
	
	public Integer getScoresDifference()
	{
		return AIScore - playerScore;
	}
	
	public Boolean isGameOver()
	{System.out.println("MinMaxCalled for game over!" + listMoves().isEmpty());
		return listMoves().isEmpty();
	}
}
