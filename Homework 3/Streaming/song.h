#ifndef SONG_H
#define SONG_H

#include "media.h"

class Song : public Media{
    protected:
        int times_heard;
    public:
        Song(){};

        Song(std::string title, std::string author, float price, int times_heard);

        float calc_total();
};

#endif