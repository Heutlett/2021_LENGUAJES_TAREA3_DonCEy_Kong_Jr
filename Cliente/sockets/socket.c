//
// Created by Jeykime on 4/24/2021.
//

#include "socket.h"

#include <stdio.h>
#include <winsock2.h>
#include <windows.h>
#include <io.h>

char Cadena[10000];

WSADATA wsaData;
SOCKET mySocket;
struct sockaddr_in server;
struct hostent *hp;
int resp;

/**
 * Se conecta a un puerto.
 * @param ip
 * @param port
 * @param message
 * @return
 */
int conectar(char *ip, int port) {
    //Inicializa la DLL de sockets
    resp = WSAStartup(MAKEWORD(1, 0), &wsaData);
    if (resp) {
        printf("Failed to initialize socket.\n");
        return -1;
    }

    // Se obtiene la IP del servidor. (para este caso es localhost)
    hp = (struct hostent *) gethostbyname(ip);

    if (!hp) {
        printf("No server found.\n");
        WSACleanup();
        return -1;
    }

    // Creamos el socket...
    mySocket = socket(AF_INET, SOCK_STREAM, 0);
    if (mySocket == INVALID_SOCKET) {
        printf("Failed to create socket.\n");
        WSACleanup();
        return -1;
    }

    memset(&server, 0, sizeof(server));
    memcpy(&server.sin_addr, hp->h_addr, hp->h_length);
    server.sin_family = hp->h_addrtype;
    server.sin_port = htons(port);

    // Nos conectamos con el servidor...
    if (connect(mySocket, (struct sockaddr *) &server, sizeof(server)) == SOCKET_ERROR) {
        printf("Failed to connect to the server.\n");
        closesocket(mySocket);
        WSACleanup();
        return -1;
    }
    printf("Connection established with: %s\n", inet_ntoa(server.sin_addr));
    return 0; // Return 0 para saber que se logro.
}

/**
 * Eschucha en el puerto conectado.
 * @param puerto
 * @param ip
 * @return
 */
char* escuchar() {
    memset(&Cadena[0], 0, sizeof(Cadena));
    recv(mySocket, Cadena, sizeof(Cadena), 0);
    printf("Rcvd: %s \n", Cadena);
    // Return el buffer recibido.
    return Cadena;
}

/**
 * Envia un mensaje al puerto conectado.
 * @param ip
 * @param puerto
 * @param mensaje
 * @return
 */
int enviar(char* mensaje) {

    /*
     * Se va a enviar una cadena de x caracteres, incluido el \0. Previamente se
     * envía un entero con el x.
     */
    int Aux;

    // Limpiar la Cadena.
    memset(&Cadena[0], 0, sizeof(Cadena));

    // Copiar mensaje en cadena.
    strcpy (Cadena, mensaje);

    // Obtener bits del mensaje.
    u_long Longitud_Cadena = strlen(Cadena)+1; // agrega el '\0'.

    /* Antes de enviar el entero hay que transformalo a formato red */
    Aux = htonl (Longitud_Cadena);
    send (mySocket, (char *)&Aux, sizeof(Longitud_Cadena),0);
    printf ("\nSent: %lu", Longitud_Cadena-1);

    /* Se envía la cadena */
    send(mySocket, Cadena, Longitud_Cadena, 0);
    printf(" - %s\n", Cadena);

    return 0;  // Return 0 para saber que se logro.
}
