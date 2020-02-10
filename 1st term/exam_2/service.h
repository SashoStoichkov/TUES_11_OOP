#ifndef SERVICE_H
#define SERVICE_H

#include <string>
#include <list>

#include "part.h"

class Service{
    protected:
        std::string name;
        float price;
        std::list<Part> needed_parts;
        std::string vehicle_type;
    public:
        Service(){};

        Service(std::string name, float price, std::list<Part> needed_parts, std::string vehicle_type);

        Service(const Service& service);
};

#endif