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



int m_initC();
int m_Move(int dir);
int m_printActual();

void m_fillStruct();

#endif //CLIENTE_LOBBYCONTROLLER_H
