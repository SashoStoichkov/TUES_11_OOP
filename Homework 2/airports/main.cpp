#include <iostream>
using namespace std;

#include "plane.h"

int main(){

    Plane p1 = Plane(10, "ASD12", "B737", true, false, 15.5, 100, 12.6, 45.6);
    // p1.operator<<;
    Plane p2 = Plane(p1);

    return 0;
}