package sockets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class Manager {


    private final static Integer maximumActiveRooms = 2;
    private final static String playerAction = "player";
    private final static String viewerRequest = "viewer";
    private static final ArrayList<Room> rooms = new ArrayList<>();


    public Manager() {
        setRooms();
    }

    // Funcion que inserta una cantidad fija de Host en la lista Rooms.
    // Como maximunActiveRooms es 2, significa que solo existen 2 salas, es decir solo dos jugadores a la misma vez.
    private void setRooms() {
        for (int r = 1; r < maximumActiveRooms; ++r) {
            rooms.add(new Room(r));
        }
    }

    // Funcion para verificar si hay espacio para un jugador.
    public boolean isEmpty() {
        for (Room room : rooms) {
            if (room.inGame())
                return false;
        }
        return true;
    }

    // Funcion que retorna si hay espacio para un espectador.
    public boolean isFull() {
        for (Room room : rooms) {
            if (!room.isFull())
                return false;
        }
        return true;
    }

    // Funcion que retorna los juegos en curso hasta el momento.
    // Las salas que tengan como mínimo un jugador, son partidas en curso.
    public String getCurrentGames() throws JsonProcessingException {
        if (isEmpty()) return "No games";

        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < rooms.size(); i++) {
            if (i ==  rooms.size()-1){
                str.append(Serializer.serializeRoom(rooms.get(i))).append("]");
            } else{
                str.append(Serializer.serializeRoom(rooms.get(i))).append(",");
            }
        }
//        System.out.println("JSON :" + str);
        return str.toString();
    }


    public String addPlayer(Server.ClientHandler client) {
        for (Room room : rooms){
            if (room.isEmpty()){
                client.setRoomNumber(room.getRoomNumber());
                client.setInRoom(true);
                // Creo el perfil del jugador y lo agrego a la sala como jugador.
                Guest player = new Guest(client.getClientId(),client.getUsername(), client.getRoomNumber());
                room.setPlayer(player);
                player.setInRoom(true);
                return "You are host of room "+room.getRoomNumber();
            }
        }
        return "All rooms full";
    }


    public String addViewer(int roomNumber, Server.ClientHandler client) {
        Room room = rooms.get(roomNumber-1);
        if (room.inGame()){
            client.setRoomNumber(room.getRoomNumber());
            client.setInRoom(true);
            // Creo el perfil del espectador y lo agrego a la sala como espectador.
            Guest viewer = new Guest(client.getClientId(),client.getUsername(), client.getRoomNumber());
            room.addViewer(viewer);
            viewer.setInRoom(true);
            return "You are the guest " + (room.getViewers().size()) + " in room " + room.getRoomNumber();
        }
        return "All rooms full";
    }


    public void removeSomeone(int id) {
        for (Room room : rooms)
            if (room.contains(id)) room.removeSomebody(id);
    }


    public String updateMatrix(String json){
        // do something
         return "This is a matrix, do with it whatever you pleased!";
    }


}