#ifndef ELECTRONICS_H
#define ELECTRONICS_H

#include "product.h"
#include "el_type.h"

class Electronics : public Product{
    protected:
        ElType &type;
        std::string expire_warranty;
        std::string terms_warranty;
    public:
        void set_el_type(ElType &type);
};


#endif
