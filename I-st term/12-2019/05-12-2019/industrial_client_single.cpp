#include "industrial_client_single.h"

float IndustrialClientSingle::calcBill(){
    return (usedPower * (rate + delivery_price + distribution_price + highVoltage));
}