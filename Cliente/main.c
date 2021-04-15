#include <stdio.h>
#include <allegro5/allegro.h>
#include <allegro5/allegro_native_dialog.h>
#include "unistd.h"

int main() {
    ALLEGRO_DISPLAY *display = 0;

    if(!al_init()){
        al_show_native_message_box(0,0,0,"Failed",0,0);
        return -1;
    }

    display = al_create_display(660,400);

    if(!display){
        al_show_native_message_box(0,0,0, "failed", 0,0);
        return -1;
    }

    sleep(5);


    return 0;
}
