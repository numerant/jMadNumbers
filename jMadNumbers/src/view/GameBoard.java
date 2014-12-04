package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import events.ButtonClickEvent;
import view.BoardButton;

/**
 * Class responsible for creation of Mad Numbers board in the main window
 * @author Jakub Maleszewski
 * @since 2014-05-25
 */
 
public class GameBoard
{
    private View view;
        /* Panel containing maze */
    private Integer boardSize;
    private JPanel boardPanel;
    private BoardButton[][] boardButtons;
    private static final Integer BUTTON_SIZE_PX = 64;
    
    /**
     * @param view - specifies view used to send events
     * @param size - size of the square maze
     */
    public GameBoard(final View view, final Integer size)
    {
        this.view = view;
        this.boardSize = size;
        
        createBoardPanel();
        showBoard();
    }
    
    /** 
     * Creates board panel with buttons.
     * Adds buttons to the mazeButtons array
     */
    private void createBoardPanel()
    {
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(boardSize, boardSize, 0, 0));
        
        boardButtons = new BoardButton[boardSize][boardSize];
        
        for (int yCurrent = 0; yCurrent < boardSize; yCurrent++)
            for (int xCurrent = 0; xCurrent < boardSize; xCurrent++)
            {
                final BoardButton newButton = new BoardButton("");
                newButton.setPreferredSize(new Dimension(BUTTON_SIZE_PX, BUTTON_SIZE_PX));
               
                addOnClickActionListener(newButton, xCurrent, yCurrent);
                
                
                boardPanel.add(newButton);
                boardButtons[xCurrent][yCurrent] = newButton;
            }
    }

    /**
     * Updates images on board buttons using a mock
     * @param mock
     */
    public void updatePointsFromMock(final Integer[][] mock)
    {
        for (int yCurrent = 0; yCurrent < boardSize; yCurrent++)
            for (int xCurrent = 0; xCurrent < boardSize; xCurrent++)
            {
                boardButtons[xCurrent][yCurrent].setText( mock[xCurrent][yCurrent].toString() );
            }
    }
    
    /**
     * Updates activity state of buttons
     * @param mock
     */
    public void updateActivityFromMock(Boolean[][] mock)
    {
        for (int yCurrent = 0; yCurrent < boardSize; yCurrent++)
            for (int xCurrent = 0; xCurrent < boardSize; xCurrent++)
            {
                if (mock[xCurrent][yCurrent].equals(true))      //TODO is mock in model generated properly?
                    boardButtons[xCurrent][yCurrent].setActive();
                else
                    boardButtons[xCurrent][yCurrent].setInactive();
            }
        
    }
    
    /**
     * Adds {@link ShowButtonCoordinatesEvent} {@link ActionListener} to the specified button
     * @param button - BoardButton object, which we add a listener to
     * @param xPosition - horizontal position of the button in the board
     * @param yPosition - vertical position of the button in the board
     */
    private void addOnClickActionListener(final BoardButton button, final int xPosition, final int yPosition)
    {
        button.addActionListener(new ActionListener()
        {                 
            public void actionPerformed(ActionEvent event)
            {
                // now it's player's turn - setting isAiTurn to false
                view.sendBoardEvent(new ButtonClickEvent(xPosition, yPosition, false));
            }
        });
    }
    
    /**
     * Adds board panel to the main window
     */
    public void showBoard()
    {
        
        view.addPanel(boardPanel, BorderLayout.CENTER);
    }
    
    /**
     * Returns reference to the JPanel object associated with current board.
     * Useful for removing panel from main window.
     * @return JPanel - associated panel
     */
    public JPanel getBoardPanel()
    {
        return boardPanel;
    }

}


