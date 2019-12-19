#ifndef AMEBA_H
#define AMEBA_H

#include <list>

class Ameba{
    public:
        virtual void act(std::list<Ameba*>& all_amebas, int index);
};

#endif