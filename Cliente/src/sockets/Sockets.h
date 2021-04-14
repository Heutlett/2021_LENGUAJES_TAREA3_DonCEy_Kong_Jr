//
// Created by Jeykime on 4/14/2021.
//

#ifndef CLIENTE_SOCKETS_H
#define CLIENTE_SOCKETS_H

char* listen(int port, char* ip);
int send(char *ip, int port, char* message);


#endif //CLIENTE_SOCKETS_H
