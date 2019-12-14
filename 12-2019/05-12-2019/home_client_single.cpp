#include "home_client_single.h"

HomeClientSingle::HomeClientSingle(float delivery_price, float distribution_price, 
                                   float usedPower, float rate) : 
    HomeClient(delivery_price, distribution_price), 
    usedPower(usedPower), rate(rate){}

float HomeClientSingle::calcBill(){
    return (usedPower * (rate + delivery_price + distribution_price));
}