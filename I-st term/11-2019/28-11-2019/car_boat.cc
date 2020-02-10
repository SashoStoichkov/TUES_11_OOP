#include "./car_boat.hh"

void CarBoat::accelerate(){
    if (on_land){
        this->speed += this->acceleration - (this->weight * (-9.8));
    } else if (in_water){
        this->speed += this->acceleration * (this->displacement / this->weight);
    }
}