package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class HelpWindow extends JDialog
{

    private static final long serialVersionUID = 1L;        //to avoid compiler warnings
    private final JPanel contentPanel = new JPanel();

    
    public HelpWindow(final JFrame mainWindow)
    {
        super(mainWindow, "How to play", ModalityType.APPLICATION_MODAL);
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
        setSize(450, 235);
        
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JLabel lblHowToPlay = new JLabel("How to play");
            lblHowToPlay.setHorizontalAlignment(SwingConstants.CENTER);
            lblHowToPlay.setFont(new Font("Dialog", Font.BOLD, 18));
            contentPanel.add(lblHowToPlay, BorderLayout.NORTH);
        }
        {
            JLabel lblNewLabel = new JLabel("<html>How to play<br>\nHow to play</html>");
            lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
            contentPanel.add(lblNewLabel, BorderLayout.CENTER);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                okButton.addActionListener(new ActionListener()
                {                 
                    public void actionPerformed(ActionEvent event)
                    {
                        dispose();
                    }
                });
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
        }
    }

}
