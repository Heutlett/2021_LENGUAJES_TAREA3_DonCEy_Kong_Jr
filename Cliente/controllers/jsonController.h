//
// Created by andre on 24/4/2021.
//

#ifndef CLIENTE_JSONCONTROLLER_H
#define CLIENTE_JSONCONTROLLER_H


#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <stdbool.h>
#include "json.h"

//identificador de objeto json
static int id;
//identificador de cadena json
static int id_j;

//Estructura que modela una habitacion de juego
static struct room
{
    int number;
    char player[20];
    char guest1[20];
    char guest2[20];
};

//Estructura que modela un mapa del juego
static struct game
{
    int win;
    int lose;
    int level;
    int pts;
    int hlth;
    int matrix[100][3];
    int len;
};

struct room room1, room2;

struct game game1;

json_char* jsonRead;

/**
 * Imprime identaciones segun una profundidad.
 * @param depth
 */
static void print_depth_shift(int depth);

/**
 * Procesa un valor JSON.
 * @param value
 * @param depth
 */
static void process_value(json_value* value, int depth);

/**
 * Procesa objetos JSON y los organiza en estructuras "room".
 * @param value
 * @param depth
 */
static void process_object1(json_value* value, int depth);

/**
 * Procesa objetos JSON y los organiza en estructuras "game".
 * @param value
 * @param depth
 */
static void process_object2(json_value* value, int depth);

/**
 * Procesa objetos JSON de tipo array.
 * @param value
 * @param depth
 */
static void process_array(json_value* value, int depth);

/**
 * Parsea JSON y guarda en estructuras "room".
 * @param index
 * @return state
 */
int jsonRoomParser(int i);

/**
 * Parsea JSON y guarda en estructuras "game".
 * @return state
 */
int jsonMatrixParser();

/**
 * Imprime las estructuras "room" y "game".
 */
void JL_printStructs();

/**
 * Inicializa variables del controlador en "null".
 */
void init_jController();

/**
 * Recarga el valor del JSON con una cadena de contenido dada.
 * @param json_file
 */
void reloadJFileRooms(char* json_file[]);

#endif //CLIENTE_JSONCONTROLLER_H
