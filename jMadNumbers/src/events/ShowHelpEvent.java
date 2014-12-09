package events;

import model.Model;
import view.View;

/**
 * Shows the help dialog
 */
public class ShowHelpEvent extends BoardEvent
{

    /**
     * Tell the view to show help window
     */
    public void process(View view, Model model)
    {
        view.showHelp();
    }

}
