if(NEW_LOG_LEVEL)
    set(CMAKE_MESSAGE_LOG_LEVEL "${NEW_LOG_LEVEL}")
endif()
cmake_language(GET_MESSAGE_LOG_LEVEL log_level)
message(STATUS "log level is: ${log_level}")
