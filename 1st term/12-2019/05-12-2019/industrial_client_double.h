#ifndef INDUSTRIAL_CLIENT_DOUBLE_H
#define INDUSTRIAL_CLIENT_DOUBLE_H

#include "industrial_client.h"

class IndustrialClientDouble : IndustrialClient{
    protected:
        float usedPowerDay;
        float usedPowerNight;
        float rateDay;
        float rateNight;
    public:
        IndustrialClientDouble(float delivery_price, float distribution_price, float highVoltage, 
                               float usedPowerDay, float usedPowerNight, float rateDay, float rateNight);
        float calcBill();
};

#endif