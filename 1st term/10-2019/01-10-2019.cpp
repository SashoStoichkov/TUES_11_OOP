// #include <iostream>
// using namespace std;

// class DivisionByZero{};
// class TerminateException{};

// double division(int a, int b){
//     if (b == 0){
//         throw DivisionByZero();
//     } else if (a == 6798) {
//         throw TerminateException();
//     } else {
//         return a/b;
//     }
// }

// int main(){
//     int a, b;

//     while (true){
//         cout << "Value of a: "; cin >> a;
//         cout << "Value of b: "; cin >> b;

//         double result;

//         try {
//             result = division(a, b);
//         } catch(DivisionByZero exc) {
//             cout << "Can't divide by zero!" << endl;
//             continue;
//         } catch(TerminateException exc) {
//             cout << "Terminate requested!" << endl;
//             return -1;
//         }

//         cout << "Result: " << result << endl;
//     }

//     return 0;
// }

// --------------- stack --------------- //

#include <iostream>
#include <string> // NEW STUFF
using namespace std;
int const STACK_SIZE = 10;

class StackException{
    string message;

    public:
        StackException(string message){
            this->message = message;
        }

        string what(){
            return message;
        }
};

class Stack {
    int data[STACK_SIZE];
    int top;

    public:
        Stack(){
            top = 0;
        }

        void push(int value){
            if (!isFull()){
                data[top++] = value;
            } else {
                throw StackException("Stack is FULL!");
            }
        }

        int pop(){
            if (isEmpty()){
                throw StackException("Stack is EMPTY!");
            } else {
                return data[--top];
            }
        }

        bool isFull(){
            return top == STACK_SIZE;
        }

        bool isEmpty(){
            return top == 0;
        }
};

int main(){
    Stack s;

    try {
        s.pop();
        for (int i = 0; i < 12; i++){
            s.push(i);
        }
    } catch (StackException exc){
        cout << exc.what() << endl;
    }

}