#include "step.h"

Step::Step(unsigned int id, std::string description, std::list<Good> used_goods, int efficency, int time) :
    id(id), description(description), used_goods(used_goods), efficency(efficency), time(time){};
