package model;

import view.View;

/**
 * 
 * @author Michal Zolyniak
 * @since 2014-11-29
 *
 */

public class Model
{
	private View view;
	private Board board;
	private Integer playerScore;
	private Integer AIscore;
	private Boolean AIturn;
	
	public Model(final View view)
	{
		this.view = view;
		this.AIturn = false;
	}

	public void generateBoard(Integer size)
	{
		board = new Board(size);
	}
		
	public void clickBoardItem(Integer x, Integer y, Boolean AIturn)
	{
		this.AIturn = AIturn;
		if(this.AIturn){
			 AIscore += board.getPoints(x,y);
			 board.setColumnInactive(y);
			 board.setRowActive(x);
			 board.hideBoardItem(x,y);
		}
		else
		{
			 playerScore += board.getPoints(x,y);
			 board.setRowInactive(x);
			 board.setColumnActive(y);
			 board.hideBoardItem(x,y);
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
}