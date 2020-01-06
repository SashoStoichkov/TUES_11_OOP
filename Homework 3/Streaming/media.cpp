#include "media.h"

Media::Media(std::string title, std::string author, float price) :
    title(title), author(author), price(price){};

std::string Media::get_title() const {
    return this->title;
}