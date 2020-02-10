#ifndef MATERIALGOOD_H
#define MATERIALGOOD_H

#include <string>

#include "good.h"

class MaterialGood : public Good{
    // protected:
    public:
        std::string name;
        std::string meter;

        MaterialGood(){};

        MaterialGood(std::string name, std::string meter, int quantity);
};

#endif