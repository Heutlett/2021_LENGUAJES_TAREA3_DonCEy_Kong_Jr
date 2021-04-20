//
// Created by andre on 19/4/2021.
//

#include "key.h"

void init_key() {
    al_init();
    al_init_image_addon();
    key = al_load_bitmap("../resources/key.png");
}

void draw_keyXY(int x_, int y_){
    al_draw_bitmap(key, x_,y_,0);
}

void destroy_key(){
    al_destroy_bitmap(key);
}