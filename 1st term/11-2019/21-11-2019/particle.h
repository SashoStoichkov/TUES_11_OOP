#ifndef PARTICLE_H
#define PARTICLE_H
#include "base_object.h"

class Particle : public BaseObject {
    public:
        bool can_go_through();
        bool is_visible();
};

#endif