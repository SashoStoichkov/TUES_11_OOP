#ifndef ROUTER_H
#define ROUTER_H

#include "handler.h"

class Router : public Handler{
    public:
        Router(){};

        Response routeRequest(const Request& request, const Server& server);
};

#endif