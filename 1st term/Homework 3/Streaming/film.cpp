#include "film.h"

Film::Film(std::string title, std::string author, float price, int minutes_watched) :
    Media(title, author, price), minutes_watched(minutes_watched){};

float Film::calc_total(){
    return this->minutes_watched * this->price;
}