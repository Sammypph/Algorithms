package webspoon;

/**
 * Created by oakinrele on Sep, 2020
 */
public class Main {

    public static void main(String[] args) {

        Car car = new WagonR(20);
        car.getMileage();

        Car car1 = new HondaCity(30);
        car1.getMileage();

        Car car2 = new InnovaCrysta(40);
        car2.getMileage();

    }
}




