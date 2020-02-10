#ifndef USER_H
#define USER_H

#include <string>
#include <list>

#include "payment.h"

class User{
    protected:
        std::string name;
        std::string email;
        std::list<Media> used_media;
        std::list<Payment> payments;
    public:
        User(){};

        User(std::string name, std::string email, std::list<Media> used_media, std::list<Payment> payments);

        std::string get_name() const;
        std::string get_email() const;

        std::list<Payment> get_payments() const;
};

#endif