#ifndef RESPONSE_H
#define RESPONSE_H

#include <string>

class Response{
    protected:
        int status;
        std::string text;
    public:
        Response(){};

        Response(int status, std::string text);

        void print_response() const;
};

#endif