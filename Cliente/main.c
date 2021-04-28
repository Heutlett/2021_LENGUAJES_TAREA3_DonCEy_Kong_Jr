

#include "ui/GameWindow.h"
#include "ui/LobbyWindow.h"


static char* serverIp = "127.0.0.1";
int port = 9090;


int main() {

    conectar(serverIp, port);
    init_lobby();
    run_lobby();

    init_game();
    run();

    return 0;
}

