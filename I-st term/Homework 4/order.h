#ifndef ORDER_H
#define ORDER_H

#include <string>
#include <list>

#include "user.h"
#include "item.h"

class Order{
    protected:
        unsigned int order_id;
        User user;
        std::list<Item> ordered_items;
        std::list<int> quantities;
    public:
        std::string order_status;
        Order(){};

        Order(unsigned int order_id, User user, std::list<Item> ordered_items, std::list<int> quantities, std::string order_status);

        unsigned int get_id() const;
        unsigned int get_user_id() const;
        std::string get_order_status() const;

        std::list<int> get_quantities() const;
        std::list<Item> get_items() const;
        void set_order_status(std::string status);

        void add_item(const Item& item, int quantity);
};

#endif