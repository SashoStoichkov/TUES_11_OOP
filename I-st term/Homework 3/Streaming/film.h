#ifndef FILM_H
#define FILM_H

#include "media.h"

class Film : public Media{
    protected:
        int minutes_watched;
    public:
        Film(){};

        Film(std::string title, std::string author, float price, int minutes_watched);

        float calc_total();
};

#endif