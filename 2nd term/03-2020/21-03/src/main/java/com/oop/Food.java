package main.java.com.oop;

public abstract class Food {
    private String name;
    private Double quantity;
    private Double quality;
    private Integer age;

    public Food(Double quantity, Double quality) {
        name = "unknown food";
        this.quantity = quantity;
        this.quality = quality;
        age = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getQuality() {
        return quality;
    }

    public void setQuality(Double quality) {
        this.quality = quality;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getFoodScore() {
        return (double) Math.round((quantity * quality) * 100.0) / 100.0;
    }

    protected abstract void passWinter();

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", quality=" + quality +
                ", age=" + age +
                ", foodScore=" + this.getFoodScore() +
                '}';
    }
}
