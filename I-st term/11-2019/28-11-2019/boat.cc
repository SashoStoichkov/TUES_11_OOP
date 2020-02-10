#include "./boat.hh"

void Boat::accelerate(){
    this->speed += this->acceleration * (this->displacement / this->weight);
}