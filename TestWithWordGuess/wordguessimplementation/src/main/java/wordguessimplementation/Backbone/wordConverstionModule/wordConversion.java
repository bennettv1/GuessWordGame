package wordguessimplementation.Backbone.wordConverstionModule;

import java.util.ArrayList;
import java.util.HashMap;

public class wordConversion {
    // Stores the processed sentence as a map of characters to their indices
    HashMap<Character, ArrayList<Integer>> ProcessedSentence;

    // Constructor initializes the ProcessedSentence map by processing the input sentence
    public wordConversion(String Sentence) {
        this.ProcessedSentence = processSentence(Sentence);
    }

    // Processes the sentence to create a map of each character to a list of its indices
    private HashMap<Character, ArrayList<Integer>> processSentence(String Sentence) {
        HashMap<Character, ArrayList<Integer>> returnHashMap = new HashMap<>();

        // Loop through each character in the sentence
        for (int i = 0; i < Sentence.length(); i++) {
            // Identify the current character
            Character currentCharacter = Sentence.charAt(i);

            if (returnHashMap.containsKey(currentCharacter)) {
                // If the character is already in the map, add the current index to its list
                returnHashMap.get(currentCharacter).add(i);
            } else {
                // If the character is not in the map, create a new list and add the current index
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                returnHashMap.put(currentCharacter, indices);
            }
        }
        // Return the populated map
        return returnHashMap;
    }

    // Returns the processed sentence map
    public HashMap<Character, ArrayList<Integer>> getProcessedSentence() {
        return ProcessedSentence;
    }

    public static void main(String[] args) {
        // Test case to verify the functionality of the class
        wordConversion test = new wordConversion("Hello There");
        // Print the processed sentence map
        System.out.println(test.getProcessedSentence());
    }
}
