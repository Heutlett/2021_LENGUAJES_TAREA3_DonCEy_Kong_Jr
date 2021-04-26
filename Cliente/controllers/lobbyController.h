//
// Created by andre on 24/4/2021.
//

#ifndef CLIENTE_LOBBYCONTROLLER_H
#define CLIENTE_LOBBYCONTROLLER_H

#include <stdio.h>
#include "jsonController.h"

int menu[2][2];
int m_bt[2][2];
int mc_i;
int mc_j;

char* espectadores[4];
int e_cont;

char* m_player;
char* m_type;
char* m_room;

int m_initC();
int m_Move(int dir);
int m_printActual();

void m_fillStruct();
void setSendJson();

#endif //CLIENTE_LOBBYCONTROLLER_H
