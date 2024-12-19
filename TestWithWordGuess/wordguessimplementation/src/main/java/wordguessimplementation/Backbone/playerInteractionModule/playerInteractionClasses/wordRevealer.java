package wordguessimplementation.Backbone.playerInteractionModule.playerInteractionClasses;

import java.util.ArrayList;
import java.util.HashMap;

public class wordRevealer {
    private char[] hiddenWord;  // Array to store the current state of the hidden word
    private int charactersLeft; // Number of characters still hidden in the word

    // Constructor initializes the hiddenWord array and calculates the number of hidden characters
    public wordRevealer(String word) {
        this.hiddenWord = word.replaceAll("[^ ]", "_").toCharArray();  // Replace all non-space characters with '_'
        this.charactersLeft = calculateCharactersLeft();  // Calculate the initial number of hidden characters
    }

    // Reveals the guessed character in the word if it exists
    public void revealCharacters(char character, HashMap<Character, ArrayList<Integer>> wordHashMap) {
        if (wordHashMap == null) {
            return; // If the wordHashMap is null, do nothing
        }

        // Check both lowercase and uppercase versions of the character
        revealCharacterVariant(Character.toLowerCase(character), wordHashMap);
        revealCharacterVariant(Character.toUpperCase(character), wordHashMap);
    }

    // Reveals the character in the hidden word for each occurrence found in wordHashMap
    private void revealCharacterVariant(char character, HashMap<Character, ArrayList<Integer>> wordHashMap) {
        if (wordHashMap.containsKey(character)) {
            // Loop through each index where the character appears
            for (Integer index : wordHashMap.get(character)) {
                if (hiddenWord[index] == '_') { // Only reveal characters that are still hidden
                    hiddenWord[index] = character;  // Reveal the character at the specified index
                    charactersLeft--;  // Decrease the number of hidden characters
                }
            }
        }
    }

    // Returns the current hidden word with underscores and revealed characters
    public char[] getHiddenWord() {
        return hiddenWord;
    }

    // Calculates the number of characters that are still hidden (represented by '_')
    private int calculateCharactersLeft() {
        int count = 0;
        for (char c : hiddenWord) {
            if (c == '_') {
                count++;  // Increment count for each hidden character
            }
        }
        return count;  // Return the total count of hidden characters
    }

    // Returns the current number of characters still hidden in the word
    public int getCharactersLeft() {
        return charactersLeft;
    }
}
