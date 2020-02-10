#include "service.h"

Service::Service(std::list<User> users, std::list<Media> all_media) :
    users(users), all_media(all_media){};

std::list<User> Service::return_all_users() const {
    return this->users;
}

std::list<Payment> Service::return_payments_for_user(const User& user) const {
    std::list<Payment> payments;

    std::list<User> all_users = this->users;
    std::list<User>::iterator i;

    for (i = all_users.begin(); i != all_users.end(); i++){
        if (i->get_name() == user.get_name() && i->get_email() == user.get_email()){
            payments = i->get_payments();
        }
    }

    return payments;
}

void Service::mark_payment_as_paid(Payment& payment){
    std::list<User> all_users = this->users;
    std::list<User>::iterator i;

    for (i = all_users.begin(); i != all_users.end(); i++){
        std::list<Payment> payments = i->get_payments();
        std::list<Payment>::iterator j;

        for (j = payments.begin(); j != payments.end(); j++){
            if (j->get_start_date() == payment.get_start_date() && j->get_end_date() == payment.get_end_date()){
                j->mark_as_paid("Paid");
                payment.mark_as_paid("Paid!");
            }
        }
    }
}

Media Service::return_media_by_title(std::string title) const {
    Media searched_media;

    std::list<Media> media = this->all_media;
    std::list<Media>::iterator i;

    for (i = media.begin(); i != media.end(); i++){
        if (i->get_title() == title){
            searched_media = *i;
        }
    }

    return searched_media;
}