#ifndef AIRPORT_H
#define AIRPORT_H

#include <list>
#include "plane.h"

class Airport{
    protected:
        int max_plane_capacity;
        int max_plane_size;

        bool can_civilian;
        bool can_military;

        list<Plane> planes;

        float position_x;
};

#endif