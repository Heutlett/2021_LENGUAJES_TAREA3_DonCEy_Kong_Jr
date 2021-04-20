package sockets;

import java.util.ArrayList;

public class Room {

    private final static Integer maximumViewersPerRoom = 2;
    private final int roomNumber;

    private Guest player = null;
    private ArrayList<Guest> viewers = new ArrayList<>();

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }


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
        if (player.getId() == id) return true;
        for (Guest viewer : viewers) {
            if (viewer.getId() == id) return true;
        }
        return false;
    }

    public void removeSomebody(int id) {
        if (id == player.getId()) {
            viewers.removeAll(viewers);
            player = null;
            return;
        }
        for (int i = 0; i < viewers.size(); i++) {
            if (id == viewers.get(i).getId()) {
                viewers.remove(viewers.get(i));
            }
        }
    }


    public boolean isEmpty() {
        return viewers.isEmpty();
    }

    public boolean inGame() {
        return (player != null);
    }

    public boolean isFull() {
        return (viewers.size() == maximumViewersPerRoom);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

}
