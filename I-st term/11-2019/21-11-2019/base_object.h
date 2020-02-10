#ifndef BASE_OBJECT_H
#define BASE_OBJECT_H
#include <string>


class BaseObject {
    public:
        int position;

        std::string render();
        std::string update();
};

#endif