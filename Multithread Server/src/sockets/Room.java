package sockets;

import settings.Settings;

import java.util.ArrayList;

/**
 * Clase Room
 * Define la estructura del servidor, pues es utilizada
 * como sala donde existe un anfitrion y sus invitados.
 */
public class Room {

    /* Attributes */
    private final int roomNumber;
    private Member host = null;
    private final ArrayList<Member> guests = new ArrayList<>();
    private String matrix;
    //private Ventana ventana;

    /* Constructor */
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        //ventana = new Ventana();
        this.matrix = "Init Matrix : "+ roomNumber; // Aquí debemos llamar a la matrix inicial.
    }

    /* Methods */

    /**
     * Agrega una instancia de Member a la lista de invitados.
     * @param guest El miembro que se debe agregar.
     */
    public void addGuest(Member guest) {
        if (!isFull()) {
            guests.add(guest);
        }
    }

    /**
     * Averigua si el id del miembro se encuentra en la sala.
     * @param id El id del miembro que se desea encontrar.
     * @return boolean
     */
    public boolean contains(int id) {
        if (host == null ) return false;
        if (host.getId() == id) return true;
        for (Member guest : guests) {
            if (guest.getId() == id) return true;
        }
        return false;
    }

    /**
     * Funcion que remueve de la lista de mimebros de la sala
     * al cliente con el id que coincide.
     * @param id El id del miembro que se desea eliminar.
     */
    public void removeMember(int id) {
        // To remove a host.
        if (id == host.getId()) {
            // Disconnect everybody of the room.
            host.endConnection();
            for (Member guest : guests) {
                guest.endConnection();
            }
            // Clear the room data.
            guests.removeAll(guests);
            host = null;
            return;
        }
        // To remove a guest.
        // Search for it in the guests list and end its connection, then remove it from the server data.
        for (Member guest : guests) {
            if (id == guest.getId()) {
                guest.endConnection();
                guests.remove(guest);
            }
        }
    }


    /**
     * Retorna la matriz.
     * @return String
     */
    public String getMatrix() {
        return matrix;
    }

    /**
     * Funciona que realiza una llamada a la logica y setea el valor
     * recibido al atributo matrix. Es un sistema de caja negra.
     * @param key Tecla presionada.
     */
    public void updateMatrix(String key){
        // do something
        matrix =  "Matrix with key pressed : "+ roomNumber;
    }


    /**
     * Retorna si la sala tiene un host.
     * @return boolean
     */
    public boolean inGame() {
        return (host != null);
    }

    /**
     * Retorna si la sala tiene el maximo de invitados.
     * @return boolean
     */
    public boolean isFull() {
        return (guests.size() == Settings.maximumViewersPerRoom);
    }

    /**
     * Retora atributo roomNumber
     * @return int
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Retora atributo host
     * @return Member
     */
    public Member getHost() {
        return host;
    }

    /**
     * Asigna el host valor de parametro al valor de la sala.
     * @param host El host que se debe asignar.
     */
    public void setHost(Member host) {
        if (this.host == null) this.host = host;
    }

    /**
     * Retora atributo guests
     * @return ArrayList<Member>
     */
    public ArrayList<Member> getGuests() {
        return guests;
    }



}
