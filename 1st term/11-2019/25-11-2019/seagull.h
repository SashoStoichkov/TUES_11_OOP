#ifndef SEAGULL_H
#define SEAGULL_H

#include "bird.h"
#include "can_fly.h"
#include "can_walk.h"
#include "can_swim.h"

class Seagull : public Bird, public CanFly, public CanWalk, public CanSwim{
    public:
        void eat_trash();
};

#endif