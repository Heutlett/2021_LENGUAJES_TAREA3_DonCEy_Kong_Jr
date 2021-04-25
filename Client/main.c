#include <stdio.h>
#include "sockets/Socket.h"
#include <unistd.h>

static char* serverIp = "127.0.0.1";
int port = 9090;

int main( )
{
    // First establish connection.
    conectar(serverIp, port);


    // Tests //
    char str1[] = "{\"username\":\"Player1\",\"type\":\"player\"}";
    char str2[] = "IT IS ME";
    // Tests  //


    /// Log in ///
    enviar("join");
    escuchar(); // cuartos disponibles.
    enviar(str1); // json de login.
    escuchar(); // matrix inicial.

    /// If player ///
    while (1){
        enviar("WA"); // como es jugador envia Keypressed.
        escuchar(); // la matriz despues de actualizar con el movimiento nuevo.
        sleep(1000);
    }






    return 0;
}
