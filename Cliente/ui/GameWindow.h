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
#include "../models/key.h"


static ALLEGRO_DISPLAY *display;
static ALLEGRO_EVENT_QUEUE *queue;
static ALLEGRO_TIMER *timer;
static ALLEGRO_FONT *font;

static ALLEGRO_BITMAP *background;
//static ALLEGRO_BITMAP *monkey;

static bool running = true;
static bool pressed = false;

//static float x = 20;
//static float y = 615;
static char xc[10];
static char yc[10];


int init_game();
int run();

#endif //CLIENTE_GAMEWINDOW_H
