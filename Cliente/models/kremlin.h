//
// Created by andre on 18/4/2021.
//

#ifndef CLIENTE_KREMLIN_H
#define CLIENTE_KREMLIN_H

#include <allegro5/allegro.h>
#include "allegro5/allegro_image.h"

static ALLEGRO_BITMAP *kremlinRU;
static ALLEGRO_BITMAP *kremlinRD;
static ALLEGRO_BITMAP *kremlinBU;
static ALLEGRO_BITMAP *kremlinBD;

static int kremlin_action = 1;
static int kremlin_color = 1;
static int Kx = 400;
static int Ky = 400;

void init_kremlin();
void draw_kremlin();
void draw_kremlinXY(int x_, int y_, int color);
void destroy_kremlin();
void set_kremlinAction(int action);
void set_kremlinColor(int color);
void set_xKremlin(int x_);
void set_yKremlin(int y_);
int get_xKremlin();
int get_yKremlin();

#endif //CLIENTE_KREMLIN_H
