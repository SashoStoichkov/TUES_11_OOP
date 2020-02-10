#include <iostream>
using namespace std;

#include "pair.cpp"
#include "hashMap.cpp"

int main(){
    Pair<string, int> p1 = Pair<string, int>("test", 15);
    Pair<string, int> p2 = Pair<string, int>("asd", 60);
    Pair<string, int> p3 = Pair<string, int>("best", 35);

    HashMap<string, int> h_map = HashMap<string, int>();

    h_map.addPair(p2);
    h_map.addPair(p1);
    h_map.addPair(p3);
    // h_map.addPair(p3);

    list<Pair<string, int>> pairs = h_map.getHashMap();

    for (auto pair : pairs){
        cout << pair.getPairKey() << " " << pair.getPairValue() << endl;
    }

    cout << endl;

    list<Pair<string, int>> sorted_pairs = h_map.sortHashMapBy("value");

    for (auto pair : sorted_pairs){
        cout << pair.getPairKey() << " " << pair.getPairValue() << endl;
    }

    return 0;
}