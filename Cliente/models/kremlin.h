//
// Created by andre on 18/4/2021.
//

#ifndef CLIENTE_KREMLIN_H
#define CLIENTE_KREMLIN_H

#include <allegro5/allegro.h>
#include "allegro5/allegro_image.h"

//Bitmaps
static ALLEGRO_BITMAP *kremlinRU;
static ALLEGRO_BITMAP *kremlinRD;
static ALLEGRO_BITMAP *kremlinBU;
static ALLEGRO_BITMAP *kremlinBD;

//Variables de kremlin
static int kremlin_action = 1;
static int kremlin_color = 1;
static int Kx = 400;
static int Ky = 400;

/**
 * Inicializa las variables de kremlin.
 */
void init_kremlin();

/**
 * Dibuja kremlin.
 */
void draw_kremlin();

/**
 * Dibuja el bitmap de un kremlin en una posicion (x y).
 * @param x_
 * @param y_
 * @param color
 */
void draw_kremlinXY(int x_, int y_, int color);

/**
 * Libera la memoria de los kremlin.
 */
void destroy_kremlin();


#endif //CLIENTE_KREMLIN_H
