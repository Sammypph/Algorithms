package webspoon;

/**
 * Created by oakinrele on Oct, 2020
 */
abstract class Car {
    protected boolean isSedan;
    protected String seats;

    public Car(boolean isSedan, String seats) {
        this.isSedan = isSedan;
        this.seats = seats;
    }

    public boolean getIsSedan() {
        return this.isSedan;
    }

    public String getSeats() {
        return this.seats;
    }

    abstract public String getMileage();

    public void printCar(String name) {
        System.out.println(
                "A " + name + " is " + (this.getIsSedan() ? "" : "not ")
                        + "Sedan, is " + this.getSeats() + "-seater, and has a mileage of around "
                        + this.getMileage() + ".");
    }
}
