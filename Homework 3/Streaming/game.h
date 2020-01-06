#ifndef GAME_H
#define GAME_H

#include "media.h"

class Game : public Media{
    protected:
        int hours_played;
    public:
        Game(){};

        Game(std::string title, std::string author, float price, int hours_played);

        float calc_total();
};

#endif