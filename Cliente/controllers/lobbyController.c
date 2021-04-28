//
// Created by andre on 24/4/2021.
//

#include "lobbyController.h"

int m_initC(){
    menu[0][0] = 1;
    menu[0][1] = 2;
    menu[1][0] = 3;
    menu[1][1] = 4;

    m_bt[0][0] = 0;
    m_bt[0][1] = 0;
    m_bt[1][0] = 0;
    m_bt[1][1] = 0;

    mc_i = 0;
    mc_j = 0;

    espectadores[0] = "Espectador1";
    espectadores[1] = "Espectador2";
    espectadores[2] = "Espectador3";
    espectadores[3] = "Espectador4";

    e_cont =0;
}

int m_Move(int dir){
    if(dir == 1){
        if(mc_j == 1){mc_j--;}
    }
    if(dir == 2){
        if(mc_j == 0){mc_j++;}
    }
    if(dir == 3){
        if(mc_i == 1){mc_i--;}
    }
    if(dir == 4){
        if(mc_i == 0){mc_i++;}
    }
    return 0;
}

int m_printActual(){

    printf("\n%d --- %d\n\n",mc_i,mc_j);
    printf("%d",menu[mc_i][mc_j]);

    return 0;
}

void setSendJson(){
    if(menu[mc_i][mc_j]<3){
        if (menu[mc_i][mc_j] == 1){
            m_player = "Jugador1";
            m_room = "1";
        }else{
            m_player = "Jugador2";
            m_room = "2";
        }
        m_type = "player";
    }else{
        if (menu[mc_i][mc_j] == 3){
            m_player = "Jugador1";
            m_room = "1";
        } else{
            m_player = "Jugador2";
            m_room = "2";
        }
        m_type = "viewer";
    }
}
