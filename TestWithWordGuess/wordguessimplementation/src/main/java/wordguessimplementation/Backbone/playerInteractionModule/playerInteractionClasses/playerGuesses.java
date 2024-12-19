package wordguessimplementation.Backbone.playerInteractionModule.playerInteractionClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import wordguessimplementation.Backbone.wordConverstionModule.wordConversionClasses.StringToCharacter;

public class playerGuesses {
    private HashMap<Character, ArrayList<Integer>> wordHashMap;  // HashMap to store character positions in the word
    private HashSet<Character> guessedLetters = new HashSet<>();  // Set of characters that have already been guessed
    private Character guessedCharacters = null;  // Stores the most recent guessed character

    // Constructor that initializes the wordHashMap
    public playerGuesses(String sentenceToGuess, HashMap<Character, ArrayList<Integer>> wordHashMap) {
        // Store the wordHashMap for later use
        this.wordHashMap = wordHashMap;
    }

    // Prompts the player for a guess, checks if it's valid, and returns true/false based on correctness
    public boolean makeGuess(Scanner playerScanner) {
        Character guess;
        while (true) {
            guess = this.playerInputHelper(playerScanner);  // Get a valid character guess
            this.guessedCharacters = guess;
            
            // Check if the guessed character has been guessed before
            if (this.isAlreadyGuessed(guess)) {
                playerInteractionClassesCLI.alreadyUsedCharacters(guess, guessedLetters);  // Inform the player
            } else {
                // Add the guess to the guessedLetters set, considering both uppercase and lowercase
                guessedLetters.add(Character.toLowerCase(guess));
                guessedLetters.add(Character.toUpperCase(guess));
                
                // Check if the guess is correct
                return (isCorrectGuess(guess));
            }
        }
    }

    // Helper method to get the player's input and validate it as a character
    private Character playerInputHelper(Scanner playerScanner) {
        Character guess = null;
        while (guess == null) {
            try {
                // Converts the player's input string into a character
                guess = StringToCharacter.checkCharPrompt(playerScanner.nextLine());
            } catch (InputMismatchException ex) {
                // If input is invalid, prompt the player again
                System.out.println("Please input a character!");
            }
        }
        return (guess);
    }

    // Checks if the guess is correct (i.e., if the character exists in the wordHashMap)
    private boolean isCorrectGuess(Character guess) {
        // Check if either the uppercase or lowercase variant of the character exists in the word
        return wordHashMap.containsKey(Character.toUpperCase(guess)) || wordHashMap.containsKey(Character.toLowerCase(guess));
    }

    // Checks if the guessed character has been guessed before (case insensitive)
    private boolean isAlreadyGuessed(Character characterToCheck) {
        return guessedLetters.contains(Character.toLowerCase(characterToCheck)) || guessedLetters.contains(Character.toUpperCase(characterToCheck));
    }

    // Returns the most recently guessed character
    public Character getGuessedCharacter() {
        return guessedCharacters;
    }

    // Main method, currently unused
    public static void main(String[] args) {

    }
}
