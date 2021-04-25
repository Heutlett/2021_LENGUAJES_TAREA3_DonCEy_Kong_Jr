//
// Created by andre on 21/4/2021.
//

#ifndef CLIENTE_LOBBYWINDOW_H
#define CLIENTE_LOBBYWINDOW_H


#include <allegro5/allegro.h>
#include <allegro5/allegro_font.h>
#include <allegro5/allegro_ttf.h>
#include "allegro5/allegro_image.h"
#include <allegro5/allegro_primitives.h>
#include "../controllers/lobbyController.h"
#include "../controllers/jsonController.h"

static ALLEGRO_DISPLAY *Lobbydisplay;
static ALLEGRO_EVENT_QUEUE *Lobbyqueue;
static ALLEGRO_TIMER *Lobbytimer;
static ALLEGRO_FONT *Lobbyfont1;
static ALLEGRO_FONT *Lobbyfont2;

static ALLEGRO_BITMAP *Lobbybackground;
static ALLEGRO_BITMAP *LobbyminiBG;
static ALLEGRO_BITMAP *LobbySelector;

static ALLEGRO_COLOR title1;
static ALLEGRO_COLOR title2;
static ALLEGRO_COLOR cl_on;
static ALLEGRO_COLOR cl_off;


static bool Lobbyrunning = true;

int init_lobby();
int run_lobby();

#endif //CLIENTE_LOBBYWINDOW_H
