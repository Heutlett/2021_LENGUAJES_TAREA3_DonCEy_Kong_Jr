package sockets;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;


public class Serializer {
    public static String serializeRoom(Room room) {
        ObjectMapper mapper = new ObjectMapper();
        RoomSerializer roomSerializer = new RoomSerializer(room);

        try {
//            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(roomSerializer);
            String jsonString = mapper.writeValueAsString(roomSerializer);
//            System.out.println(jsonString);
            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static class RoomSerializer {
        public final int roomNumber;
        public String player;
        public ArrayList<String> guests = new ArrayList<>();

        public RoomSerializer(Room room) {
            this.roomNumber = room.getRoomNumber();
            setGuests(room);
        }

        private void setGuests(Room room) {
            // Player
            player = room.getPlayer().getName();
//            guests.add(room.getPlayer().getName());
            // Viewers
            for (Guest viewer : room.getViewers()) {
                guests.add(viewer.getName());
            }
        }
    }
}