#include "food.h"

int Food::has_allergens(){
    return false;
}

int Food::is_BDS(){
    return true;
}

void Food::set_foodtype(FoodType &type){
    this->type = type;
}