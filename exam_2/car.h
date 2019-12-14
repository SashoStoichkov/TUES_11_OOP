#ifndef CAR_H
#define CAR_H

#include "motorVehicle.h"

class Car : public MotorVehicle{
    protected:
        std::string type_gasoline;
    public:
        Car(){};

        Car(std::string model_name, std::string serial_number, std::string type_gasoline);

        Car(const Car& car);
};

#endif