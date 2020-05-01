package AMZ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oakinrele on Mar, 2020
 */
public class AddPassengersToFlight {
    public List<Passenger> addPassengersToFlight(List<Passenger> passengers, Flight flight)
    {
        if(passengers.size() < 1)
        {
            return new ArrayList<>();
        }

        List<Passenger> unboardedPassengers = new ArrayList<>();
        for (Passenger passenger : passengers)
        {
            if(passenger.hasPriority && passenger.flight.passengerSeatHashMap.get(passenger.seat).seat.isFree)
            {
                flight.addPassenger(passenger,passenger.seat);
                passengers.remove(passenger);
            }

            else if(!flight.isFull)
            {
                {
                    flight.addPassenger(passenger);
                }
            }

            else
            {
                unboardedPassengers.add(passenger);
            }

        }
        return unboardedPassengers;
    }


    public class Flight
    {
        public List<Passenger> boardedPassengers;
        public List<Seat> seats;
        Map<Seat,Passenger> passengerSeatHashMap = new HashMap<>();
        boolean isFull;

        public void addPassenger(Passenger passenger, Seat seat)
        {
            passengerSeatHashMap.put(seat,passenger);
        }

        public void addPassenger(Passenger passenger)
        {
            passengerSeatHashMap.put(new Seat(),passenger);
        }

    }

    public class Passenger
    {
        public Flight flight;
        public String name;
        public int age;
        public Seat seat;
        public boolean hasPriority;
    }

    public class Seat
    {
        public String seat;
        public boolean isFree;
    }
}
