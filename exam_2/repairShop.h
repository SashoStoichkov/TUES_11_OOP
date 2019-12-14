#ifndef REPAIRSHOP_H
#define REPAIRSHOP_H

#include "order.h"

class RepairShop{
    protected:
        std::list<Client> clients;
        std::list<Part> parts;
        std::list<Service> services;
        std::list<Car> cars;
        int capacity;
        std::list<Order> orders;
    public:
        RepairShop(){};

        RepairShop(std::list<Client> clients, std::list<Part> parts, std::list<Service> services, std::list<Car> cars, int capacity, std::list<Order> orders);

        RepairShop(const RepairShop& repairShop);

        std::list<Order> orders_for_client(Client client);
        std::list<Order> orders_for_car(Car car);
        Order return_order_by_number(int number);
        std::list<Order> all_active_orders();
};

#endif