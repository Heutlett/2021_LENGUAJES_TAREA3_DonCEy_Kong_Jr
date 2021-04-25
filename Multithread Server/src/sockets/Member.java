package sockets;

/**
 * Clase Member
 * Clase utilizada para guardar los datos de un
 * cliente en una sala.
 */
public class Member {

    /* Attributes */
    private final int id;
    private final String name;
    private final Server.ClientHandler socket;

    /* Constructor */
    public Member(Server.ClientHandler client) {
        this.id = client.getClientId();
        this.name = client.getUsername();
        this.socket = client;
    }

    /**
     * Retora atributo id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Retora atributo name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Funcion que cierra el socket del cliente.
     */
    public void endConnection() {
        socket.endConnection();
    }
}
