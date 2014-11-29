package events;

import modelOld.Model;
import view.View;

/**
 * Abstract class representing application events
 * 
 * @author Jakub Maleszewski
 * @since 2014-05-25
 */

public abstract class BoardEvent
{
    /**
     * Abstract process() method describes what should be done in response to the event. It is called from the controller.
     */
    public abstract void process(final View view, final Model model);
}
