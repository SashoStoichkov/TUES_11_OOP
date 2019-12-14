#ifndef MOTORVEHICLE_H
#define MOTORVEHICLE_H

#include <string>

class MotorVehicle{
    protected:
        std::string model_name;
        std::string serial_number;
    public:
        MotorVehicle(){};

        MotorVehicle(std::string model_name, std::string serial_number);

        MotorVehicle(const MotorVehicle& motorVehicle);
};

#endif