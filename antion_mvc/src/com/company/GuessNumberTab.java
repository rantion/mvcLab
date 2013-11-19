package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 11/16/13
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuessNumberTab extends JPanel implements ActionListener {
    protected JButton guess;
    protected JLabel guesses, enterGuess, higherOrLower;
    protected JTextField playerGuess;
    private Game game = new Game();

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener (PropertyChangeListener handler){
        support.addPropertyChangeListener(handler);
    }

    public void removePropertyChangeListener(PropertyChangeListener handler){
        support.removePropertyChangeListener(handler);
    }

    public GuessNumberTab(){



        guesses = new JLabel("Number of Guesses: "+game.getGuesses());
        guesses.setVerticalTextPosition(SwingConstants.CENTER);
        guesses.setHorizontalTextPosition(SwingConstants.CENTER);
        this.add(guesses);


        enterGuess = new JLabel("Please Enter Your Guess");
        enterGuess.setHorizontalTextPosition(SwingConstants.CENTER);
        enterGuess.setVerticalTextPosition(SwingConstants.CENTER);
        this.add(enterGuess);

        playerGuess = new JTextField();
        this.add(playerGuess);

        guess = new JButton("Enter Number");
        guess.setVerticalTextPosition(AbstractButton.CENTER);
        guess.setHorizontalTextPosition(AbstractButton.LEADING);
        guess.setMnemonic(KeyEvent.VK_D);
        guess.setActionCommand("Guess");
        guess.addActionListener(this);
        this.add(guess);


//        higherOrLower = new JLabel("Higher or Lower: "+);

        this.setLayout(new GridLayout(1, 1));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if("Guess".equals(e.getActionCommand())){
            String playersGuess = playerGuess.getText();
            int newGuess = Integer.parseInt(playersGuess);
            game.setGuess(newGuess);
            System.out.println("New Guess in Tab: " + newGuess);
            System.out.println("New Guess calling game method: "+game.getGuess());
            System.out.println("Number in guessNumber tAB: "+game.getNumber());
            game.checkGuess(newGuess);

        }
    }
}

