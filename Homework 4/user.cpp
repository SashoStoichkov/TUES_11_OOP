#include "user.h"

User::User(unsigned int user_id, std::string username, std::string password) :
    user_id(user_id), username(username), password(password){};

unsigned int User::get_id() const {
    return this->user_id;
}