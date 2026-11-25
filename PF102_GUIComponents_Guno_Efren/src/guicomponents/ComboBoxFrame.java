/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guicomponents;


import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author gcc
 */

public class ComboBoxFrame extends JFrame 
{
    private final JComboBox<String> imagesJComboBox;
    private final JLabel label; 

    private static final String[] names = 
        {"bug1.GIF", "bug2.GIF", "travelbug.gif", "buganim.gif"};
    private final Icon[] icons = { 
        new ImageIcon(getClass().getResource("/guicomponents/Image resources/" + names[0])),
        new ImageIcon(getClass().getResource("/guicomponents/Image resources/" + names[1])), 
        new ImageIcon(getClass().getResource("/guicomponents/Image resources/" + names[2])),
        new ImageIcon(getClass().getResource("/guicomponents/Image resources/" + names[3]))
    };

    public ComboBoxFrame()
    {
        super("Testing JComboBox");
        setLayout(new BorderLayout()); 

        
        for (int i = 0; i < icons.length; i++) {
            ImageIcon original = (ImageIcon) icons[i];
            Image scaled = original.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            icons[i] = new ImageIcon(scaled);
        }

        imagesJComboBox = new JComboBox<String>(names); 
        imagesJComboBox.setMaximumRowCount(3);

        imagesJComboBox.addItemListener(
            new ItemListener() 
            {
                @Override
                public void itemStateChanged(ItemEvent event)
                {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
                    }
                } 
            } 
        ); 

        
        JPanel topPanel = new JPanel();
        topPanel.add(imagesJComboBox);
        add(topPanel, BorderLayout.NORTH);

        
        label = new JLabel(icons[0]); 
        add(label, BorderLayout.CENTER); 
    }

    public static void main(String[] args)
    {
        ComboBoxFrame frame = new ComboBoxFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(280, 220);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}
