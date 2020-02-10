#include <iostream>

#include "home_client_single.h"
#include "home_client_double.h"

#include "industrial_client_single.h"
#include "industrial_client_double.h"

int main(){

    HomeClientSingle h_client_s = HomeClientSingle(42, 42, 100, 42);
    HomeClientDouble h_client_d = HomeClientDouble(42, 42, 100, 100, 42, 42);

    IndustrialClientSingle i_client_s = IndustrialClientSingle(42, );
    IndustrialClientDouble i_client_d = IndustrialClientDouble(42, 42, 42, 100, 100, 42, 42);


    return 0;
}