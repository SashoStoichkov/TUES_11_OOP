#ifndef HOME_CLIENT_DOUBLE_H
#define HOME_CLIENT_DOUBLE_H

#include "home_client.h"

class HomeClientDouble : HomeClient{
    protected:
        float usedPowerDay;
        float usedPowerNight;
        float rateDay;
        float rateNight;
    public:
        HomeClientDouble(float delivery_price, float distribution_price, 
                         float usedPowerDay, float usedPowerNight, 
                         float rateDay, float rateNight);
        float calcBill();
};

#endif