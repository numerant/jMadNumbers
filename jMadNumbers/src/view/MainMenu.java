package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import events.*;


/**
 * Class responsible for creating main application menu.
 */

public class MainMenu
{
    private View view;
        /* Menu bar and items */
    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenu newGameMenu;
    private JMenuItem difficulyEasyItem;
    private JMenuItem difficulyMediumItem;
    private JMenuItem difficulyHardItem;
    private JMenuItem difficulyVeryHardItem;
    private JMenu predefinedLevelsMenu;
    private JMenuItem difficulyNoviceItem;
    private JMenuItem difficulyMasterItem;
    private JMenuItem difficulyLegendaryItem;
    private JMenu aiTypeMenu;
    private ButtonGroup aiTypeGroup;
    private JRadioButtonMenuItem minMaxAiItem;
    private JRadioButtonMenuItem greedyAiItem;
    private JRadioButtonMenuItem stupidAiItem;
    private JMenuItem quitMenuItem;
    private JMenu helpMenu;
    private JMenuItem howToPlayMenuItem;
    private JMenuItem aboutMenuItem;
    
        /* How difficult are difficulty levels */
    private final Integer DIFFICULTY_EASY_SIZE = 5;
    private final Integer DIFFICULTY_MEDIUM_SIZE = 7;
    private final Integer DIFFICULTY_HARD_SIZE = 8;
    private final Integer DIFFICULTY_VERY_HARD_SIZE = 10;
    
    MainMenu(final View view)
    {
        this.view = view;
        createMenuItems();
        enableMenu();
    }
    
    /**
     * Creates menu items and sets their action listeners
     */
    void createMenuItems()
    {
        menuBar = new JMenuBar();

        gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        
        newGameMenu = new JMenu("New game");
        gameMenu.add(newGameMenu);
        
        difficulyEasyItem = new JMenuItem("Easy");
        difficulyEasyItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                view.sendBoardEvent(new GenerateBoardEvent(DIFFICULTY_EASY_SIZE));
            }
        });
        newGameMenu.add(difficulyEasyItem);
        
        difficulyMediumItem = new JMenuItem("Medium");
        difficulyMediumItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                view.sendBoardEvent(new GenerateBoardEvent(DIFFICULTY_MEDIUM_SIZE));
            }
        });
        newGameMenu.add(difficulyMediumItem);
        
        difficulyHardItem = new JMenuItem("Hard");
        difficulyHardItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                view.sendBoardEvent(new GenerateBoardEvent(DIFFICULTY_HARD_SIZE));
            }
        });
        newGameMenu.add(difficulyHardItem);
        
        difficulyVeryHardItem = new JMenuItem("Very Hard");
        difficulyVeryHardItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                view.sendBoardEvent(new GenerateBoardEvent(DIFFICULTY_VERY_HARD_SIZE));
            }
        });
        newGameMenu.add(difficulyVeryHardItem);
        
        predefinedLevelsMenu = new JMenu("Predefined levels");
        gameMenu.add(predefinedLevelsMenu);
        
        difficulyNoviceItem = new JMenuItem("Novice");
        difficulyNoviceItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                view.sendBoardEvent(new GenerateBoardEvent("novice"));
            }
        });
        predefinedLevelsMenu.add(difficulyNoviceItem);
        
        difficulyMasterItem = new JMenuItem("Master");
        difficulyMasterItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                view.sendBoardEvent(new GenerateBoardEvent("master"));
            }
        });
        predefinedLevelsMenu.add(difficulyMasterItem);
        
        difficulyLegendaryItem = new JMenuItem("Legendary");
        difficulyLegendaryItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                view.sendBoardEvent(new GenerateBoardEvent("legendary"));
            }
        });
        predefinedLevelsMenu.add(difficulyLegendaryItem);
        
        
        aiTypeMenu = new JMenu("AI type");
        gameMenu.add(aiTypeMenu);
        
        aiTypeGroup = new ButtonGroup();
        
        minMaxAiItem = new JRadioButtonMenuItem("MinMax", true);
        minMaxAiItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                view.sendBoardEvent(new AITypeChangeEvent("minmax"));
            }
        });
        aiTypeMenu.add(minMaxAiItem);
        aiTypeGroup.add(minMaxAiItem);
        
        greedyAiItem = new JRadioButtonMenuItem("Greedy");
        greedyAiItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                view.sendBoardEvent(new AITypeChangeEvent("greedy"));
            }
        });
        aiTypeMenu.add(greedyAiItem);
        aiTypeGroup.add(greedyAiItem);
        
        stupidAiItem = new JRadioButtonMenuItem("Stupid");
        stupidAiItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                view.sendBoardEvent(new AITypeChangeEvent("stupid"));
            }
        });
        aiTypeMenu.add(stupidAiItem);
        aiTypeGroup.add(stupidAiItem);
        
        
        
        quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        });
        gameMenu.add(quitMenuItem);
        
        helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);
        
        howToPlayMenuItem = new JMenuItem("How to play");
        helpMenu.add(howToPlayMenuItem);
        howToPlayMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                view.sendBoardEvent(new ShowHelpEvent());
            }
        });
        
        aboutMenuItem = new JMenuItem("About");
        helpMenu.add(aboutMenuItem);
        aboutMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                view.sendBoardEvent(new ShowAboutEvent());
            }
        });
    }
    
    /**
     * Sets the menu as a default for specified view
     */
    void enableMenu()
    {
        view.setMenuBar(menuBar);
    }
    
}
