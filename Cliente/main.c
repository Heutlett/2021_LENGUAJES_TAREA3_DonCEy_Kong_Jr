
#include <allegro5/allegro.h>
#include <allegro5/allegro_primitives.h>
#include "ui/GameWindow.h"


void create_grid(){
    for (int i=0;i<100;i++){
        for (int j=0;j<100;j++){
            al_draw_rectangle(i*5,j*5,5,5, al_map_rgb(255,255,100),2);
        }
    }
}



int main() {

    init_game();
    run();

    return 0;
}

