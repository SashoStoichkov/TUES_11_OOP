#include <iostream>
using namespace std;

// class Stack{
//     static const int chunk = 2;
//     int size, top;
//     int* data;

//     public:
//         Stack(){
//             size = chunk;
//             data = new int[size];
//             top = -1;
//         }

//         void push(int v){
//             if (top >= (size - 1)){
//                 resize();
//             }

//             data[++top] = v;
//         }

//         int pop(){
//             if (top < 0){
//                 throw exception();
//             }

//             return data[top--];
//         }

//     private:
//         void resize(){
//             cout << "Resize stack" << endl;
//             int* temp = data;
//             data = new int[size + chunk];

//             for (int i = 0; i < size; i++){
//                 data[i] = temp[i];
//             }

//             size += chunk;
//             delete temp;
//             cout << "Size now: " << size << endl;
//         }
// };

class Point{
    int x, y;

    public:
        Point(int x, int y){
            this->x = x;
            this->y = y;
        }

        Point(const Point& p){
            x = p.x;
            y = p.y;
        }

        void set_x(int x){
            this->x = x;
        }

        void set_y(int y){
            this->y = y;
        }

        int get_x() const{
            return x;
        }

        int get_y() const{
            return y;
        }

        Point& operator=(const Point& p){
            x = p.x;
            y = p.y;
            return *this;
        }

        ~Point(){
            x = 0;
            y = 0;
            // free dynam memory
        }
};

void printPoint(const Point& p){
    cout << "Point(" << p.get_x() << ", " << p.get_y() << ")" << endl;
}

int main(){

    // ---------- stack ------------
    // Stack s;

    // s.push(1);
    // s.push(2);
    // s.push(3);
    // s.push(4);

    // try {
    //     cout << s.pop() << endl;
    //     cout << s.pop() << endl;
    //     cout << s.pop() << endl;
    //     cout << s.pop() << endl;
    //     cout << s.pop() << endl;
    // } catch (const exception exc){
    //     cout << "Exception while poping" << endl;
    // }

    // ------------- point -----------
    Point p1 = Point(1, 2);
    Point p2 = Point(p1);

    printPoint(p1);
    printPoint(p2);

    Point p3 = p2;

    printPoint(p3);

    return 0;
}