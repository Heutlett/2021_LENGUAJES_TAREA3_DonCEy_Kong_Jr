# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2020.3.3\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2020.3.3\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable"

# Include any dependencies generated for this target.
include CMakeFiles/Cliente.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Cliente.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Cliente.dir/flags.make

CMakeFiles/Cliente.dir/main.c.obj: CMakeFiles/Cliente.dir/flags.make
CMakeFiles/Cliente.dir/main.c.obj: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/Cliente.dir/main.c.obj"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\Cliente.dir\main.c.obj   -c "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\main.c"

CMakeFiles/Cliente.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Cliente.dir/main.c.i"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\main.c" > CMakeFiles\Cliente.dir\main.c.i

CMakeFiles/Cliente.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Cliente.dir/main.c.s"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\main.c" -o CMakeFiles\Cliente.dir\main.c.s

CMakeFiles/Cliente.dir/ui/GameWindow.c.obj: CMakeFiles/Cliente.dir/flags.make
CMakeFiles/Cliente.dir/ui/GameWindow.c.obj: ../ui/GameWindow.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Building C object CMakeFiles/Cliente.dir/ui/GameWindow.c.obj"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\Cliente.dir\ui\GameWindow.c.obj   -c "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\ui\GameWindow.c"

CMakeFiles/Cliente.dir/ui/GameWindow.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Cliente.dir/ui/GameWindow.c.i"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\ui\GameWindow.c" > CMakeFiles\Cliente.dir\ui\GameWindow.c.i

CMakeFiles/Cliente.dir/ui/GameWindow.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Cliente.dir/ui/GameWindow.c.s"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\ui\GameWindow.c" -o CMakeFiles\Cliente.dir\ui\GameWindow.c.s

CMakeFiles/Cliente.dir/models/monkey.c.obj: CMakeFiles/Cliente.dir/flags.make
CMakeFiles/Cliente.dir/models/monkey.c.obj: ../models/monkey.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_3) "Building C object CMakeFiles/Cliente.dir/models/monkey.c.obj"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\Cliente.dir\models\monkey.c.obj   -c "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\models\monkey.c"

CMakeFiles/Cliente.dir/models/monkey.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Cliente.dir/models/monkey.c.i"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\models\monkey.c" > CMakeFiles\Cliente.dir\models\monkey.c.i

CMakeFiles/Cliente.dir/models/monkey.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Cliente.dir/models/monkey.c.s"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\models\monkey.c" -o CMakeFiles\Cliente.dir\models\monkey.c.s

CMakeFiles/Cliente.dir/models/kremlin.c.obj: CMakeFiles/Cliente.dir/flags.make
CMakeFiles/Cliente.dir/models/kremlin.c.obj: ../models/kremlin.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_4) "Building C object CMakeFiles/Cliente.dir/models/kremlin.c.obj"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\Cliente.dir\models\kremlin.c.obj   -c "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\models\kremlin.c"

CMakeFiles/Cliente.dir/models/kremlin.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Cliente.dir/models/kremlin.c.i"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\models\kremlin.c" > CMakeFiles\Cliente.dir\models\kremlin.c.i

CMakeFiles/Cliente.dir/models/kremlin.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Cliente.dir/models/kremlin.c.s"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\models\kremlin.c" -o CMakeFiles\Cliente.dir\models\kremlin.c.s

CMakeFiles/Cliente.dir/models/fruit.c.obj: CMakeFiles/Cliente.dir/flags.make
CMakeFiles/Cliente.dir/models/fruit.c.obj: ../models/fruit.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_5) "Building C object CMakeFiles/Cliente.dir/models/fruit.c.obj"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\Cliente.dir\models\fruit.c.obj   -c "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\models\fruit.c"

CMakeFiles/Cliente.dir/models/fruit.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Cliente.dir/models/fruit.c.i"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\models\fruit.c" > CMakeFiles\Cliente.dir\models\fruit.c.i

CMakeFiles/Cliente.dir/models/fruit.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Cliente.dir/models/fruit.c.s"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\models\fruit.c" -o CMakeFiles\Cliente.dir\models\fruit.c.s

CMakeFiles/Cliente.dir/ui/LobbyWindow.c.obj: CMakeFiles/Cliente.dir/flags.make
CMakeFiles/Cliente.dir/ui/LobbyWindow.c.obj: ../ui/LobbyWindow.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_6) "Building C object CMakeFiles/Cliente.dir/ui/LobbyWindow.c.obj"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\Cliente.dir\ui\LobbyWindow.c.obj   -c "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\ui\LobbyWindow.c"

CMakeFiles/Cliente.dir/ui/LobbyWindow.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Cliente.dir/ui/LobbyWindow.c.i"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\ui\LobbyWindow.c" > CMakeFiles\Cliente.dir\ui\LobbyWindow.c.i

CMakeFiles/Cliente.dir/ui/LobbyWindow.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Cliente.dir/ui/LobbyWindow.c.s"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\ui\LobbyWindow.c" -o CMakeFiles\Cliente.dir\ui\LobbyWindow.c.s

CMakeFiles/Cliente.dir/sockets/socket.c.obj: CMakeFiles/Cliente.dir/flags.make
CMakeFiles/Cliente.dir/sockets/socket.c.obj: ../sockets/socket.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_7) "Building C object CMakeFiles/Cliente.dir/sockets/socket.c.obj"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\Cliente.dir\sockets\socket.c.obj   -c "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\sockets\socket.c"

CMakeFiles/Cliente.dir/sockets/socket.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Cliente.dir/sockets/socket.c.i"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\sockets\socket.c" > CMakeFiles\Cliente.dir\sockets\socket.c.i

