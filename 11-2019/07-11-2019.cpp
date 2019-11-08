#include <iostream>
#include <algorithm>
using namespace std;


class Rect{
    int x, y, w, h;

    public:
        Rect(){};

        Rect(int x, int y, int w, int h){
            this->x = x;
            this->y = y;
            this->w = w;
            this->h = h;
        }

        Rect operator+(int num){
            return Rect(x+num, y+num, w+num, h+num);
        }

        Rect operator+(Rect r){
            return Rect(min(x, r.x), min(y, r.h),
                        (max((x + w), (r.x + r.w)) - min(x, r.x)),
                        (max((y + h), (r.y + r.h)) - min(y, r.h)));
        }

        Rect& operator+=(int num){
            this->x += num; this->y += num;
            this->w += num; this->h += num;
            return *this;
        }

        Rect& operator+=(Rect r){
            this->x = min(x, r.x); this->y = min(y, r.h);
            this->w = max((x + w), (r.x + r.w)) - min(x, r.x);
            this->h = max((y + h), (r.y + r.h)) - min(y, r.h);
            return *this;
        }

        Rect& operator++(){
            this->x++; this->y++;
            this->w++; this->h++;
            return *this;
        }

        Rect& operator++(int){
            this->x++; this->y++;
            this->w++; this->h++;
            return *this;
        }

        void printRect(){
            cout << "x = " << x << ", y = " << y << ", w = " << w << ", h = " << h << ";" << endl;
        }
};

int main(){

    Rect r1 = Rect(1, 2, 3, 4);
    Rect r2 = r1 + 5;
    Rect r3 = r1 + r2;

    r1.printRect();
    r2.printRect();
    r2++;
    r2.printRect();
    r3.printRect();

    return 0;
}