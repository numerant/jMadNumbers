package model;

/**
 * 
 * @author Michal Zolyniak
 * @since 2014-11-30
 *
 */

public class Board implements Cloneable
{
	private BoardItem board[][];
	private Integer size;
	private Integer pointsMock[][];
	private Boolean visibilityMock[][];
	private Boolean activityMock[][];
		
	public Board(Integer size)
	{
		this.size = size;
		board = new BoardItem[size][size];
		pointsMock = new Integer[size][size];
		visibilityMock = new Boolean[size][size];
		activityMock = new Boolean[size][size];
		for(Integer i = 0; i < size; ++i)
		{
			for(Integer j = 0; j < size; j++)
			{
				board[i][j] = new BoardItem(size);
				pointsMock[i][j] = board[i][j].getDigit();
				visibilityMock[i][j] = board[i][j].getVisible();
				activityMock[i][j] = board[i][j].getActive();
			}
		}	
	}
	
	public Object clone()
	{
		Board newBoard = new Board(size);
		newBoard.board = board.clone();
		newBoard.pointsMock = pointsMock.clone();
		newBoard.visibilityMock = visibilityMock.clone();
		newBoard.activityMock = activityMock.clone();
		return newBoard;
	}
	
	public void setColumnActive(Integer y)
	{
		for(Integer i = 0; i < size; ++i)
		{
			board[i][y].setActive(true);
			activityMock[i][y] = true;
		}
	}
	
	public void setColumnInactive(Integer y)
	{
		for(Integer i = 0; i < size; ++i)
		{
			board[i][y].setActive(false);
			activityMock[i][y] = false;
		}
	}
	
	public void setRowActive(Integer x)
	{
		for(Integer i = 0; i < size; ++i)
		{
			board[x][i].setActive(true);
			activityMock[x][i] = true;
		}
	}
	
	public void setRowInactive(Integer x)
	{
		for(Integer i = 0; i < size; ++i)
		{
			board[x][i].setActive(false);
			activityMock[x][i] = false;	
		}
	}
	
	public void hideBoardItem(Integer x, Integer y)
	{
		board[x][y].setVisible(false);
		visibilityMock[x][y] = false;
	}
	
	public Integer getPoints(Integer x, Integer y)
	{
		return board[x][y].getDigit();
	}
	
	public Integer[][] getPointsMock()
	{
		return pointsMock;
	}
	
	public Boolean[][] getVisibilityMock()
	{
		return visibilityMock;
	}
	
	public Boolean[][] getActivityMock()
	{
		return activityMock;
	}
}
