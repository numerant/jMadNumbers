package events;

import model.Model;
import view.View;

/**
 * Abstract class representing application events
 */

public abstract class BoardEvent
{
    /**
     * Abstract process() method describes what should be done in response to the event. It is called from the controller.
     */
    public abstract void process(final View view, final Model model);
}
