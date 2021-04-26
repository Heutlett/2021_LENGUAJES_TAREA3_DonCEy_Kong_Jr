
#include <allegro5/allegro.h>
#include <allegro5/allegro_primitives.h>
#include "controllers/jsonController.h"
#include "ui/GameWindow.h"
#include "ui/LobbyWindow.h"
#include "sockets/socket.h"
#include "controllers/lobbyController.h"
#include "stdio.h"

static char* serverIp = "127.0.0.1";
int port = 9090;

void create_grid(){
    for (int i=0;i<100;i++){
        for (int j=0;j<100;j++){
            al_draw_rectangle(i*5,j*5,5,5, al_map_rgb(255,255,100),2);
        }
    }
}



int main() {

//    room1.number = 1;
//    room2.number = 2;
//
//    strcpy(room1.player,"Jugador1");
//    strcpy(room2.player,"Jugador2");
//
//    strcpy(room1.guest1,"BOT1");
//    strcpy(room2.guest1,"BOT3");
//
//    strcpy(room1.guest2,"BOT2");
//    strcpy(room2.guest2,"BOT4");


//    jsonRoomParser(0);
//    JL_printStructs();
//    jsonRoomParser(1);
//    JL_printStructs();

//    jsonMatrixParser();
    //JL_printStructs();
    conectar(serverIp, port);
    init_lobby();
    run_lobby();

//    init_game();
//    run();


//    reloadJFileRooms("[{\"roomNumber\": 1, \"player\": \"Jugador1\", \"guests\": [\"BOTS1\",\"BOTS2\"]}, {\"roomNumber\": 2, \"player\": \"Jugador2\", \"guests\": []}]"
//    );
//    jsonRoomParser(0);
//    jsonRoomParser(1);
//    JL_printStructs();

//    char rslt[200] = "{\n""\t\"username \": \"";
//    strcat(rslt,"Jugador1");
//    strcat(rslt,"\",\n""\t\"type\": \"");
//    strcat(rslt,"viewer");
//    strcat(rslt,"\",\n""\t\"room\": \"");
//    strcat(rslt,"1");
//    strcat(rslt,"\"}");
//    printf(rslt);

//    reloadJFileRooms("[{\"roomNumber\": 1, \"player\": \"Jugador1\", \"guests\": [\"BOTS1\",\"BOTS2\"]}, {\"roomNumber\": 2, \"player\": \"Jugador2\", \"guests\": []}]");

//    start_connection();
//    //sendMessage("{\"username\": \"Jugador1\",\"type\": \"player\"}");
//    getRecvMessage();
//    close_socket();

//    enviar("127.0.0.1",80,"{\"username\": \"Jugador2\",\"type\": \"player\"}");
//    escuchar(80,"127.0.0.1");

//    [{"roomNumber": 1, "player": "Jugador1", "guests": ["BOTS1","BOTS2"]}, {"roomNumber": 2, "player": "Jugador2", "guests": []}]

    return 0;
}

