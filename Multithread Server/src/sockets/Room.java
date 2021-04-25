package sockets;

import settings.Settings;

import java.io.IOException;
import java.util.ArrayList;

public class Room {

    // Attributes
    private final int roomNumber;
    private Guest player = null;
    private final ArrayList<Guest> viewers = new ArrayList<>();

    // Constructor
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    // Methods
    public Guest getPlayer() {
        return player;
    }

    public void setPlayer(Guest player) {
        if (this.player == null) this.player = player;
    }

    public ArrayList<Guest> getViewers() {
        return viewers;
    }

    public void addViewer(Guest viewer) {
        if (!isFull()) {
            viewers.add(viewer);
        }
    }

    public boolean contains(int id) {
        if (player == null ) return false;
        if (player.getId() == id) return true;
        for (Guest viewer : viewers) {
            if (viewer.getId() == id) return true;
        }
        return false;
    }

    public void removeSomebody(int id) throws IOException {
        // To remove a player.
        if (id == player.getId()) {
            // Disconnect everybody of the room.
            try {
                player.getSocket().endConnection();
            } catch (IOException e) {
                e.printStackTrace();

            }
            for (Guest viewer : viewers) { viewer.getSocket().endConnection(); }
            // Clear the room data.
            viewers.removeAll(viewers);
            player = null;
            return;
        }
        // To remove a viewer.
        // Search for it in the viewers list and end its connection, then remove it from the server data.
        for (Guest viewer : viewers) {
            if (id == viewer.getId()) {
                viewer.getSocket().endConnection();
                viewers.remove(viewer);
            }
        }
    }

    public boolean inGame() {
        return (player != null);
    }

    public boolean isFull() {
        return (viewers.size() == Settings.maximumViewersPerRoom);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

}
