#include "techItem.h"

TechItem::TechItem(std::string name, double price, int stock, Supplier supplier, int delivery_days, std::string type, int years_warranty, int weight) :
    Item(name, price, stock, supplier, delivery_days), type(type), years_warranty(years_warranty), weight(weight){};