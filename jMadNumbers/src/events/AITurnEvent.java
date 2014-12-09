package events;

import java.awt.Point;

import model.Model;
import view.View;

/**
 * AI turn handling
 * @author Jakub Maleszewski
 * @since 2014-12-07
 */
public class AITurnEvent extends BoardEvent
{
    private Point position;
    private static final Boolean isAiTurn = true;

    
    public void process(final View view, final Model model)
    {
        position = model.getAIDecision();
        //TODO remove this debug code
        System.out.println(position.x);
        System.out.println(position.y);
        
        model.clickBoardItem(position.x, position.y, isAiTurn);
        view.setPointsMock(model.getPointsMock());
        view.setActivityMock(model.getActivityMock());
        view.setVisibilityMock(model.getVisibilityMock());
        view.checkIfGameOver(model.getActivityMock(), model.getVisibilityMock());
    }

}
