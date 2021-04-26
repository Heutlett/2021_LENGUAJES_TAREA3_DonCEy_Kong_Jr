//
// Created by Jose Solano on 16/4/2021.
//

#include "GameWindow.h"

int init_game() {

    w=0;
    a=0;
    s=0;
    d=0;

    strcpy(sendKey,"_");

    al_init();
    al_init_font_addon();
    al_init_ttf_addon();
    al_init_image_addon();
    al_init_primitives_addon();


    display = al_create_display(700,700);
    queue = al_create_event_queue();
    timer = al_create_timer(1.0/60);

    font = al_load_ttf_font("../resources/bahnschrift.ttf",64,0);
    background = al_load_bitmap("../resources/background.jpeg");
    init_monkey();
    init_kremlin();
    init_fruit();

    al_start_timer(timer);

    al_install_keyboard();
    al_register_event_source(queue, al_get_keyboard_event_source());
    al_register_event_source(queue, al_get_display_event_source(display));
    al_register_event_source(queue, al_get_timer_event_source(timer));

    return 0;
}

int run(){

    enviar("join");
    reloadJFileRooms(escuchar());

    jsonMatrixParser();
    while (running) {

        jsonMatrixParser();
        ALLEGRO_EVENT event;
        al_wait_for_event(queue, &event);

        if(event.type == ALLEGRO_EVENT_DISPLAY_CLOSE){
            running = false;
        }

        if(event.type == ALLEGRO_EVENT_TIMER){

            al_draw_bitmap(background,0,0,0);


            //Dibujar aqui*****************************

            for (int i = 0; i < 100; ++i) {
                for (int j = 0; j < 100; ++j) {
                    if(game1.matrix[j][i] == 1){
                        draw_monkeyXY((i*7)-10,(j*7)-10);
                    }
                    if(game1.matrix[j][i] == 2){
                        draw_kremlinXY((i*7)-20,(j*7)-20,1);
                    }
                    if(game1.matrix[j][i] == 3){
                        draw_kremlinXY((i*7)-20,(j*7)-20,2);
                    }
                    if(game1.matrix[j][i] == 4){
                        draw_fruitXY((i*7)-10,(j*7)-10,1);
                    }
                    if(game1.matrix[j][i] == 5){
                        draw_fruitXY((i*7)-10,(j*7)-10,2);
                    }
                    if(game1.matrix[j][i] == 6){
                        draw_fruitXY((i*7)-10,(j*7)-10,3);
                    }
                }
            }

//            draw_kremlinXY(300, 400, 1);
//            draw_kremlinXY(500, 400, 2);
//
//
//            draw_fruitXY(310,100,1);
//            draw_fruitXY(350,100,2);
//            draw_fruitXY(390,100,3);
            //draw_fruitXY(190,100,3);



            //*****************************************

//            draw_monkey();
            itoa(get_xMonkey()/7,xc,10);
            itoa(get_yMonkey()/7,yc,10);
            al_draw_text(font, al_map_rgb(0,255,0),20,20,0,xc);
            al_draw_text(font, al_map_rgb(0,255,0),20,100,0,yc);
            al_flip_display();

        }

        if (event.type == ALLEGRO_EVENT_KEY_DOWN){ //|| pressed){
//            pressed = true;
            switch (event.keyboard.keycode){
                case ALLEGRO_KEY_W:
                    w=1;
                    set_yMonkey(get_yMonkey()-4);
                    break;
                case ALLEGRO_KEY_S:
                    s=1;
                    set_yMonkey(get_yMonkey()+4);
                    break;
                case ALLEGRO_KEY_D:
                    d=1;
                    set_monkeyAction(1);
                    set_xMonkey(get_xMonkey()+4);
                    break;
                case ALLEGRO_KEY_A:
                    a=1;
                    set_monkeyAction(2);
                    set_xMonkey(get_xMonkey()-4);
                    break;
            }
        }

        if (event.type == ALLEGRO_EVENT_KEY_UP){
//            pressed = false;
            switch (event.keyboard.keycode){
                case ALLEGRO_KEY_W:
                    w=0;
                    break;
                case ALLEGRO_KEY_S:
                    s=0;
                    break;
                case ALLEGRO_KEY_D:
                    d=0;
                    break;
                case ALLEGRO_KEY_A:
                    a=0;
                    break;
            }
        }

        if(a){
            strcpy(sendKey,"A");
        }
        if(s){
            strcpy(sendKey,"S");
        }
        if(d){
            strcpy(sendKey,"D");
        }
        if(w){
            strcpy(sendKey,"W");
        }
        if(w&&a){
            strcpy(sendKey,"WA");
        }
        if(w&&d){
            strcpy(sendKey,"WD");
        }
        printf(sendKey);
        printf("\n");


        enviar("sendkey");
        reloadJFileRooms(escuchar());

        strcpy(sendKey,"_");

    }

    al_destroy_display(display);
    al_uninstall_keyboard();
    al_destroy_timer(timer);
    destroy_monkey();
    destroy_kremlin();
    destroy_fruit();
    al_destroy_bitmap(background);
    al_destroy_font(font);
    return 0;
}
