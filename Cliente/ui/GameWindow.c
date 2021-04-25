//
// Created by Jose Solano on 16/4/2021.
//

#include "GameWindow.h"

int init_game() {

    al_init();
    al_init_font_addon();
    al_init_ttf_addon();
    al_init_image_addon();
    al_init_primitives_addon();


    display = al_create_display(690,700);
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
    //running = true;
    while (running) {

        ALLEGRO_EVENT event;
        al_wait_for_event(queue, &event);

        if(event.type == ALLEGRO_EVENT_DISPLAY_CLOSE){
            running = false;
        }

        if(event.type == ALLEGRO_EVENT_TIMER){
            //al_clear_to_color(al_map_rgba_f(200,1,200,200));
            al_draw_bitmap(background,-8,0,0);
            //al_draw_rectangle(100,100,300,300, al_map_rgb(200,100,255),5);

            //Dibujar aqui*****************************
            draw_kremlinXY(300, 400, 1);
            draw_kremlinXY(500, 400, 2);


            draw_fruitXY(310,100,1);
            draw_fruitXY(350,100,2);
            draw_fruitXY(390,100,3);
            //draw_fruitXY(190,100,3);



            //*****************************************

            draw_monkey();
            itoa(get_xMonkey()/7,xc,10);
            itoa(get_yMonkey()/7,yc,10);
            al_draw_text(font, al_map_rgb(0,255,0),20,20,0,xc);
            al_draw_text(font, al_map_rgb(0,255,0),20,100,0,yc);
            al_flip_display();

        }

        if (event.type == ALLEGRO_EVENT_KEY_DOWN || pressed){
            pressed = true;
            switch (event.keyboard.keycode){
                case ALLEGRO_KEY_W:
                    set_yMonkey(get_yMonkey()-4);
                    break;
                case ALLEGRO_KEY_S:
                    set_yMonkey(get_yMonkey()+4);
                    break;
                case ALLEGRO_KEY_D:
                    set_monkeyAction(1);
                    set_xMonkey(get_xMonkey()+4);
                    break;
                case ALLEGRO_KEY_A:
                    set_monkeyAction(2);
                    set_xMonkey(get_xMonkey()-4);
                    break;
            }
        }

        if (event.type == ALLEGRO_EVENT_KEY_UP){
            pressed = false;
        }
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
