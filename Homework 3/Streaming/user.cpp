#include "user.h"

User::User(std::string name, std::string email, std::list<Media> used_media, std::list<Payment> payments) :
    name(name), email(email), used_media(used_media), payments(payments){};

std::string User::get_name() const{
    return this->name;
}

std::string User::get_email() const{
    return this->email;
}

std::list<Payment> User::get_payments() const {
    return this->payments;
}