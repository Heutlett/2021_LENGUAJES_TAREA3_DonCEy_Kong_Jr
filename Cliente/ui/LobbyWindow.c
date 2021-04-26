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
    m_initC();
    init_jController();


    Lobbydisplay = al_create_display(620,700);
    Lobbyqueue = al_create_event_queue();
    Lobbytimer = al_create_timer(1.0/60);

    Lobbyfont1 = al_load_ttf_font("../resources/bahnschrift.ttf",60,0);
    Lobbyfont2 = al_load_ttf_font("../resources/bahnschrift.ttf",30,0);
    Lobbybackground = al_load_bitmap("../resources/lobbyBG.png");
    LobbyminiBG = al_load_bitmap("../resources/miniBG.jpeg");
    LobbySelector = al_load_bitmap("../resources/flecha.png");

    title1 = al_map_rgb(255,20,10);
    title2 = al_map_rgb(0,100,255);
    cl_on = al_map_rgb(100,0,255);
    cl_off = al_map_rgb(40,0,98);

    al_start_timer(Lobbytimer);

    al_install_keyboard();
    al_register_event_source(Lobbyqueue, al_get_keyboard_event_source());
    al_register_event_source(Lobbyqueue, al_get_display_event_source(Lobbydisplay));
    al_register_event_source(Lobbyqueue, al_get_timer_event_source(Lobbytimer));

    return 0;
}

int run_lobby(){

    enviar("join");
    reloadJFileRooms(escuchar());
    while (Lobbyrunning) {

        enviar("reload");
        reloadJFileRooms(escuchar());
        jsonRoomParser(0);
        jsonRoomParser(1);
        //JL_printStructs();
        ALLEGRO_EVENT event;
        al_wait_for_event(Lobbyqueue, &event);




        if(event.type == ALLEGRO_EVENT_DISPLAY_CLOSE){
            Lobbyrunning = false;
        }

        if(event.type == ALLEGRO_EVENT_TIMER){
            al_clear_to_color(al_map_rgb_f(0,0,0));
            al_draw_bitmap(Lobbybackground,10,12,0);

            al_draw_bitmap(LobbyminiBG,100,450,0);
            al_draw_bitmap(LobbyminiBG,420,450,0);

            al_draw_rectangle(50,400,250,675, al_map_rgb(0,100,255),5);
            al_draw_rectangle(370,400,570,675, al_map_rgb(0,100,255),5);

            //Dibujar aqui*****************************







            //*****************************************


            al_draw_text(Lobbyfont1, title1,100,300,0,"Seleccione Sala");

            al_draw_text(Lobbyfont2, title2,95,400,0,"Juego 1");
            al_draw_text(Lobbyfont2, title2,415,400,0,"Juego 2");

            al_draw_text(Lobbyfont2, cl_on,100,560,0,"Jugar");
            al_draw_text(Lobbyfont2, cl_on,100,610,0,"Observar");


            al_draw_text(Lobbyfont2, cl_on,420,560,0,"Jugar");
            al_draw_text(Lobbyfont2, cl_on,420,610,0,"Observar");

            if (strcmp(room1.player,"null")){
                al_draw_text(Lobbyfont2, title1,90,460,0,room1.player);
                al_draw_text(Lobbyfont2, cl_off,100,560,0,"Jugar");
                m_bt[0][0] = 1;
            }
            if (!strcmp(room1.player,"null")){
                al_draw_text(Lobbyfont2, cl_off,100,610,0,"Observar");
                m_bt[1][0] = 1;
            }

            if (strcmp(room2.player,"null")){
                al_draw_text(Lobbyfont2, title1,410,460,0,room2.player);
                al_draw_text(Lobbyfont2, cl_off,420,560,0,"Jugar");
                m_bt[0][1] = 1;
            }

            if (!strcmp(room2.player,"null")){
                al_draw_text(Lobbyfont2, cl_off,420,610,0,"Observar");
                m_bt[1][1] = 1;
            }

            if ((strcmp(room1.guest1,"null")) && (strcmp(room1.guest2,"null"))){
                al_draw_text(Lobbyfont2, cl_off,100,610,0,"Observar");
                m_bt[1][0] = 1;
            }

            if ((strcmp(room2.guest1,"null")) && (strcmp(room2.guest2,"null"))){
                al_draw_text(Lobbyfont2, cl_off,420,610,0,"Observar");
                m_bt[1][1] = 1;
            }



            if(menu[mc_i][mc_j] == 1){
                al_draw_bitmap(LobbySelector,60,565,0);
            }
            if(menu[mc_i][mc_j] == 2){
                al_draw_bitmap(LobbySelector,380,565,0);
            }
            if(menu[mc_i][mc_j] == 3){
                al_draw_bitmap(LobbySelector,60,615,0);
            }
            if(menu[mc_i][mc_j] == 4){
                al_draw_bitmap(LobbySelector,380,615,0);
            }

            printf(timer);
            al_flip_display();

        }

        if (event.type == ALLEGRO_EVENT_KEY_DOWN){
            switch (event.keyboard.keycode){
                case ALLEGRO_KEY_UP:
                    m_Move(3);
                    break;
                case ALLEGRO_KEY_DOWN:
                    m_Move(4);
                    break;
                case ALLEGRO_KEY_RIGHT:
                    m_Move(2);
                    break;
                case ALLEGRO_KEY_LEFT:
                    m_Move(1);
                    break;
                case ALLEGRO_KEY_ENTER:
                    if(!m_bt[mc_i][mc_j]){
                        Lobbyrunning = false;
                        //if(!strcmp(m_type,"viewer")){viewer = 1;}
                        setSendJson();
                        char rslt[200] = "{\"username\": \"";
                        strcat(rslt,m_player);
                        strcat(rslt,"\","" \"type\": \"");
                        strcat(rslt,m_type);
                        strcat(rslt,"\",""\"room\":");
                        strcat(rslt,m_room);
                        strcat(rslt,"}");
                        printf(rslt);
                        enviar(rslt);
                    }
                    break;
            }
        }
    }

    al_destroy_display(Lobbydisplay);
    al_uninstall_keyboard();
    al_destroy_timer(Lobbytimer);

    al_destroy_bitmap(Lobbybackground);
    al_destroy_bitmap(LobbySelector);
    al_destroy_font(Lobbyfont1);
    al_destroy_font(Lobbyfont2);
    return 0;
}