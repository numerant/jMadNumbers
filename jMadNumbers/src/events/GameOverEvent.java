package events;

import model.Model;
import view.View;

/**
 * Shows About message
 */
public class GameOverEvent extends BoardEvent
{
    private Integer aiScore;
    private Integer playerScore;
    
    private String message;
    private String title;
    
    /**
     * Tell the view to create new message box
     */
    public void process(View view, Model model)
    {
        title = "Game over!";
        
        aiScore = model.getAiScore();
        playerScore = model.getPlayerScore();
        
        if (playerScore > aiScore)
            message = "<html>You won!<br>Your score: " + playerScore.toString() + "<br>AI score: " + aiScore.toString() + "</html>";
        else if (playerScore.equals(aiScore))
            message = "<html>It's a draw!<br>Your score: " + playerScore.toString() + "<br>AI score: " + aiScore.toString() + "</html>";
        else
            message = "<html>You lost!<br>Your score: " + playerScore.toString() + "<br>AI score: " + aiScore.toString() + "</html>";
        

        view.showMessage(message, title);
        view.hideMazePanel();
    }

}
