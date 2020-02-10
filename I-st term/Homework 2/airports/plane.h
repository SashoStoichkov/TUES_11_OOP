#ifndef PLANE_H
#define PLANE_H

#include <iostream>
#include <string>
using namespace std;

class Plane{
    protected:
        int size;

        std::string flight_number;
        std::string plane_model;
        bool is_civilian;
        bool is_military;

        float speed;
        float fuel_amount;
        float expense_for_kilometer;

        float position_x;

    public:
        Plane(){};

        Plane(int size, std::string flight_number, std::string plane_model, bool is_civilian, bool is_military, float speed, float fuel_amount, float expense_for_kilometer, float position_x);

        Plane(const Plane& plane);

        // Plane& operator<<(const Plane& plane){
        //     std::cout << plane.size << " " << plane.flight_number << " " << plane.plane_model << " " << plane.is_civilian << " " << plane.is_military << " " << plane.speed << " " << plane.fuel_amount << " " << plane.expense_for_kilometer << " " << plane.position_x << std::endl;
        // }
};

#endif