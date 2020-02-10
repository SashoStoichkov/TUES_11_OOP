#ifndef PAIR_H
#define PAIR_H

template<class Key, class Value>
class Pair{
    protected:
        Key key;
        Value value;
    public:
        Pair(){};

        Pair(Key key, Value value);

        Key getPairKey() const;
        Value getPairValue() const;

        Pair getPair() const;
};

#endif