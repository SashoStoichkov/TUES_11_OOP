#ifndef SERVICE_H
#define SERVICE_H

#include "user.h"

class Service{
    protected:
        std::list<User> users;
        std::list<Media> all_media;
    public:
        Service(){};

        Service(std::list<User> users, std::list<Media> all_media);

        std::list<User> return_all_users() const;
        std::list<Payment> return_payments_for_user(const User& user) const;

        void mark_payment_as_paid(Payment& payment);
        Media return_media_by_title(std::string title) const;
};

#endif