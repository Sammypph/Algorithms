package firecode;

import java.util.*;

/**
 * Created by oakinrele on Feb, 2020
 */
public class reverseInteger {
    public static int reverseInt(int x) {
        boolean multiplyByNegative = false;
        if(x < 1)
        {
            x = x * -1;
            multiplyByNegative = true;
        }

        int valueAfterDivision;
        int reversed=0;

        while(x > 0)
        {
            valueAfterDivision = x/10;
            reversed = reversed * 10 + x % 10;
            x = valueAfterDivision;
        }
        return multiplyByNegative ? (reversed * -1) : reversed;
    }


    public static int reverseIntSecondSolution(int x) {
        int rev = 0;
        while(x != 0){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return rev;
    }



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

    //Amount of people that can be inside the elevator?
    //Amount of floors?
    //When inactive what happens?
    //Keep moving in a direction till there are no more floors to visit in that direction.
    // Are we assuming the user inputs his destination as well?
    // Are you taking consideration of direction?
    // We need to keep track of the ground floor and topmost floor
    // Are there buttons that represents every floor in the building or user enters the floor themselves?

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


    public static void main(String [] args)
    {


        String name = "Ade";

        //Map<Character,Character> map = new HashMap<>(Collections.singletonList(name));

        for (char value:name.toCharArray()) {

        }
    }
}
