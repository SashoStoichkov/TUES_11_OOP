#include "racer.h"
#include <iostream>

Racer::Racer(std::string name, int position, int speed) :
    name(name), position(position), speed(speed){};

void Racer::print_name() const {
    std::cout << this->name[0];
}

// void Racer::move_forward(const Race& race){
//     std::list<std::list<Racer>> map = race.get_map();

//     std::list<std::list<Racer>>::iterator i;

//     for (i = map.begin(); i != map.end(); i++){
//         std::list<Racer>::iterator j;

//         for (j = i->begin(); j != i->end(); j++){
//             if (j->name == this->name){
//                 for (int step=0; step < this->speed; step++){
//                     i->push_front(NULL);
//                 }
//             }
//         }
//     }

//     race.update_map(map);
// }