#include "car.h"

Car::Car(std::string model_name, std::string serial_number, std::string type_gasoline) :
    MotorVehicle(model_name, serial_number), type_gasoline(type_gasoline){};

Car::Car(const Car& car){
    this->model_name = car.model_name;
    this->serial_number = car.serial_number;
    this->type_gasoline = car.type_gasoline;
}