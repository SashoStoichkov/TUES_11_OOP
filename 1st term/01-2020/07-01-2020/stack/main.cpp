#include <iostream>

#include "stack.cpp"

int main(){
    Stack<int> intStack;

    for (int i = 0; i < 10; i++){
        intStack.push(i);
    }

    for (int i = 0; i < 10; i++){
        std::cout << intStack.pop() << std::endl;
    }

    return 0;
}