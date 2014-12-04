package events;

import model.Model;
import view.View;

/**
 * Board generation event
 * @author Jakub Maleszewski
 * @author Michal Zolyniak
 * @since 2014-05-26
 */
public class GenerateBoardEvent extends BoardEvent
{
    private Integer size;
    
    public GenerateBoardEvent(Integer size)
    {
        this.size = size;
    }
    
    /**
     * Notifies view that the board panel should be created now
     */
    public void process(final View view, final Model model)
    {
        view.setPlayerScore(0);
        view.setAiScore(0);
        view.createBoardPanel(size);
        model.generateBoard(size);
        view.setPointsMock(model.getPointsMock());
        view.setActivityMock(model.getActivityMock());
    }

}
