package socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Fruit;

import java.io.IOException;

public class Serializer {

    /**
     * Serializa un snapjaw.
     * @param snapjaw
     * @return
     * @throws IOException
     */
    public static <SnapJaw> String serializeSnapJaw(SnapJaw snapjaw) throws IOException {
        ObjectMapper snapjawMapper = new ObjectMapper();
        return snapjawMapper.writeValueAsString(snapjaw);
    }

    /**
     * Serializa un kremlin
     * @param fruit
     * @return
     * @throws IOException
     */
    public static String serializeFruit(Fruit fruit) throws IOException{
        ObjectMapper fruit_Mapper = new ObjectMapper();
        return fruit_Mapper.writeValueAsString(fruit);
    }

}