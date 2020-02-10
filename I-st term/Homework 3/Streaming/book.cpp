#include "book.h"

Book::Book(std::string title, std::string author, float price) :
    Media(title, author, price){};

float Book::calc_total(){
    return this->price;
}