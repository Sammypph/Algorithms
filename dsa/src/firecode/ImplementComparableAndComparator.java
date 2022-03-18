package firecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by oakinrele on Feb, 2020
 */
public class ImplementComparableAndComparator {



    public static void main(String [] args)
    {
        List<Human> humans = new ArrayList<>();

        humans.add(new Human(12,"Sanmi", 3));
        humans.add(new Human(14,"Akinrele", 1));
        humans.add(new Human(17,"Tobi", 0));

        Collections.sort(humans);

        for (Human human: humans) {
            System.out.println(human.getName());
        }


        List<Animal> animals = new ArrayList<>();

        animals.add(new Animal(12,"Goat", 3));
        animals.add(new Animal(14,"Sheep", 15));
        animals.add(new Animal(17,"Ram", 0));

        AnimalComparator animalComparator = new AnimalComparator();

        Collections.sort(animals,animalComparator);

        for (Animal animal: animals) {
            System.out.println(animal.getName());
        }

    }
}



class Human implements Comparable<Human>
{

    private int age;
    private String name;
    private int level;


    Human(int age,String name,int level )
    {
        this.age = age;
        this.name = name;
        this.level=level;
    }


    @Override
    public int compareTo(Human anotherHuman)
    {
        return this.level - anotherHuman.level;
    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}


class Animal
{

    private int age;
    private String name;
    private int level;


    Animal(int age,String name,int level )
    {
        this.age = age;
        this.name = name;
        this.level=level;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}


class AnimalComparator implements Comparator<Animal>
{
    @Override
    public int compare(Animal firstAnimal, Animal secondAnimal)
    {
        return firstAnimal.getLevel() - secondAnimal.getLevel();
    }
}