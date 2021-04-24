cmake_minimum_required(VERSION 3.17)
project(Cliente C)

set(CMAKE_C_STANDARD 99)

add_executable(Cliente main.c ui/GameWindow.h ui/GameWindow.c models/monkey.h models/monkey.c models/kremlin.c models/kremlin.h models/fruit.c models/fruit.h models/key.c models/key.h sockets/dkClient.c ui/LobbyWindow.c ui/LobbyWindow.h sockets/dkClient.h sockets/socket.c sockets/socket.h)

#[[include(FetchContent)

FetchContent_Declare(json
GIT_REPOSITORY https://github.com/nlohmann/json.git
GIT_TAG v3.7.3)

FetchContent_GetProperties(json)
if(NOT json_POPULATED)
FetchContent_Populate(json)
add_subdirectory(${json_SOURCE_DIR} ${json_BINARY_DIR} EXCLUDE_FROM_ALL)
endif()]]

#target_link_libraries(Cliente PRIVATE nlohmann_json::nlohmann_json)
target_link_libraries(Cliente -lmingw32 -lallegro-5.0.10-monolith-md-debug wsock32 ws2_32)
