#include <iostream>
using namespace std;

#include <string>
#include <list>

#include <sstream>

class Contestant{
    string name;
    double speed;
    double covered_distance = 0;

    public:
        Contestant(){}

        Contestant(string name, double speed){
            Contestant::name = name;
            Contestant::speed = speed;
        }

        string getName(){
            return name;
        }

        double getSpeed(){
            return speed;
        }

        double getDistance(){
            return covered_distance;
        }

        void calcDistance(int iteration_count){
            covered_distance = speed * iteration_count;
        }
};

class Race{
    list<Contestant> contestants;

    public:
        Race(){}

        Race(list<Contestant> contestants){
            Race::contestants = contestants;
        }

        list<Contestant> getContestants(){
            return contestants;
        }

        void addContestant(Contestant new_contestant){
            contestants.push_back(new_contestant);
        }

        void resetContestants(){
            list<Contestant>::iterator i;

            for (i = contestants.begin(); i != contestants.end(); i++){
                i->calcDistance(0);
            }
        }

        void simulateRace(int iteration_count){
            list<Contestant>::iterator i;

            resetContestants();
            cout << "*** Standings before race ***" << endl;
            cout << getContestantStanding() << endl;

            for (i = contestants.begin(); i != contestants.end(); i++){
                i->calcDistance(iteration_count);
            }

            // sort ???????

            cout << "*** Standings after race ***" << endl;
            cout << getContestantStanding() << endl;
        }

        string getContestantStanding(){
            ostringstream s;

            list<Contestant>::iterator i;
            for (i = contestants.begin(); i != contestants.end(); i++){
                s << "< " << i->getName() << " >: < " << i->getDistance() << " >(< " << i->getSpeed() << " >)" << endl;
            }

            return s.str();
        }
};

int main(){

    Contestant c1 = Contestant("Pesho", 10);
    Contestant c2 = Contestant("Gosho", 20);
    Contestant c3 = Contestant("Tosho", 15);

    Race r1 = Race({c1, c2, c3});

    r1.simulateRace(5);

    return 0;
}