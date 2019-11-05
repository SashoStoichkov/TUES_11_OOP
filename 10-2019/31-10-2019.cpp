#include <iostream>
using namespace std;

#include <list>
#include <string>

class Animal{
    protected:
        int age;
        const string name;

    public:
        Animal(int age, string name) : name(name){
            this->age = age;
        }
};

class Dog : public Animal{
    public:
        Dog(int age, string name) : Animal(age, name){}

        const string getName(){
            return name;
        }

        int getAge(){
            return age;
        }
};

class Cat : public Animal{

    public:
        Cat(int age, string name) : Animal(age, name){}

        const string getName(){
            return name;
        }

        int getAge(){
            return age;
        }
};

class Shelter{
    Shelter(){};

    public:
        static list<Dog> dogs;
        static list<Cat> cats;

        static void addAnimal(string kind, string name, short age){
            if (kind == "dog"){
                dogs.push_back(Dog(age, name));
            } else {
                cats.push_back(Cat(age, name));
            }
        }

        static void print_collection(string kind){
            if (kind == "dogs"){
                static list<Dog>::iterator i;

                cout << "Dogs:" << endl;

                for (i = dogs.begin(); i != dogs.end(); i++){
                    cout << i->getName() << " " << i->getAge() << endl;
                }
            } else {
                static list<Cat>::iterator i;

                cout << "Cats:" << endl;

                for (i = cats.begin(); i != cats.end(); i++){
                    cout << i->getName() << " " << i->getAge() << endl;
                }
            }
        }

        static void print_shelter(){
            print_collection("dogs");
            print_collection("cats");
        }

        static Animal& findAnimal(string kind, string name, short age){
            if (kind == "dog"){
                static list<Dog>::iterator i;

                for (i = dogs.begin(); i != dogs.end(); i++){
                    if (i->getAge() == age && i->getName() == name){
                        Dog& d = *i;
                        return d;
                    }
                }
            }

            static list<Cat>::iterator i;

            for (i = cats.begin(); i != cats.end(); i++){
                if (i->getAge() == age && i->getName() == name){
                    Cat& c = *i;
                    return c;
                }
            }
        }
};

list<Dog> Shelter::dogs;
list<Cat> Shelter::cats;

int main(){

    Shelter::addAnimal("dog", "Pesho", 12);
    Shelter::addAnimal("cat", "Gosho", 2);

    Shelter::print_shelter();

    Dog d = Shelter::findAnimal("dog", "Pesho", 12);

    return 0;
}