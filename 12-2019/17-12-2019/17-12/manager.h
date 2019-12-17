#ifndef MANAGER_H
#define MANAGER_H

#include "employee.h"
#include <string>

class Manager : public Employee{
    protected:
        int level;
    public:
        Manager(){};

        Manager(std::string name, long id, int level);

        void print() const;
};

#endif