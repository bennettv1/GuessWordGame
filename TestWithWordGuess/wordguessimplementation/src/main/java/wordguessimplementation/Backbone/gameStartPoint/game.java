package wordguessimplementation.Backbone.gameStartPoint;

import java.util.Scanner;

import wordguessimplementation.Backbone.playerInteractionModule.playerInteractionModule;
import wordguessimplementation.Backbone.wordConverstionModule.wordConversion;

public class game {
    public static void main(String[] args) {
        // Initialize the maximum number of attempts allowed for the player
        int availableAttempts = 3;

        // Define the target sentence that the player must guess
        String sentenceToPredict = "Hello World!";

        // Convert the target sentence into a format suitable for gameplay
        wordConversion wordConverter = new wordConversion(sentenceToPredict);

        // Create a scanner for player input
        Scanner playerScanner = new Scanner(System.in);

        // Set up the player interaction module with the target sentence and processed data
        playerInteractionModule playerPrompts = new playerInteractionModule(
                sentenceToPredict, wordConverter.getProcessedSentence());

        // Main game loop: runs until attempts are exhausted or the player guesses the sentence
        while (availableAttempts > 0) {
            // Display the remaining number of attempts
            gameCommandLineInterface.triesLeft(availableAttempts);

            // Handle the player's guess and determine its correctness
            if (playerPrompts.makeGuess(playerScanner)) {
                gameCommandLineInterface.correctGuess(); // Notify for correct guess
            } else {
                gameCommandLineInterface.wrongGuess(); // Notify for incorrect guess
                availableAttempts--; // Decrement the remaining attempts
            }

            // Check if the player has successfully guessed the entire sentence
            if (playerPrompts.gameOverCheck()) {
                System.out.println();
                System.out.println("You completed the word!");
                System.out.println(sentenceToPredict);
                break; // End the game loop
            }
        }

        // Handle the case where the player runs out of attempts
        if (availableAttempts == 0) {
            System.out.println();
            System.out.println("You lost. Too many incorrect attempts.");
            System.out.println("The correct word was: " + sentenceToPredict);
        }

        // Close the scanner to release resources
        playerScanner.close();
    }
}
