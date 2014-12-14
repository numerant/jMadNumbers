package model;

import java.awt.Point;

import view.AiDuelOptionsWindow;

public class AIDuelSupporter
{
    
    private String aiFirstType;
    private String aiSecondType;
    private Integer boardSize;
    private Integer iterationCount;
    private Model model;
    private AiDuelOptionsWindow optionsWindow;
    
    private Point position;
    
    private Integer scoreDifferenceValues[];
    private Integer aiFirstWinCount;
    private Integer aiSecondWinCount;
    private Integer drawCount;
    
    private String messageForGUI = "";
    
    
    
    public AIDuelSupporter(Model model, AiDuelOptionsWindow optionsWindow)
    {
        this.model = model;
        this.optionsWindow = optionsWindow;
    }
    
    public final String getMessageForGUI()
    {
        return messageForGUI;
    }
    
    private final Double getScoreDifferencesVariance()
    {
        Double averageScoreDifference = getAverageScoreDifference();
        Double sum = 0.0;
        
        for (double scoreDifference : scoreDifferenceValues) {
            sum += (scoreDifference-averageScoreDifference)*(scoreDifference-averageScoreDifference);
         }
        Double variance = sum/(scoreDifferenceValues.length-1);
        
        return variance;
    }
    
    private final Double getAverageScoreDifference()
    {
        Double scoreDifferencesSum = 0.0;
        for (Integer scoreDifference : scoreDifferenceValues)
        {
            scoreDifferencesSum += scoreDifference;
        }
        return (scoreDifferencesSum/iterationCount);
    }
    
    private Boolean checkIfGameOver(final Boolean[][] activityMock, final Boolean[][] visibilityMock)
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
        scoreDifferenceValues = new Integer[iterationCount];
        aiFirstWinCount = 0;
        aiSecondWinCount = 0;
        drawCount = 0;
        
        for(int currentIteration = 0; currentIteration < iterationCount; currentIteration++)
        {
            optionsWindow.setProgress(currentIteration, iterationCount);
            
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
            
                // save score difference (for variance)
            scoreDifferenceValues[currentIteration] = (aiFirstScore - aiSecondScore);
            
            
            
        }
        
        Double averageScoreDifference = getAverageScoreDifference();
        Double scoreDifferencesVariance = getScoreDifferencesVariance();
        
        messageForGUI = "<html>Results:<br>AI 1 (" + aiFirstType + ") win count: " + aiFirstWinCount.toString() 
                + "<br>AI 2 (" + aiSecondType + ") win count: " + aiSecondWinCount.toString() 
                + "<br>Draw count: " + drawCount.toString()
                + "<br> Average score difference: " + averageScoreDifference
                + "<br> Variance of score differences: " + scoreDifferencesVariance
                + "</html>";
        
    }
    
}
