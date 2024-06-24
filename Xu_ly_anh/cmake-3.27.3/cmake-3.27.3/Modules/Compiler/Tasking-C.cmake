include(Compiler/Tasking)
__compiler_tasking(C)

set(CMAKE_C90_STANDARD_COMPILE_OPTION "--iso=90" "--strict")
set(CMAKE_C90_EXTENSION_COMPILE_OPTION "--iso=90" " ")

set(CMAKE_C99_STANDARD_COMPILE_OPTION "--iso=99" "--strict")
set(CMAKE_C99_EXTENSION_COMPILE_OPTION "--iso=99" " ")

set(CMAKE_C11_STANDARD_COMPILE_OPTION "--iso=11" "--strict")
set(CMAKE_C11_EXTENSION_COMPILE_OPTION "--iso=11" " ")

if(CMAKE_C_COMPILER_ARCHITECTURE_ID STREQUAL "TriCore")
  if(CMAKE_TASKING_TOOLSET STREQUAL "SmartCode")
    __compiler_check_default_language_standard(C 10.1 11)
  else()
    __compiler_check_default_language_standard(C 6.3 11)
  endif()
elseif(CMAKE_C_COMPILER_ARCHITECTURE_ID STREQUAL "ARM")
  if(CMAKE_TASKING_TOOLSET STREQUAL "SmartCode")
    __compiler_check_default_language_standard(C 10.1 11)
  elseif(CMAKE_TASKING_TOOLSET STREQUAL "TriCore")
    __compiler_check_default_language_standard(C 6.3 11)
  else()
    __compiler_check_default_language_standard(C 6.0 11)
  endif()
elseif(CMAKE_C_COMPILER_ARCHITECTURE_ID STREQUAL "MCS")
  if(CMAKE_TASKING_TOOLSET STREQUAL "SmartCode")
    __compiler_check_default_language_standard(C 10.1 11)
  elseif(CMAKE_TASKING_TOOLSET STREQUAL "TriCore")
    __compiler_check_default_language_standard(C 6.3 11)
  else()
    __compiler_check_default_language_standard(C 3.3 11)
  endif()
elseif(CMAKE_C_COMPILER_ARCHITECTURE_ID STREQUAL "ARC")
  __compiler_check_default_language_standard(C 10.1 11)
elseif(CMAKE_C_COMPILER_ARCHITECTURE_ID STREQUAL "8051")
  if(CMAKE_TASKING_TOOLSET STREQUAL "SmartCode")
    __compiler_check_default_language_standard(C 10.1 11)
  elseif(CMAKE_TASKING_TOOLSET STREQUAL "TriCore")
    __compiler_check_default_language_standard(C 6.3 11)
  else()
    __compiler_check_default_language_standard(C 7.2 89)
  endif()
elseif(CMAKE_C_COMPILER_ARCHITECTURE_ID STREQUAL "PCP")
  __compiler_check_default_language_standard(C 6.3 11)
endif()