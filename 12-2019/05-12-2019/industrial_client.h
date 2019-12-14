#ifndef INDUSTRIAL_CLIENT_H
#define INDUSTRIAL_CLIENT_H

#include "client.h"

class IndustrialClient : public Client{
    protected:
        float highVoltage;
    public:
        IndustrialClient(float delivery_price, float distribution_price, float highVoltage);
};

#endif