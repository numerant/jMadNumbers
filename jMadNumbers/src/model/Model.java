package model;

import java.awt.Point;

import view.View;

/**
 * 
 */

public class Model
{
	private View view;
	private Board board;
	private Integer playerScore;
	private Integer aiScore;
	private Boolean aiTurn;
	
	public Model(final View view)
	{
		this.view = view;
		this.aiTurn = false;
	}

	public void generateBoard(Integer size)
	{
		board = new Board(size);
		playerScore = 0;
		aiScore = 0;
	}
	
	public void generateNoviceBoard()
	{
		board = new Board("novice");
		playerScore = 0;
		aiScore = 0;
	}
	
	public Point getAIDecision()
	{
        return AI.MinMaxDecision(board, playerScore, aiScore);
	}
	
	public void clickBoardItem(Integer x, Integer y, Boolean AIturn)
	{
		this.aiTurn = AIturn;
		if(this.aiTurn){
			 aiScore += board.getPoints(x,y);
			 board.setColumnInactive(y);
			 board.setRowActive(x);
			 board.hideBoardItem(x,y);
			 
			 view.setAiScore(aiScore);
		}
		else
		{
			 playerScore += board.getPoints(x,y);
			 board.setRowInactive(x);
			 board.setColumnActive(y);
			 board.hideBoardItem(x,y);
			 
			 view.setPlayerScore(playerScore);
		}
		return;
	}
	
	public Integer[][] getPointsMock()
	{
		return board.getPointsMock();
	}
	
	public Boolean[][] getVisibilityMock()
	{
		return board.getVisibilityMock();
	}
	
	public Boolean[][] getActivityMock()
	{
		return board.getActivityMock();
	}
	
	public Integer getAiScore()
	{
	    return aiScore;
	}
	public Integer getPlayerScore()
	{
	    return playerScore;
	}
}