package model;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Game {

    private static boolean start = false;

    // Singleton.
    private Game(){}
    private static Game game = null;
    public static Game getInstance(){
        if (game == null){
            game = new Game();
            start = true;
            System.out.println("➽ Game Start!");
        }
        return game;
    }


    // Attributes
    private String lianasFiles = "lianas.txt";







    // Attributes
//    private static int numberOfLianas = 0;
//    private static int numberOfFruits = 0;
//    private static int numberOfSnapjaws = 0;
//    private ArrayList<String> cars = new ArrayList<String>();
//    Map<Key, Pair<Value, Value>>
//    Dictionary<int, string> dictFriends = new Dictionary<int, string>();
//    private Hashtable<String, String> my_dict = new Hashtable<String, String>();

    // Methods
    public static boolean isStart() {
        return start;
    }

}
