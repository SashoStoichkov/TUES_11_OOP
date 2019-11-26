#ifndef PLAYER_H
#define PLAYER_H
#include "character.h"

class Player : public Character {
    public:
        int id;

        void set_id(int id);
};

#endif