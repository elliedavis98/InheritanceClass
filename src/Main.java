//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //creating objects for the vehicles to give them values
        Car prius = new Hybrid("Toyota Prius", 112.0, 5, 600.0, 55.0, "Blue", false, true, "Lithium-ion", false);
        Car mustang = new Ford("Ford Mustang", 165.0, 4, 400,23, "2.3", 3.5, "black", true,true);

        Boat sailboat = new SailBoat("Lagoon 40 Catamaran",500, 1250.0, 30.0, 40.0,  90.0, true, 4);
        Boat cargoboat = new CargoBoat("Maersk Container Ship", 18720,64000, 25.0, 1302.0, 25000000.0, 3, "Armed vessel security guards");

        Airplane boeing737 = new Boeing737("Boeing 737", 521.0, 321, 30000, 41000.0, 93.0, 6875.0, 189, 2 );
        Airplane invisiblePlane = new invisiblePlane(" Invisible HondaJet Echelon", 483.0, 4, 4800.0, 120000,56.0, 3020.0, true, "Honda Aircraft Company");

        Bike trainingbike = new Trainingbike("Stationary Little Tikes Training Bike", 10.0, 1, 35.0, "Playground", 0, "none, bike does not move", 4, true);
        Bike SpeedBike = new SpeedBike(" Ninja HR 2 Speed Bike", 249.0, 2, 250.0, "road", 326, "Top Tier Detergent Gasoline", 2, " supercharged motor bike", false);

        //printing out vehicles
        System.out.println(prius);
        System.out.println(mustang);
        System.out.println(sailboat);
        System.out.println(cargoboat);
        System.out.println(boeing737);
        System.out.println(invisiblePlane);
        System.out.println(trainingbike);
        System.out.println(SpeedBike);
    }
}

class Vehicle implements Speedometer {
    protected String brandName = "";
    protected double speed = 0.0;
    protected int passengers = 0;
    protected double cargoWeight = 0.0;

    public Vehicle(String inBrand, int inPassengers, double inCargo) {
        brandName = inBrand;
        speed = inCargo;
        passengers = inPassengers;
        cargoWeight = inCargo;

    }

    public Vehicle(String inBrand, double inSpeed, int inPassengers, double inCargo) {
        brandName = inBrand;
        speed = inSpeed;
        passengers = inPassengers;
        cargoWeight = inCargo;
    }

    public String getBrand() {
        return brandName;
    }

    public void setBrandName(String inBrand) {
        brandName = inBrand;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double inSpeed) {
        speed = inSpeed;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int inPassengers) {
        passengers = inPassengers;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double inCargoWeight) {
        cargoWeight = inCargoWeight;
    }

    public String toString() {
        String result = "";
        result = "Brand: \t\t\t" + getBrand() + "\n" +
                "Speed (mph): \t" + getSpeed() + "\n" +
                "Passengers: \t" + getPassengers() + "\n" +
                "Cargo (lbs): \t" + getCargoWeight() + "\n";
        return result;
    }
}

interface Speedometer {
    public void setSpeed(double inSpeed);
    public double getSpeed();
}

class Car extends Vehicle {
    int wheels = 4;
    String color;
    boolean spoiler;
    boolean stereo;
    double mpg = 0.0;

    public Car(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG, String color, boolean spoiler, boolean stereo) {
        super(inBrand, inSpeed, inPassengers, inCargo);
        this.mpg = inMPG;
        this.color = color;
        this.spoiler = spoiler;
        this.stereo = stereo;
    }

    public void setSpoiler(boolean inSpoiler) {
        spoiler = inSpoiler;
    }

    public boolean getSpoiler() {
        return spoiler;
    }

    public void setStereo(boolean inStereo) {
        stereo = inStereo;
    }

    public boolean getStereo() {
        return stereo;
    }

    @Override
    public double getSpeed() {
        if (spoiler)
            return super.getSpeed() + 20;
        else
            return super.getSpeed();
    }

    public double getMPG() {
        if (stereo)
            return mpg - (mpg / 10);
        else
            return mpg;
    }

    public String toString() {
        String result = super.toString() +
                "MPG :\t\t\t" + getMPG() + "\n" +
                "Color: " + "\t" + color + "\n" +
                "Spoiler: " + "\t" + spoiler + "\n" +
                "Stereo: " + "\t" + stereo + "\n";
        return result;
    }
}

class Hybrid extends Car {
    private String batterytype;
    private boolean motor;

    //constructor for hybrid car
    public Hybrid(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG, String color, boolean spoiler, boolean stereo, String batterytype, boolean leatherseats) {
        super(inBrand, inSpeed, inPassengers, inCargo, inMPG, color, spoiler, stereo);
        this.batterytype = batterytype;
        this.motor = motor;
    }

    //getters and setters for variables specific for hybrid
    public String getBatterytype() {
        return batterytype;
    }

    public boolean isMotor() {
        return motor;
    }

    public void setBatterytype(String batterytype) {
        this.batterytype = batterytype;
    }

