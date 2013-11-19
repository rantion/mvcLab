package com.company;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 11/13/13
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    private int number, guesses, guess;




    public Game(){
        number = 39;
        guess = 0;
        guesses = 0;


    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        System.out.println("In set Number Method");
//        int oldValue = this.number;
        this.number = number;
//        support.firePropertyChange("number", oldValue, number);
        System.out.println("Number in Game Class: "+ this.number);
    }

    public int getGuesses() {
        return guesses;
    }

    public void setGuesses(int guesses) {
        int oldValue = this.guesses;
        this.guesses = guesses;
    }

    public int getGuess() {
        System.out.println("Guess: "+guess);
        return guess;
    }

    public void setGuess(int guess) {
        int oldValue = this.guess;
        this.guess = guess;
    }

    public int checkGuess(int guess){
        int guessResult=0;
        System.out.println("in checkGuess method, guess: "+guess+" number: "+number);
        if(guess>getNumber()){
            guessResult = 1;
        }
        if(guess<getNumber()){
            guessResult = -1;
        }
        else if(guess == number){
            guessResult = 0;
        }
        guesses++;
        System.out.println("Guesses: "+guesses);
        System.out.println(guessResult);
        return guessResult;
    }

    public void reset(int newNumber){
        number = newNumber;
        guesses = 0;

    }

}

