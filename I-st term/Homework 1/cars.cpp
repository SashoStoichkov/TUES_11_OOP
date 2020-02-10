#include <iostream>
using namespace std;

#include <string>
#include <list>

class LessThanFiveModelsException : exception {};

class OneModelWithNoNameException : exception {};

class DublicatedModelsException : exception {};

class LessThanFiveCharsInBrandException : exception {};

class NewModelWithNoNameException : exception {};

class NewModelAlreadyInListException : exception {};

class TooBigIndexException : exception {};

class CarCatalogue{
    string brand;
    list<string> models;

    bool anyModelHasNoName(list<string> models){
        list<string>::iterator i;

        for (i = models.begin(); i != models.end(); i++){
            string name = *i;
            if (name.length() == 0){
                return true;
            }
        }

        return false;
    }

    public:
        CarCatalogue(){}

        CarCatalogue(string brand, list<string> models){
            if (models.size() < 5){
                throw LessThanFiveModelsException();
            } else if (brand.length() < 5){
                throw LessThanFiveCharsInBrandException();
            } else if (anyModelHasNoName(models)){
                throw OneModelWithNoNameException();
            }

            CarCatalogue::brand = brand;
            CarCatalogue::models = models;
        }

        void setBrand(string brand){
            CarCatalogue::brand = brand;
        }

        string getBrand(){
            return brand;
        }

        list<string> getModels(){
            return models;
        }

        void addModel(string model_name){
            if (model_name.length() == 0){
                throw NewModelWithNoNameException();
            } else if (hasModel(model_name) == 1){
                throw NewModelAlreadyInListException();
            } else {
                models.push_back(model_name);
            }
        }

        int hasModel(string model_name){
            list<string>::iterator i;

            for (i = models.begin(); i != models.end(); i++){
                if (model_name == *i){
                    return 1;
                }
            }

            return 0;
        }

        void toString(){
            cout << "< " << brand << " >:" << endl;

            list<string>::iterator i;

            for (i = models.begin(); i != models.end(); i++){
                cout << "  " << "< " << *i << " >" << endl;
            }
        }

        void removeModelAt(int index){
            if (index >= models.size()){
                throw TooBigIndexException();
            } else {
                list<string>::iterator i = models.begin();

                advance(i, index);

                models.erase(i);
            }
        }

        void replaceModelAt(int index, string model_name){
            if (index >= models.size()){
                throw TooBigIndexException();
            } else if (model_name.length() == 0){
                throw NewModelWithNoNameException();
            } else if (hasModel(model_name) == 1){
                throw NewModelAlreadyInListException();
            } else {
                list<string>::iterator i = models.begin();

                advance(i, index);

                *i = model_name;
            }
        }
};

int main(){

    CarCatalogue c1 = CarCatalogue();

    c1.setBrand("Pesho");

    for (int i = 0; i < 2; i++){
        try {
            c1.addModel("Pesho1");
        } catch (NewModelAlreadyInListException exc){
            cout << "New model is already in list!" << endl;
        }
    }

    // list<string> models = c1.getModels();
    // list<string>::iterator i;
    // for (i = models.begin(); i != models.end(); i++){
    //     cout << *i << endl;
    // }

    // cout << c1.hasModel("Pesho") << endl;

    c1.toString();

    try {
        CarCatalogue c2 = CarCatalogue("Gosho", {"Gosho1", "Gosho2", "Gosho3", "", "Gosho5"});

        // cout << c2.hasModel("Gosho1") << endl;
        // cout << c2.getBrand() << endl;

        try {
            c2.addModel("Gosho6");
        } catch (NewModelWithNoNameException exc){
            cout << "New model has no name!" << endl;
        } catch (NewModelAlreadyInListException exc){
            cout << "New model is already in list!" << endl;
        }

        c2.toString();

        try {
            // c2.removeModelAt(2);
            // c2.replaceModelAt(2, "Tosho");
        } catch (TooBigIndexException exc){
            cout << "Too big index!" << endl;
        } catch (NewModelWithNoNameException exc){
            cout << "New model has no name!" << endl;
        } catch (NewModelAlreadyInListException exc){
            cout << "New model is already in list!" << endl;
        }

        // c2.toString();

    } catch (LessThanFiveModelsException exc){
        cout << "Less than five models!" << endl;
    } catch (LessThanFiveCharsInBrandException exc){
        cout << "Less than five chars in brand!" << endl;
    } catch (OneModelWithNoNameException exc){
        cout << "Model with no name!" << endl;
    }

    return 0;
}