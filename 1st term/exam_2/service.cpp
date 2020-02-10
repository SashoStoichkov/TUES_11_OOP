#include "service.h"

Service::Service(std::string name, float price, std::list<Part> needed_parts, std::string vehicle_type) :
    name(name), price(price), needed_parts(needed_parts), vehicle_type(vehicle_type){};

Service::Service(const Service& service){
    this->name = service.name;
    this->price = service.price;
    this->needed_parts = service.needed_parts;
    this->vehicle_type = service.vehicle_type;
}