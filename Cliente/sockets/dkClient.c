//
// Created by andre on 19/4/2021.
//

#include <winsock2.h>
#include <stdio.h>
#include "dkClient.h"
//#include <nloh

void start_connection(){

    startup = WSAStartup(MAKEWORD(2,2),&WinSockData);
    if (startup != 0){
        printf("WSAStartup failed\n");
    }
    printf("WSAStartup success\n");

    DKJrClient = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
    if (DKJrClient == INVALID_SOCKET){
        printf("Client socket creation failed\n");
    }
    printf("Client socket creation success\n");

    DKJrServerAdd.sin_family = AF_INET;
    DKJrServerAdd.sin_addr.s_addr = inet_addr("127.0.0.1");
    DKJrServerAdd.sin_port = htons(80);

    iConnect = connect(DKJrClient,(SOCKADDR*)&DKJrServerAdd,sizeof(DKJrServerAdd));
    if (iConnect == SOCKET_ERROR){
        printf("Connection failed, ERROR No. "), printf("%d\n",WSAGetLastError());
    }
    printf("Connection success\n");

    /*iRecv = recv(DKJrClient,recvBuff,iRecvBuff,0);
    if (iRecv == SOCKET_ERROR){
        printf("Error in data received, ERROR No. "), printf("%d",WSAGetLastError());
    }
    printf("DATA RECEIVED --> "),printf(recvBuff);

    iSend = send(DKJrClient,sendBuff,iSendBuff,0);
    if (iSend == SOCKET_ERROR){
        printf("Sending failed, ERROR No. "), printf("%d",WSAGetLastError());
    }
    printf("Data sending success");

    iCloseSocket = closesocket(DKJrClient);
    if (iCloseSocket == SOCKET_ERROR){
        printf("Closing socket failed, ERROR No. "), printf("%d",WSAGetLastError());
    }
    printf("Closing socket success");

    cleanup = WSACleanup();
    if (cleanup == SOCKET_ERROR){
        printf("CleanUp failed, ERROR No. "), printf("%d",WSAGetLastError());
    }
    printf("CleanUp success");*/

    //system("PAUSE");
    return;
}

void sendMessage(char* message){

    strcpy(sendBuff,message);
    iSendBuff = strlen(sendBuff)+1;

    printf(sendBuff);

    iSend = send(DKJrClient,sendBuff,iSendBuff,0);
    if (iSend == SOCKET_ERROR){
        printf("Sending failed, ERROR No. "), printf("%d\n",WSAGetLastError());
    }
    printf("Data sending success\n");
    return;
}

char* getRecvMessage(){

    iRecvBuff = strlen(recvBuff)+1;

    iRecv = recv(DKJrClient,recvBuff,iRecvBuff,0);
    if (iRecv == SOCKET_ERROR){
        printf("Error in data received, ERROR No. "), printf("%d\n",WSAGetLastError());
    }
    printf("DATA RECEIVED --> "),printf(recvBuff),printf("\n");

    return recvBuff;
}

void close_socket(){

    iCloseSocket = closesocket(DKJrClient);
    if (iCloseSocket == SOCKET_ERROR){
        printf("Closing socket failed, ERROR No. "), printf("%d\n",WSAGetLastError());
    }
    printf("Closing socket success\n");

    cleanup = WSACleanup();
    if (cleanup == SOCKET_ERROR){
        printf("CleanUp failed, ERROR No. "), printf("%d\n",WSAGetLastError());
    }
    printf("CleanUp success\n");

    return;
}

