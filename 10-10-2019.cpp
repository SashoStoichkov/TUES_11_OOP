#include <iostream>
using namespace std;

#include <string>
#include <queue>

class ReadLine{
    string brackets;
    int left_brackets = 0;
    int right_brackets = 0;
    bool equal_brackets;
    bool balanced_brackets;

    queue<char> q;

    public:
        void readline(){
            cout << "Enter brackets: "; getline(cin, brackets);

            for (int i = 0; i < brackets.size(); i++){
                if (brackets[i] == '('){
                    left_brackets++;
                } else if (brackets[i] == ')'){
                    right_brackets++;
                }

                q.push(brackets[i]);
            }

            if (left_brackets == right_brackets){
                equal_brackets = true;
                cout << "Brackets are equal" << endl;
            } else {
                equal_brackets = false;
                cout << "Brackets are not equal" << endl;
            }
        }
};

int main(){

    ReadLine r = ReadLine();

    r.readline();

    return 0;
}