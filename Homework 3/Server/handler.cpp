#include "handler.h"
#include "user.h"
#include <sstream>

Response Handler::handleRequestLoginHtml(const Request& request){
    return Response(200, "<html>login</html>");
}

Response Handler::handleRequestHomeHtml(const Request& request){
    return Response(200, "<html>home</html>");
}

Response Handler::handleRequestApiLogin(const Request& request, const Server& server){
    User user = User(request.get_username(), request.get_password());

    std::list<User> users = server.users;
    std::list<User>::iterator i;

    for (i = users.begin(); i != users.end(); i++){
        if (i->get_username() == user.get_username() && i->get_password() == user.get_password()){
            return Response(200, "OK");
        }
    }

    return Response(403, "Unauthorized");
}

Response Handler::handleRequestApiGetUsers(const Request& request, const Server& server){
    std::ostringstream users_str;

    std::list<User> users = server.users;
    std::list<User>::iterator i;

    int number_of_users = users.size();
    int j = 0;

    users_str << "[";
    for (i = users.begin(); i != users.end(); i++){
        users_str << "\"" << i->get_username() << "\"";
        j++;
        if (j < number_of_users){
            users_str << ", ";
        }
    }
    users_str << "]";

    return Response(200, users_str.str());
}