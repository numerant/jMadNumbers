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
    private Boolean isAiTurn;
    
    public ButtonClickEvent(Integer xPosition, Integer yPosition, Boolean isAiTurn)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.isAiTurn = isAiTurn;
    }
    
    public void process(final View view, final Model model)
    {
        model.clickBoardItem(xPosition, yPosition, false);
        view.setPointsMock(model.getPointsMock());
        view.setActivityMock(model.getActivityMock());
    }

}
