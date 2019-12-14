#include "client.h"

Client::Client(std::string name, std::string email) :
    name(name), email(email){};

Client::Client(const Client& client){
    this->name = client.name;
    this->email = client.email;
}