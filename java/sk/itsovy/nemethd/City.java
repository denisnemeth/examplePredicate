package sk.itsovy.nemethd;

public class City {

    private int pop;
    private String code;
    private String district;
    private String name;

    public City(int pop, String code, String district, String name) {
        this.pop = pop;
        this.code = code;
        this.district = district;
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" + "pop=" + pop + ", code=\"" + code + "\"" + ", district=\"" + district + "\"" + ", name=\"" + name + "\"" + "}";
    }

    public int getPopulation() {
        return pop;
    }

    public String getCode() {
        return code;
    }
}
