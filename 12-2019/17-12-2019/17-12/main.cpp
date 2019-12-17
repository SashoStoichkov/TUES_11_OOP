#include "employee.h"
#include "manager.h"

#include <vector>
using namespace std;

void printAll(vector<Employee*>& v){
    for (vector<Employee*>::iterator it = v.begin(); it != v.end(); it++){
        (*it)->print();
    }
}

int main(){
    vector<Employee*> employees;

    Employee e1 = Employee("Gosho", 15665341568);
    Manager m1 = Manager("Pesho", 16686431652, 10);

    employees.push_back(&e1);
    employees.push_back(&m1);

    printAll(employees);

    return 0;
}