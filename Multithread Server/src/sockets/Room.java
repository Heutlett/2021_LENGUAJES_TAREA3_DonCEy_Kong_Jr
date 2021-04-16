package sockets;

import structures.Tuple;

import java.util.ArrayList;

public class Room {

    private final static Integer playerIndex = 0;
    private final static Integer maximumGuestsPerRoom = 3;

    private final int roomNumber;
    private ArrayList<Tuple<Integer, Server.ClientHandler>> guests = new ArrayList<>();

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void addGuest(Tuple<Integer, Server.ClientHandler> guest){
        if (!isFull()) {
            guests.add(guest);
        }
    }

    public void removeGuest(Server.ClientHandler guest){
        for (int i = 0; i < guests.size(); i++) {
            if ( guests.get(i).getA().equals(guest.getClientID()) ){
                if ( i==playerIndex ){
                    guests.clear();
                } else{
                    guests.remove(guests.get(i));
                }
            }
        }
    }

    public boolean isEmpty(){
        return guests.isEmpty();
    }

    public boolean inGame() {
        return (guests.size() >= 1);
    }

    public boolean isFull() {
        return (guests.size() == maximumGuestsPerRoom);
    }

    public int size() {
        return guests.size();
    }

    public boolean isAlreadyIn(Integer id){
        for (Tuple<Integer, Server.ClientHandler> guest : guests) {
            if (guest.getA().equals(id)) return true;
        }
        return false;
    }


    public ArrayList<Tuple<Integer, Server.ClientHandler>> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<Tuple<Integer, Server.ClientHandler>> guests) {
        this.guests = guests;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getNames() {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < guests.size(); i++) {
            if (i == guests.size() - 1) {
                a.append(guests.get(i).getB().getUsername());
            }else {
                a.append(guests.get(i).getB().getUsername()).append(",");
            }
        }
        return a.toString();
    }
}
