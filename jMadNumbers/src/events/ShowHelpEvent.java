package events;

import modelOld.Model;
import view.View;

/**
 * Shows the help dialog
 * 
 * @author Jakub Maleszewski
 * @since 2014-05-29
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
