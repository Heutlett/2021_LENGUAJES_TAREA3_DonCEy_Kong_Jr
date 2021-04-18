//
// Created by andre on 17/4/2021.
//

#ifndef CLIENTE_MONKEY_H
#define CLIENTE_MONKEY_H

#include <allegro5/allegro.h>
#include "allegro5/allegro_image.h"

static ALLEGRO_BITMAP *monkeyL;
static ALLEGRO_BITMAP *monkeyR;

static int monkey_action = 1;
static int Mx = 20;
static int My = 615;

void init_monkey();
void draw_monkey();
void draw_monkeyXY(int x_, int y_);
void destroy_monkey();
void set_monkeyAction(int action);
void set_xMonkey(int x_);
void set_yMonkey(int y_);
int get_xMonkey();
int get_yMonkey();

#endif //CLIENTE_MONKEY_H
