package view;

import javax.swing.*;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.BlockingQueue;

import events.BoardEvent;

/**
 * Class representing view in MVC. Creates interface and main window.
 * 
 * @author Jakub Maleszewski
 * @since 2014-05-18
 */

public class View
{
    private BlockingQueue<BoardEvent> eventQueue; 
    private JFrame frame;
    private GameBoard board;
    private StatusBar statusBar;

    /**
     * Constructor - sets event queue for communication with controller and calls (in EDT) method responsible for creation of GUI
     */
    public View(final BlockingQueue<BoardEvent> eventQueue)
    {
        this.eventQueue = eventQueue;
        
        try
        {
            EventQueue.invokeAndWait(new Runnable()
            {
                public void run() 
                {
                    createAndShowGUI();
                }
            });
        }
        catch (InvocationTargetException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Creates the application main window.
     */
    private void createAndShowGUI()
    {
        createMainWindow();
        new MainMenu(this);
        statusBar = new StatusBar(this);
        
        frame.setSize(400, 400);
        
        frame.setResizable(false);              //Due to bug in Java positioning does not work as intended
        frame.setLocationByPlatform(true);      //when both setResizable() and setLocationByPlatform() are used
        frame.setVisible(true);
        frame.setTitle("jMadNumbers");
    }

    /**
     * Initializes the content of the frame.
     */
    private void createMainWindow()
    {
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
            /* Some frame properties - default size and positioning */
        frame = new JFrame();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
    }
    
    /**
     * Sends an event to the controller event queue
     * @param event - {@link BoardEvent} event to send
     */
    public void sendBoardEvent(final BoardEvent event)
    {
        eventQueue.offer(event);
    }
    
    /**
     * Sets the default menu bar of application main window
     * @param menuBar - {@link JMenuBar} object to set as main menu
     */
    public void setMenuBar (final JMenuBar menuBar)
    {
        frame.setJMenuBar(menuBar);
    }
    
    /**
     * Adds panel to the main window
     * Doesn't need to run in EDT, as it's called by methods already running in this thread
     * @param panel - {@link JPanel} object to add
     * @param layout - {@link BorderLayout} layout type string
     */
    public void addPanel (final JPanel panel, final String layout)
    {
        frame.getContentPane().add(panel, layout);
        frame.pack();
    }

    /**
     * Hides maze panel
     */
    public void hideMazePanel()
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                board.getBoardPanel().setVisible(false);
            }
        });
    }
    
    /**
     * Removes previous game panel from the main window and creates new one.
     * 
     * @param size - size of the new maze
     */
    public void createBoardPanel(final Integer size)
    {
        final View view = this;
        EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                    /* Remove previous panel if it does exist */
                if (board != null)       
                {
                    frame.getContentPane().remove(board.getBoardPanel());
                    board = null;
                }
                
                    /* Create new maze panel and show it */
                board = new GameBoard(view, size);
                
            }
        });
    }
    
    /**
     * Updates on-screen board using a new points mock
     * Makes board panel visible after update (useful when staring a new game)
     * @param mock - mock to update panel with
     */
    public void setPointsMock (final Integer[][] mock)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                board.updatePointsFromMock(mock);
                board.showBoard();
            }
        });
    }
    
    /**
     * Sets activity mock
     */
    public void setActivityMock (final Boolean[][] mock)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                board.updateActivityFromMock(mock);
                board.showBoard();
            }
        });
    }
    
    /**
     * Sets visibility mock
     */
    public void setVisibilityMock (final Boolean[][] mock)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                board.updateVisibilityFromMock(mock);
                board.showBoard();
            }
        });
    }
    
    /**
     * Wrapper for checking if there are still any available choices
     * @param activityMock
     * @param visibilityMock
     */
    public Boolean checkIfGameOver(final Boolean[][] activityMock, final Boolean[][] visibilityMock)
    {
        return board.checkIfGameOver(activityMock, visibilityMock);
    }
    
    /**
     * Wrapper for setting player score on status bar
     * @param score - score to set as label
     */
    public void setPlayerScore(final Integer score)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                statusBar.setPlayerScoreValue(score);
            }
        });
    }
    
    /**
     * Wrapper for setting AI score on status bar
     * @param score - score to set as label
     */
    public void setAiScore(final Integer score)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                statusBar.setAiScoreValue(score);
            }
        });
    }
    
    /**
     * Shows specified message as a message box on the screen.
     * @param message - message to show
     */
    public void showMessage(final String message, final String title)
    {
        try
        {
            EventQueue.invokeAndWait(new Runnable()
            {
                public void run() 
                {
                    JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Wrapper method for showing help dialog.
     */
    public void showHelp()
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new HelpWindow(frame);
            }
        });
    }
}
