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
    private int number, guesses, guess, guessResult;




    public Game(){
        number = 39;
        guess = 0;
        guesses = 0;


    }

    public void setGuesses(int guesses) {
        this.guesses = guesses;
    }

    public int getGuessResult() {
        return guessResult;
    }

    public void setGuessResult(int guessResult) {
        this.guessResult = guessResult;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getGuesses() {
        return guesses;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int checkGuess(int guess){
        guessResult=0;
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
        System.out.println(guessResult);
        System.out.println("Guesses: "+guesses);
        return guessResult;
    }

    public void reset(int newNumber){
        setNumber(newNumber);
        guesses = 0;

    }

}

