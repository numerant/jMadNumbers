package view;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Class responsible for creating status bar in main application window.
 * Status bar contains actual score.
 */

public class StatusBar
{
    private View view;
        /* Status bar items */
    private JPanel statusBarPanel;
    private JLabel playerScoreLabel;
    private JLabel playerScoreValue;
    private JLabel aiScoreLabel;
    private JLabel aiScoreValue;
    
    StatusBar(final View view)
    {
        this.view = view;
        createStatusBarItems();
        showStatusBar();
    }
    
    /**
     * Creates status bar with its items
     */
    void createStatusBarItems()
    {
        statusBarPanel = new JPanel();
        statusBarPanel.setLayout(new BoxLayout(statusBarPanel, BoxLayout.X_AXIS));

        aiScoreLabel = new JLabel("AI score:");
        aiScoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusBarPanel.add(aiScoreLabel);
        
        aiScoreValue = new JLabel("");
        statusBarPanel.add(aiScoreValue);
        
        statusBarPanel.add(Box.createHorizontalGlue());
        
        playerScoreLabel = new JLabel("Player score:");
        playerScoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusBarPanel.add(playerScoreLabel);
        
        playerScoreValue = new JLabel("");
        statusBarPanel.add(playerScoreValue);
    }
    
    /**
     * Adds status bar panel to the main window
     */
    void showStatusBar()
    {
        view.addPanel(statusBarPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Setter for playerScoreValue
     * @param score - number to set
     */
    public void setPlayerScoreValue(final Integer score)
    {
        playerScoreValue.setText(score.toString());
    }
    
    /**
     * Setter for aiScoreValue
     * @param score - number to set
     */
    public void setAiScoreValue(final Integer score)
    {
        aiScoreValue.setText(score.toString());
    }
}
