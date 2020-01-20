#ifndef STORE_H
#define STORE_H

#include "user.h"
#include "item.h"
#include "order.h"
#include "supplier.h"


class UserExists : std::exception {};
class UserDoesNotExist : std::exception {};
class TooMuchItems : std::exception {};
class OrderExists : std::exception {};
class OrderDoesNotExist : std::exception {};
class OrderNotNew : std::exception {};
class OrderNotInStore : std::exception {};

class Store{
    protected:
        std::list<User> users;
        std::list<Item> items;
    public:
        std::list<Order> orders; // ако е в protected не мога да променя глобално order_status-а
        Store(){};

        Store(std::list<User> users, std::list<Item> items, std::list<Order> orders);

        std::list<Item> get_items() const;
        std::list<Order> get_orders() const;

        void add_user(const User& user);
        void add_item(const Item& item);

        void create_order(const Order& order);
        std::pair<double, int> accept_order(unsigned int order_id, std::list<Order>& store_orders);
        void send_order(unsigned int order_id, std::list<Order>& store_orders);

        std::list<Order> get_orders_by_user(unsigned int user_id) const;
        std::list<Item> get_items_by_supplier(const Supplier& supplier) const;
};

#endif