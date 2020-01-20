#ifndef ITEM_H
#define ITEM_H

#include <string>

#include "supplier.h"

class Item{
    protected:
        std::string name;
        double price;
        int stock;
        Supplier supplier;
        int delivery_days;
    public:
        Item(){};

        Item(std::string name, double price, int stock, Supplier supplier, int delivery_days);

        std::string get_name() const;
        double get_price() const;
        int get_stock() const;
        std::string get_supplier_name() const;
        int get_delivery_days() const;

        void reduce_stock_by(int stock);
};

#endif