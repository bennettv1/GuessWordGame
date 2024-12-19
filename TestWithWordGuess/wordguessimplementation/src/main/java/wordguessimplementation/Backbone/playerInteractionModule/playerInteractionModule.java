package wordguessimplementation.Backbone.playerInteractionModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import wordguessimplementation.Backbone.playerInteractionModule.playerInteractionClasses.playerGuesses;
import wordguessimplementation.Backbone.playerInteractionModule.playerInteractionClasses.wordRevealer;
import wordguessimplementation.Backbone.playerInteractionModule.playerInteractionClasses.playerInteractionClassesCLI;

public class playerInteractionModule {

    playerGuesses PlayerGuess;  // Object to manage player's guesses
    wordRevealer WordRevealer;  // Object to manage revealing of word characters
    HashMap<Character, ArrayList<Integer>> wordHashMap;  // HashMap to store word character locations

    // Constructor initializes PlayerGuess, WordRevealer, and wordHashMap
    public playerInteractionModule(String sentenceToGuess, HashMap<Character, ArrayList<Integer>> wordHashMap){
        this.PlayerGuess = new playerGuesses(sentenceToGuess, wordHashMap);
        this.WordRevealer = new wordRevealer(sentenceToGuess);
        this.wordHashMap = wordHashMap;
    }

    // Checks if the game is over by verifying if there are any characters left to reveal
    public boolean gameOverCheck(){
        return(this.WordRevealer.getCharactersLeft() == 0);
    }

    // Returns the number of characters left to be revealed in the word
    public int remainingLettersAmount(){
        return(this.WordRevealer.getCharactersLeft());
    }

    // Prompts the player to make a guess and updates the word's revealed characters if the guess is correct
    public boolean makeGuess(Scanner playerScanner){
        playerInteractionClassesCLI.hiddenWord(WordRevealer.getHiddenWord());
        
        // Make the guess and reveal characters if the guess is correct
        if(PlayerGuess.makeGuess(playerScanner)){
            WordRevealer.revealCharacters(PlayerGuess.getGuessedCharacter(), wordHashMap);
            return(true);  // Return true if the guess was valid and correct
        }
        return(false);  // Return false if the guess was invalid or incorrect
    }
}
