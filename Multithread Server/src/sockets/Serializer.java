package sockets;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;



/**
 * Clase Serializer
 * Parsea una clase a formato de strig JSON utilizando
 * la libreria jackson.
 */
public class Serializer {
    public static String serializeRoom(Room room) {
        ObjectMapper mapper = new ObjectMapper();
        RoomSerializer roomSerializer = new RoomSerializer(room);

        try {
            //String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(roomSerializer);



            String jsonString = mapper.writeValueAsString(roomSerializer);
            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Clase auxiliar RoomSerializer
     * Utilizada para serializar de forma especifica ciertos
     * atributos de la clase Room.
     * i.e: roomNumber, player, guests
     */
    static class RoomSerializer {
        public final int roomNumber;
        public String player;
        public ArrayList<String> guests = new ArrayList<>();

        /* Constructor */
        public RoomSerializer(Room room) {
            this.roomNumber = room.getRoomNumber();
            setGuests(room);
        }

        /**
         * Inserta a la lista guests los nombres de las instancias
         * Member de la lista guests de la instancia Room que se
         * esta serializando.
         * @param room La sala que se debe serializar.
         */
        private void setGuests(Room room) {
            // Host
            if (room.getHost() == null) {
                player = "null";
            } else{
                player = room.getHost().getName();
            }
            // Guests
            for (Member viewer : room.getGuests()) {
                guests.add(viewer.getName());
            }
        }
    }
}