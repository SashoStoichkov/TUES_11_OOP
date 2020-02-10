#include "race.h"
#include <iostream>

Race::Race(int length, int number_of_racers) :
    length(length), number_of_racers(number_of_racers){};

std::list<std::list<Racer>> Race::get_map() const {
    return this->map;
}

// void Race::update_map(const std::list<std::list<Racer>>& map){
//     this->map = map;
// }

void Race::add_racer(const Racer& racer){
    std::list<Racer> new_list(this->length);
    new_list.push_front(racer);

    this->map.push_back(new_list);
    this->number_of_racers++;
}

void Race::print_map() const {
    std::list<std::list<Racer>>::iterator i;
    std::list<std::list<Racer>> map = this->map;

    for (i = map.begin(); i != map.end(); i++){
        std::list<Racer>::iterator j;

        for (j = i->begin(); j != i->end(); j++){
            std::cout << "| ";
            j->print_name();
            std::cout << " ";
        }
        std::cout << std::endl;
    }
}