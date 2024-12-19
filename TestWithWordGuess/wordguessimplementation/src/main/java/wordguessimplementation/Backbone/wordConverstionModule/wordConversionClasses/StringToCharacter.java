package wordguessimplementation.Backbone.wordConverstionModule.wordConversionClasses;

import java.util.InputMismatchException;

public class StringToCharacter {

    // Main method to check and convert player input into a character
    public static Character checkCharPrompt(String playerInputtedSentence) {
        try {
            // Delegate to helper method for validation and conversion
            return checkCharPromptHelper(playerInputtedSentence);
        } catch (InputMismatchException ex) {
            // Handle invalid input by notifying the player and returning null
            System.out.println("Please input a valid character.");
            return null;
        }
    }

    // Helper method to validate and convert the input string into a character
    private static Character checkCharPromptHelper(String playerInputtedSentence) throws InputMismatchException {
        if (checkforChar(playerInputtedSentence)) {
            // If valid, convert the string to a character
            return stringtoChar(playerInputtedSentence);
        } else {
            // If invalid, throw an exception
            throw new InputMismatchException();
        }
    }

    // Method to check if the input is a single character
    private static boolean checkforChar(String playerInputtedSentence) {
        // Return true only if the input string contains exactly one character
        return playerInputtedSentence.length() == 1;
    }

    // Method to convert a valid single-character string into a Character object
    private static Character stringtoChar(String playerInputtedSentence) {
        return playerInputtedSentence.charAt(0);
    }
}
