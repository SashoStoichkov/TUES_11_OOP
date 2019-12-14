#include "industrial_client.h"

IndustrialClient::IndustrialClient(float delivery_price, float distribution_price, float highVoltage) : 
    Client(delivery_price, distribution_price), highVoltage(highVoltage){}