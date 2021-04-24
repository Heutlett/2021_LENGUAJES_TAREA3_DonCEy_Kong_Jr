//
// Created by andre on 18/4/2021.
//

#include "fruit.h"

void init_fruit() {
    //al_init();
    //al_init_image_addon();
    banana = al_load_bitmap("../resources/banana.png");
    apple = al_load_bitmap("../resources/apple.png");
    mango = al_load_bitmap("../resources/mango.png");
}

void draw_fruitXY(int x_, int y_, int kind){
    if(kind == 1){
        al_draw_bitmap(banana, x_,y_,0);
    }
    if(kind == 2){
        al_draw_bitmap(apple, x_,y_,0);
    }
    if(kind == 3){
        al_draw_bitmap(mango, x_,y_,0);
    }
}

void destroy_fruit(){
    al_destroy_bitmap(banana);
    al_destroy_bitmap(apple);
    al_destroy_bitmap(mango);
}