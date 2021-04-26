//
// Created by andre on 18/4/2021.
//

#ifndef CLIENTE_FRUIT_H
#define CLIENTE_FRUIT_H

#include <allegro5/allegro.h>
#include "allegro5/allegro_image.h"

//Bitmaps
static ALLEGRO_BITMAP *banana;
static ALLEGRO_BITMAP *apple;
static ALLEGRO_BITMAP *mango;

//Variables de frutas
static int fruit_kind = 1;
static int Fx = 400;
static int Fy = 400;

/**
 * Inicializa las variables de frutas.
 */
void init_fruit();

/**
 * Dibuja el bitmap de una fruta en una posicion (x y).
 * @param x_
 * @param y_
 * @param kind
 */
void draw_fruitXY(int x_, int y_, int kind);

/**
 * Libera la memoria de las frutas.
 */
void destroy_fruit();


#endif //CLIENTE_FRUIT_H
