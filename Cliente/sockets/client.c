//
// Created by andre on 19/4/2021.
//

#include <winsock2.h>
#include <stdio.h>

int start_connection(){

    WSADATA WinSockData;
    int startup;
    int cleanup;

    SOCKET DKJrClient;
    int iCloseSocket;

    struct sockaddr_in DKJrServerAdd;

    int iConnect;

    int iRecv;
    char recvBuff[512];
    int iRecvBuff = strlen(recvBuff)+1;

    int iSend;
    char sendBuff[512];
    int iSendBuff = strlen(sendBuff)+1;

    startup = WSAStartup(MAKEWORD(2,2),&WinSockData);
    if (startup != 0){
        printf("WSAStartup failed");
    }
    printf("WSAStartup success");

    DKJrClient = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
    if (DKJrClient == INVALID_SOCKET){
        printf("Client socket creation failed");
    }
    printf("Client socket creation success");

    DKJrServerAdd.sin_family = AF_INET;
    DKJrServerAdd.sin_addr.s_addr = inet_addr("127.0.0.1");
    DKJrServerAdd.sin_port = htons(8000);

    iConnect = connect(DKJrClient,(SOCKADDR*)&DKJrServerAdd,sizeof(DKJrServerAdd));
    if (iConnect == SOCKET_ERROR){
        printf("Connection failed, ERROR No. "), printf(WSAGetLastError(),"%d");
    }
    printf("Connection success");

    iRecv = recv(DKJrClient,recvBuff,iRecvBuff,0);
    if (iRecv == SOCKET_ERROR){
        printf("Error in data received, ERROR No. "), printf(WSAGetLastError(),"%d");
    }
    printf("DATA RECEIVED --> "),printf(recvBuff);

    iSend = send(DKJrClient,sendBuff,iSendBuff,0);
    if (iSend == SOCKET_ERROR){
        printf("Sending failed, ERROR No. "), printf(WSAGetLastError(),"%d");
    }
    printf("Data sending success");

    iCloseSocket = closesocket(DKJrClient);
    if (iCloseSocket == SOCKET_ERROR){
        printf("Closing socket failed, ERROR No. "), printf(WSAGetLastError(),"%d");
    }
    printf("Closing socket success");

    cleanup = WSACleanup();
    if (cleanup == SOCKET_ERROR){
        printf("CleanUp failed, ERROR No. "), printf(WSAGetLastError(),"%d");
    }
    printf("CleanUp success");

    system("PAUSE");
    return 0;
}