#include "factory.h"

Factory::Factory(std::string name, Process process) :
    name(name), process(process){};

void Factory::add_step(std::list<Good> used_goods, std::string description, int used_time, int efficency){
    int id = this->process.get_last_step_id() + 1;

    Step new_step = Step(id, description, used_goods, efficency, used_time);

    this->process.steps.push_back(new_step);
}

std::pair<std::list<Good>, int> Factory::total_goods_and_time() const {
    std::list<Good> goods;
    int time = 0;

    std::list<Step> steps = this->process.steps;
    std::list<Step>::iterator s;

    for (s = steps.begin(); s != steps.end(); s++){
        std::list<Good> used_goods = s->used_goods;
        std::list<Good>::iterator ug;
        for (ug = used_goods.begin(); ug != used_goods.end(); ug++){
            goods.push_back(*ug);
        }

        time += s->time;
    }

    return std::make_pair(goods, time);
}

int Factory::return_efficency() const {
    int total = 1;

    std::list<Step> steps = this->process.steps;
    std::list<Step>::iterator s;

    for (s = steps.begin(); s != steps.end(); s++){
        total *= s->efficency;
    }

    return total;
}

// Report Factory::return_report() const {
//     std::pair<std::list<Good>, int> pair = this->total_goods_and_time();

//     return Report(pair.first, pair.second, this->process.steps, this->return_efficency());
// }