    public void setLeatherseats(boolean motor) {
        this.motor = motor;
    }

    //toString to print out Hybrid
    public String toString() {
        String result = super.toString() + "Battery Type: " + "\t" + getBatterytype() + "\n" + "Is motor in Car?: " +"\t" + isMotor() + "\n";
        return result;
    }
}
class Ford extends Car {
    private String engineSize;
    private double reliabilityS;

    //constructor implementing variables specifc to ford and extending car variables
    public Ford(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG, String engineSize, double reliabilityS, String color, boolean spoiler, boolean stereo) {
        super(inBrand, inSpeed, inPassengers, inCargo, inMPG, color, spoiler, stereo);
        this.engineSize= engineSize;
        this.reliabilityS = reliabilityS;
    }
    //getters and setters
    public String getEngineSize() {
        return engineSize;
    }

    public double getReliabilityS() {
        return reliabilityS;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public void setReliabilityS(double reliabilityS) {
        this.reliabilityS = reliabilityS;
    }

    //toString to print out an instance of ford
    public String toString(){
        String result = super.toString() + "Size of engine(liters): " +"\t" + getEngineSize() + "\n" + "Reliability Score: " + "\t" +getReliabilityS() +"\n";
        return result;
    }
}

// Boat class inherits from Vehicle class constructor for boat
class Boat extends Vehicle {
    double maximumSpeed;
    double length;
    double fuelCapacity;

    //toString that extends from vehicle but adds variables specific to boat
    public Boat(String brandName, int passengers, double cargoWeight, double maximumSpeed, double length, double fuelCapacity) {
        super(brandName, passengers, cargoWeight);
        this.brandName = brandName;
        this.maximumSpeed = maximumSpeed;
        this.length = length;
        this.fuelCapacity = fuelCapacity;
    }
    //a getter that decreases the max speed of the boat if length is over 34 feet
    public double getMaximumSpeed() {
        if(length>34.0){
            return maximumSpeed -10;
        }
        return maximumSpeed;
    }

    //getters and setters
    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getFuelCapacity() {
        return fuelCapacity;
    }
    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    //ToString to print out values
    @Override
    public String toString() {
        return super.toString() + "Maximum Speed (knots): \t" + getMaximumSpeed() + "\n" + "Length (ft): \t\t" + getLength() + "\n" + "Fuel Capacity (liters per engine): \t" + getFuelCapacity() + "\n";
    }
}

class SailBoat extends Boat {
    private boolean sailboat;
    private int numberOfCabins;

    public SailBoat(String brandName, int passengers, double cargoWeight, double maximumSpeed, double length, double fuelCapacity, boolean sailboat, int numberOfCabins) {
        super(brandName, passengers, cargoWeight, maximumSpeed, length, fuelCapacity);
        this.sailboat = sailboat;
        this.numberOfCabins = numberOfCabins;
    }

    public boolean isSailboat() {
        return sailboat;
    }

    public void setSailboat(boolean sailboat) {
        this.sailboat = sailboat;
    }

    public int getNumberOfCabins() {
        return numberOfCabins;
    }

    public void setNumberOfCabins(int numberOfCabins) {
        this.numberOfCabins = numberOfCabins;
    }

    @Override
    public String toString() {
        return super.toString() + "Sailboat: \t\t" + isSailboat() + "\n" + "Number of Cabins: \t" + getNumberOfCabins() + "\n";
    }
}

class CargoBoat extends Boat {
    private int cranenumb;
    private String securitysystem;

    public CargoBoat(String brand,int passengers, double cargo,double maximumspeed, double length, double fuelCapacity, int cranenumb, String securitysystem) {
        super(brand, passengers, cargo, maximumspeed, length, fuelCapacity );
        this.cranenumb = cranenumb;
        this.securitysystem = securitysystem;
    }

    public int getCranenumb() {
        return cranenumb;
    }
    public void setCranenumb(int cranenumb) {
        this.cranenumb = cranenumb;
    }
    public String getSecuritysystem() {
        return securitysystem;
    }
    public void setSecuritysystem(String securitysystem) {
        this.securitysystem = securitysystem;
    }

    @Override
    public String toString(){
        String result = super.toString() + "Number of Cranes: \t\t" + getCranenumb() + "\n" + "Security System: \t" + getSecuritysystem() + "\n";
        return result;
    }
}

// Airplane class inherits from Vehicle class
class Airplane extends Vehicle {
    private double maximumAltitude;
    private double wingSpan;
    private double fuelEfficiency;

    public Airplane(String brand, double speed, int passengers, double cargo, double maxAltitude, double wingSpan, double fuelEfficiency) {
        super(brand, speed, passengers, cargo);
        this.maximumAltitude = maxAltitude;
        this.wingSpan = wingSpan;
        this.fuelEfficiency = fuelEfficiency;
    }

    // Additional getters and setters
    public double getMaximumAltitude() {
        return maximumAltitude;
    }

    public void setMaximumAltitude(double maximumAltitude) {

        this.maximumAltitude = maximumAltitude;
    }

