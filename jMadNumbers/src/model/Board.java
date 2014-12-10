package model;

/**
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
				pointsMock[i][j] = board[i][j].getNumber();
				visibilityMock[i][j] = board[i][j].getVisible();
				activityMock[i][j] = board[i][j].getActive();
			}
		}	
		this.setRowActive(size/2);
	}
	
	public Board(String level)
	{
		if(level == "novice")
		{
			this.generateNoviceBoard();
		}
		else if(level == "master")
		{
			this.generateMasterBoard();			
		}
		else if(level == "legendary")
		{
			this.generateLegendaryBoard();
		}
	}
	
	private void generateNoviceBoard()
	{
		Integer values[][] = 	{	{9,-3,10,2,-2,-1,8,-5	},
														{-7,10,2,-10,3,-7,7,4	},
														{3,-11,6,-9,10,-5,11,2},
														{4,3,-4,7,-11,4,8,-10	},
														{10,-11,4,-5,9,-5,8,2	},
														{-6,2,4,-8,9,-9,-5,-3	},
														{2,-3,9,11,10,-3,-2,-5},
														{2,9,-5,9,-8,-1,-1,-9	} };
		
		this.size = 8;
		this.fillBoard(values);
	}
	
	private void generateMasterBoard()
	{
		Integer values[][] = 	{	{4,10,8,2,10,-1,-5,-11,-7,7,2,9			},
														{1,10,4,-2,-8,-10,-7,-9,6,-11,-4,-1	},
														{-9,-3,7,-4,-5,-8,-9,9,10,-11,9,8 	},
														{-3,9,10,4,-4,-7,-3,2,9,-8,9,7			},
														{-7,1,-11,9,10,1,-9,-1,5,-2,2,-5		},
														{11,-3,-3,-8,-10,-5,-4,-4,4,11,-2,11},
														{11,9,4,-4,3,-11,4,1,5,4,1,-4 			},
														{9,-4,3,5,20,-6,5,-11,-5,-4,4,6 		}, 
														{-8,1,4,8,7,2,8,-1,-5,8,1,-4				},
														{-4,-11,-9,-11,6,-6,4,-8,11,5,10,11	},
														{-5,-3,3,10,-8,-7,-2,10,10,-3,-7,7	},
														{-4,2,1,-1,3,-8,-10,-7,6,-1,6,5			} };
		
		this.size = 12;
		this.fillBoard(values);
	}
	
	private void generateLegendaryBoard()
	{
		Integer values[][] = 	{	{-9,-6,-2,-8,-9,7,-7,6,3,9,-7,5,-4,4,-6,-3 			},
														{5,-10,2,2,-1,-11,4,2,6,-2,5,2,-4,-8,-7,-5 			},
														{-7,9,10,10,10,4,1,-5,6,-6,-11,3,-5,3,-5,8			},
														{-11,8,-7,10,7,-6,-10,-2,-6,-10,9,-4,-6,-8,4,-10},
														{5,7,2,8,8,-2,7,11,10,3,11,3,6,-3,-9,-8 				},
														{1,-8,3,2,-9,9,-7,-9,-11,4,2,4,7,-2,-8,-2 			},
														{3,-2,-4,-1,-6,5,3,11,-2,7,-2,-11,-6,-4,3,6 		},
														{5,-10,-11,-5,6,4,-7,1,-6,-7,-3,-4,-1,-4,-11,10 },
														{-6,11,7,-7,-5,-2,7,1,-8,8,-4,-6,4,2,5,-8 			},
														{-11,-2,-5,-1,9,8,6,2,-8,-11,10,-10,5,7,-5,-10 	},
														{2,-4,-4,-5,2,-3,-7,2,7,-7,-9,7,-8,4,5,-8 			},
														{-3,-10,4,7,-1,-3,-9,-8,9,1,-8,7,-1,-6,10,5 		},
														{1,-6,-1,-5,-6,-5,-7,4,-8,-2,-5,-4,1,3,7,-6 		},
														{-11,-1,1,9,-8,-3,5,8,-8,-10,3,9,3,-3,-11,2 		},
														{9,7,-4,-9,-5,-5,-3,-2,6,3,8,11,-1,1,-10,-7 		},
														{-5,4,-4,7,-6,9,-2,11,3,-5,1,-5,-5,-8,8,-10 		} };
		
		this.size = 16;
		this.fillBoard(values);
	}
	
private void fillBoard(Integer values[][])
	{
		board = new BoardItem[size][size];
		
		pointsMock = new Integer[size][size];
		visibilityMock = new Boolean[size][size];
		activityMock = new Boolean[size][size];
		
		for(Integer i = 0; i < size; ++i)
		{
			for(Integer j = 0; j < size; j++)
			{
				if(values[i][j] > 0)
				{
					new BoardItem(Math.abs(values[i][j]), true);
				}
				else
				{
					new BoardItem(Math.abs(values[i][j]), false);
				}
				pointsMock[i][j] = board[i][j].getNumber();
				visibilityMock[i][j] = board[i][j].getVisible();
				activityMock[i][j] = board[i][j].getActive();
			}
		}	
		this.setRowActive(size/2);
	}
	
	
	private Integer[][] copy(Integer[][] input)
	{
	      Integer[][] target = new Integer[input.length][];
	      for (int i=0; i <input.length; i++)
	      {
	    	  target[i] = new Integer[input[i].length];
	    	  System.arraycopy(input[i], 0, target[i], 0, input[i].length);
	      }
	      return target;
	}
	
	private Boolean[][] copy(Boolean[][] input)
	{
	      Boolean[][] target = new Boolean[input.length][];
	      for (int i=0; i <input.length; i++)
	      {
	    	  target[i] = new Boolean[input[i].length];
	    	  System.arraycopy(input[i], 0, target[i], 0, input[i].length);
	      }
	      return target;
	}
	
	public Object clone()
	{
		Board newBoard = new Board(size);
		//newBoard.board = board.clone();
		newBoard.pointsMock = copy(pointsMock);
		newBoard.visibilityMock = copy(visibilityMock);
		newBoard.activityMock = copy(activityMock);
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
		return board[x][y].getNumber();
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
