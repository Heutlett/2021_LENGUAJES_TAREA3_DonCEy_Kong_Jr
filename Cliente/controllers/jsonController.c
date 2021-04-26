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
        printf("object[%d].name = %s\n", x, value->u.object.values[x].name);
        if (id == 0) {
            printf("hey");
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
        process_value(value->u.object.values[x].value, depth+1);
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
        //print_depth_shift(depth);
        //printf("object[%d].name = %s\n", x, value->u.object.values[x].name);

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
        if (!strcmp(value->u.object.values[x].name, "matriz ")) {
            for (int i = 0; i < 100; ++i) {
                for (int j = 0; j < 100; ++j) {
                    game1.matrix[i][j] = value->u.object.values[x].value->u.array.values[i]->u.array.values[j]->u.integer;
                }
            }
        }

        //process_value(value->u.object.values[x].value, depth+1);
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
            //process_array(value, depth+1);
            break;
        case json_integer:
            //printf("int: %10" PRId64 "\n", value->u.integer);
            break;
        case json_double:
            printf("double: %f\n", value->u.dbl);
            break;
        case json_string:
            //printf("string: %s\n", value->u.string.ptr);
            break;
        case json_boolean:
            printf("bool: %d\n", value->u.boolean);
            break;
    }
}

int jsonRoomParser(int i) {

    //printf("JSON ROOM PARSER\n");

    id_j =1;
    id = i;

    char* filename;
    FILE *fp;
    struct stat filestatus;
    int file_size;
    char* file_contents;
    json_char* json;
    json_value* value;

    filename = "../data.json";

    if ( stat(filename, &filestatus) != 0) {
        fprintf(stderr, "File %s not found\n", filename);
        return 1;
    }

    file_size = filestatus.st_size;
    file_contents = (char*)malloc(filestatus.st_size);
    if ( file_contents == NULL) {
        fprintf(stderr, "Memory error: unable to allocate %d bytes\n", file_size);
        return 1;
    }

    fp = fopen(filename, "rt");
    if (fp == NULL) {
        fprintf(stderr, "Unable to open %s\n", filename);
        fclose(fp);
        free(file_contents);
        return 1;
    }
    if ( fread(file_contents, file_size, 1, fp) != 1 ) {
        fprintf(stderr, "Unable t read content of %s\n", filename);
        fclose(fp);
        free(file_contents);
        return 1;
    }
    fclose(fp);

    //printf("%s\n", file_contents);

    //printf("--------------------------------\n\n");

    json = (json_char*)file_contents;

    value = json_parse(json,file_size);

    if (value == NULL) {
        fprintf(stderr, "Unable to parse data\n");
        free(file_contents);
        exit(1);
    }

    process_value(value->u.array.values[i], 1);



    json_value_free(value);
    free(file_contents);


    return 0;
}

int jsonMatrixParser() {

    id_j = 2;
    //printf("JSON MATRIX PARSER\n");

    char* filename;
    FILE *fp;
    struct stat filestatus;
    int file_size;
    char* file_contents;
    json_char* json;
    json_value* value;

    filename = "../data.json";

    if ( stat(filename, &filestatus) != 0) {
        fprintf(stderr, "File %s not found\n", filename);
        return 1;
    }

    file_size = filestatus.st_size;
    file_contents = (char*)malloc(filestatus.st_size);
    if ( file_contents == NULL) {
        fprintf(stderr, "Memory error: unable to allocate %d bytes\n", file_size);
        return 1;
    }

    fp = fopen(filename, "r+");
    if (fp == NULL) {
        fprintf(stderr, "Unable to open %s\n", filename);
        fclose(fp);
        free(file_contents);
        return 1;
    }
    if ( fread(file_contents, file_size, 1, fp) != 1 ) {
        fprintf(stderr, "Unable t read content of %s\n", filename);
        fclose(fp);
        free(file_contents);
        return 1;
    }
    fclose(fp);

    //printf("%s\n", file_contents);

    //printf("--------------------------------\n\n");

    json = (json_char*)file_contents;

    value = json_parse(json,file_size);

    if (value == NULL) {
        fprintf(stderr, "Unable to parse data\n");
        free(file_contents);
        exit(1);
    }

    process_value(value, 0);


    json_value_free(value);
    free(file_contents);


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
//    printf("\n***********\nGAME\n\n");
//    printf("WIN?: %d\n", game1.win);
//    printf("LOSE: %d\n", game1.lose);
//    printf("LEVL: %d\n", game1.level);
//    printf("POTS: %d\n", game1.pts);
//    printf("HLTH: %d\n", game1.hlth);
//    printf("MTRX: \n");
//    for (int i = 0;i<100;i++){
//        printf("\n");
//        for (int j = 0; j < 100; ++j) {
//            printf("%d",game1.matrix[i][j]);
//        }
//    }
//    printf("\n-----------------");
}

void init_jController(){
    strcpy(room1.guest1,"null");
    strcpy(room1.guest2,"null");
    strcpy(room2.guest1,"null");
    strcpy(room2.guest2,"null");
}

void reloadJFileRooms(char* json_file[]){
    char* filename;
    FILE *fp;


    filename = "../data.json";

    fp = fopen(filename, "w");
    if (fp == NULL) {
        fprintf(stderr, "Unable to open %s\n", filename);
        fclose(fp);
        return;
    }

    printf("tamano: %d,  %s",strlen(json_file), json_file);

    if ( fwrite(json_file, sizeof(char), strlen(json_file), fp) != 1 ) {
        fprintf(stderr, "Unable to write content of %s\n", filename);
        fclose(fp);
        return;
    }


    fclose(fp);
}