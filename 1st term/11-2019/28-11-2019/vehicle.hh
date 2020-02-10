#ifndef VEHICLE_HH
#define VEHICLE_HH

#include "./entity.hh"

class Vehicle : public Entity {
protected:
  float speed;
  int seatCount;
  float acceleration;
  float weight;
public:
  void accelerate();
};

#endif
