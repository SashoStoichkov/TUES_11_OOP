#include "store.h"
#include <iostream>

bool user_exists(int user_id, std::list<User> users){
    std::list<User> all_users = users;
    std::list<User>::iterator aui;

    for (aui = all_users.begin(); aui != all_users.end(); aui++){
        if (aui->get_id() == user_id){
            return true;
        }
    }

    return false;
}

bool order_exists(int order_id, std::list<Order> orders){
    std::list<Order> all_orders = orders;
    std::list<Order>::iterator aoi;

    for (aoi = all_orders.begin(); aoi != all_orders.end(); aoi++){
        if (aoi->get_id() == order_id){
            return true;
        }
    }

    return false;
}

Store::Store(std::list<User> users, std::list<Item> items, std::list<Order> orders) :
    users(users), items(items), orders(orders){};

std::list<Item> Store::get_items() const {
    return this->items;
}

std::list<Order> Store::get_orders() const {
    return this->orders;
}

void Store::add_user(const User& user){
    if (user_exists(user.get_id(), this->users)){
        throw UserExists();
    } else {
        this->users.push_back(user);
    }
}

void Store::add_item(const Item& item){
    this->items.push_back(item);
}

void Store::create_order(const Order& order){
    if (!user_exists(order.get_user_id(), this->users)){
        throw UserDoesNotExist();
    } else if (order_exists(order.get_id(), this->orders)){
        throw OrderExists();
    } else {
        std::list<Item> order_items = order.get_items();
        std::list<Item>::iterator oii;

        std::list<int> order_item_quantities = order.get_quantities();
        std::list<int>::iterator oiqi;

        std::list<Item> store_items = this->items;
        std::list<Item>::iterator sii;

        for (sii = store_items.begin(); sii != store_items.end(); sii++){
            for (oii = order_items.begin(), oiqi = order_item_quantities.begin(); oii != order_items.end(), oiqi != order_item_quantities.end(); oii++, oiqi++){
                if (sii->get_name() == oii->get_name()){
                    if (sii->get_stock() - *oiqi < 0){
                        throw TooMuchItems();
                    } else {
                        sii->reduce_stock_by(*oiqi);
                    }
                }
            }
        }

        this->items = store_items;
        this->orders.push_back(order);
    }

}

std::pair<double, int> Store::accept_order(unsigned int order_id, std::list<Order>& store_orders){
    if (!order_exists(order_id, this->orders)){
        throw OrderDoesNotExist();
    } else {
        store_orders = this->orders;
        std::list<Order>::iterator soi;

        Order order = Order();

        for (soi = store_orders.begin(); soi != store_orders.end(); soi++){
            if (soi->get_id() == order_id){
                if (soi->get_order_status() != "New"){
                    throw OrderNotNew();
                } else {
                    soi->set_order_status("In Store!");
                    order = *soi;
                }
            }
        }

        std::list<Item> order_items = order.get_items();
        std::list<Item>::iterator oii;

        std::list<int> order_item_quantities = order.get_quantities();
        std::list<int>::iterator oiqi;

        double total_price = 0;
        int max_days = 0;

        for (oii = order_items.begin(), oiqi = order_item_quantities.begin(); oii != order_items.end(), oiqi != order_item_quantities.end(); oii++, oiqi++){
            total_price += (oii->get_price() * *(oiqi));

            if (oii->get_delivery_days() > max_days){
                max_days = oii->get_delivery_days();
            }
        }

        return std::make_pair(total_price, max_days);
    }

}

void Store::send_order(unsigned int order_id, std::list<Order>& store_orders){
    if (!order_exists(order_id, this->orders)){
        throw OrderDoesNotExist();
    } else {
        store_orders = this->orders;
        std::list<Order>::iterator soi;

        Order order = Order();

        for (soi = store_orders.begin(); soi != store_orders.end(); soi++){
            if (soi->get_id() == order_id){
                if (soi->get_order_status() != "In Store!"){
                    throw OrderNotInStore();
                } else {
                    soi->set_order_status("Sent!");
                    order = *soi;
                }
            }
        }
    }
}

std::list<Order> Store::get_orders_by_user(unsigned int user_id) const {
    if (!user_exists(user_id, this->users)){
        throw UserDoesNotExist();
    } else {
        std::list<Order> all_orders = this->orders;
        std::list<Order>::iterator aoi;

        std::list<Order> orders_by_user;

        for (aoi = all_orders.begin(); aoi != all_orders.end(); aoi++){
            if (aoi->get_user_id() == user_id){
                orders_by_user.push_back(*(aoi));
            }
        }

        return orders_by_user;
    }
}

std::list<Item> Store::get_items_by_supplier(const Supplier& supplier) const {
    std::list<Item> all_items = this->items;
    std::list<Item>::iterator aii;

    std::list<Item> items_by_supplier;

    for (aii = all_items.begin(); aii != all_items.end(); aii++){
        if (aii->get_supplier_name() == supplier.get_name()){
            items_by_supplier.push_back(*(aii));
        }
    }

    return items_by_supplier;
}