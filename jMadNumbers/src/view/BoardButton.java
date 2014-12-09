package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

/**
 * Internal class for representing a button aware of its position on board
 */

public class BoardButton extends JButton
{
    private static final long serialVersionUID = 1L;
    private static final Font defaultFont = new Font("Sans Serif", Font.BOLD, 20);
    private static final Color activeButtonColor = Color.GREEN;
    private static final Color activeFontColor = Color.RED;
    
    /**
     * Constructor - sets button caption and maze position
     */
    public BoardButton(final String string)
    {
        super(string);
        
        this.setFont(defaultFont);
        
       // this.setBackground(Color.GREEN);
        
            // Flat design
        this.setContentAreaFilled(false);
    }
    
    /**
     * Sets appearance of button as active
     */
    public void setActive()
    {
        this.setContentAreaFilled(true);
        this.setForeground(activeFontColor);
        this.setBackground(activeButtonColor);
        this.setEnabled(true);
    }
    
    /**
     * Sets appearance of button as inactive
     */
    public void setInactive()
    {
        this.setContentAreaFilled(false);
        this.setEnabled(false);
    }
}