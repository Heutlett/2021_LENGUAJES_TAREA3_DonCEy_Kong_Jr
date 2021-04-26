//
// Created by andre on 24/4/2021.
//

#include "jsonController.h"

static void print_depth_shift(int depth)
{
    int j;
    for (j=0; j < depth; j++) {
        printf(" ");
    }
}

static void process_value(json_value* value, int depth);

static void process_object1(json_value* value, int depth)
{
    int length, x;
    if (value == NULL) {
        return;
    }
    length = value->u.object.length;
    for (x = 0; x < length; x++) {
        print_depth_shift(depth);
        if (id == 0) {
            if (!strcmp(value->u.object.values[x].name, "roomNumber")) {
                room1.number = value->u.object.values[x].value->u.integer;
            }
            if (!strcmp(value->u.object.values[x].name, "player")) {
                strcpy(room1.player, value->u.object.values[x].value->u.string.ptr);
            }
            if (!strcmp(value->u.object.values[x].name, "guests")) {
                if (value->u.object.values[x].value->u.array.length == 1){
                    strcpy(room1.guest1, value->u.object.values[x].value->u.array.values[0]->u.string.ptr);
                }
                if (value->u.object.values[x].value->u.array.length == 2){
                    strcpy(room1.guest1, value->u.object.values[x].value->u.array.values[0]->u.string.ptr);
                    strcpy(room1.guest2, value->u.object.values[x].value->u.array.values[1]->u.string.ptr);
                }
            }
        }
        if (id == 1) {
            if (!strcmp(value->u.object.values[x].name, "roomNumber")) {
                room2.number = value->u.object.values[x].value->u.integer;
            }
            if (!strcmp(value->u.object.values[x].name, "player")) {
                strcpy(room2.player, value->u.object.values[x].value->u.string.ptr);
            }
            if (!strcmp(value->u.object.values[x].name, "guests")) {
                if (value->u.object.values[x].value->u.array.length == 1){
                    strcpy(room2.guest1, value->u.object.values[x].value->u.array.values[0]->u.string.ptr);
                }
                if (value->u.object.values[x].value->u.array.length == 2){
                    strcpy(room2.guest1, value->u.object.values[x].value->u.array.values[0]->u.string.ptr);
                    strcpy(room2.guest2, value->u.object.values[x].value->u.array.values[1]->u.string.ptr);
                }
            }
        }
    }
}

static void process_object2(json_value* value, int depth)
{
    int length, x;
    if (value == NULL) {
        return;
    }
    length = value->u.object.length;
    for (x = 0; x < length; x++) {

        if (!strcmp(value->u.object.values[x].name, "vidas")) {
            game1.hlth = value->u.object.values[x].value->u.integer;
        }
        if (!strcmp(value->u.object.values[x].name, "puntuacion")) {
            game1.pts = value->u.object.values[x].value->u.integer;
        }
        if (!strcmp(value->u.object.values[x].name, "nivel")) {
            game1.level = value->u.object.values[x].value->u.integer;
        }
        if (!strcmp(value->u.object.values[x].name, "haPerdido")) {
            game1.lose = value->u.object.values[x].value->u.boolean;
        }
        if (!strcmp(value->u.object.values[x].name, "haGanado")) {
            game1.win = value->u.object.values[x].value->u.boolean;
        }
        if (!strcmp(value->u.object.values[x].name, "entidades ")) {
            game1.len = value->u.object.values[x].value->u.array.length;
            for (int i = 0; i < value->u.object.values[x].value->u.array.length; ++i) {
                for (int j = 0; j < 3; ++j) {
                    game1.matrix[i][j] = value->u.object.values[x].value->u.array.values[i]->u.array.values[j]->u.integer;
                }
            }
        }
    }
}

static void process_array(json_value* value, int depth)
{
    int length, x;
    if (value == NULL) {
        return;
    }
    length = value->u.array.length;
    printf("array\n");
    for (x = 0; x < length; x++) {

        process_value(value->u.array.values[x], depth);

    }
}

static void process_value(json_value* value, int depth)
{
    int j;
    if (value == NULL) {
        return;
    }
    if (value->type != json_object) {
        print_depth_shift(depth);
    }
    switch (value->type) {
        case json_none:
            printf("none\n");
            break;
        case json_object:
            if (id_j == 1) {
                process_object1(value, depth + 1);
            } else {
                process_object2(value,depth + 1);
            }
            break;
        case json_array:
            process_array(value, depth+1);
            break;
        case json_integer:
            printf("int: %10" PRId64 "\n", value->u.integer);
            break;
        case json_double:
            printf("double: %f\n", value->u.dbl);
            break;
        case json_string:
            printf("string: %s\n", value->u.string.ptr);
            break;
        case json_boolean:
            printf("bool: %d\n", value->u.boolean);
            break;
    }
}

int jsonRoomParser(int i) {

    id_j =1;
    id = i;

    json_value* value;


    value = json_parse(jsonRead, strlen(jsonRead));

    if (value == NULL) {
        fprintf(stderr, "Unable to parse data\n");
        exit(1);
    }

    process_value(value->u.array.values[i], 1);


    json_value_free(value);


    return 0;
}

int jsonMatrixParser() {

    id_j = 2;


    json_value* value;


    value = json_parse(jsonRead, strlen(jsonRead));

    if (value == NULL) {
        fprintf(stderr, "Unable to parse data\n");
        exit(1);
    }

    process_value(value, 0);


    json_value_free(value);


    return 0;
}

void JL_printStructs(){
    printf("\n***********\nROOM1\n\n");
    printf("NUMB: %d\n", room1.number);
    printf("NAME: "), printf(room1.player), printf("\n");
    printf("GUE1: "), printf(room1.guest1), printf("\n");
    printf("GUE1: "), printf(room1.guest2), printf("\n");
    printf("\n***********\nROOM2\n\n");
    printf("NUMB: %d\n", room2.number);
    printf("NAME: "), printf(room2.player), printf("\n");
    printf("GUE1: "), printf(room2.guest1), printf("\n");
    printf("GUE1: "), printf(room2.guest2), printf("\n");
    printf("\n***********\nGAME\n\n");
    printf("WIN?: %d\n", game1.win);
    printf("LOSE: %d\n", game1.lose);
    printf("LEVL: %d\n", game1.level);
    printf("POTS: %d\n", game1.pts);
    printf("HLTH: %d\n", game1.hlth);
    printf("MTRX: \n");
    for (int i = 0;i<100;i++){
        printf("\n");
        for (int j = 0; j < 100; ++j) {
            printf("%d",game1.matrix[i][j]);
        }
    }
    printf("\n-----------------");
}

void init_jController(){
    strcpy(room1.guest1,"null");
    strcpy(room1.guest2,"null");
    strcpy(room2.guest1,"null");
    strcpy(room2.guest2,"null");
}

void reloadJFileRooms(char* json_file[]){
    jsonRead = json_file;
}