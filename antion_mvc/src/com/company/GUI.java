package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 11/16/13
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class GUI extends JPanel{

    public GUI(){

        super (new GridLayout(1,1));

        JTabbedPane tabbedPane = new JTabbedPane();

        Game game = new Game();

        JComponent panel1 = new EnterNumberTab(game);
        tabbedPane.add("Enter Number", panel1);
        tabbedPane.setMnemonicAt(0,KeyEvent.VK_1);

        JComponent panel2 = new GuessNumberTab(game);
        tabbedPane.add("Play Game", panel2);
        tabbedPane.setMnemonicAt(1,KeyEvent.VK_2);

        add(tabbedPane);
        panel1.setVisible(true);
        panel2.setVisible(true);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);


    }

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new GUI(),BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main (String[]args){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UIManager.put("swing.boldMetal",Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}
