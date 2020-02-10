#include "request.h"

Request::Request(std::string ip_address, std::string path) :
    ip_address(ip_address), path(path){};

std::string Request::get_path() const {
    return this->path;
}

void Request::set_username_and_password(std::string username, std::string password){
    this->username = username;
    this->password = password;
}

std::string Request::get_username() const {
    return this->username;
}

std::string Request::get_password() const {
    return this->password;
}