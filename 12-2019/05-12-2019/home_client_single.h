#ifndef HOME_CLIENT_SINGLE_H
#define HOME_CLIENT_SINGLE_H

#include "home_client.h"

class HomeClientSingle : HomeClient{
    protected:
        float usedPower;
        float rate;
    public:
        HomeClientSingle(float delivery_price, float distribution_price, 
                         float usedPower, float rate);
        float calcBill();
};

#endif