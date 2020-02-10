#ifndef CAR_HH
#define CAR_HH

#include "./vehicle.hh"
#include "./land_vehicle.hh"

class Car : public Vehicle, public LandVehicle {
    public:
        void accelerate();
};

#endif
