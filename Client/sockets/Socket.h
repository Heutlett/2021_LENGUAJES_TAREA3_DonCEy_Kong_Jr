//
// Created by Jeykime on 4/25/2021.
//

#ifndef CLIENT_SOCKET_H
#define CLIENT_SOCKET_H

int conectar(char *ip, int port);
char* escuchar();
int enviar(char *mensaje);


#endif //CLIENT_SOCKET_H
