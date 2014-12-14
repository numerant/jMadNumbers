package events;

import model.Model;
import view.View;


public class ShowAiDuelOptionsEvent extends BoardEvent
{

    /**
     * Tell the view to show AI duel options window
     */
    public void process(View view, Model model)
    {
        view.showAiDuelOptionsWindow();
    }

}
