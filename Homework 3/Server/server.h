#ifndef SERVER_H
#define SERVER_H

#include <list>

#include "user.h"
#include "request.h"
#include "response.h"

class Server{
    protected:
        std::list<std::string> possible_paths;
    public:
        std::list<User> users;

        Server(){};

        Server(std::list<std::string> possible_paths, std::list<User> users);
};

#endif