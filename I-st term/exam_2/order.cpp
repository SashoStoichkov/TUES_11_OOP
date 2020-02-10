#include "order.h"

Order::Order(int number, std::list<Service> services, std::list<Part> parts, Car car, float price, std::string status, Client client) :
    number(number), services(services), parts(parts), car(car), price(price), status(status), client(client){};

Order::Order(const Order& order){
    this->number = order.number;
    this->services = order.services;
    this->parts = order.parts;
    this->car = order.car;
    this->price = order.price;
    this->status = order.status;
    this->client = order.client;
}