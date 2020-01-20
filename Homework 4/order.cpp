#include "order.h"

Order::Order(unsigned int order_id, User user, std::list<Item> ordered_items, std::list<int> quantities, std::string order_status) :
    order_id(order_id), user(user), ordered_items(ordered_items), quantities(quantities), order_status(order_status){};

unsigned int Order::get_id() const {
    return this->order_id;
}

unsigned int Order::get_user_id() const {
    return this->user.get_id();
}

std::string Order::get_order_status() const {
    return this->order_status;
}

std::list<int> Order::get_quantities() const {
    return this->quantities;
}

std::list<Item> Order::get_items() const {
    return this->ordered_items;
}

void Order::set_order_status(std::string status){
    this->order_status = status;
}

bool has_item(const std::list<Item> items, const Item item){
    std::list<Item> items_list = items;
    std::list<Item>::iterator i;

    for (i = items_list.begin(); i != items_list.end(); i++){
        if (i->get_name() == item.get_name()){
            return true;
        }
    }

    return false;
}

void Order::add_item(const Item& item, int quantity){
    std::list<Item> items = this->ordered_items;

    if (has_item(items, item)){
        std::list<int> quant = this->quantities;

        int index = 0;
        std::list<Item>::iterator i;

        for (i = items.begin(); i != items.end(); i++, index++){
            if (i->get_name() == item.get_name()){
                break;
            }
        }

        auto it = std::next(quant.begin(), index);
        *it = *it + quantity;

        this->quantities = quant;
    } else {
        this->ordered_items.push_back(item);
        this->quantities.push_back(quantity);
    }
}