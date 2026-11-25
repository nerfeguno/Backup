/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guicomponents;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author gcc
 */

public class MultipleSelectionFrame extends JFrame 
{
    private final JList<String> colorJList;
    private final JList<String> copyJList;
    private final DefaultListModel<String> copyListModel;
    private final JButton copyJButton;
    private static final String[] colorNames = {"Black", "Blue", "Cyan",
        "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange",
        "Pink", "Red", "White", "Yellow"};

    public MultipleSelectionFrame()
    {
        super("Multiple Selection Lists");
        setLayout(new FlowLayout());

        colorJList = new JList<String>(colorNames);
        colorJList.setVisibleRowCount(13);
        colorJList.setSelectionMode(
            ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(colorJList));

        copyListModel = new DefaultListModel<String>();
        copyJList = new JList<String>(copyListModel);
        copyJList.setVisibleRowCount(13);
        copyJList.setFixedCellWidth(120);
        copyJList.setFixedCellHeight(18);
        copyJList.setSelectionMode(
            ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        copyJButton = new JButton("Copy >>>");
        copyJButton.addActionListener(
            new ActionListener()
            {  
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    for (String color : colorJList.getSelectedValuesList())
                    {
                        copyListModel.addElement(color);
                    }
                } 
            } 
        ); 

        add(copyJButton);
        add(new JScrollPane(copyJList));
    } 
}

