#include "server.h"

Server::Server(std::list<std::string> possible_paths, std::list<User> users) :
    possible_paths(possible_paths), users(users){};