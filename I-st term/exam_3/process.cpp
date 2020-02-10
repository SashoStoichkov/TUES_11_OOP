#include "process.h"

Process::Process(std::list<Step> steps) :
    steps(steps){};

int Process::get_last_step_id() const {
    std::list<Step> s = this->steps;
    std::list<Step>::iterator i;

    int id;

    for (i = s.begin(); i != s.end(); i++){
        id = i->id;
    }

    return id;
}