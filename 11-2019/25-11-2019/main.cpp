#include <iostream>

#include "lion.h"
#include "whale.h"
#include "salmon.h"
#include "flying_fish.h"
#include "seagull.h"
#include "ostrich.h"

int main(){
    FlyingFish my_fish = FlyingFish();

    my_fish.run_away();
    my_fish.fly();

    return 0;
}