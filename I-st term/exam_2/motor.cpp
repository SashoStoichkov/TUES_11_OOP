#include "motor.h"

Motor::Motor(std::string model_name, std::string serial_number, int kubic) :
    MotorVehicle(model_name, serial_number), kubic(kubic){};

Motor::Motor(const Motor& motor){
    this->model_name = motor.model_name;
    this->serial_number = motor.serial_number;
    this->kubic = motor.kubic;
}