#include "./car.hh"

void Car::accelerate(){
    this->speed += this->acceleration - (this->weight * (-9.8));
}