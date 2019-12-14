#ifndef TOURIST_PLANE_H
#define TOURIST_PLANE_H

#include "plane.h"

class TouristPlane : Plane{
    protected:
        int passengers;
        int seats;
        int exits;
};

#endif