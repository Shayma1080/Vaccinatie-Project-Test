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
                .sorted(Comparator.comparingInt(Animal::getAge))
                .forEach(e-> System.out.println(e));
    }
    public void printAnimalsNotVaccinated(Disease disease){
        animals.stream()
                .filter(e-> !e.isVaccinated(disease))
                //.map((Animal::getIsVaccinated))
                .forEach(System.out::println);
    }

    public Animal findAnimal(int number){
        return animals.stream()
                .filter(e->e.getAnimalNumber() == number)
                .findFirst()
                .orElse(null); // null als lijst leeg is, gebruikt bij zoek of vergelijksoperaties

    }
    public Animal findAnimal(String name){
        return animals.stream()
                .filter(e->e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

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
                .forEach(Animal::treatAnimal);
    }

    public Animal findOldestAnimal(){
        return  animals.stream()
                .max(Comparator.comparingInt(Animal::getAge))
                .orElse(null);
    }

    public int countAnimals(){

        return (int)animals.stream()
                .count();
    }

    public static void addAnimal(Animal animal){
        animals.add(animal);
        animalId++;
    }


    @Override
    public String toString() {
        return super.toString() + getAge() + getName();
    }
}
