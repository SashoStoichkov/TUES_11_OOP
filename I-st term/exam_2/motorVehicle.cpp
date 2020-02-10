#include "motorVehicle.h"

MotorVehicle::MotorVehicle(std::string maodel_name, std::string serial_number) :
    model_name(model_name), serial_number(serial_number){};

MotorVehicle::MotorVehicle(const MotorVehicle& motorVehicle){
    this->model_name = motorVehicle.model_name;
    this->serial_number = motorVehicle.serial_number;
}