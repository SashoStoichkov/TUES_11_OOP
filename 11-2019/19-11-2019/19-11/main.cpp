#include "employee.h"
#include "manager.h"

int main(){
    Employee e1 = Employee("Ivan", 1);
    Manager m1 = Manager("Pesho", 2, 10);

    e1.print();
    m1.print();
}