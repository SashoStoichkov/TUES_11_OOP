#include <iostream>
using namespace std;

#include "race.h"
#include "racer.h"

int main(){
    Racer r1 = Racer("Pesho", 0, 2);
    Racer r2 = Racer("Gosho", 0, 3);

    Race race1 = Race(15, 0);
    race1.add_racer(r1);
    race1.add_racer(r2);

    race1.print_map();

    return 0;
}