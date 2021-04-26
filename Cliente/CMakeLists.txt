cmake_minimum_required(VERSION 3.17)
project(Cliente C)

set(CMAKE_C_STANDARD 99)

add_executable(Cliente main.c ui/GameWindow.h ui/GameWindow.c models/monkey.h models/monkey.c models/kremlin.c models/kremlin.h models/fruit.c models/fruit.h models/key.c models/key.h sockets/dkClient.c ui/LobbyWindow.c ui/LobbyWindow.h sockets/dkClient.h sockets/socket.c sockets/socket.h controllers/lobbyController.c controllers/lobbyController.h controllers/jsonController.c controllers/jsonController.h controllers/json.c controllers/json.h controllers/gameController.c controllers/gameController.h)

set(FLAGS "-I${GTK3_INCLUDE_DIRS}")
message(STATUS "Flags: ${FLAGS}")
string(REPLACE ";" " -I" FLAGS "${FLAGS}")
set(CMAKE_C_FLAGS ${CMAKE_C_FLAGS} ${GTK3_FLAGS} ${FLAGS})

target_link_libraries(Cliente -lmingw32 -lallegro-5.0.10-monolith-md-debug wsock32 ws2_32)
