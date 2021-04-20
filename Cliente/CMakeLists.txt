cmake_minimum_required(VERSION 3.17)
project(Cliente C)

set(CMAKE_C_STANDARD 99)

add_executable(Cliente main.c ui/GameWindow.h ui/GameWindow.c models/monkey.h models/monkey.c models/kremlin.c models/kremlin.h models/fruit.c models/fruit.h models/key.c models/key.h sockets/client.c)
target_link_libraries(Cliente -lmingw32 -lallegro-5.0.10-monolith-md-debug -lws2_32)