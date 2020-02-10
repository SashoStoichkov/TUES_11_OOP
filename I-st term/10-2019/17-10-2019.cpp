#include <iostream>
using namespace std;

#include <string>
#include <list>

#include <sstream>

class Point{
    float x;
    float y;

    public:
        Point(float x, float y){
            Point::x = x;
            Point::y = y;
        }

        string toString(){
            ostringstream s;

            s << "(" << x << ", " << y << ")" << endl;

            return s.str();
        }

        float getX(){
            return x;
        }

        float getY(){
            return y;
        }
};

class Points{
    list<Point> points;

    public:
        void readPoints(string input){
            istringstream in(input);

            float x; float y;

            in.ignore(1);
            in >> x;

            in.ignore(2);
            in >> y;

            points.push_back(Point(x, y));

            cout << Point(x, y).toString() << endl;
        }

        Point calculateAverage(){
            list<Point>::iterator i;

            float avg_x = 0; float avg_y = 0;

            for (i = points.begin(); i != points.end(); i++){
                avg_x += i->getX();
                avg_y += i->getY();
            }

            cout << avg_x << " " << avg_y << endl;

            avg_x /= points.size();
            avg_y /= points.size();

            return Point(avg_x, avg_y);
        }
};

int main(){

    Points points = Points();
    string input;

    while (!cin.eof()){
        getline(cin, input);
        points.readPoints(input);
    }

    Point avg_point = points.calculateAverage();
    cout << "Average point: " << avg_point.toString() << endl;

    return 0;
} 