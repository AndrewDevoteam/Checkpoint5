package domain;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {

    private final List<Vehicle> vehicleList;

    private static final List<AutoMaker> automakers = new ArrayList<>(List.of(
            new AutoMaker("GM"),
            new AutoMaker("Hyundai"),
            new AutoMaker("Volkswagen"),
            new AutoMaker("Audi"),
            new AutoMaker("Mercedes"),
            new AutoMaker("Peugeot")
    ));

    private static final List<Vehicle> vehicles = new ArrayList<>(List.of(

            new Car("Suburban", "Red", "1995", automakers.get(0)),
            new Car("Malibu", "Yellow", "2003", automakers.get(0)),
            new Car("Silverado", "Blue", "2007", automakers.get(0)),
            new Car("Azera", "Red", "2014", automakers.get(1)),
            new Car("Sonata", "Yellow", "2015", automakers.get(1)),
            new Car("Veloster", "Blue", "2009", automakers.get(1)),
            new Car("Golf", "Red", "1994", automakers.get(2)),
            new Car("Jetta", "Yellow", "2017", automakers.get(2)),
            new Car("Polo", "Blue", "2000", automakers.get(2)),
            new Car("A4", "Red", "2001", automakers.get(3)),
            new Car("Q7", "Yellow", "2002", automakers.get(3)),
            new Car("R8", "Blue", "1999", automakers.get(3)),
            new Car("C180", "Red", "2017", automakers.get(4)),
            new Car("C200", "Yellow", "2018", automakers.get(4)),
            new Car("GLA200", "Blue", "2019", automakers.get(4)),
            new Car("206", "Red", "2006", automakers.get(5)),
            new Car("208", "Yellow", "2008", automakers.get(5)),
            new Car("2008", "Blue", "2007", automakers.get(5))
    ));

    public VehicleRepository() {
        vehicleList = vehicles;
    }


    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }
}
