#ifndef CLOTHITEM_H
#define CLOTHITEM_H

#include "item.h"

class ClothItem : public Item{
    protected:
        std::string color;
        std::string size;
        std::string fabric;
    public:
        ClothItem(){};

        ClothItem(std::string name, double price, int stock, Supplier supplier, int delivery_days, std::string color, std::string size, std::string fabric);
};

#endif