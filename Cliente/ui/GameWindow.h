//
// Created by Jose Solano on 16/4/2021.
//

#ifndef CLIENTE_GAMEWINDOW_H
#define CLIENTE_GAMEWINDOW_H

#include <allegro5/allegro.h>
#include <allegro5/allegro_font.h>
#include <allegro5/allegro_ttf.h>
#include "allegro5/allegro_image.h"
#include <allegro5/allegro_primitives.h>
#include "../models/monkey.h"
#include "../models/kremlin.h"
#include "../models/fruit.h"
#include <stdio.h>
#include <stdlib.h>
#include "../controllers/jsonController.h"
#include "../sockets/socket.h"
#include "../controllers/lobbyController.h"

//Variables graficas de ALLEGRO
static ALLEGRO_DISPLAY *display;
static ALLEGRO_EVENT_QUEUE *queue;
static ALLEGRO_TIMER *timer;
static ALLEGRO_FONT *font;
static ALLEGRO_FONT *font2;

static ALLEGRO_BITMAP *background;

//Variable que indica si la ventana esta activa
static bool running = true;

//Variables utilizadas durante la ejecucion del juego
static char level[10];
static char health[10];
static char points[15];

static char iLvl[10];
static char iHlth[10];
static char iPts[10];

static int w;
static int a;
static int s;
static int d;

static int viewer;

static int rev;

static char sendKey[5];

/**
 * Inicializa las variables de la ventana juego.
 * @return state
 */
int init_game();

/**
 * Inicia la ejecucion de la ventana juego.
 */
int run();

#endif //CLIENTE_GAMEWINDOW_H
