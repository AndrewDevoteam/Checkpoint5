package domain;

public enum VehicleTypeEnum {

    CAR {
        @Override
        public Vehicle buildNewVehicle(String name,String color, String year, AutoMaker automaker, VehicleTypeEnum vehicleTypeEnum) {
            return new Car(name, color, year, automaker, vehicleTypeEnum);

        }
    },
    MOTORCYCLE {
        @Override
        public Vehicle buildNewVehicle(String name,String color, String year, AutoMaker automaker, VehicleTypeEnum vehicleTypeEnum) {
            return new Motorcycle(name, color, year, automaker, vehicleTypeEnum);

        }
    },
    VAN {
        @Override
        public Vehicle buildNewVehicle(String name,String color, String year, AutoMaker automaker, VehicleTypeEnum vehicleTypeEnum) {
            return new Van(name, color, year, automaker, vehicleTypeEnum);
        }
    },
    TRUCK {
        @Override
        public Vehicle buildNewVehicle(String name,String color, String year, AutoMaker automaker, VehicleTypeEnum vehicleTypeEnum) {
            return new Truck(name, color, year, automaker, vehicleTypeEnum);

        }
    },
    PICKUP {
        @Override
        public Vehicle buildNewVehicle(String name,String color, String year, AutoMaker automaker, VehicleTypeEnum vehicleTypeEnum) {
            return new PickUp(name, color, year, automaker, vehicleTypeEnum);

        }
    },
    OTHERS {
        @Override
        public Vehicle buildNewVehicle(String name,String color, String year, AutoMaker automaker, VehicleTypeEnum vehicleTypeEnum) {
            return new Others(name, color, year, automaker, vehicleTypeEnum);
        }
    };

    public Vehicle buildNewVehicle(String name,String color, String year, AutoMaker automaker, VehicleTypeEnum vehicleTypeEnum) {
        return null;
    }
}
