#include <stdlib.h>
#include <iostream>
using namespace std;

class VectorPopException : exception {};

class VectorPushException : exception {};

class VectorPushMaxedException : exception {};

class Vector{
    int *items;
    int max_count_el;
    int maxed_el;
    
    public:
        int count;

        Vector(){
            max_count_el = 10;
            maxed_el = 1000;

            count = 0;
            items = NULL;
        }

        Vector(int max_count, int maxed){
            max_count_el = max_count;
            maxed_el = maxed;

            count = 0;
            items = NULL;
        }

        void push(int new_item){
            if (count == max_count_el){
                throw VectorPushException();
            } else if (new_item > maxed_el){
                throw VectorPushMaxedException();
            }

            items = (int *) realloc (items, (sizeof(int)*(++count)));
            items[count-1] = new_item;
        }

        int is_empty(){
            if (count <= 0) return 1;
            else return 0;
        }

        int pop(){
            if (is_empty()) throw VectorPopException();

            return items[--count];
        }
};

int main(){
    Vector v1(12, 11);
    Vector v2;

    try {
        for (int i = 0; ; i++){
            v2.push(i+1);
            v1.push(i+1);
        }
    } catch (VectorPushException exc){
        cout << "No more space" << endl;
    } catch (VectorPushMaxedException exc){
        cout << "Maximum el is 11" << endl;
    }

    cout << v1.count << endl;

    try {
        int popped_item;
        
        while (1){
            popped_item = v1.pop();
            printf("Popped item: %d\n", popped_item);
        }
    } catch (VectorPopException exc){
        cout << "KAPUT WITH STYLE!!!" << endl;
    } catch (exception exc){
        cout << "KAPUT!!!" << endl;
    }
}