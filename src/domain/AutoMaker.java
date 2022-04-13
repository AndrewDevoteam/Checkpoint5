package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class AutoMaker {

    private final long id;
    private String name;
    private Vehicle[] cars;

    public AutoMaker(String name) {
        this.id = ThreadLocalRandom.current().nextLong(0, 100_000);
        this.name = name;
    }

    public AutoMaker(String name, Vehicle[] cars) {
        this.id = ThreadLocalRandom.current().nextLong(0, 100_000);
        this.name = name;
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoMaker autoMaker = (AutoMaker) o;
        return id == autoMaker.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle[] getVehicles() {
        return cars;
    }

    public void setVehicles(Vehicle[] cars) {
        this.cars = cars;
    }

}
