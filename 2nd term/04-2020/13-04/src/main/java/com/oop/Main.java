package main.java.com.oop;

public class Main {

//    public static void main(String[] args) {
//
//        Test<Number> test = new Test<>(new Integer(1));
//        System.out.println(test.getItem());
//
//        Test.<Number>fn(5);
//        Test.<String>fn("ASDF");
//        Test.<Test<Number>>fn(test);
//    }

    public static void main(String[] args) {
//        Payload<Number> payload = new Payload<>(15);
//        Payload<Number> payload2 = new Payload<>(15);
//        Package pack = new Package(payload);

        Package pack = new Package();
        pack.deserialize("15", new Builder<Integer>() {
            @Override
            public Integer build(String data) {
                return Integer.parseInt(data);
            }
        });

        System.out.println(pack.serialize());
    }
}
