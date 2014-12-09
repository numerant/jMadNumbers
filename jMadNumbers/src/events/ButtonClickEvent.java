package events;

import model.Model;
import view.View;

/**
 * Event handling maze item rotation
 */
public class ButtonClickEvent extends BoardEvent
{
    private Integer xPosition;
    private Integer yPosition;
    private final static Boolean isAiTurn = false;
    private Boolean isGameOver;
    
    public ButtonClickEvent(Integer xPosition, Integer yPosition)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    
    public void process(final View view, final Model model)
    {
        model.clickBoardItem(xPosition, yPosition, isAiTurn);
        view.setPointsMock(model.getPointsMock());
        view.setActivityMock(model.getActivityMock());
        view.setVisibilityMock(model.getVisibilityMock());
        
        isGameOver = view.checkIfGameOver(model.getActivityMock(), model.getVisibilityMock());
        
        if(!isGameOver)
            view.sendBoardEvent(new AITurnEvent());
    }

}
