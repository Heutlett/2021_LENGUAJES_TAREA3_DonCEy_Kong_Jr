//
// Created by andre on 19/4/2021.
//

#ifndef CLIENTE_KEY_H
#define CLIENTE_KEY_H

#include <allegro5/allegro.h>
#include "allegro5/allegro_image.h"

static ALLEGRO_BITMAP *key;

void init_key();
void draw_keyXY(int x_, int y_);
void destroy_key();

#endif //CLIENTE_KEY_H
