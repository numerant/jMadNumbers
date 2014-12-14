package model;

import java.awt.Point;

public class AIDuelSupporter
{
    
    private String aiFirstType;
    private String aiSecondType;
    private Integer boardSize;
    private Integer iterationCount;
    private Model model;
    
    private Point position;
    
    private Double scoreDifferencesSum;
    private Integer aiFirstWinCount;
    private Integer aiSecondWinCount;
    private Integer drawCount;
    
    private String messageForGUI = "";
    
    
    
    public AIDuelSupporter(Model model)
    {
        this.model = model;
    }
    
    public final String getMessageForGUI()
    {
        return messageForGUI;
    }
    
    public Boolean checkIfGameOver(final Boolean[][] activityMock, final Boolean[][] visibilityMock)
    {
        for (int xCurrent = 0; xCurrent < boardSize; xCurrent++)
            for (int yCurrent = 0; yCurrent < boardSize; yCurrent++)
            {
                if (activityMock[xCurrent][yCurrent].equals(true) && (visibilityMock[xCurrent][yCurrent].equals(true)))
                {
                    return false;
                }
            }
        return true;
        
    }
    
    public void setDuelParameters(final String aiFirstType, final String aiSecondType, final Integer boardSize, final Integer iterationCount)
    {
        this.aiFirstType = aiFirstType;
        this.aiSecondType = aiSecondType;
        this.boardSize = boardSize;
        this.iterationCount = iterationCount;
    }
    
    public void startTheWar()
    {
        scoreDifferencesSum = 0.0;
        aiFirstWinCount = 0;
        aiSecondWinCount = 0;
        drawCount = 0;
        
        for(int i = 0; i < iterationCount; i++)
        {
            model.generateBoard(boardSize);
            
            /*
             * while there are still some active points on board 
             */
            while( !checkIfGameOver(model.getActivityMock(), model.getVisibilityMock()))
            {
                model.setAIType(aiFirstType);
                position = model.getAIDecision();
                
                model.clickBoardItem(position.x, position.y, true);     //let's assume that first AI is really AI and the second AI is player
                
                if(checkIfGameOver(model.getActivityMock(), model.getVisibilityMock()))
                    break;
                
                model.setAIType(aiSecondType);
                position = model.getAIDecision();
                
                model.clickBoardItem(position.x, position.y, false);
            }
            
            /*
             * Update statistics
             */
            Integer aiFirstScore = model.getAiScore();
            Integer aiSecondScore = model.getPlayerScore();
            
                // win/draw count
            if (aiFirstScore > aiSecondScore)
                aiFirstWinCount++;
            else if (aiFirstScore < aiSecondScore)
                aiSecondWinCount++;
            else
                drawCount++;
            
            
            scoreDifferencesSum += (aiFirstScore - aiSecondScore);
            
        }
        
        messageForGUI = "<html>Results:<br>AI 1 (" + aiFirstType + ") win count: " + aiFirstWinCount.toString() 
                + "<br>AI 2 (" + aiSecondType + ") win count: " + aiSecondWinCount.toString() 
                + "<br>Draw count: " + drawCount.toString()
                + "<br> Average score difference: " + scoreDifferencesSum/iterationCount
                + "</html>";
        
        System.out.println( scoreDifferencesSum/iterationCount + " " + aiFirstWinCount + " " + aiSecondWinCount + " " + drawCount );
        
    }
    
}
