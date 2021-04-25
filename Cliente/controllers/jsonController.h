//
// Created by andre on 24/4/2021.
//

#ifndef CLIENTE_JSONCONTROLLER_H
#define CLIENTE_JSONCONTROLLER_H


#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include "json.h"

static void print_depth_shift(int depth);
static void process_value(json_value* value, int depth);
static void process_object(json_value* value, int depth);
static void process_array(json_value* value, int depth);
int jsonparser();

#endif //CLIENTE_JSONCONTROLLER_H
