#include "game.h"

Game::Game(std::string title, std::string author, float price, int hours_played) :
    Media(title, author, price), hours_played(hours_played){};

float Game::calc_total(){
    return this->hours_played * this->price;
}