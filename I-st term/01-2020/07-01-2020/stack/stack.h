#ifndef STACK_H
#define STACK_H

template<class T>
class Stack{
    protected:
        static const unsigned int chunk = 2;
        int size;
        T* data;
        int top;
    public:
        Stack();
        Stack(const Stack& other);
        ~Stack();
        Stack& operator=(const Stack& other);
        void push(const T& value);
        T pop();
    private:
        void resize();
};

#endif