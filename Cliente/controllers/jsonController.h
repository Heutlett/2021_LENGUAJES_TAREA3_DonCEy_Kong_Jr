//
// Created by andre on 24/4/2021.
//

#ifndef CLIENTE_JSONCONTROLLER_H
#define CLIENTE_JSONCONTROLLER_H


#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include "json.h"

static int id;

static struct room
{
    int number;
    char player[20];
    char guest1[20];
    char guest2[20];
};

struct room room1, room2;


static void print_depth_shift(int depth);
static void process_value(json_value* value, int depth);
static void process_object(json_value* value, int depth);
static void process_array(json_value* value, int depth);
int jsonRoomParser(int i);

void JL_printStructs();
void init_jController();

#endif //CLIENTE_JSONCONTROLLER_H
