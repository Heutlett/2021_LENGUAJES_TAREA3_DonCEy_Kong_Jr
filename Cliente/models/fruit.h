//
// Created by andre on 18/4/2021.
//

#ifndef CLIENTE_FRUIT_H
#define CLIENTE_FRUIT_H

#include <allegro5/allegro.h>
#include "allegro5/allegro_image.h"

static ALLEGRO_BITMAP *banana;
static ALLEGRO_BITMAP *apple;
static ALLEGRO_BITMAP *mango;

static int fruit_kind = 1;
static int Fx = 400;
static int Fy = 400;

void init_fruit();
//void draw_kremlin();
void draw_fruitXY(int x_, int y_, int kind);
void destroy_fruit();
/*void set_kremlinAction(int action);
void set_kremlinColor(int color);
void set_xKremlin(int x_);
void set_yKremlin(int y_);
int get_xKremlin();
int get_yKremlin();*/

#endif //CLIENTE_FRUIT_H
