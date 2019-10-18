#include <iostream>
using namespace std;

#include <string>
#include <list>

#include <sstream>

class MarksAreMoreThanTenException : exception {};

class MarkNotInRangeTwoToSixException : exception {};

class NameLessThanFiveCharsException : exception {};

class TooBigIndexException : exception {};

class StudentInfo{
    string name;
    list<double> marks;

    bool markNotInRangeTwoSix(list<double> marks){
        list<double>::iterator i;

        for (i = marks.begin(); i != marks.end(); i++){
            if (*i < 2 || *i > 6){
                return true;
            }
        }

        return false;
    }

    public:
        StudentInfo(){}

        StudentInfo(string name, list<double> marks){
            if (marks.size() > 10){
                throw MarksAreMoreThanTenException();
            } else if (markNotInRangeTwoSix(marks)){
                throw MarkNotInRangeTwoToSixException();
            } else if (name.length() < 5){
                throw NameLessThanFiveCharsException();
            } else {
                StudentInfo::name = name;
                StudentInfo::marks = marks;
            }
        }

        string getName(){
            return name;
        }

        list<double> getMarks(){
            return marks;
        }

        void addMark(double new_mark){
            if (new_mark < 2 || new_mark > 6){
                throw MarkNotInRangeTwoToSixException();
            } else if (marks.size() == 10){
                throw MarksAreMoreThanTenException();
            } else {
                marks.push_back(new_mark);
            }
        }

        double getAvarage(){
            double avg = 0;
            list<double>::iterator i;

            for (i = marks.begin(); i != marks.end(); i++){
                avg += *i;
            }

            return avg / marks.size();
        }

        string toString(){
            ostringstream s;

            s << "< " << name << " > ";

            list<double>::iterator i;

            for (i = marks.begin(); i != marks.end(); i++){
                s << "< " << *i << " > ";
            }

            s << "[ " << getAvarage() << " ]";

            return s.str();
        }

        void removeMarkAt(int index){
            if (index >= marks.size()){
                throw TooBigIndexException();
            } else {
                list<double>::iterator i = marks.begin();

                advance(i, index);

                marks.erase(i);
            }
        }

        void replaceMarkAt(int index, double new_mark){
            if (index >= marks.size()){
                throw TooBigIndexException();
            } else if (markNotInRangeTwoSix(marks)){
                throw MarkNotInRangeTwoToSixException();
            } else {
                list<double>::iterator i = marks.begin();

                advance(i, index);

                *i = new_mark;
            }
        }
};

int main(){

    StudentInfo s1 = StudentInfo();

    try {
        for (int i = 0; i < 10; i++)
            s1.addMark(6);

        cout << s1.toString() << endl;
    } catch (MarkNotInRangeTwoToSixException exc){
        cout << "Mark is not in range 2-6!" << endl;
    } catch (MarksAreMoreThanTenException exc){
        cout << "Marks are more than 10!" << endl;
    }

    try {
        StudentInfo s2 = StudentInfo("Pesho", {6, 4, 5, 6, 4, 2, 3});

        cout << s2.toString() << endl;
    } catch (NameLessThanFiveCharsException exc){
        cout << "Name is less than 5 chars!" << endl;
    } catch (MarkNotInRangeTwoToSixException exc){
        cout << "Mark is not in range 2-6!" << endl;
    } catch (MarksAreMoreThanTenException exc){
        cout << "Marks are more than 10!" << endl;
    }

    return 0;
}