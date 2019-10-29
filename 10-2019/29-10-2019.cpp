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

    static int count;

    public:
        Point(double x, double y){
            this->x = x;
            this->y = y;
            count++;
        }

        Point(double x, double y, const char name) : name(name){
            this->x = x;
            this->y = y;
            count++;
        }

        double get_x() const {
            return x;
        }

        Point& set_x(double x){
            this->x = x;
            return *this;
        }

        double get_y() const ;

        Point& set_y(double y);

        void print() const {
            cout << name << " -> X: " << x << ", Y: " << y << endl;
        }

        static int get_count(){
            return count;
        }

};

double Point::get_y() const {
    return y;
}

Point& Point::set_y(double y){
    this->y = y;
    return *this;
}

void change(Point a, Point& b){
    a.set_x(8);
    b.set_x(9);
}

int Point::count = 0;

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
    // a.print();

    Point b = Point(3, 4, 'B');
    // cout << b.get_x() << endl;
    // b.print();

    change(a, b);
    a.print();
    b.print();

    cout << Point::get_count() << endl;

    Point c = Point(3, 5, 'C');
    c.set_x(10).set_y(15);
    c.print();

    return 0;
}