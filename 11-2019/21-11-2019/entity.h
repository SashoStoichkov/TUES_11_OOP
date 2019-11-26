#ifndef ENTITY_H
#define ENTITY_H
#include "base_object.h"

class Entity : public BaseObject {
    public:
        bool is_touchable;

        void set_touchable();
};

#endif