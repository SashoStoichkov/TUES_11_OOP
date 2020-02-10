#ifndef REQUEST_H
#define REQUEST_H

#include <string>

class Request{
    protected:
        std::string ip_address;
        std::string path;

        std::string username;
        std::string password;
    public:
        Request(){};

        Request(std::string ip_address, std::string path);

        std::string get_path() const;

        void set_username_and_password(std::string username, std::string password);

        std::string get_username() const;
        std::string get_password() const;
};

#endif