#include <stdlib.h>
#include <iostream>
using namespace std;

class Vector{
    int *items;
    public:
        int count;

        Vector(){
            count = 0;
            items = NULL;
        }

        void push(int new_item){
            items = (int *) realloc (items, (sizeof(int)*(++count)));
            items[count-1] = new_item;
        }

        int is_empty(){
            if (count <= 0) return 1;
            else return 0;
        }

        int pop(int *popped_item){
            if (is_empty()) return 0;

            *popped_item = items[--count];
            return 1;
        }
};

int main(){
    Vector v1 = Vector();

    cout << v1.count << endl;

    return 0;
}