cmake_minimum_required(VERSION 3.19)
project(Client C)

set(CMAKE_C_STANDARD 99)

add_executable(Client main.c sockets/Socket.c sockets/Socket.h)


set(FLAGS "-I${GTK3_INCLUDE_DIRS}")
message(STATUS "Flags: ${FLAGS}")
string(REPLACE ";" " -I" FLAGS "${FLAGS}")
set(CMAKE_C_FLAGS ${CMAKE_C_FLAGS} ${GTK3_FLAGS} ${FLAGS})


target_link_libraries(Client -lws2_32 wsock32 ws2_32)