    public double getWingSpan() {

        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {

        this.wingSpan = wingSpan;
    }

    public double getFuelEfficiency() {

        return fuelEfficiency;
    }

    public void setFuelEfficiency(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    //tostring to print out base information about the plane
    public String toString() {
        String result = super.toString() + "Maximum Altitude(feet):" + "\t" + getMaximumAltitude() + "\n" + "Wing Span(feet): " + "\t" + getWingSpan() + "\n" + "Fuel Efficiency(FEM)" + "\t" + getFuelEfficiency() + "\n";
        return result;
    }}

class Boeing737 extends Airplane {
    private int seats;
    private int pilotnumb;

    public Boeing737(String brand, double speed, int passengers, double cargo, double maxAltitude, double wingSpan, double fuelEfficiency, int seats, int pilotnumb) {
        super(brand, speed, passengers, cargo, maxAltitude, wingSpan, fuelEfficiency);
        this.seats = seats;
        this.pilotnumb = pilotnumb;
    }

    //getters and setters for seats and number of pilots and seat number of plane
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getPilotnumb() {
        return pilotnumb;
    }

    public void setPilotnumb(int pilotnumb) {
        this.pilotnumb = pilotnumb;
    }

    //tostring to print out information about the Boeing737
    public String toString() {
        String result = super.toString() + "Number of Seats: " + "\t" + getSeats() + "\n" + "Number of pilots:" + "\t" + getPilotnumb() + "\n";
        return result;


    }
}

//  airplane invisible jet class inherits from airplane class
class invisiblePlane extends Airplane {
    private boolean jetEngine;
    private String manufacturer;

    public invisiblePlane(String brand, double speed, int passengers, double cargo, double maxAltitude, double wingSpan, double fuelEfficiency, boolean jetEngine, String manufacturer) {
        super(brand, speed, passengers, cargo, maxAltitude, wingSpan, fuelEfficiency);
        this.jetEngine = jetEngine;
        this.manufacturer = manufacturer;
    }

    // Additional getters and setters
    public boolean isJetEngine() {
        return jetEngine;
    }

    public void setJetEngine(boolean jetEngine) {
        this.jetEngine = jetEngine;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    public String toString(){
        String result = super.toString() + "Is there a jet engine?" + "\t" + isJetEngine() + "\n" + "Manufacturer: " +"\t" + getManufacturer() + "\n";
        return result;
    }
}


// Other vehicle class inherits from Vehicle class
class Bike extends Vehicle {
    private String terrainType;
    private String fuelType;

    public Bike(String brand, double speed, int passengers, double cargo, String terrainType, int horsepower, String fuelType) {
        super(brand, speed, passengers, cargo);
        this.terrainType = terrainType;
        this.fuelType = fuelType;
    }

    // Additional getters and setters
    public String getTerrainType() {
        return terrainType;
    }
    public void setTerrainType(String terrainType) {
        this.terrainType = terrainType;
    }

    public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String toString(){
        String result = super.toString() + "Terrain Type: "+"\t" +getTerrainType() +"\n"+ "Fuel Type: " + " \t" + getFuelType() + "\n";
        return result;

    }

}

class Trainingbike extends Bike {
    private int wheels;
    private boolean bell;

    public Trainingbike(String brand, double speed, int passengers, double cargo, String terrainType, int horsepower, String fuelType, int wheels, boolean bell) {
        super(brand, speed, passengers, cargo, terrainType, horsepower, fuelType);
        this.wheels = wheels;
        this.bell = bell;
    }

    //getters amd setters
    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public boolean isBell() {
        return bell;
    }

    public void setBell(boolean bell) {
        this.bell = bell;
    }

    //tostring
    public String toString(){
        String result = super.toString() + "Wheels: " + "\t" + getWheels() + "\n" + " Bell?" + "\t" + isBell() + "\n";
        return result;
    }
}

// Another other vehicle class inherits from Vehicle class
class SpeedBike extends Bike {
    private int horsepower;
    private String vehicleType;

    private boolean legal;

    public SpeedBike(String brand, double speed, int passengers, double cargo, String terrainType, int horsepower, String fuelType, int numberOfWheels, String vehicleType, boolean legal) {
        super(brand, speed, passengers, cargo, terrainType, horsepower, fuelType);
        this.horsepower = horsepower;
        this.vehicleType = vehicleType;
        this.legal = legal;
    }

    // Additional getters and setters
    public int getHorsepower() {

        return horsepower;
    }
    public void setHorsepower(int horsepower) {

        this.horsepower = horsepower;
    }
    public String getVehicleType() {

        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {

        this.vehicleType = vehicleType;
    }
    public boolean isLegal() {
        return legal;
    }

    public void setLegal(boolean legal) {
        this.legal = legal;
    }

    public String toString(){
        String result = super.toString() + "Horsepower: " + "\t" + getHorsepower() + "\n" + "Type of Vehicle: " + "\t" + getVehicleType() +"\n" + "Street legal: " + "\t" + isLegal() + "\n";
        return result;
    }
}
