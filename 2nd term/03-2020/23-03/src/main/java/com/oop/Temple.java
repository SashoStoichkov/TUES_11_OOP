package main.java.com.oop;

public class Temple {
    private final String templeName;
    private final String religion;
    private final Integer numberOfWorshipers;
    private final boolean needMoreCandles;

    public Temple(String templeName, String religion, Integer numberOfWorshipers, boolean needMoreCandles) {
        this.templeName = templeName;
        this.religion = religion;
        this.numberOfWorshipers = numberOfWorshipers;
        this.needMoreCandles = needMoreCandles;
    }

    public String getTempleName() {
        return templeName;
    }

    public String getReligion() {
        return religion;
    }

    public Integer getNumberOfWorshipers() {
        return numberOfWorshipers;
    }

    public boolean isNeedMoreCandles() {
        return needMoreCandles;
    }

    @Override
    public String toString() {
        return "Temple{" +
                "templeName='" + templeName + '\'' +
                ", religion='" + religion + '\'' +
                ", numberOfWorshipers=" + numberOfWorshipers +
                ", needMoreCandles=" + needMoreCandles +
                '}';
    }
}
