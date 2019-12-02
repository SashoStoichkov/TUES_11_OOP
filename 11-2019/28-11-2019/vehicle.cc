#include "./vehicle.hh"

void Vehicle::accelerate(){
    this->speed += this->acceleration;
}