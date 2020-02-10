#include "pair.h"

template<class Key, class Value>
Pair<Key, Value>::Pair(Key key, Value value) :
    key(key), value(value){};

template<class Key, class Value>
Key Pair<Key, Value>::getPairKey() const {
    return this->key;
}

template<class Key, class Value>
Value Pair<Key, Value>::getPairValue() const {
    return this->value;
}

template<class Key, class Value>
Pair<Key, Value> Pair<Key, Value>::getPair() const {
    return this;
}