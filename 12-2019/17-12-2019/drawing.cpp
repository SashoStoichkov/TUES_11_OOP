#include <iostream>
#include <list>

using namespace std;

class Point{
    protected:
        int x;
        int y;

    public:
        Point(){};

        Point(int x, int y) : x(x), y(y){};

        void print() const{
            cout << "(" << x << ", " << y << ")";
        }
};

class Shape{
    public:
        virtual void draw() const=0;
};

class Circle : public Shape{
    protected:
        Point center;
        int radius;

    public:
        Circle(const Point& center, int radius) : center(center), radius(radius){};

        void draw() const{
            cout << "Circle(";
            center.print();
            cout << ", " << radius << ")" << endl;
        }
};

class Rectangle : public Shape{
    protected:
        Point ul;
        Point br;

    public:
        Rectangle(const Point& ul, const Point& br) : ul(ul), br(br){};

        void draw() const{
            cout << "Rectangle(";
            ul.print();
            cout << ", ";
            br.print();
            cout << ")" << endl;
        }
};

void drawAll(list<Shape*>& l){
    for (list<Shape*>::iterator it = l.begin(); it != l.end(); it++){
        (*it)->draw();
    }
}

int main(){

    list<Shape*> shapes;

    Point center = Point(1, 2);
    Point ul = Point(3, 4);
    Point br = Point(5, 6);

    Circle c = Circle(center, 5);
    Rectangle r = Rectangle(ul, br);

    shapes.push_back(&c);
    shapes.push_back(&r);

    drawAll(shapes);

    return 0;
}