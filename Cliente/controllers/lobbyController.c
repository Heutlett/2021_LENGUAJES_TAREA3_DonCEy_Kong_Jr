//
// Created by andre on 24/4/2021.
//

#include "lobbyController.h"

int m_initC(){
    menu[0][0] = 1;
    menu[0][1] = 2;
    menu[1][0] = 3;
    menu[1][1] = 4;

    mc_i = 0;
    mc_j = 0;
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
