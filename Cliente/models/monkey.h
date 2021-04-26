//
// Created by andre on 17/4/2021.
//

#ifndef CLIENTE_MONKEY_H
#define CLIENTE_MONKEY_H

#include <allegro5/allegro.h>
#include "allegro5/allegro_image.h"

//Bitmaps del mono
static ALLEGRO_BITMAP *monkeyL;
static ALLEGRO_BITMAP *monkeyR;

//Variables del mono
static int monkey_action = 1;
static int Mx = 20;
static int My = 615;

/**
 * Inicializa las variables del mono.
 */
void init_monkey();

/**
 * Dibuja al mono.
 */
void draw_monkey();

/**
 * Dibuja al mono en coordenadas (x y).
 * @param x_
 * @param y_
 */
void draw_monkeyXY(int x_, int y_);

/**
 * Libera memoria del mono.
 */
void destroy_monkey();

/**
 * Establece la accion del mono
 * @param action
 */
void set_monkeyAction(int action);

#endif //CLIENTE_MONKEY_H
