package sk.itsovy.nemethd;

import java.util.function.Predicate;

public class CityFromNLD<T> implements Predicate<City> {

    @Override
    public boolean test(City city) {
        return city.getCode().equals("NLD");
    }
}
