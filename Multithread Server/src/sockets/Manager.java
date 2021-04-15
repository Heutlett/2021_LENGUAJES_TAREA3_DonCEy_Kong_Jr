package sockets;

import structure.Tuple;

import java.util.ArrayList;

public class Manager {

    private final static String playerAction = "player";
    private final static String viewerRequest = "viewer";

    private final Room room1 = new Room(1);
    private final Room room2 = new Room(2);
    private final ArrayList<Room> rooms = new ArrayList<>();


    public Manager() {
        this.rooms.add(room1);
        this.rooms.add(room2);
    }


    public boolean isFull() {
        for (Room room : rooms) {
            if (!room.isFull())
                return false;
        }
        return true;
    }


    public boolean isEmpty() {
        for (Room room : rooms) {
            if (room.inGame())
                return false;
        }
        return true;
    }


    public String currentGames() {
        if(isEmpty()) return "No games";
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            if (room.inGame()) {
                if ((i == rooms.size() - 1) && room2.isEmpty()){
                    s.append("|").append(room.getNames());
                } else if (i == rooms.size() - 1) {
                    s.append(room.getNames());
                } else{
                    s.append(room.getNames()).append("|");
                }
            }
        }
        return (!s.toString().equals("")) ? s.toString() : "No games";
    }


    public String addPlayer(Server.ClientHandler client) {
        for (Room room : rooms){
            if (room.isEmpty()){
                client.setRoomNumber(room.getRoomNumber());
                client.setInRoom(true);
                Tuple<Integer, Server.ClientHandler> guest = new Tuple<>(client.getClientID(), client);
                room.addGuest(guest);
                return "You are host of room "+room.getRoomNumber();
            }
        }
        return "All rooms full";
    }


    public String addViewer(int roomNumber, Server.ClientHandler client) {
        Room room = (roomNumber == 1) ? room1 : room2;

        if (room.inGame()){
            client.setRoomNumber(room.getRoomNumber());
            client.setInRoom(true);
            Tuple<Integer, Server.ClientHandler> guest = new Tuple<>(client.getClientID(), client);
            room.addGuest(guest);
            return "You are the guest " + (room.size()-1) + " in room " + room.getRoomNumber();
        }
        return "All rooms full";
    }


    public void removeGuest(Server.ClientHandler clientHandler) {
        if ((clientHandler.getRoomNumber() == 1)) {
            room1.removeGuest(clientHandler);
        } else {
            room2.removeGuest(clientHandler);
        }
    }


    public String updateMatrix(String json){
        // do something
         return "This is a matrix, do with it whatever you pleased!";
    }


}