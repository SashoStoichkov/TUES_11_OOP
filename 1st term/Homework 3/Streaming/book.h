#ifndef BOOK_H
#define BOOK_H

#include "media.h"

class Book : public Media{
    public:
        Book(){};

        Book(std::string title, std::string author, float price);

        float calc_total();
};

#endif