#ifndef MEDIA_H
#define MEDIA_H

#include <string>

class Media{
    protected:
        std::string title;
        std::string author;
        float price;
    public:
        Media(){};

        Media(std::string title, std::string author, float price);

        std::string get_title() const;

        float calc_total();
};

#endif