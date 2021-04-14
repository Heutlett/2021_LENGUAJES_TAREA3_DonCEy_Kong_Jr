cmake_minimum_required(VERSION 3.19)
project(Cliente C)

set(CMAKE_C_STANDARD 99)

add_executable(Cliente src/main.c src/sockets/Sockets.c src/sockets/Sockets.h src/sockets/cJson.c src/sockets/cJson.h)