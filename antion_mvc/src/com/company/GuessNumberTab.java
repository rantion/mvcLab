package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 11/16/13
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuessNumberTab extends JPanel implements ActionListener , PropertyChangeListener {
    protected JButton guess;
    protected JLabel enterGuess;
    protected JFormattedTextField guesses, higherOrLower, playerGuess;
    private Game game;
    private int numGuesses, numResult, newGuess;

    public GuessNumberTab(Game game){

        this.game = game;

        guesses = new JFormattedTextField("Number of Guesses: "+game.getGuesses());

        this.add(guesses);


        enterGuess = new JLabel("Please Enter Your Guess");
        enterGuess.setHorizontalTextPosition(SwingConstants.CENTER);
        enterGuess.setVerticalTextPosition(SwingConstants.CENTER);
        this.add(enterGuess);

        playerGuess = new JFormattedTextField();
        this.add(playerGuess);
        playerGuess.addPropertyChangeListener("value", this);

        guess = new JButton("Enter Number");
        guess.setVerticalTextPosition(AbstractButton.CENTER);
        guess.setHorizontalTextPosition(AbstractButton.LEADING);
        guess.setMnemonic(KeyEvent.VK_D);
        guess.setActionCommand("Guess");
        guess.addActionListener(this);
        this.add(guess);


        higherOrLower = new JFormattedTextField("Higher or Lower: "+game.getGuessResult());
        this.add(higherOrLower);
        this.setLayout(new GridLayout(1, 1));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if("Guess".equals(e.getActionCommand())){
            try{
            String playersGuess = playerGuess.getText();
            newGuess = Integer.parseInt(playersGuess);
            game.setGuess(newGuess);
            game.checkGuess(newGuess);
            }
            catch(Exception r){
                System.out.println("Something has gone wrong, please try again.");
            }

        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

       guesses.setText("Guesses: "+game.getGuesses());
       higherOrLower.setText("Higher or Lower: "+game.getGuessResult());


    }
}

