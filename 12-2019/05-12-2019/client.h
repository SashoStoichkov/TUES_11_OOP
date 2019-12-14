#ifndef CLIENT_H
#define CLIENT_H

class Client{
    protected:
        float delivery_price;
        float distribution_price;
    public:
        Client(float delivery_price, float distribution_price);
};

#endif