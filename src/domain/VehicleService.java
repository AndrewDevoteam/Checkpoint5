package domain;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService {

    private final VehicleRepository vehicleRepository = new VehicleRepository();

    public void searchByAutomaker(String manufacturerName) {

        List<Vehicle> collect = vehicleRepository.getVehicleList().stream()
                .filter(vehicle1 -> vehicle1.getAutoMaker().getName().equalsIgnoreCase(manufacturerName))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    public void searchByModel(String modelName) {
        vehicleRepository.getVehicleList().stream()
                .filter(vehicle1 -> vehicle1.getModel().equalsIgnoreCase(modelName))
                .findAny()
                .ifPresent(System.out::println);
    }

    public void addVehicle(String model, String color, String year, AutoMaker automaker, VehicleTypeEnum vehicleTypeEnum) {
        Vehicle vehicle = createVehicle(model, color, year, automaker, vehicleTypeEnum);
        vehicleRepository.getVehicleList().add(vehicle);
    }

    public void updateVehicle(String vehicleName, Vehicle vehicle) {
        vehicleRepository.getVehicleList().replaceAll(vehicle1 -> vehicle1.getModel().equalsIgnoreCase(vehicleName) ? vehicle : vehicle1);
    }

    public void deleteVehicleByModel(String deleteVehicle) {
        vehicleRepository.getVehicleList().removeIf(vehicle1 -> vehicle1.getModel().equalsIgnoreCase(deleteVehicle));
    }

    public void generateReportFile() {
        //Set LocalDateTime Format
        String pattern = "MMM d, yyyy, HH:mm:ss a";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);

        vehicleRepository.getVehicleList()
                .forEach(vehicle -> {
                    System.out.println("#------------------------------------------------------#");
                    System.out.println("Registration Date: " + vehicle.createdAt.format(format));
                    System.out.println("AutoMaker: " + vehicle.getAutoMaker().getName());
                    System.out.println("Model: " + vehicle.getModel());
                    System.out.println("Vehicle Type: " + vehicle.getVehicleType());
                    System.out.println("Color: " + vehicle.getColor());
                    System.out.println("Year: " + vehicle.getYear());
                }
        );
    }

    public Vehicle createVehicle(String name,String color, String year, AutoMaker automaker, VehicleTypeEnum vehicleTypeEnum) {
        return switch (vehicleTypeEnum) {
            case CAR -> VehicleTypeEnum.CAR.buildNewVehicle(name, color, year, automaker, vehicleTypeEnum);
            case MOTORCYCLE -> VehicleTypeEnum.MOTORCYCLE.buildNewVehicle(name, color, year, automaker, vehicleTypeEnum);
            case VAN -> VehicleTypeEnum.VAN.buildNewVehicle(name, color, year, automaker, vehicleTypeEnum);
            case TRUCK -> VehicleTypeEnum.TRUCK.buildNewVehicle(name, color, year, automaker, vehicleTypeEnum);
            case PICKUP -> VehicleTypeEnum.PICKUP.buildNewVehicle(name, color, year, automaker, vehicleTypeEnum);
            case OTHERS -> VehicleTypeEnum.OTHERS.buildNewVehicle(name, color, year, automaker, vehicleTypeEnum);
        };
    }
}
