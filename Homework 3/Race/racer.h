#ifndef RACER_H
#define RACER_H

#include <string>

#include "race.h"
class Race;

class Racer{
    protected:
        std::string name;
        int position;
        int speed;
    public:
        Racer(){};

        Racer(std::string name, int position, int speed);

        void print_name() const;

        // void move_forward(const Race& race);
};

#endif