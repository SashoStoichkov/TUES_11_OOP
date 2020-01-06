#include <iostream>
using namespace std;

#include "book.h"
#include "film.h"
#include "game.h"
#include "song.h"

#include "media.h"
#include "service.h"

int main(){
    Song s1 = Song("Song1", "AuthorSong1", 15.75, 100);
    Film f1 = Film("Film1", "AuthorFilm1", 75.90, 120);
    Game g1 = Game("Game1", "AuthorGame1", 60.50, 145);

    Payment p1 = Payment("01-12-2019", "31-12-2019", {s1, f1}, s1.calc_total() + f1.calc_total(), "Not paid!");
    Payment p2 = Payment("10-12-2019", "31-12-2019", {f1}, f1.calc_total(), "Not paid!");
    Payment p3 = Payment("15-12-2019", "31-12-2019", {g1}, g1.calc_total(), "Not paid!");

    User u1 = User("Pesho", "pesho@gmail.com", {s1, f1, g1}, {p1, p3});
    User u2 = User("Gosho", "gosho@gmail.com", {f1, g1}, {p2, p1});

    Service ser1 = Service({u1, u2}, {s1, f1, g1});

    cout << p3.get_status() << endl;
    ser1.mark_payment_as_paid(p3);
    cout << p3.get_status() << endl;

    cout << endl;

    std::list<User> all_users = ser1.return_all_users();
    std::list<User>::iterator ui;

    for (ui = all_users.begin(); ui != all_users.end(); ui++){
        cout << ui->get_name() << " " << ui->get_email() << endl;
    }

    cout << endl;

    Media media = ser1.return_media_by_title("Song1");
    // cout << media.calc_total() << " " << s1.calc_total() << endl;
    cout << media.get_title() << " " << s1.get_title() << endl;

    cout << endl;

    std::list<Payment> payments = ser1.return_payments_for_user(u1);
    std::list<Payment>::iterator pi;

    for (pi = payments.begin(); pi != payments.end(); pi++){
        cout << pi->get_start_date() << " " << pi->get_end_date() << endl;
    }

    return 0;
}