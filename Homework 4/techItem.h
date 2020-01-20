#ifndef TECHITEM_H
#define TECHITEM_H

#include "item.h"

class TechItem : public Item{
    protected:
        std::string type;
        int years_warranty;
        int weight;
    public:
        TechItem(){};

        TechItem(std::string name, double price, int stock, Supplier supplier, int delivery_days, std::string type, int years_warranty, int weight);
};

#endif