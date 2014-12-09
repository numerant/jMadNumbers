package events;

import model.Model;
import view.View;

/**
 * Shows About message
 */
public class ShowAboutEvent extends BoardEvent
{

    /**
     * Tell the view to create new message box
     */
    public void process(View view, Model model)
    {
        String message = "<html>jMadNumbers by:<br><br>Jakub Maleszewski<br>Lukasz Waclawski<br>Michal Zolyniak</html>";
        String title = "About";

        view.showMessage(message, title);
    }

}
