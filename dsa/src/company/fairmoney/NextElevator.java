package company.fairmoney;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by oakinrele on Jul, 2020
 */


 /*
    This solution is subjected to further updates
 */

public class NextElevator {
     //Possible questions to ask //

    /* Amount of people that can be inside the elevator?
       Amount of floors?
       When inactive what happens?
       Keep moving in a direction till there are no more floors to visit in that direction.
       Are we assuming the user inputs his destination as well?
       Are you taking consideration of direction?
       We need to keep track of the ground floor and topmost floor
       Are there buttons that represents every floor in the building or user enters the floor themselves?
    */

    public enum Direction
    {
        Up,
        Down
    }


    class Position
    {
        int floor;
        Direction direction;
    }


    //List<Elevators> elevators = elevatorRepository.getAllElevators();
    //Write a method that returns the next floor of an elevator

    //TreeSet<Integer> floors = elevatorRepository.getAllFloors();
    List<Integer> destinations = new ArrayList<>();
    // Set<Integer> set = new TreeSet<>();
    // currentPosition = 0
    // destination = 4;
    //0,1,2,3,4,5

    public int getNextElevatorFloor(int currentFloor, int previousFloor, int destination) throws Exception {
        Direction direction = currentFloor > previousFloor ? Direction.Up : Direction.Down;

        if(!destinations.contains(destination)) {
            destinations.add(destination);
        }
        Collections.sort(destinations);

//        if(floors.isEmpty() || floors == null)
//        {
//            throw new Exception("Floors can not be empty");
//        }

        try
        {
            for(int i = 0; i < destinations.size(); i++){
                //move(currentPosition);
                if(currentFloor == destinations.get(i))
                {

                    if(direction == Direction.Up) {
                        return destinations.get(i + 1);
                    }

                    else {
                        return destinations.get(i - 1);
                    }
                }

            }
        }

        catch(Exception ex){
            System.out.println("Ops! unexpected error");
            throw new Exception("Ops! an unexpected error occured");
        }

        return -1;
    }


    public void move(int position) {
        position++;
    }


}
