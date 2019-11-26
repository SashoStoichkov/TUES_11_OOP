#ifndef CHARACTER_H
#define CHARACTER_H
#include "entity.h"

class Character : public Entity {
    public:
        int age;

        void set_age(int age);
};

#endif