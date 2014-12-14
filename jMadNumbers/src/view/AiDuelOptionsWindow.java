package view;

import javax.swing.JDialog;
import javax.swing.JPanel; 
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.border.EtchedBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import events.StartAIDuelEvent;

public class AiDuelOptionsWindow extends JDialog
{
    private static final long serialVersionUID = 181378790847582836L;
    
    /* How difficult are difficulty levels */
    private final Integer DIFFICULTY_EASY_SIZE = 5;
    private final Integer DIFFICULTY_MEDIUM_SIZE = 7;
    private final Integer DIFFICULTY_HARD_SIZE = 8;
    private final Integer DIFFICULTY_VERY_HARD_SIZE = 10;
    
    private final JPanel aiFirstTypePanel = new JPanel();
    private final ButtonGroup difficultyButtonGroup = new ButtonGroup();
    private final ButtonGroup aiSecondTypeButtonGroup = new ButtonGroup();
    private final ButtonGroup aiFirstTypeButtonGroup = new ButtonGroup();
    private View view;
    
    private String aiFirstType = "minmax";
    private String aiSecondType = "minmax";
    private Integer boardSize = 5;
    private Integer iterationCount = 10;
    
    public AiDuelOptionsWindow(final JFrame mainWindow, View view)
    {
        super(mainWindow, "AI Duel", ModalityType.APPLICATION_MODAL);
        this.view = view;
        createDialog();
        showDialog();
    }
    
    /**
     * Show the dialog
     */
    private void showDialog()
    {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
    }

