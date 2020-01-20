#include "hashMap.h"
#include <iostream>

template<class Key, class Value>
void HashMap<Key, Value>::addPair(const Pair<Key, Value>& pair){
    this->pairs.push_back(pair);
}

template<class Key, class Value>
std::list<Pair<Key, Value>> HashMap<Key, Value>::getHashMap() const {
    return this->pairs;
}

template<class Key, class Value>
std::list<Pair<Key, Value>> HashMap<Key, Value>::sortHashMapBy(std::string method){
    std::list<Pair<Key, Value>> h_map = this->getHashMap();

    for (auto i = h_map.begin(); i != h_map.end(); i++){
        for (auto j = h_map.begin(); j != h_map.end(); j++){
            if (j == h_map.end()){
                break;
            }

            if (method == "value"){
                Pair<Key, Value> &pair_1 = *j;
                Pair<Key, Value> &pair_2 = *(++j);

                if (pair_1.getPairValue() > pair_2.getPairValue()){
                    Pair<Key, Value> temp_pair_1 = pair_1;
                    pair_1 = pair_2;
                    pair_2 = temp_pair_1;
                }

                j++;
            } else if (method == "key"){
                Pair<Key, Value> &pair_1 = *j;
                Pair<Key, Value> &pair_2 = *(++j);

                if (pair_1.getPairKey() > pair_2.getPairKey()){
                    Pair<Key, Value> temp_pair_1 = pair_1;
                    pair_1 = pair_2;
                    pair_2 = temp_pair_1;
                }

                j++;
            }
        }
    }

    return h_map;
}