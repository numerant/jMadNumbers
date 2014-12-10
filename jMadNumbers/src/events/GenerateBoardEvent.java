package events;

import model.Model;
import view.View;

/**
 * Board generation event
 */
public class GenerateBoardEvent extends BoardEvent
{
    private Integer size;
    private String difficultyLevel;
    
    public GenerateBoardEvent(Integer size)
    {
        this.size = size;
    }
    
    public GenerateBoardEvent(String difficultyLevel)
    {
        this.difficultyLevel = difficultyLevel;
        this.size = -1;
    }
    
    /**
     * Notifies view that the board panel should be created now
     */
    public void process(final View view, final Model model)
    {
        view.setPlayerScore(0);
        view.setAiScore(0);
        
        if (difficultyLevel.equals("novice"))
        {
            view.createBoardPanel(8);
            model.generateNoviceBoard();
        }
        else if (difficultyLevel.equals("master"))
        {
            view.createBoardPanel(12);
            model.generateMasterBoard();
        }
        else if (difficultyLevel.equals("legendary"))
        {
            view.createBoardPanel(16);
            model.generateLegendaryBoard();
        }
        else
        {
            view.createBoardPanel(size);
            model.generateBoard(size);
        }
        
        view.setPointsMock(model.getPointsMock());
        view.setActivityMock(model.getActivityMock());
        view.setVisibilityMock(model.getVisibilityMock());
    }

}
