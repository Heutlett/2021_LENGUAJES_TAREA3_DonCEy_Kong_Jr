import model.Game;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Liana;

import java.io.File;
import java.io.IOException;

public class Main {

    private final Game game = null;

    public static void main(String[] args) {
//        Game game = Game.getInstance();
        ObjectMapper objectMapper = new ObjectMapper();
        Liana liana = new Liana(1,2, 3);
        try {
            objectMapper.writeValue(new File("files/lianas.json"), liana);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
