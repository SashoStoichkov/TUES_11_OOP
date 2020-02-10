#ifndef REPORT_H
#define REPORT_H

#include "process.h"

class Report{
    protected:
        std::list<Good> used_goods;
        int time;
        int steps;
        int total_efficency;
    public:
        Report(){};

        Report(std::list<Good> used_goods, int time, int steps, int total_efficency);
};

#endif