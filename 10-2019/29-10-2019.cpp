#include <iostream>
using namespace std;

class Point{

    class Line{
        int len;

        public:
            Line(int len){
                this->len = len;
            }

            int get_len(){
                return len;
            }
    };

    double x;
    double y;
    const char name = 'A';

    public:
        Point(double x, double y){
            this->x = x;
            this->y = y;
        }

        Point(double x, double y, const char name) : name(name){
            this->x = x;
            this->y = y;
        }

        double get_x() const {
            return x;
        }

        void set_x(double x){
            this->x = x;
        }

        double get_y() const ;

        void set_y(double y);

        void print() const {
            cout << name << " " << "X: " << x << ", Y: " << y << endl;
        }

};

double Point::get_y() const {
    return y;
}

void Point::set_y(double y){
    this->y = y;
}

void change(Point a, Point& b){
    a.set_x(8);
    b.set_x(9);
}

int main(){
    // // ----- constants
    // const int i = 5;
    // // i = 3; ERROR

    // char str1[] = "Hello";
    // char str2[] = "Alo";

    // const char* p1 = str1;
    // p1 = str2;
    // // p1[2] = 'A'; ERROR

    // char* const p2 = str1;
    // // p2 = str2; ERROR
    // p2[2] = 'A';

    // const char* const p3 = str1;
    // // p3 = str2;
    // // p3[2] = 'A';
    // cout << p3 << endl;

    // // ------ references
    // int a = 2;
    // int& ra = a;

    // cout << ra << endl;
    // ra = 3;
    // cout << a << endl;

    // const int& cra = a;
    // cout << cra << endl;
    // // cra = 5; ERROR

    // int b = 10;
    // int& rb = a;
    // rb = b;
    // cout << a << endl;

    Point a = Point(2, 3, 'A');
    a.print();

    Point b = Point(3, 4, 'B');
    // cout << b.get_x() << endl;
    b.print();

    change(a, b);
    a.print();
    b.print();

    return 0;
}