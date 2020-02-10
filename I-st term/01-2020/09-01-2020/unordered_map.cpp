#include <iostream>
using namespace std;

#include <unordered_map>

int main(){
    unordered_map<string, int> umap;

    umap["asd"] = 10;
    umap["qwerty"] = 5;

    for (auto x : umap){
        cout << x.first << " " << x.second << endl;
    }

    return 0;
}