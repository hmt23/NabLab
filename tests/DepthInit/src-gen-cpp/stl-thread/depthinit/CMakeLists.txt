### GENERATED FILE - DO NOT OVERWRITE ###

cmake_minimum_required(VERSION 3.10)

set(LIBCPPNABLA_DIR $ENV{HOME}/workspaces/NabLab/tests/DepthInit/../LibCppNabla CACHE STRING "")
set(NABLA_CXX_COMPILER /usr/bin/g++)
set(BATILIB_DIR $ENV{HOME}/workspaces/NabLab/tests/DepthInit/../BatiLib/src-cpp)

project(DepthInitProject CXX)

set(CMAKE_CXX_COMPILER ${NABLA_CXX_COMPILER} CACHE STRING "")

if(CMAKE_CXX_COMPILER_ID STREQUAL "GNU")
	if(CMAKE_CXX_COMPILER_VERSION VERSION_LESS "7.4.0")
		message(FATAL_ERROR "GCC minimum required version is 7.4.0. Please upgrade.")
	endif()
elseif(CMAKE_CXX_COMPILER_ID STREQUAL "Clang")
	if(CMAKE_CXX_COMPILER_VERSION VERSION_LESS "9.0.0")
		message(FATAL_ERROR "Clang minimum required version is 9.0.0. Please upgrade.")
	endif()
endif()

add_subdirectory(${BATILIB_DIR} ${CMAKE_BINARY_DIR}/BatiLibCpp EXCLUDE_FROM_ALL)
if(NOT TARGET cppnabla)
	add_subdirectory(${LIBCPPNABLA_DIR} ${CMAKE_BINARY_DIR}/LibCppNabla EXCLUDE_FROM_ALL)
endif()


add_executable(depthinit DepthInit.cc)
target_include_directories(depthinit PUBLIC ${CMAKE_CURRENT_SOURCE_DIR}/..)
target_link_libraries(depthinit PUBLIC cppnabla cppnablastl pthread batilib)

if (EXISTS ${CMAKE_CURRENT_SOURCE_DIR}/Project.cmake)
	include(${CMAKE_CURRENT_SOURCE_DIR}/Project.cmake)
endif()
