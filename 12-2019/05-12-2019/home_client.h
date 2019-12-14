#ifndef HOME_CLIENT_H
#define HOME_CLIENT_H

#include "client.h"

class HomeClient : public Client{
    public:
        HomeClient(float delivery_price, float distribution_price);
};

#endif