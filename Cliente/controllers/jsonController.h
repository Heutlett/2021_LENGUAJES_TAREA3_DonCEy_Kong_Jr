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

static int id;
static int id_j;

static struct room
{
    int number;
    char player[20];
    char guest1[20];
    char guest2[20];
};

static struct game
{
    int win;
    int lose;
    int level;
    int pts;
    int hlth;
    int matrix[100][100];
};

struct room room1, room2;

struct game game1;

static void print_depth_shift(int depth);
static void process_value(json_value* value, int depth);
static void process_object1(json_value* value, int depth);
static void process_object2(json_value* value, int depth);
static void process_array(json_value* value, int depth);
int jsonRoomParser(int i);
int jsonMatrixParser();

void JL_printStructs();
void init_jController();
void reloadJFileRooms(char* json_file[]);

#endif //CLIENTE_JSONCONTROLLER_H
