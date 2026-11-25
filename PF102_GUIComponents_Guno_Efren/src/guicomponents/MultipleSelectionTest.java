/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guicomponents;

import javax.swing.JFrame;

/**
 *
 * @author gcc
 */

public class MultipleSelectionTest 
{
    public static void main(String[] args)
    { 
        MultipleSelectionFrame multipleSelectionFrame = 
            new MultipleSelectionFrame(); 
        multipleSelectionFrame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);
        multipleSelectionFrame.setSize(400, 310);
        multipleSelectionFrame.setVisible(true);
    }
}
