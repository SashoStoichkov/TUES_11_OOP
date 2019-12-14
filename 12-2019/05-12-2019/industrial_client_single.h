#ifndef INDUSTRIAL_CLIENT_SINGLE_H
#define INDUSTRIAL_CLIENT_SINGLE_H

#include "industrial_client.h"

class IndustrialClientSingle : IndustrialClient{
    protected:
        float usedPower;
        float rate;
    public:
        float calcBill();
};

#endif