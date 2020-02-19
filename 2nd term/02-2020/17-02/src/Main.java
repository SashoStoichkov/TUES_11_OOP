import com.oop.*;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.name + " " + person.getAge());

        Person person1 = new Person("Elizara", 23);
        System.out.println(person1.name + " " + person1.getAge());

        System.out.println(Person.gender);
        System.out.println(Person.getCount() + " Iliana count");
    }
}
