#ifndef STEP_H
#define STEP_H

#include <string>
#include <list>

#include "good.h"

class Step{
    // protected:
    public:
        unsigned int id;
        std::string description;
        std::list<Good> used_goods;
        int efficency;
        int time;

        Step(){};

        Step(unsigned int id, std::string description, std::list<Good> used_goods, int efficency, int time);
};

#endif