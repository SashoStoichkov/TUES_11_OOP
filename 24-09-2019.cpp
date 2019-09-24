#include <iostream>
#include <cmath>
using namespace std;

class Point {
    private:
        int x;
        int y;

    public:
        Point (int x, int y){
            this->x = x;
            this->y = y;
        }

        int getX(){
            return x;
        };

        int getY(){
            return y;
        };

        void setX(int x);

        double dist(Point b){
            int dx = getX() - b.getX();
            int dy = getY() - b.getY();
            return sqrt(dx ^ 2 + dy ^ 2);
        }
};

void Point::setX(int x){
    this->x = x;
    // Point::x = x;
}

int main(){
    // cout << "Enter a: ";
    // int a;
    // cin >> a;
    // cout << "a = " << a << endl;

    // Point p = Point(4, 5);
    // Point* p_ = &p;
    // p.setX(9);
    // cout << "x = " << p.getX() << endl;

    Point a = Point(2, 3);
    Point b = Point(4, 5);
    cout << "Distance = " << a.dist(b) << endl; 

}