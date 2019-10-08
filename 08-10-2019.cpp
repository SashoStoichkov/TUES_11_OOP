#include <iostream>
using namespace std;

// -------- namespaces -------
namespace firstSpace{
    void say_hello(){
        cout << "Hello from the first namespace" << endl;
    }

    namespace innerSpace{
        void say_hello(){
            cout << "Hello from the inner namespace" << endl;
        }
    }
}

namespace secondSpace{
    void say_hello(){
        cout << "Hello from the second namespace" << endl;
    }
}

// ------ string ------
#include <string>

// ------- stack --------
#include <stack>

// ------- vector --------
#include <vector>

void print_vector(vector<int> v){
    for (long unsigned int i = 0; i < v.size(); i++){
        cout << v[i] << " ";
    }

    cout << endl;
}

// -------- list ----------
#include <list>

void print_list(list<int> l){
    list<int>::iterator i;

    for (i = l.begin(); i != l.end(); i++){
        cout << *i << " ";
    }

    cout << endl;
}

int main(){

    // ----- namespaces ------
    firstSpace::say_hello();
    firstSpace::innerSpace::say_hello();
    secondSpace::say_hello();

    // ------ string -------
    string firstName;
    string lastName;

    cout << "Enter first name: "; getline(cin, firstName);
    cout << "Enter last name: "; getline(cin, lastName);

    cout << "Full name: " << firstName << " " << lastName << endl;

    cout << "Size of first name: " << firstName.length() << endl;
    cout << "Capacity of first name: " << firstName.capacity() << endl;

    string fullName;
    cout << "Enter full name: "; getline(cin, fullName);

    fullName[2] = 'Q';

    cout << "Full name: " << fullName << endl;

    // ------- stack -------
    stack<int> s;

    cout << "Empty: " << s.empty() << endl;

    for (int i = 0; i < 10; i++){
        s.push(i);
    }

    cout << "Size: " << s.size() << endl;

    s.pop();
    cout << "Size: " << s.size() << endl;

    cout << "Top element: " << s.top() << endl;

    if (!s.empty()){
        cout << "Stack is not empty" << endl;
    }

    cout << "Empty: " << s.empty() << endl;

    // ------ vector -------
    vector<int> v;

    for (int i = 0; i < 10; i++){
        v.push_back(i);
    }

    cout << "Size: " << v.size() << endl;
    cout << "Capacity: " << v.capacity() << endl;

    v.pop_back();

    print_vector(v);

    // -------- list ---------
    list<int> l;

    for (int i = 0; i < 10; i++){
        l.push_back(i);
    }

    print_list(l);

    return 0;
}