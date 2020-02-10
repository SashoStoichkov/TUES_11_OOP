#ifndef FACTORY_H
#define FACTORY_H

#include "report.h"

class Factory{
    protected:
        std::string name;
        Process process;
    public:
        Factory(){};

        Factory(std::string name, Process process);

        void add_step(std::list<Good> used_goods, std::string description, int used_time, int efficency);
        std::pair<std::list<Good>, int> total_goods_and_time() const;
        int return_efficency() const;
        // Report return_report() const; - проба за реализация (неуспешен)
};

#endif