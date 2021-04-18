//
// Created by andre on 17/4/2021.
//

#include "monkey.h"

void init_monkey() {
    al_init();
    al_init_image_addon();
    monkeyL = al_load_bitmap("../resources/walk_left2.png");
    monkeyR = al_load_bitmap("../resources/walk_right2.png");
}

void draw_monkey(){
    if(monkey_action == 1){
        al_draw_bitmap(monkeyR, Mx,My,0);
    }
    if(monkey_action == 2){
        al_draw_bitmap(monkeyL, Mx,My,0);
    }
}

void draw_monkeyXY(int x_, int y_){
    Mx = x_;
    My = y_;
    draw_monkey();
}

void destroy_monkey(){
    al_destroy_bitmap(monkeyL);
    al_destroy_bitmap(monkeyR);
}

void set_monkeyAction(int action){
    monkey_action = action;
}

void set_xMonkey(int x_){
    Mx = x_;
}

void set_yMonkey(int y_){
    My = y_;
}

int get_xMonkey(){
    return Mx;
}

int get_yMonkey(){
    return My;
}