#ifndef RACE_H
#define RACE_H

#include <list>

#include "racer.h"
class Racer;

class Race{
    protected:
        int length;
        int number_of_racers;

        std::list<std::list<Racer>> map;
    public:
        Race(){};

        Race(int length, int number_of_racers);
        std::list<std::list<Racer>> get_map() const;
        // void update_map(const std::list<std::list<Racer>>& map);

        void print_map() const;

        void add_racer(const Racer& racer);
};

#endif