#ifndef CLIENT_H
#define CLIENT_H

#include <string>

class Client{
    protected:
        std::string name;
        std::string email;
    public:
        Client(){};

        Client(std::string name, std::string email);

        Client(const Client& client);
};

#endif