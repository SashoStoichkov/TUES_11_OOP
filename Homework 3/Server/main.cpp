// Демонстрация

#include <iostream>
using namespace std;

#include "server.h"
#include "router.h"

int main(){
    User u1 = User("Pesho", "qwerty");
    User u2 = User("Gosho", "qwertyasd123");

    Server s1 = Server({"/login.html", "/home.html", "/api/login", "/api/get_users"}, {u1, u2});

    std::list<User>::iterator i;

    for (i = s1.users.begin(); i != s1.users.end(); i++){
        cout << i->get_username() << " " << i->get_password() << endl;
    }

    cout << endl;

    Request r1 = Request("localhost", "/login.html");
    Request r2 = Request("localhost", "/home.html");

    Request r3 = Request("localhost", "/api/login");
    r3.set_username_and_password("Pesho", "qwerty");

    Request r4 = Request("localhost", "/api/login");
    r4.set_username_and_password("Pesh", "qwerty");

    Request r5 = Request("localhost", "/api/get_users");

    Router route1 = Router();

    Response res1 = route1.routeRequest(r1, s1);
    res1.print_response();

    cout << endl;

    Response res2 = route1.routeRequest(r2, s1);
    res2.print_response();

    cout << endl;

    Response res3 = route1.routeRequest(r3, s1);
    res3.print_response();

    cout << endl;

    Response res4 = route1.routeRequest(r4, s1);
    res4.print_response();

    cout << endl;

    Response res5 = route1.routeRequest(r5, s1);
    res5.print_response();

    return 0;
}