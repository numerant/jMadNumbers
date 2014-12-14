package events;

import model.Model;
import view.View;

/**
 * Event generated on change of active AI type
 *
 */
public class AITypeChangeEvent extends BoardEvent
{
    private String aiType;
    
    public AITypeChangeEvent(final String aiType)
    {
        this.aiType = aiType;
    }
    
    public void process(final View view, final Model model)
    {
        model.setAIType(aiType);        
    }

}
