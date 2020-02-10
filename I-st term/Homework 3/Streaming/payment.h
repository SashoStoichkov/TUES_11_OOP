#ifndef PAYMENT_H
#define PAYMENT_H

#include <string>
#include <list>

#include "media.h"

class Payment{
    protected:
        std::string start_date;
        std::string end_date;
        std::list<Media> used_media;
        float total_price;
        std::string status;
    public:
        Payment(){};

        Payment(std::string start_date, std::string end_date, std::list<Media> used_media, float total_price, std::string status);

        std::string get_start_date() const;
        std::string get_end_date() const;
        std::string get_status() const;

        void mark_as_paid(std::string status);
};

#endif