#include "supplier.h"

Supplier::Supplier(std::string name) :
    name(name){};

std::string Supplier::get_name() const {
    return this->name;
}