CMakeFiles/Cliente.dir/sockets/socket.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Cliente.dir/sockets/socket.c.s"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\sockets\socket.c" -o CMakeFiles\Cliente.dir\sockets\socket.c.s

CMakeFiles/Cliente.dir/controllers/lobbyController.c.obj: CMakeFiles/Cliente.dir/flags.make
CMakeFiles/Cliente.dir/controllers/lobbyController.c.obj: ../controllers/lobbyController.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_8) "Building C object CMakeFiles/Cliente.dir/controllers/lobbyController.c.obj"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\Cliente.dir\controllers\lobbyController.c.obj   -c "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\controllers\lobbyController.c"

CMakeFiles/Cliente.dir/controllers/lobbyController.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Cliente.dir/controllers/lobbyController.c.i"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\controllers\lobbyController.c" > CMakeFiles\Cliente.dir\controllers\lobbyController.c.i

CMakeFiles/Cliente.dir/controllers/lobbyController.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Cliente.dir/controllers/lobbyController.c.s"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\controllers\lobbyController.c" -o CMakeFiles\Cliente.dir\controllers\lobbyController.c.s

CMakeFiles/Cliente.dir/controllers/jsonController.c.obj: CMakeFiles/Cliente.dir/flags.make
CMakeFiles/Cliente.dir/controllers/jsonController.c.obj: ../controllers/jsonController.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_9) "Building C object CMakeFiles/Cliente.dir/controllers/jsonController.c.obj"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\Cliente.dir\controllers\jsonController.c.obj   -c "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\controllers\jsonController.c"

CMakeFiles/Cliente.dir/controllers/jsonController.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Cliente.dir/controllers/jsonController.c.i"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\controllers\jsonController.c" > CMakeFiles\Cliente.dir\controllers\jsonController.c.i

CMakeFiles/Cliente.dir/controllers/jsonController.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Cliente.dir/controllers/jsonController.c.s"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\controllers\jsonController.c" -o CMakeFiles\Cliente.dir\controllers\jsonController.c.s

CMakeFiles/Cliente.dir/controllers/json.c.obj: CMakeFiles/Cliente.dir/flags.make
CMakeFiles/Cliente.dir/controllers/json.c.obj: ../controllers/json.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_10) "Building C object CMakeFiles/Cliente.dir/controllers/json.c.obj"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\Cliente.dir\controllers\json.c.obj   -c "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\controllers\json.c"

CMakeFiles/Cliente.dir/controllers/json.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Cliente.dir/controllers/json.c.i"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\controllers\json.c" > CMakeFiles\Cliente.dir\controllers\json.c.i

CMakeFiles/Cliente.dir/controllers/json.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Cliente.dir/controllers/json.c.s"
	C:\MinGW\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\controllers\json.c" -o CMakeFiles\Cliente.dir\controllers\json.c.s

# Object files for target Cliente
Cliente_OBJECTS = \
"CMakeFiles/Cliente.dir/main.c.obj" \
"CMakeFiles/Cliente.dir/ui/GameWindow.c.obj" \
"CMakeFiles/Cliente.dir/models/monkey.c.obj" \
"CMakeFiles/Cliente.dir/models/kremlin.c.obj" \
"CMakeFiles/Cliente.dir/models/fruit.c.obj" \
"CMakeFiles/Cliente.dir/ui/LobbyWindow.c.obj" \
"CMakeFiles/Cliente.dir/sockets/socket.c.obj" \
"CMakeFiles/Cliente.dir/controllers/lobbyController.c.obj" \
"CMakeFiles/Cliente.dir/controllers/jsonController.c.obj" \
"CMakeFiles/Cliente.dir/controllers/json.c.obj"

# External object files for target Cliente
Cliente_EXTERNAL_OBJECTS =

Cliente.exe: CMakeFiles/Cliente.dir/main.c.obj
Cliente.exe: CMakeFiles/Cliente.dir/ui/GameWindow.c.obj
Cliente.exe: CMakeFiles/Cliente.dir/models/monkey.c.obj
Cliente.exe: CMakeFiles/Cliente.dir/models/kremlin.c.obj
Cliente.exe: CMakeFiles/Cliente.dir/models/fruit.c.obj
Cliente.exe: CMakeFiles/Cliente.dir/ui/LobbyWindow.c.obj
Cliente.exe: CMakeFiles/Cliente.dir/sockets/socket.c.obj
Cliente.exe: CMakeFiles/Cliente.dir/controllers/lobbyController.c.obj
Cliente.exe: CMakeFiles/Cliente.dir/controllers/jsonController.c.obj
Cliente.exe: CMakeFiles/Cliente.dir/controllers/json.c.obj
Cliente.exe: CMakeFiles/Cliente.dir/build.make
Cliente.exe: CMakeFiles/Cliente.dir/linklibs.rsp
Cliente.exe: CMakeFiles/Cliente.dir/objects1.rsp
Cliente.exe: CMakeFiles/Cliente.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_11) "Linking C executable Cliente.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\Cliente.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Cliente.dir/build: Cliente.exe

.PHONY : CMakeFiles/Cliente.dir/build

CMakeFiles/Cliente.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\Cliente.dir\cmake_clean.cmake
.PHONY : CMakeFiles/Cliente.dir/clean

CMakeFiles/Cliente.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente" "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente" "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable" "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable" "C:\Users\carlo\OneDrive\Escritorio\version subir tarea 3\2021_LENGUAJES_TAREA3_DonCEy_Kong_Jr\Cliente\Ejecutable\CMakeFiles\Cliente.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/Cliente.dir/depend
