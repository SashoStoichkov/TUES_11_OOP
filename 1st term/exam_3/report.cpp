#include "report.h"

Report::Report(std::list<Good> used_goods, int time, int steps, int total_efficency) :
    used_goods(used_goods), time(time), steps(steps), total_efficency(total_efficency){};
