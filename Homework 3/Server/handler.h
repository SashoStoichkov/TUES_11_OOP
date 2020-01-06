#ifndef HANDLER_H
#define HANDLER_H

#include "server.h"
#include "request.h"
#include "response.h"

class Handler{
    public:
        Handler(){};

        Response handleRequestLoginHtml(const Request& request);
        Response handleRequestHomeHtml(const Request& request);
        Response handleRequestApiLogin(const Request& request, const Server& server);
        Response handleRequestApiGetUsers(const Request& request, const Server& server);
};

#endif