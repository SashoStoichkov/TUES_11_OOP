#include "item.h"

Item::Item(std::string name, double price, int stock, Supplier supplier, int delivery_days) :
    name(name), price(price), stock(stock), supplier(supplier), delivery_days(delivery_days){};

std::string Item::get_name() const {
    return this->name;
}

double Item::get_price() const {
    return this->price;
}

int Item::get_stock() const {
    return this->stock;
}

std::string Item::get_supplier_name() const {
    return this->supplier.get_name();
}

int Item::get_delivery_days() const {
    return this->delivery_days;
}

void Item::reduce_stock_by(int stock){
    this->stock -= stock;
}