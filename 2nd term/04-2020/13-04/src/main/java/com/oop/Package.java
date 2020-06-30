package main.java.com.oop;

public class Package {
    private Payload payload;

    public Package() { }
    public Package(Payload payload) {
        this.payload = payload;
    }

    public String serialize() {
        return payload.serialize();
    }

    public <T> void deserialize(String data, Builder<? extends T> builder) {
        this.payload = new Payload<T>(builder.build(data));
    }
}
