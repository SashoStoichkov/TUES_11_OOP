#ifndef MOTOR_H
#define MOTOR_H

#include "motorVehicle.h"

class Motor : public MotorVehicle{
    protected:
        int kubic;
    public:
        Motor(){};

        Motor(std::string model_name, std::string serial_number, int kubic);

        Motor(const Motor& motor);
};

#endif