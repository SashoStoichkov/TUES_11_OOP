#include <iostream>
using namespace std;

class Fibonacci{
    int number_1;
    int number_2;
    
    int size = 2;
    int *numbers;

    void create_fib_sequence(int size){
        numbers = new int[size];
        numbers[0] = 0;
        numbers[1] = 1;

        for (int i = 2; i < size; i++){
            numbers[i] = numbers[i-2] + numbers[i-1];
        }
    }

    public:
        Fibonacci(){
            size = 2;
            numbers = new int[size];

            numbers[0] = 0;
            numbers[1] = 1;
        }

        Fibonacci(int size){
            this->size = size;
            create_fib_sequence(size);
        }

        Fibonacci(const Fibonacci& fib){
            size = fib.get_size();
            numbers = new int[size];

            for (int i = 0; i < size; i++){
                numbers[i] = fib.numbers[i];
            }
        }

        Fibonacci& operator=(const Fibonacci& fib){
            size = fib.get_size();
            numbers = new int[size];

            for (int i = 0; i < size; i++){
                numbers[i] = fib.numbers[i];
            }

            return *this;
        }

        Fibonacci(int size, int number_1, int number_2){
            this->size = size;
            numbers = new int[size];

            numbers[0] = number_1;
            numbers[1] = number_2;
        }

        int get_size() const{
            return size;
        }

        void print_fibonacci_sequence(){
            for (int i = 0; i < size; i++){
                cout << numbers[i] << " ";
            }

            cout << endl;
        }
};

int main(){

    Fibonacci f1 = Fibonacci(5);
    f1.print_fibonacci_sequence();

    Fibonacci f2 = Fibonacci(f1);
    f2.print_fibonacci_sequence();

    Fibonacci f3 = f2;
    f3.print_fibonacci_sequence();

    return 0;
}