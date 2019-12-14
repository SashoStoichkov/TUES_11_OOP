#ifndef FOOD_H
#define FOOD_H

#include "product.h"
#include "food_type.h"

class Food : public Product{
    protected:
        FoodType &type;
        std::string expire_date;
    public:
        
        int has_allergens();
        int is_BDS();
        void set_foodtype(FoodType &type);
};


#endif
