#ifndef PART_H
#define PART_H

#include <string>

class Part{
    protected:
        std::string name;
        float price;
        std::string vehicle_category;
    public:
        Part(){};

        Part(std::string name, float price, std::string vehicle_category);

        Part(const Part& part);
};

#endif