#include <iostream>
using namespace std;

class Point{
    double x;
    double y;

    public:
        Point(){};

        Point(double x, double y){
            this->x = x;
            this->y = y;
        }

        double get_x() const{
            return x;
        }

        void set_x(double x){
            this->x = x;
        }

        double get_y() const{
            return y;
        }

        void set_y(double y){
            this->y = y;
        }

        Point& add(const Point p){
            x += p.get_x();
            y += p.get_y();
            return *this;
        }

        Point& sub(const Point p){
            x -= p.get_x();
            y -= p.get_y();
            return *this;
        }

        Point& mul(int alpha){
            x *= alpha;
            y *= alpha;
            return *this;
        }

        Point operator+(const Point p){
            return Point(x + p.get_x(), y + p.get_y());
        }

        Point operator*(int alpha){
            return Point(x * alpha, y * alpha);
        }

        Point& operator+=(const Point p){
            x += p.get_x();
            y += p.get_y();
            return *this;
        }

        void operator()(double a){
            x += a;
            y += a;
        }
};

ostream& operator<<(ostream& out, const Point p){
    out << "point(" << p.get_x() << ", " << p.get_y() << ")" << endl;
    return out;
}

Point operator-(const Point p1, const Point p2){
    return Point(p1.get_x() - p2.get_x(), p1.get_y() - p2.get_y());
}

Point operator-(const Point p){
    return Point(-p.get_x(), -p.get_y());
}

void printPoint(const Point p){
    cout << "point(" << p.get_x() << ", " << p.get_y() << ")" << endl;
}

int main(){

    Point p1 = Point(1, 2);
    Point p2 = Point(2, 3);

    p1.add(p2).sub(p2).mul(2);
    printPoint(p1);

    Point p3 = Point(3, 4);
    Point p4 = p2 + p3;
    printPoint(p4);

    Point p5 = p4 - p3;
    printPoint(p5);

    Point p6 = -p5;
    printPoint(p6);

    Point p7 = Point(1, 2);
    Point p8 = p7 * 2;
    printPoint(p8);

    p7 += p8 += p6 += p5;
    printPoint(p7);

    p8(6);
    printPoint(p8);
    cout << p8;

    return 0;
}