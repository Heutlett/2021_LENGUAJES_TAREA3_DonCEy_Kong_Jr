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


    while (1){
        enviar(str2);
        escuchar();
        escuchar();
        sleep(3000);
    }



    return 0;
}
