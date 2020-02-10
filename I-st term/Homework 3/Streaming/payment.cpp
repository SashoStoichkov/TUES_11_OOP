#include "payment.h"

Payment::Payment(std::string start_date, std::string end_date, std::list<Media> used_media, float total_price, std::string status) :
    start_date(start_date), end_date(end_date), used_media(used_media), total_price(total_price), status(status){};

std::string Payment::get_start_date() const{
    return this->start_date;
}

std::string Payment::get_end_date() const{
    return this->end_date;
}

std::string Payment::get_status() const{
    return this->status;
}

void Payment::mark_as_paid(std::string status){
    this->status = status;
}