package main.java.com.oop;

public abstract class BaseType {
    protected String name;
    protected Status status;

    public BaseType(String name) {
        this.name = name;
        this.status = Status.WAITING;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
