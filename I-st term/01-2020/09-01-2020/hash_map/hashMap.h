#ifndef HASHMAP_H
#define HASHMAP_H

#include <string>
#include <list>
#include "pair.h"

template<class Key, class Value>
class HashMap{
    protected:
        std::list<Pair<Key, Value>> pairs;
    public:
        HashMap(){};

        void addPair(const Pair<Key, Value>& pair);

        std::list<Pair<Key, Value>> getHashMap() const;

        std::list<Pair<Key, Value>> sortHashMapBy(std::string method);
};

#endif