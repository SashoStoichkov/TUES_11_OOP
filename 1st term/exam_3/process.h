#ifndef PROCESS_H
#define PROCESS_H

#include <list>

#include "step.h"

class Process{
    // protected:
    public:
        std::list<Step> steps;
        Process(){};

        Process(std::list<Step> steps);
        int get_last_step_id() const;
};

#endif