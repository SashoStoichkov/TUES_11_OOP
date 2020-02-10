#include "user.h"

User::User(std::string username, std::string password) :
    username(username), password(password){};

std::string User::get_username() const {
    return this->username;
}

std::string User::get_password() const {
    return this->password;
}