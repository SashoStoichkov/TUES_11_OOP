#include <iostream>
using namespace std;

#include "factory.h"

#include "materialGood.h"
#include "timeGood.h"

int main(){
    MaterialGood m1 = MaterialGood("Water", "l", 10);
    TimeGood t1 = TimeGood(120);

    MaterialGood m2 = MaterialGood("Milk", "l", 20);
    TimeGood t2 = TimeGood(60);

    Step s1 = Step(1, "Add water", {m1, t1}, 100, 120);

    Process p1 = Process({s1});

    Factory f1 = Factory("Pesho", p1);

    f1.add_step({m2, t2}, "Add milk", 60, 100);
    std::pair<std::list<Good>, int> pair = f1.total_goods_and_time();
    int total_efficiency = f1.return_efficency();

    return 0;
}