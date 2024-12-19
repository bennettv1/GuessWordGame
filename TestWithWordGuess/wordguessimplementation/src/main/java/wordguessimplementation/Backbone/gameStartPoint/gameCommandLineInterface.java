package wordguessimplementation.Backbone.gameStartPoint;


public class gameCommandLineInterface {

    //Displays the number of tries left for the player.
    public static void triesLeft(int triesLeft){
        System.out.println("Tries Left: " + triesLeft);
    }

    // Notifies the player that their guess was correct.
    public static void correctGuess(){
        System.out.println("!!!Correct guess!!!");
        System.out.println();
        System.out.println();
    }
    // Notifies the player that their guess was incorrect.
    public static void wrongGuess(){
        System.out.println("!!!Wrong guess!!!");
        System.out.println();
        System.out.println();

    }

}
