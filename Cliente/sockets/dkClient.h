//
// Created by andre on 23/4/2021.
//

#ifndef CLIENTE_DKCLIENT_H
#define CLIENTE_DKCLIENT_H

static WSADATA WinSockData;
static int startup;
static int cleanup;

static SOCKET DKJrClient;
static int iCloseSocket;

static struct sockaddr_in DKJrServerAdd;

static int iConnect;

static int iRecv;
static char recvBuff[512];
static int iRecvBuff;// = strlen(recvBuff)+1;

static int iSend;
static char sendBuff[512];
static int iSendBuff;// = strlen(sendBuff)+1;

void start_connection();
void sendMessage(char* message);
char* getRecvMessage();
void close_socket();

#endif //CLIENTE_DKCLIENT_H
