#include "industrial_client_double.h"

IndustrialClientDouble::IndustrialClientDouble(float delivery_price, float distribution_price, float highVoltage, 
                                               float usedPowerDay, float usedPowerNight, float rateDay, float rateNight) :
    IndustrialClient(delivery_price, distribution_price, highVoltage), 
    usedPowerDay(usedPowerDay), usedPowerNight(usedPowerNight), rateDay(rateDay), rateNight(rateNight){}

float IndustrialClientDouble::calcBill(){
    return ((usedPowerDay+usedPowerNight) * (rateDay + rateNight + delivery_price + distribution_price + highVoltage));
}