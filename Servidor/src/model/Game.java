package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import utility.ReadFile;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Game {

    // Singleton.
    private Game(){}
    private static Game game = null;
    public static Game getInstance(){
        if (game == null){
            game = new Game();
            start = true;
            System.out.printf("%n➽ Game. Start!%n");
        }
        return game;
    }


    // Attributes
    private static boolean start = false;
    //%%% PARSING
    private String lianasFile = "lianas.txt";

    private ObjectMapper objectMapper = new ObjectMapper();
    private volatile Liana[] lianas = null;

//    public void setLianasArray() {
//        if (lianas == null) {
//            try {
//                String jsonLianaArray = ReadFile.getData(lianasFile);
//                objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
//                lianas = objectMapper.readValue(jsonLianaArray, Liana[].class);
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        }
//    }


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
