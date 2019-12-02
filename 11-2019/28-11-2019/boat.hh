#ifndef BOAT_HH
#define BOAT_HH

#include "./vehicle.hh"
#include "./water_vehicle.hh"

class Boat : public Vehicle, public WaterVehicle {
    public:
        void accelerate();
};

#endif
