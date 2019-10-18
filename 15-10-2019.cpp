#include <iostream>
using namespace std;

#include <sstream>
#include <string>

#include <fstream>

int main(){
    // input stream
    string data = "3.14159265 2ke";

    istringstream in(data);

    double pi;
    in >> pi;

    if (in.good()){
        cout << "Everyting is OK!" << endl;
        cout << "pi = " << pi << endl;
    } else {
        cout << "Something went wrong!" << endl;
    }

    int num;
    in >> num;

    if (in.good()){
        cout << "Everyting is OK!" << endl;
        cout << "num = " << num << endl;
    } else {
        cout << "Something went wrong!" << endl;
    }

    string end = "not set";
    in >> end;

    if (!in.fail()){
        cout << "Everyting is OK!" << endl;
        cout << "End: " << end << endl;
    } else {
        cout << "Something went wrong!" << endl;
    }

    if (in.eof()){
        cout << "Reached the end!" << endl;
    }

    // output stream
    ostringstream out;

    out << "Pesho," << " " << "Gosho" << " " << "&" << " " << "Tosho";

    string data = out.str();

    cout << "Data: " << data << endl;

    // file stream
    // ofstream out;
    // out.open("pesho.txt");

    // string name;
    // cout << "Enter your name: "; getline(cin, name);

    // out << name << endl;

    // int age;
    // cout << "Enter your age: "; cin >> age;
    // getchar();

    // out << age << endl;

    // out.close();

    // ifstream in;
    // in.open("pesho.txt");

    // string iName;
    // getline(in, iName);
    // cout << "Name: " << iName << endl;

    // int iAge;
    // in >> iAge;
    // cout << "Age: " << iAge << endl;

    return 0;
}