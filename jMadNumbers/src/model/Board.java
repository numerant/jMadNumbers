package model;

/**
 * 
 * @author Michal Zolyniak
 * @since 2014-11-30
 *
 */

public class Board 
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
	
	public void setColumnActive(Integer y)
	{
		for(Integer i = 0; i < size; ++i)
		{
			board[i][y].setActive(true);
		}
	}
	
	public void setColumnInactive(Integer y)
	{
		for(Integer i = 0; i < size; ++i)
		{
			board[i][y].setActive(false);
		}
	}
	
	public void setRowActive(Integer x)
	{
		for(Integer i = 0; i < size; ++i)
		{
			board[x][i].setActive(true);
		}
	}
	
	public void setRowInactive(Integer x)
	{
		for(Integer i = 0; i < size; ++i)
		{
			board[x][i].setActive(false);
		}
	}
	
	public void hideBoardItem(Integer x, Integer y)
	{
		board[x][y].setVisible(false);
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
