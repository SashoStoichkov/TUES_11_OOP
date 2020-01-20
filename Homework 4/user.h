#ifndef USER_H
#define USER_H

#include <string>

class User{
    protected:
        unsigned int user_id;
        std::string username;
        std::string password;
    public:
        User(){};

        User(unsigned int user_id, std::string username, std::string password);

        unsigned int get_id() const;
};

#endif