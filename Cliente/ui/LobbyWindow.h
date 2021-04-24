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

static ALLEGRO_DISPLAY *Lobbydisplay;
static ALLEGRO_EVENT_QUEUE *Lobbyqueue;
static ALLEGRO_TIMER *Lobbytimer;
static ALLEGRO_FONT *Lobbyfont;

static ALLEGRO_BITMAP *Lobbybackground;

static bool Lobbyrunning = true;



#endif //CLIENTE_LOBBYWINDOW_H
