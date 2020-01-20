#ifndef SUPPLIER_H
#define SUPPLIER_H

#include <string>

class Supplier{
    protected:
        std::string name;
    public:
        Supplier(){};

        Supplier(std::string name);

        std::string get_name() const;
};

#endif