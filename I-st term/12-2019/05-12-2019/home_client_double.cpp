#include "home_client_double.h"

HomeClientDouble::HomeClientDouble(float delivery_price, float distribution_price, 
                                   float usedPowerDay, float usedPowerNight, 
                                   float rateDay, float rateNight) : 
    HomeClient(delivery_price, distribution_price), 
    usedPowerDay(usedPowerDay), usedPowerNight(usedPowerNight), 
    rateDay(rateDay), rateNight(rateNight){}

float HomeClientDouble::calcBill(){
    return ((usedPowerDay+usedPowerNight) * (rateDay + rateNight + delivery_price + distribution_price));
}