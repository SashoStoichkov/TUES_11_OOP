#ifndef USER_H
#define USER_H

#include <string>

class User{
    protected:
        std::string username;
        std::string password;
    public:
        User(){};

        User(std::string username, std::string password);

        std::string get_username() const;
        std::string get_password() const;
};

#endif