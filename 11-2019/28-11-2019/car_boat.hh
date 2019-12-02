#ifndef CAR_BOAT_HH
#define CAR_BOAT_HH

#include "./vehicle.hh"
#include "./land_vehicle.hh"
#include "./water_vehicle.hh"

class CarBoat : public Vehicle, public LandVehicle, public WaterVehicle {
    protected:
        bool in_water;
        bool on_land;
    public:
        void accelerate();
};

#endif
