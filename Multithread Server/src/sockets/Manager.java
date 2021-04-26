package sockets;

import org.json.JSONObject;
import settings.Settings;

import java.util.ArrayList;

/**
 * Clase Manager
 * Es la clase principal que hace manejo de las peticiones, resolución
 * y respuesta, así como el manejo de los miembros de la base de datos
 * de las salas.
 */
public class Manager {

    // Attributes
    private static final ArrayList<Room> rooms = new ArrayList<>();

    // Constructor
    public Manager() {
        setRooms();
    }

    /**
     * Funcion que inserta una cantidad fija de Salas en la lista Salas.
     * Nota: maximunActiveRooms es 2, significa que solo existen 2 salas
     * como maximo, es decir solo dos jugadores a la misma vez.
     */
    private void setRooms() {
        for (int r = 0; r < Settings.maximumActiveRooms; ++r) {
            rooms.add(new Room(r+1));
        }
    }

    /**
     * Funcion para verificar si hay espacio para un jugador.
     * @return boolean
     */
    public boolean isEmpty() {
        for (Room room : rooms) {
            if (room.inGame())
                return false;
        }
        return true;
    }

    /**
     * Funcion que retorna si hay espacio para un espectador.
     * @return boolean
     */
    public boolean isFull() {
        for (Room room : rooms) {
            if (!room.isFull())
                return false;
        }
        return true;
    }

    /**
     * Funcion que retorna los juegos en curso hasta el momento.
     * Nota: Las salas que tengan como mínimo un jugador, son partidas en curso.
     * @return String
     */
    public String getCurrentGames() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < rooms.size(); i++) {
            if (i ==  rooms.size()-1){ str.append(Serializer.serializeRoom(rooms.get(i))).append("]"); }
            else{ str.append(Serializer.serializeRoom(rooms.get(i))).append(","); }
        }
//        System.out.println("JSON :" + str);
        return str.toString();
    }

    /**
     * Funcion que lee el json recibido y agrega al cliente
     * a una sala, dependiendo de la informacion recibida.
     * @param json String en formato json recibido del cliente.
     * @param client Socket del cliente.
     * @return int
     */
    public int addMember(String json, Server.ClientHandler client) {

        json = json.replaceAll(" ", "");
        json = json.replaceAll("\n", "");
        json = json.replaceAll("\t", "");

        System.out.println("PRUEBA");
        System.out.println(json);
        JSONObject obj = new JSONObject(json); // Parse String to JSONObject.
        // { "username":"Player1", "type":"player", "room":"2" }";
        client.setUsername(obj.getString("username")); //Set nombre del miembro.
        String type = obj.getString("type");
        int room = obj.getInt("room")-1; // -1 por el indice de la sala.

        if(type.equalsIgnoreCase("player")) {
            client.setIsPlayer(true); // Si es jugador, true, sino false.
            return addHost(room, client);
        }else if (type.equalsIgnoreCase("viewer")) {
            if (isEmpty()) return 0;
            return addGuest(room, client);
        }
        return 0;
    }

    /**
     * Funcion que crea una instancia de la clase Miembro con los datos recibidos
     * y la agrega como Host de la Sala en el numero de sala correspondiente.
     * Output: 1 si tiene exito, 0 si la sala esta en partida.
     * @param roomNumber Numero de sala.
     * @param client Socket del cliente.
     * @return int
     */
    private int addHost(int roomNumber, Server.ClientHandler client) {
        Room room = rooms.get(roomNumber);
        if (!room.inGame()) {
            /* Se crea el perfil del host y lo agrego a la sala como host. */
            client.setRoomNumber(roomNumber);
            Member host = new Member(client);
            room.setHost(host);
            room.startVentana();
            return 1;
        } return 0;
    }

    /**
     * Funcion que crea una instancia de la clase Miembro con los datos recibidos
     * y la agrega como Guest en el numero de sala correspondiente.
     * Output: 1 si tiene exito, 0 si la sala esta llena.
     * @param roomNumber Numero de sala.
     * @param client Socket del cliente.
     * @return int
     */
    private int addGuest(int roomNumber, Server.ClientHandler client) {
        Room room = rooms.get(roomNumber);
        if (!room.isFull()) {
            /* Se crea el perfil del invitado y lo agrego a la sala como guest. */
            client.setRoomNumber(roomNumber);
            Member host = new Member(client);
            room.addGuest(host);
            return 1;
        } return 0;
    }

    /**
     * Funcion que remueve a un miembro de la sala.
     * Nota: Si el miembre es host, saca a todos de la sala.
     * @param id ID del miembro que se debe remover.
     */
    public void removeMember(int id) {
        for (Room room : rooms)
            if (room.contains(id)) room.removeMember(id);
    }

    /**
     * Funciona que realiza una llamada a la logica y setea el valor
     * recibido al atributo matrix. Es un sistema de caja negra.
     * @param roomNumber Numero de sala
     * @param k Tecla presionada.
     */
    public void updateMatrix(int roomNumber, String k) {
        Room room = rooms.get(roomNumber);
        room.updateMatrix(k);
    }

    /**
     * Retorna el atributo matrix.
     * @return String
     */
    public String getMatrix(int roomNumber) {
        Room room = rooms.get(roomNumber);
        return room.getMatrix();
    }

}