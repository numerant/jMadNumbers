package events;

import java.awt.Point;

import model.Model;
import view.View;

/**
 * AI turn handling
 */
public class AITurnEvent extends BoardEvent
{
    private Point position;
    private static final Boolean isAiTurn = true;

    
    public void process(final View view, final Model model)
    {
        position = model.getAIDecision();
        
        model.clickBoardItem(position.x, position.y, isAiTurn);
        view.setPointsMock(model.getPointsMock());
        view.setActivityMock(model.getActivityMock());
        view.setVisibilityMock(model.getVisibilityMock());
        view.checkIfGameOver(model.getActivityMock(), model.getVisibilityMock());
    }

}
