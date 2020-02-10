#include "repairShop.h"

RepairShop::RepairShop(std::list<Client> clients, std::list<Part> parts, std::list<Service> services, std::list<Car> cars, int capacity, std::list<Order> orders) :
    clients(clients), parts(parts), services(services), cars(cars), capacity(capacity), orders(orders){};

RepairShop::RepairShop(const RepairShop& repairShop){
    this->clients = repairShop.clients;
    this->parts = repairShop.parts;
    this->services = repairShop.services;
    this->cars = repairShop.cars;
    this->capacity = repairShop.capacity;
    this->orders = repairShop.orders;
}

// std::list<Order> RepairShop::orders_for_client(Client client){
//     std::list<Order> orders;

//     std::list<Order>::iterator i;
//     std::list<Order>::iterator j = orders.begin;

//     for (i = this->orders.begin; i != this->orders.end; i++){
//         if (i->client == client){
//             *j = *i;
//             j++;
//         }
//     }

//     return orders;
// }

// std::list<Order> RepairShop::orders_for_car(Car car){
//     std::list<Order> orders;

//     std::list<Order>::iterator i;
//     std::list<Order>::iterator j = orders.begin;

//     for (i = this->cars.begin; i != this->cars.end; i++){
//         if (i->car == car){
//             *j = *i;
//             j++;
//         }
//     }

//     return orders;
// }

// Order RepairShop::return_order_by_number(int number){
//     Order order;

//     std::list<Order>::iterator i;

//     for (i = this->orders.begin; i != this->orders.end; i++){
//         if (i->number == number){
//             order = *i;
//         }
//     }

//     return order;
// }

// std::list<Order> RepairShop::all_active_orders(){
//     std::list<Order> orders;

//     std::list<Order>::iterator i;
//     std::list<Order>::iterator j = orders.begin;

//     for (i = this->orders.begin; i != this->orders.end; i++){
//         if (i->status == "Active"){
//             *j = *i;
//             j++;
//         }
//     }

//     return orders;
// }