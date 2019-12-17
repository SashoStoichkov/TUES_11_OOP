#ifndef EMPLOYEE_H
#define EMPLOYEE_H

#include <string>

class Employee{
    protected:
        std::string name;
        long id;
    public:
        Employee(){};

        Employee(std::string name, long id);

        virtual void print() const;
};

#endif