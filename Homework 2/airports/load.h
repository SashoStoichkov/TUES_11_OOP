#ifndef LOAD_PLANE_H
#define LOAD_PLANE_H

#include "plane.h"

class LoadPlane : Plane{
    protected:
        int curr_capacity;
        int max_capacity;
};

#endif