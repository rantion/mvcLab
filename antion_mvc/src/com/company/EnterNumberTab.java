package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 11/16/13
 * Time: 5:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnterNumberTab extends JPanel implements ActionListener {
    protected JButton enter;
    protected JLabel enterNumber;
    protected JTextField number;
    private Game game;

    public EnterNumberTab(Game game){

        this.game = game;

        enterNumber= new JLabel("Enter the Number you would like the other player to Guess");
        enterNumber.setHorizontalTextPosition(SwingConstants.CENTER);
        enterNumber.setVerticalTextPosition(SwingConstants.CENTER);
        this.add(enterNumber);

        number = new JTextField();
        this.add(number);



        enter = new JButton("Enter Number");
        enter.setVerticalTextPosition(AbstractButton.CENTER);
        enter.setHorizontalTextPosition(AbstractButton.LEADING);
        enter.setMnemonic(KeyEvent.VK_D);

        enter.setActionCommand("Enter");
        enter.addActionListener(this);

        this.add(enter);

       this.setLayout(new GridLayout(1,1));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if("Enter".equals(e.getActionCommand())){
            try{
           String enteredNumber = number.getText();
           game.reset(Integer.parseInt(enteredNumber));
            }
            catch(Exception p){
                System.out.println("Something has gone wrong, please enter a number.");
            }
        }
    }
}
