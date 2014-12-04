package events;

import model.Model;
import view.View;

/**
 * Shows About message
 * @author Jakub Maleszewski
 * @since 2014-05-29
 */
public class GameOverEvent extends BoardEvent
{
    private Integer moveCount;
    
    public GameOverEvent (final Integer moveCount)
    {
        this.moveCount = moveCount;
    }
    
    /**
     * Tell the view to create new message box
     */
    //TODO replace messages
    public void process(View view, Model model)
    {
        String message = "<html>You won this game!<br>Moves: " + moveCount.toString() +"</html>";
        String title = "Congratulations!";

        view.showMessage(message, title);
        view.hideMazePanel();
    }

}
