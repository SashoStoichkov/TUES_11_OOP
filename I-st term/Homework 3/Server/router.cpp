#include "router.h"
#include <iostream>

Response Router::routeRequest(const Request& request, const Server& server){
    std::cout << request.get_path() << std::endl;

    if (request.get_path() == "/login.html"){
        return this->handleRequestLoginHtml(request);
    } else if (request.get_path() == "/home.html"){
        return this->handleRequestHomeHtml(request);
    } else if (request.get_path() == "/api/login"){
        return this->handleRequestApiLogin(request, server);
    } else if (request.get_path() == "/api/get_users"){
        return this->handleRequestApiGetUsers(request, server);
    } else {
        return Response(404, "Wrong address_path");
    }
}