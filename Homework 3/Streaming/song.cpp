#include "song.h"

Song::Song(std::string title, std::string author, float price, int times_heard) :
    Media(title, author, price), times_heard(times_heard){};

float Song::calc_total(){
    return this->times_heard * this->price;
}