#include <iostream>
using namespace std;

#include <string>
#include <list>

#include <sstream>

class FlightAlreadyInListException : exception {};

class FlightNotInListException : exception {};

class Flight{
    public:
        string flight_number;
        string flight_date;
        string flight_hour;
        bool is_cancelled;

        Flight(string flight_number, string flight_date, string flight_hour){
            Flight::flight_number = flight_number;
            Flight::flight_date = flight_date;
            Flight::flight_hour = flight_hour;
        }
};

bool flightsAreEqual(Flight f1, Flight f2){
    if ((f1.flight_number == f2.flight_number) &&
        (f1.flight_date == f2.flight_date) &&
        (f1.flight_hour == f2.flight_hour)){
        return true;
    } else {
        return false;
    }
}

class FlightSchedule{
    list<Flight> flights;

    public:
        FlightSchedule(){};

        FlightSchedule(list<Flight> flights){
            FlightSchedule::flights = flights;
        }

        list<Flight> getFlights(){
            return flights;
        }

        void addFlight(Flight newFlight){
            list<Flight>::iterator i;

            for (i = flights.begin(); i != flights.end(); i++){
                if (flightsAreEqual(*i, newFlight)){
                    throw FlightAlreadyInListException();
                }
            }

            flights.push_back(newFlight);
        }

        void setCancelled(Flight toCancel){
            list<Flight>::iterator i;

            for (i = flights.begin(); i != flights.end(); i++){
                if (flightsAreEqual(*i, toCancel) == 0){
                    throw FlightNotInListException();
                } else {
                    i->is_cancelled = true;
                }
            }

            // toCancel.is_cancelled = true;
        }

        list<Flight> findForDate(string date){
            list<Flight> result_flights;
            list<Flight>::iterator i;

            for (i = flights.begin(); i != flights.end(); i++){
                if (i->flight_date == date){
                    result_flights.push_back(*i);
                }
            }

            return result_flights;
        }

        string toString(){
            ostringstream result;
            list<Flight>::iterator i;

            for (i = flights.begin(); i != flights.end(); i++){
                result << i->flight_number << " " << i->flight_date << " " << i->flight_hour << " " << i->is_cancelled << endl;
            }

            return result.str();
        }

        void fromString(string flights){
            istringstream in(flights);

            string flight_num, flight_hour, flight_date;

            while (!in.eof()){
                in >> flight_num;
                in >> flight_date;
                in >> flight_hour;

                flight_hour.pop_back();

                Flight new_flight = Flight(flight_num, flight_date, flight_hour);

                addFlight(new_flight);
            }
        }
};

int main(){

    FlightSchedule s = FlightSchedule();

    string input; getline(cin, input);

    s.fromString(input);

    cout << endl << "Flights:" << endl;
    cout << s.toString();

    try {
        s.addFlight(Flight("Qwerty", "123", "456"));
    } catch (FlightAlreadyInListException exc){
        cout << endl << "Flight Already In List!" << endl;
    }

    try {
        s.setCancelled(Flight("Qwerty", "123", "456"));
    } catch (FlightNotInListException exc){
        cout << endl << "Flight Not In List!" << endl;
    }


    cout << endl << "Flights:" << endl;
    cout << s.toString();

    return 0;
}