    /**
     * Create the dialog
     */
    private void createDialog() 
    {
        setSize(250, 200);
        //setResizable(false);
        
        /*
         * First AI panel
         */
        aiFirstTypePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        getContentPane().add(aiFirstTypePanel, BorderLayout.WEST);
        GridBagLayout gbl_aiFirstTypePanel = new GridBagLayout();
        aiFirstTypePanel.setLayout(gbl_aiFirstTypePanel);
        
        JLabel aiFirstTypeLabel = new JLabel("AI 1 type:");
        GridBagConstraints gbc_aiFirstTypeLabel = new GridBagConstraints();
        gbc_aiFirstTypeLabel.gridx = 0;
        gbc_aiFirstTypeLabel.gridy = 0;
        aiFirstTypePanel.add(aiFirstTypeLabel, gbc_aiFirstTypeLabel);
        
        Component aiFirstPanelTopStrut = Box.createVerticalStrut(20);
        GridBagConstraints gbc_aiFirstPanelTopStrut = new GridBagConstraints();
        gbc_aiFirstPanelTopStrut.gridx = 0;
        gbc_aiFirstPanelTopStrut.gridy = 1;
        aiFirstTypePanel.add(aiFirstPanelTopStrut, gbc_aiFirstPanelTopStrut);
        
        JRadioButton aiFirstMinMaxRadioButton = new JRadioButton("MinMax");
        aiFirstMinMaxRadioButton.setSelected(true);
        aiFirstMinMaxRadioButton.addActionListener(new ActionListener()
        {                 
            public void actionPerformed(ActionEvent event)
            {
                aiFirstType = "minmax";
            }
        });
        aiFirstTypeButtonGroup.add(aiFirstMinMaxRadioButton);
        GridBagConstraints gbc_aiFirstMinMaxRadioButton = new GridBagConstraints();
        gbc_aiFirstMinMaxRadioButton.anchor = GridBagConstraints.NORTHWEST;
        gbc_aiFirstMinMaxRadioButton.gridx = 0;
        gbc_aiFirstMinMaxRadioButton.gridy = 2;
        aiFirstTypePanel.add(aiFirstMinMaxRadioButton, gbc_aiFirstMinMaxRadioButton);
        
        JRadioButton aiFirstGreedyRadioButton = new JRadioButton("Greedy");
        aiFirstGreedyRadioButton.addActionListener(new ActionListener()
        {                 
            public void actionPerformed(ActionEvent event)
            {
                aiFirstType = "greedy";
            }
        });
        aiFirstTypeButtonGroup.add(aiFirstGreedyRadioButton);
        GridBagConstraints gbc_aiFirstGreedyRadioButton = new GridBagConstraints();
        gbc_aiFirstGreedyRadioButton.anchor = GridBagConstraints.NORTHWEST;
        gbc_aiFirstGreedyRadioButton.gridx = 0;
        gbc_aiFirstGreedyRadioButton.gridy = 3;
        aiFirstTypePanel.add(aiFirstGreedyRadioButton, gbc_aiFirstGreedyRadioButton);
        
        JRadioButton aiFirstStupidRadioButton = new JRadioButton("Stupid");
        aiFirstStupidRadioButton.addActionListener(new ActionListener()
        {                 
            public void actionPerformed(ActionEvent event)
            {
                aiFirstType = "stupid";
            }
        });
        aiFirstTypeButtonGroup.add(aiFirstStupidRadioButton);
        GridBagConstraints gbc_aiFirstStupidRadioButton = new GridBagConstraints();
        gbc_aiFirstStupidRadioButton.anchor = GridBagConstraints.NORTHWEST;
        gbc_aiFirstStupidRadioButton.gridx = 0;
        gbc_aiFirstStupidRadioButton.gridy = 4;
        aiFirstTypePanel.add(aiFirstStupidRadioButton, gbc_aiFirstStupidRadioButton);
        
        Component aiFirstPanelBottomStrut = Box.createVerticalStrut(20);
        GridBagConstraints gbc_aiFirstPanelBottomStrut = new GridBagConstraints();
        gbc_aiFirstPanelBottomStrut.gridx = 0;
        gbc_aiFirstPanelBottomStrut.gridy = 5;
        aiFirstTypePanel.add(aiFirstPanelBottomStrut, gbc_aiFirstPanelBottomStrut);
        
        
        /*
         * Second AI panel
         */
        JPanel aiSecondPanel = new JPanel();
        aiSecondPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        getContentPane().add(aiSecondPanel, BorderLayout.CENTER);
        GridBagLayout gbl_aiSecondPanel = new GridBagLayout();
        aiSecondPanel.setLayout(gbl_aiSecondPanel);
        
        JLabel aiSecondTypeLabel = new JLabel("AI 2 type:");
        GridBagConstraints gbc_aiSecondTypeLabel = new GridBagConstraints();
        gbc_aiSecondTypeLabel.gridx = 0;
        gbc_aiSecondTypeLabel.gridy = 0;
        aiSecondPanel.add(aiSecondTypeLabel, gbc_aiSecondTypeLabel);
        
        Component aiSecondPanelTopStrut = Box.createVerticalStrut(20);
        GridBagConstraints gbc_aiSecondPanelTopStrut = new GridBagConstraints();
        gbc_aiSecondPanelTopStrut.gridx = 0;
        gbc_aiSecondPanelTopStrut.gridy = 1;
        aiSecondPanel.add(aiSecondPanelTopStrut, gbc_aiSecondPanelTopStrut);
        
        JRadioButton aiSecondMinMaxRadioButton = new JRadioButton("MinMax");
        aiSecondMinMaxRadioButton.addActionListener(new ActionListener()
        {                 
            public void actionPerformed(ActionEvent event)
            {
                aiSecondType = "minmax";
            }
        });
        aiSecondMinMaxRadioButton.setSelected(true);
        aiSecondTypeButtonGroup.add(aiSecondMinMaxRadioButton);
        GridBagConstraints gbc_aiSecondMinMaxRadioButton = new GridBagConstraints();
        gbc_aiSecondMinMaxRadioButton.gridx = 0;
        gbc_aiSecondMinMaxRadioButton.gridy = 2;
        aiSecondPanel.add(aiSecondMinMaxRadioButton, gbc_aiSecondMinMaxRadioButton);
        
        JRadioButton aiSecondGreedyRadioButton = new JRadioButton("Greedy");
        aiSecondGreedyRadioButton.addActionListener(new ActionListener()
        {                 
            public void actionPerformed(ActionEvent event)
            {
                aiSecondType = "greedy";
            }
        });
        aiSecondTypeButtonGroup.add(aiSecondGreedyRadioButton);
        GridBagConstraints gbc_aiSecondGreedyRadioButton = new GridBagConstraints();
        gbc_aiSecondGreedyRadioButton.anchor = GridBagConstraints.WEST;
        gbc_aiSecondGreedyRadioButton.gridx = 0;
        gbc_aiSecondGreedyRadioButton.gridy = 3;
        aiSecondPanel.add(aiSecondGreedyRadioButton, gbc_aiSecondGreedyRadioButton);
        
        JRadioButton aiSecondStupidRadioButton = new JRadioButton("Stupid");
        aiSecondStupidRadioButton.addActionListener(new ActionListener()
        {                 
            public void actionPerformed(ActionEvent event)
            {
                aiSecondType = "stupid";
            }
        });
        aiSecondTypeButtonGroup.add(aiSecondStupidRadioButton);
        GridBagConstraints gbc_aiSecondStupidRadioButton = new GridBagConstraints();
        gbc_aiSecondStupidRadioButton.anchor = GridBagConstraints.WEST;
        gbc_aiSecondStupidRadioButton.gridx = 0;
        gbc_aiSecondStupidRadioButton.gridy = 4;
        aiSecondPanel.add(aiSecondStupidRadioButton, gbc_aiSecondStupidRadioButton);
        
        Component aiSecondPanelBottomStrut = Box.createVerticalStrut(20);
        GridBagConstraints gbc_aiSecondPanelBottomStrut = new GridBagConstraints();
        gbc_aiSecondPanelBottomStrut.gridx = 0;
        gbc_aiSecondPanelBottomStrut.gridy = 5;
        aiSecondPanel.add(aiSecondPanelBottomStrut, gbc_aiSecondPanelBottomStrut);
        

        /*
         * Difficulty level panel
         */
        JPanel levelDifficultyPanel = new JPanel();
        levelDifficultyPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        getContentPane().add(levelDifficultyPanel, BorderLayout.EAST);
        GridBagLayout gbl_levelDifficultyPanel = new GridBagLayout();
        gbl_levelDifficultyPanel.columnWeights = new double[]{1.0};
        gbl_levelDifficultyPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        levelDifficultyPanel.setLayout(gbl_levelDifficultyPanel);
        
        JLabel levelDifficultyLabel = new JLabel("Level difficulty");
        GridBagConstraints gbc_levelDifficultyLabel = new GridBagConstraints();
        gbc_levelDifficultyLabel.gridx = 0;
        gbc_levelDifficultyLabel.gridy = 0;
        levelDifficultyPanel.add(levelDifficultyLabel, gbc_levelDifficultyLabel);
        
        Component difficultyPanelTopStrut = Box.createVerticalStrut(20);
        GridBagConstraints gbc_difficultyPanelTopStrut = new GridBagConstraints();
        gbc_difficultyPanelTopStrut.gridx = 0;
        gbc_difficultyPanelTopStrut.gridy = 1;
        levelDifficultyPanel.add(difficultyPanelTopStrut, gbc_difficultyPanelTopStrut);
        
        JRadioButton difficultyEasyButton = new JRadioButton("Easy");
        difficultyEasyButton.addActionListener(new ActionListener()
        {                 
            public void actionPerformed(ActionEvent event)
            {
                boardSize = DIFFICULTY_EASY_SIZE;
            }
        });
        difficultyEasyButton.setSelected(true);
        difficultyButtonGroup.add(difficultyEasyButton);
        GridBagConstraints gbc_difficultyEasyButton = new GridBagConstraints();
        gbc_difficultyEasyButton.gridx = 0;
        gbc_difficultyEasyButton.gridy = 2;
        gbc_difficultyEasyButton.anchor = GridBagConstraints.NORTHWEST;
        levelDifficultyPanel.add(difficultyEasyButton, gbc_difficultyEasyButton);
        
        JRadioButton difficultyMediumButton = new JRadioButton("Medium");
        difficultyMediumButton.addActionListener(new ActionListener()
        {                 
            public void actionPerformed(ActionEvent event)
            {
                boardSize = DIFFICULTY_MEDIUM_SIZE;
            }
        });
        difficultyButtonGroup.add(difficultyMediumButton);
        GridBagConstraints gbc_difficultyMediumButton = new GridBagConstraints();
        gbc_difficultyMediumButton.anchor = GridBagConstraints.NORTHWEST;
        gbc_difficultyMediumButton.gridx = 0;
        gbc_difficultyMediumButton.gridy = 3;
        levelDifficultyPanel.add(difficultyMediumButton, gbc_difficultyMediumButton);
        
        JRadioButton difficultyHardButton = new JRadioButton("Hard");
        difficultyHardButton.addActionListener(new ActionListener()
        {                 
            public void actionPerformed(ActionEvent event)
            {
                boardSize = DIFFICULTY_HARD_SIZE;
            }
        });
        difficultyButtonGroup.add(difficultyHardButton);
        GridBagConstraints gbc_difficultyHardButton = new GridBagConstraints();
        gbc_difficultyHardButton.anchor = GridBagConstraints.NORTHWEST;
        gbc_difficultyHardButton.gridx = 0;
        gbc_difficultyHardButton.gridy = 4;
        levelDifficultyPanel.add(difficultyHardButton, gbc_difficultyHardButton);
        
        JRadioButton difficultyVeryHardButton = new JRadioButton("Very hard");
        difficultyVeryHardButton.addActionListener(new ActionListener()
        {                 
            public void actionPerformed(ActionEvent event)
            {
                boardSize = DIFFICULTY_VERY_HARD_SIZE;
            }
        });
        difficultyButtonGroup.add(difficultyVeryHardButton);
        GridBagConstraints gbc_difficultyVeryHardButton = new GridBagConstraints();
        gbc_difficultyVeryHardButton.anchor = GridBagConstraints.NORTHWEST;
        gbc_difficultyVeryHardButton.gridx = 0;
        gbc_difficultyVeryHardButton.gridy = 5;
        levelDifficultyPanel.add(difficultyVeryHardButton, gbc_difficultyVeryHardButton);
        
        Component difficultyPanelBottomStrut = Box.createVerticalStrut(20);
        GridBagConstraints gbc_difficultyPanelBottomStrut = new GridBagConstraints();
        gbc_difficultyPanelBottomStrut.gridx = 0;
        gbc_difficultyPanelBottomStrut.gridy = 6;
        levelDifficultyPanel.add(difficultyPanelBottomStrut, gbc_difficultyPanelBottomStrut);

        
        /*
         * Bottom iteration panel
         */
        JPanel iterationNumberPanel = new JPanel();
        getContentPane().add(iterationNumberPanel, BorderLayout.SOUTH);
        iterationNumberPanel.setLayout(new BorderLayout(0, 0));
        
        JLabel iterationNumberLabel = new JLabel("Number of iterations:");
        iterationNumberPanel.add(iterationNumberLabel, BorderLayout.WEST);
        
        final JSpinner iterationCountSpinner = new JSpinner();
        iterationCountSpinner.setModel(new SpinnerNumberModel(10, 1, 10000, 1));
        iterationNumberPanel.add(iterationCountSpinner, BorderLayout.CENTER);

        JButton startAiDuels = new JButton("Start");
        startAiDuels.addActionListener(new ActionListener()
        {                 
            public void actionPerformed(ActionEvent event)
            {
                iterationCount = (Integer) iterationCountSpinner.getValue();
                view.sendBoardEvent(new StartAIDuelEvent(aiFirstType, aiSecondType, boardSize, iterationCount));
            }
        });
        iterationNumberPanel.add(startAiDuels, BorderLayout.EAST);
        
    }

}
