#include <iostream>
using namespace std;

#include "store.h"
#include "techItem.h"
#include "clothItem.h"

int main(){
    Store store1 = Store();

    User u1 = User(1, "pesho101", "qwerty");
    User u2 = User(2, "tosho101", "qwertyasd1");

    try {
        store1.add_user(u1);
        store1.add_user(u1);
    } catch (UserExists){
        cout << "User Exists!" << endl;
    }

    Supplier s1 = Supplier("Gosho");

    TechItem ti1 = TechItem("PS4", 500, 10, s1, 5, "Black", 2, 15);
    store1.add_item(ti1);

    ClothItem ci1 = ClothItem("T-shirt", 2.50, 15, s1, 2, "red", "L", "wool");
    store1.add_item(ci1);

    Order o1 = Order(1105496013, u1, {ti1}, {1}, "New");
    o1.add_item(ti1, 5);
    o1.add_item(ci1, 4);
    o1.add_item(ci1, 10);

    list<Item> st1_items = store1.get_items();
    list<Item>::iterator st1ii;

    for (st1ii = st1_items.begin(); st1ii != st1_items.end(); st1ii++){
        cout << st1ii->get_stock() << endl;
    }

    cout << endl;

    try {
        store1.create_order(o1);
    } catch (OrderExists){
        cout << "Order Exists!" << endl;
    } catch (TooMuchItems){
        cout << "Too Much Items" << endl;
    } catch (UserDoesNotExist){
        cout << "User Does Not Exist!" << endl;
    }

    st1_items = store1.get_items();

    for (st1ii = st1_items.begin(); st1ii != st1_items.end(); st1ii++){
        cout << st1ii->get_stock() << endl;
    }

    cout << endl;

    list<Item> o1_items = o1.get_items();
    list<Item>::iterator ii1;

    list<int> o1_quantities = o1.get_quantities();
    list<int>::iterator iq1;

    for (ii1 = o1_items.begin(), iq1 = o1_quantities.begin(); ii1 != o1_items.end(), iq1 != o1_quantities.end(); ii1++, iq1++){
        cout << ii1->get_name() << " " << *iq1 << endl;
    }

    cout << endl;

    try {
        auto p1 = store1.accept_order(1105496013, store1.orders);
        cout << "Total price: " << p1.first << endl << "Delivery days: " << p1.second << endl;
    } catch (OrderDoesNotExist){
        cout << "Order does not exist!" << endl;
    } catch (OrderNotNew){
        cout << "Order is not New!" << endl;
    }

    cout << endl;

    try {
        store1.send_order(1105496013, store1.orders);
    } catch (OrderDoesNotExist){
        cout << "Order does not exist!" << endl;
    } catch (OrderNotInStore){
        cout << "Order is not In Store!" << endl;
    }


    try {
        list<Order> orders_by_user = store1.get_orders_by_user(1);
        list<Order>::iterator obui;

        for (obui = orders_by_user.begin(); obui != orders_by_user.end(); obui++){
            list<Item> items = obui->get_items();
            list<Item>::iterator ibu;

            list<int> quantities = obui->get_quantities();
            list<int>::iterator q;

            cout << endl;

            for (ibu = items.begin(), q = quantities.begin(); ibu != items.end(), q != quantities.end(); ibu++, q++){
                cout << ibu->get_name() << " " << *q << endl;
            }
        }
    } catch (UserDoesNotExist){
        cout << "User does not exists!" << endl;
    }

    list<Item> items_by_supplier = store1.get_items_by_supplier(s1);
    list<Item>::iterator ibsi;

    cout << endl;

    for (ibsi = items_by_supplier.begin(); ibsi != items_by_supplier.end(); ibsi++){
        cout << ibsi->get_name() << " " << ibsi->get_price() << endl;
    }

    return 0;
}