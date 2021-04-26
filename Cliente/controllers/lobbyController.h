//
// Created by andre on 24/4/2021.
//

#ifndef CLIENTE_LOBBYCONTROLLER_H
#define CLIENTE_LOBBYCONTROLLER_H

#include <stdio.h>
#include "jsonController.h"

//Variables usadas para modelar el menu del lobby
//***********************************************
int menu[2][2];
int m_bt[2][2];
int mc_i;
int mc_j;

char* espectadores[4];
int e_cont;

//Variables que se mandaran en formato json al servidor
char* m_player;
char* m_type;
char* m_room;
//***********************************************

/**
 * Inicializa variables del menu de juego.
 * @return state
 */
int m_initC();

/**
 * Inicializa variables del menu de juego.
 * @return state
 */
int m_Move(int dir);

/**
 * Imprime estado del menu.
 * @return state
 */
int m_printActual();

/**
 * Establece un valor a las variables para enviarlas al servidor.
 */
void setSendJson();

#endif //CLIENTE_LOBBYCONTROLLER_H
