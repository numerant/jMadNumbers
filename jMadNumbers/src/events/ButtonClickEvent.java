package events;

import model.Model;
import view.View;

/**
 * Event handling maze item rotation
 * @author Jakub Maleszewski
 * @since 2014-05-26
 */
public class ButtonClickEvent extends BoardEvent
{
    private Integer xPosition;
    private Integer yPosition;
    
    public ButtonClickEvent(Integer xPosition, Integer yPosition)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    
    public void process(final View view, final Model model)
    {
        //model.rotateItem(xPosition, yPosition);
    }

}