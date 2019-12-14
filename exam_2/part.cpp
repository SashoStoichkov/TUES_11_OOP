#include "part.h"

Part::Part(std::string name, float price, std::string vehicle_category) :
    name(name), price(price), vehicle_category(vehicle_category){};

Part::Part(const Part& part){
    this->name = part.name;
    this->price = part.price;
    this->vehicle_category = part.vehicle_category;
}