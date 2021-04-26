//
// Created by andre on 18/4/2021.
//

#include "kremlin.h"

void init_kremlin() {
    //al_init();
    //al_init_image_addon();
    kremlinRU = al_load_bitmap("../resources/redcroc_onvine_up.png");
    kremlinRD = al_load_bitmap("../resources/redcroc_onvine_down.png");
    kremlinBU = al_load_bitmap("../resources/bluecroc_onvine_up.png");
    kremlinBD = al_load_bitmap("../resources/bluecroc_onvine_down.png");
}

void draw_kremlin(){
    if(kremlin_action == 1){
        al_draw_bitmap(kremlinRU, Kx,Ky,0);
    }
    if(kremlin_action == 2){
        al_draw_bitmap(kremlinRD, Kx,Ky,0);
    }
}

void draw_kremlinXY(int x_, int y_, int color){
    if(color == 1){
        al_draw_bitmap(kremlinRU, x_,y_,0);
    }
    if(color == 2){
        al_draw_bitmap(kremlinBU, x_,y_,0);
    }
}

void destroy_kremlin(){
    al_destroy_bitmap(kremlinRU);
    al_destroy_bitmap(kremlinRD);

    al_destroy_bitmap(kremlinBU);
    al_destroy_bitmap(kremlinBD);
}