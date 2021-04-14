import model.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import socket.HostManager;
import java.io.IOException;

public class Main {

    private final Game game = null;

    public static void main(String[] args) throws IOException {
        HostManager hostManager = new HostManager();


//        Game game = Game.getInstance();
        ObjectMapper objectMapper = new ObjectMapper();
        Liana liana = new Liana(0,1, 3);
//        try {
//            File file = new File("files/data.json");
////            Fruit fruit = new Fruit(7,10);
////            objectMapper.writeValue(file, liana);
////            objectMapper.writeValue(file, fruit);
////            ArrayList<Snapjaw> snapjaws = new ArrayList<>();
////            ArrayList<Fruit> fruit = new ArrayList<>();
////            Liana liana = new Liana ()
////            snapjaws.add(new Snapjaw(1,2));
//
//
////            Data data = new Data();
////            objectMapper.writeValue(file, data);
////
////            Data data = objectMapper.readValue(file, Data.class);
////            String json = "{\"i\":1,\"j\":0,\"speed\":1,\"onScreen\":true,\"length\":3}";
////            Liana data = objectMapper.readValue(json, Liana.class);
////            objectMapper.writeValue(file, liana);
////            ArrayList<Liana> listCar = objectMapper.readValue(file, new TypeReference<ArrayList<Liana>>(){});
////            for (Liana e : listCar){
////                System.out.println(e.getId());
////            }
//
//
//
//// print cars
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
