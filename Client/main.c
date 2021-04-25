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
    char str1[] = "{\"username\":\"Mikael\",\"type\":\"host\",\"room\":2}";
    char str2[] = "IT IS ME";
    // Tests  //


    /// Log in ///
    enviar("join");
    escuchar(); // cuartos disponibles.
    enviar(str1); // json de login.
    escuchar(); // matrix inicial.

    /// If viewer ///
    while (1){
        enviar("S"); // como no es es jugador, no envia Keypressed.
//        sleep(1000);
        escuchar(); // la matriz que se actualizo antes.
//        sleep(1000);
    }



    return 0;
}
