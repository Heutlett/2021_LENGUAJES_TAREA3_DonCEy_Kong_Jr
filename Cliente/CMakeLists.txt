cmake_minimum_required(VERSION 3.17)
project(Cliente C)

set(CMAKE_C_STANDARD 99)

add_executable(Cliente main.c)
target_link_libraries(Cliente -lmingw32 -lallegro-5.0.10-monolith-md-debug)