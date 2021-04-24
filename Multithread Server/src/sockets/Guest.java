package sockets;

public class Guest{
    private final int id;
    private final String name;
    private final int roomNumber;
    private final Server.ClientHandler socket;
    private boolean inRoom = false;

    public Guest(int id, String name, int roomNumber, Server.ClientHandler socket) {
        this.id = id;
        this.name = name;
        this.roomNumber = roomNumber;
        this.socket = socket;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isInRoom() {
        return inRoom;
    }

    public void setInRoom(boolean inRoom) {
        this.inRoom = inRoom;
    }

    public Server.ClientHandler getSocket() {
        return socket;
    }
}
