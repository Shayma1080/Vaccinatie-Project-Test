package be.intecbrussel.vaccinatie;

import java.security.Key;
import java.util.*;
import java.util.Random;
public abstract class Animal implements Vaccinateable,Treatable{
    Random random = new Random();
    protected Map<Disease,Boolean> isVaccinated = new HashMap<>();
    protected Boolean isClean;
    protected String name;
    protected int age;
    protected int animalNumber;
    protected static int animalId = 1;
    List<Animal> animals= new ArrayList<>();

    public Animal() {}

    public Animal(String name,int age) {
        this.name=name;
        this.age=age;
        this.animalId= animalId;
    }


    @Override
    public void vaccinateAnimal(Disease d) {
        if(isVaccinated.getOrDefault(d,false)){ // wordt gebruikt bij Map, waarde opvragen met sleutel (key)
            System.out.println(name + " van " + age +" is gevaccineerd tegen " + d);
        }else{
            System.out.println("Is nog niet gevaccineerd!!!");
        }
    }

    public boolean isVaccinated(Disease d){
//        if(isVaccinated.containsKey(d) && isVaccinated.containsValue(true)){
//            return true;
//        }else{
//            return false;
//        }

        return isVaccinated.getOrDefault(d, false);// haal alle d uit als er niets in staat geef false terug
    }

    @Override
    public void treatAnimal() {
        this.isClean = true;
        System.out.println(name + " is behandelt");
    }

    public Map<Disease, Boolean> getIsVaccinated() {
        return isVaccinated;
    }

    public void setIsVaccinated(Map<Disease, Boolean> isVaccinated) {
        this.isVaccinated = isVaccinated;
    }

    public Boolean getClean() {
        return true;
    }

    public void setClean(Boolean clean) {
        isClean = clean;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnimalNumber() {
        return animalNumber;
    }

    public void setAnimalNumber(int animalNumber) {
        this.animalNumber = animalNumber;
    }

    public static int getAnimalId() {
        return animalId += animalId;
    }

    public static void setAnimalId(int animalId) {
        Animal.animalId = animalId;
    }

    @Override
    public String toString() {
        return  "isVaccinated=" + isVaccinated +
                ", isClean=" + isClean +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", animalNumber=" + animalNumber +
                ", animals=" + animals;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return  true;
        if (!(o instanceof Animal animal)) return false;
        return age == animal.age && animalNumber == animal.animalNumber && Objects.equals(isVaccinated, animal.isVaccinated) && Objects.equals(isClean, animal.isClean) && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isVaccinated, isClean, name, age, animalNumber);
    }
}
