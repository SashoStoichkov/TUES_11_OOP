#ifndef ORDER_H
#define ORDER_H

#include <string>
#include <list>

#include "service.h"
#include "client.h"
#include "part.h"
#include "car.h"

class Order{
    public:
        int number;
        std::list<Service> services;
        std::list<Part> parts;
        Car car;
        float price;
        std::string status;
        Client client;

        Order(){};

        Order(int number, std::list<Service> services, std::list<Part> parts, Car car, float price, std::string status, Client client);

        Order(const Order& order);
};

#endif