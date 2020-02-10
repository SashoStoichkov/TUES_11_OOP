#include "plane.h"

Plane::Plane(int size, std::string flight_number, std::string plane_model, bool is_civilian, bool is_military, float speed, float fuel_amount, float expense_for_kilometer, float position_x) : 
    size(size), flight_number(flight_number), plane_model(plane_model), is_civilian(is_civilian), is_military(is_military), speed(speed), fuel_amount(fuel_amount), expense_for_kilometer(expense_for_kilometer), position_x(position_x){};

Plane::Plane(const Plane& plane){
    this->size = plane.size;
    this->flight_number = plane.flight_number;
    this->plane_model = plane.plane_model;
    this->is_civilian = plane.is_civilian;
    this->is_military = plane.is_military;
    this->speed = plane.speed;
    this->fuel_amount = plane.fuel_amount;
    this->expense_for_kilometer = plane.expense_for_kilometer;
    this->position_x = plane.position_x;
}