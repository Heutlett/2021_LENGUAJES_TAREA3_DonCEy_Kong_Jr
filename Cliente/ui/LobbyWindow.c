//
// Created by andre on 21/4/2021.
//

#include "LobbyWindow.h"

int init_lobby() {

    al_init();
    al_init_font_addon();
    al_init_ttf_addon();
    al_init_image_addon();
    al_init_primitives_addon();


    Lobbydisplay = al_create_display(620,700);
    Lobbyqueue = al_create_event_queue();
    Lobbytimer = al_create_timer(1.0/60);

    Lobbyfont1 = al_load_ttf_font("../resources/bahnschrift.ttf",60,0);
    Lobbyfont2 = al_load_ttf_font("../resources/bahnschrift.ttf",30,0);
    Lobbybackground = al_load_bitmap("../resources/lobbyBG.png");

    al_start_timer(Lobbytimer);

    al_install_keyboard();
    al_register_event_source(Lobbyqueue, al_get_keyboard_event_source());
    al_register_event_source(Lobbyqueue, al_get_display_event_source(Lobbydisplay));
    al_register_event_source(Lobbyqueue, al_get_timer_event_source(Lobbytimer));

    return 0;
}

int run_lobby(){
    //running = true;
    while (Lobbyrunning) {

        ALLEGRO_EVENT event;
        al_wait_for_event(Lobbyqueue, &event);

        if(event.type == ALLEGRO_EVENT_DISPLAY_CLOSE){
            Lobbyrunning = false;
        }

        if(event.type == ALLEGRO_EVENT_TIMER){
            //al_clear_to_color(al_map_rgba_f(200,1,200,200));
            al_draw_bitmap(Lobbybackground,10,12,0);
            al_draw_rectangle(50,400,250,675, al_map_rgb(0,100,255),5);
            al_draw_rectangle(370,400,570,675, al_map_rgb(0,100,255),5);

            //Dibujar aqui*****************************







            //*****************************************


            al_draw_text(Lobbyfont1, al_map_rgb(255,20,10),100,300,0,"Seleccione Sala");

            al_draw_text(Lobbyfont2, al_map_rgb(0,100,255),95,400,0,"Juego 1");
            al_draw_text(Lobbyfont2, al_map_rgb(100,0,255),80,560,0,"Jugar");
            al_draw_text(Lobbyfont2, al_map_rgb(100,0,255),80,610,0,"Observar");

            al_draw_text(Lobbyfont2, al_map_rgb(0,100,255),415,400,0,"Juego 2");
            al_draw_text(Lobbyfont2, al_map_rgb(100,0,255),400,560,0,"Jugar");
            al_draw_text(Lobbyfont2, al_map_rgb(100,0,255),400,610,0,"Observar");

            al_flip_display();

        }

//        if (event.type == ALLEGRO_EVENT_KEY_DOWN || pressed){
//            pressed = true;
//            switch (event.keyboard.keycode){
//                case ALLEGRO_KEY_UP:
//                    set_yMonkey(get_yMonkey()-4);
//                    break;
//                case ALLEGRO_KEY_DOWN:
//                    set_yMonkey(get_yMonkey()+4);
//                    break;
//                case ALLEGRO_KEY_RIGHT:
//                    set_monkeyAction(1);
//                    set_xMonkey(get_xMonkey()+4);
//                    break;
//                case ALLEGRO_KEY_LEFT:
//                    set_monkeyAction(2);
//                    set_xMonkey(get_xMonkey()-4);
//                    break;
//            }
//        }
//
//        if (event.type == ALLEGRO_EVENT_KEY_UP){
//            pressed = false;
//        }
    }

    al_destroy_display(Lobbydisplay);
    al_uninstall_keyboard();
    al_destroy_timer(Lobbytimer);

    al_destroy_bitmap(Lobbybackground);
    al_destroy_font(Lobbyfont1);
    al_destroy_font(Lobbyfont2);
    return 0;
}