package be.intecbrussel.vaccinatie;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalShelter extends Animal{
    private static List<Animal> animals= new ArrayList<>();
    private static int animalId= 1;

    public AnimalShelter() {}

    public AnimalShelter(List<Animal> animals) {
        this.animals = animals;
    }

    public void printAnimals(){
        animals.stream()
                .forEach(e -> System.out.println(e));
    }
    public void sortAnimals(){
        animals.stream()
                .map((Animal::getAnimalNumber))
                .sorted((p1,p2) ->p1.compareTo(p2))
                .forEach(e-> System.out.println(e));
    }
    public void sortAnimalsByName(){
        animals.stream()
                .map((Animal::getName))
                .sorted((p1,p2) ->p1.compareTo(p2))
                .forEach(e-> System.out.println(e));
    }
    public void sortAnimalsByAge(){
        animals.stream()
                .map((Animal::getAge))
                .sorted((p1,p2) ->p1.compareTo(p2))
                .forEach(e-> System.out.println(e));
    }
    public void printAnimalsNotVaccinated(Disease disease){
        animals.stream()
                .filter(e->e != getIsVaccinated())
                //.map((Animal::getIsVaccinated))
                .forEach(e-> System.out.println(e));
    }

//    public Animal findAnimal(int number){
//        return animals.stream()
//                .filter(e->e.equals(number))
//                .map(e-> e.getAnimalNumber())
//                .collect(Collectors.toList());
//
//    }
//    public Animal findAnimal(String name){
//        return animals.stream()
//                .filter(e->e.equals(name))
//                .map(e->e.getName())
//                .collect(Collectors.toList());
//    }

    public void treatAnimal(int animalNumber){
        animals.stream()
                .filter(e->e.equals(animalNumber))
                .forEach(System.out::println);
    }
    public void treatAnimal(String name){
        animals.stream()
                .filter(e->e.equals(name))
                .forEach(System.out::println);
    }
    public void treatAllAnimals(){
        animals.stream()
                .collect(Collectors.toList());
                //.forEach(e-> System.out.println(e));
    }

//    public Animal findOldestAnimal(){
//        return  animals.stream()
//                .sorted((p1,p2)->p2 -p1)
//                .collect(Collectors.toList());
//    }
//
//    public int countAnimals(){
//        animalId++;
//        return animals.stream()
//                .forEach(e->System.out.println(e));
//    }

    public static void addAnimal(Animal animal){
        animals.add(animal);
        animalId++;
        animals.stream()
                .distinct()
                .forEach(e-> System.out.println(e));
    }


    @Override
    public String toString() {
        return super.toString() + getAge() + getName();
    }
}
