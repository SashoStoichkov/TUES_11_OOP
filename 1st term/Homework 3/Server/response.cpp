#include "response.h"
#include <iostream>

Response::Response(int status, std::string text) :
    status(status), text(text){};

void Response::print_response() const {
    std::cout << this->status << " " << this->text << std::endl;
}