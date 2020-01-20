#include "clothItem.h"

ClothItem::ClothItem(std::string name, double price, int stock, Supplier supplier, int delivery_days, std::string color, std::string size, std::string fabric) :
    Item(name, price, stock, supplier, delivery_days), color(color), size(size), fabric(fabric){};