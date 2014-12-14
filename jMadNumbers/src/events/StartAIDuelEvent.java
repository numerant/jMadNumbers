package events;

import model.AIDuelSupporter;
import model.Model;
import view.AiDuelOptionsWindow;
import view.View;


public class StartAIDuelEvent extends BoardEvent
{
    private AIDuelSupporter aiDuelSupporter;
    private String aiFirstType;
    private String aiSecondType;
    private Integer boardSize;
    private Integer iterationCount;
    private AiDuelOptionsWindow optionsWindow;
    
    public StartAIDuelEvent(final String aiFirstType, final String aiSecondType, final Integer boardSize, final Integer iterationCount, final AiDuelOptionsWindow optionsWindow)
    {
        this.aiFirstType = aiFirstType;
        this.aiSecondType = aiSecondType;
        this.boardSize = boardSize;
        this.iterationCount = iterationCount;
        this.optionsWindow = optionsWindow;
    }
    
    public void process(View view, Model model)
    {
        aiDuelSupporter = new AIDuelSupporter(model, optionsWindow);
        aiDuelSupporter.setDuelParameters(aiFirstType, aiSecondType, boardSize, iterationCount);
        aiDuelSupporter.startTheWar();
        view.showMessage(aiDuelSupporter.getMessageForGUI(), "War is over");
    }

}
