package wordguessimplementation.Backbone.playerInteractionModule.playerInteractionClasses;

import java.util.HashSet;

public class playerInteractionClassesCLI {
    
    // Displays a message when a player guesses a character they've already used
    public static void alreadyUsedCharacters(Character guess, HashSet<Character> ChracterHashSet) {
        System.out.println("----------");
        System.out.println();
        // Inform the player they already guessed the character
        System.out.println("You've already guessed " + guess + ". Please choose another character.");
        System.out.println();
        // Show the list of characters that have already been guessed
        System.out.println("already used characters: ");
        System.out.println(ChracterHashSet.toString());
        System.out.println("----------");
        // Prompt the player to try again
        System.out.println("Try Again: ");
    }

    // Displays the current state of the hidden word (with revealed and hidden characters)
    public static void hiddenWord(char[] hiddenWord) {
        System.out.println("-----------");
        // Show the current progress of the word
        System.out.println("What the word looks like so far : ");
        System.out.println(hiddenWord);  // Print the hidden word array (with revealed characters)
    }
}
