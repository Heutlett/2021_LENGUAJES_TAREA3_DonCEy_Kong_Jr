//
// Created by Jeykime on 4/25/2021.
//

#ifndef CLIENTE_SOCKET_H
#define CLIENTE_SOCKET_H

int conectar(char *ip, int port);
char* escuchar();
int enviar(char *mensaje);


#endif //CLIENTE_SOCKET_H
