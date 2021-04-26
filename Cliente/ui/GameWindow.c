//
// Created by Jose Solano on 16/4/2021.
//

#include "GameWindow.h"

int init_game() {

    w=0;
    a=0;
    s=0;
    d=0;

    strcpy(level,"Nivel: ");
    strcpy(health,"Vidas: ");
    strcpy(points,"Puntos: ");

    strcpy(sendKey,"_");

    al_init();
    al_init_font_addon();
    al_init_ttf_addon();
    al_init_image_addon();
    al_init_primitives_addon();


    display = al_create_display(700,700);
    queue = al_create_event_queue();
    timer = al_create_timer(1.0/60);

    font = al_load_ttf_font("../resources/bahnschrift.ttf",20,0);
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
    reloadJFileRooms(escuchar2());

    jsonMatrixParser();
    while (running) {

        jsonMatrixParser();
        ALLEGRO_EVENT event;
        al_wait_for_event(queue, &event);

        if (event.type == ALLEGRO_EVENT_DISPLAY_CLOSE) {
            running = false;
        }

        if (event.type == ALLEGRO_EVENT_TIMER) {

            al_draw_bitmap(background, 0, 0, 0);


            //Dibujar aqui*****************************


            for (int i = 0; i < game1.len; ++i) {
                if (game1.matrix[i][0] == 1) {
                    draw_monkeyXY((game1.matrix[i][2] * 7) - 10, (game1.matrix[i][1] * 7) - 10);
                }
                if (game1.matrix[i][0] == 2) {
                    draw_kremlinXY((game1.matrix[i][2] * 7) - 20, (game1.matrix[i][1] * 7) - 20, 1);
                }
                if (game1.matrix[i][0] == 3) {
                    draw_kremlinXY((game1.matrix[i][2] * 7) - 20, (game1.matrix[i][1] * 7) - 20, 2);
                }
                if (game1.matrix[i][0] == 4) {
                    draw_fruitXY((game1.matrix[i][2] * 7) - 10, (game1.matrix[i][1] * 7) - 10, 1);
                }
                if (game1.matrix[i][0] == 5) {
                    draw_fruitXY((game1.matrix[i][2] * 7) - 10, (game1.matrix[i][1] * 7) - 10, 2);
                }
                if (game1.matrix[i][0] == 6) {
                    draw_fruitXY((game1.matrix[i][2] * 7) - 10, (game1.matrix[i][1] * 7) - 10, 3);
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
            itoa(game1.level, iLvl, 10);
            itoa(game1.hlth, iHlth, 10);
            itoa(game1.pts, iPts, 10);

//            strcat(level,iLvl);
//            strcat(health,iHlth);
//            strcat(points,iPts);

            al_draw_filled_rectangle(15, 100, 150, 165, al_map_rgb(255, 255, 200));
            al_draw_text(font, al_map_rgb(255, 50, 0), 20, 100, 0, level);
            al_draw_text(font, al_map_rgb(255, 50, 0), 80, 100, 0, iLvl);
            al_draw_text(font, al_map_rgb(255, 50, 0), 20, 120, 0, health);
            al_draw_text(font, al_map_rgb(255, 50, 0), 80, 120, 0, iHlth);
            al_draw_text(font, al_map_rgb(255, 50, 0), 20, 140, 0, points);
            al_draw_text(font, al_map_rgb(255, 50, 0), 90, 140, 0, iPts);
            al_flip_display();

        }

        if (event.type == ALLEGRO_EVENT_KEY_DOWN) { //|| pressed){
//            pressed = true;
            switch (event.keyboard.keycode) {
                case ALLEGRO_KEY_W:
                    w = 1;
                    set_yMonkey(get_yMonkey() - 4);
                    break;
                case ALLEGRO_KEY_S:
                    s = 1;
                    set_yMonkey(get_yMonkey() + 4);
                    break;
                case ALLEGRO_KEY_D:
                    d = 1;
                    set_monkeyAction(1);
                    set_xMonkey(get_xMonkey() + 4);
                    break;
                case ALLEGRO_KEY_A:
                    a = 1;
                    set_monkeyAction(2);
                    set_xMonkey(get_xMonkey() - 4);
                    break;
            }
        }

        if (event.type == ALLEGRO_EVENT_KEY_UP) {
//            pressed = false;
            switch (event.keyboard.keycode) {
                case ALLEGRO_KEY_W:
                    w = 0;
                    break;
                case ALLEGRO_KEY_S:
                    s = 0;
                    break;
                case ALLEGRO_KEY_D:
                    d = 0;
                    break;
                case ALLEGRO_KEY_A:
                    a = 0;
                    break;
            }
        }
        if(!viewer){
            if (a) {
                strcpy(sendKey, "A");
            }
            if (s) {
                strcpy(sendKey, "S");
            }
            if (d) {
                strcpy(sendKey, "D");
            }
            if (w) {
                strcpy(sendKey, "W");
            }
            if (w && a) {
                strcpy(sendKey, "WA");
            }
            if (w && d) {
                strcpy(sendKey, "WD");
            }
        }
        printf(sendKey);
        printf("\n");


        enviar(sendKey);
        reloadJFileRooms(escuchar2());

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
