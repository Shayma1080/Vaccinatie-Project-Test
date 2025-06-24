package be.intecbrussel.vaccinatie;

import java.security.Key;
import java.util.*;

public abstract class Animal implements Vaccinateable,Treatable{
    protected Map<Disease,Boolean> isVaccinated = new HashMap<>();
    protected Boolean isClean;
    protected String name;
    protected int age;
    protected int animalNumber;
    protected static int animalId = 1;
    List<Animal> animals= new ArrayList<>();

    public Animal() {}

    public Animal(String name,int age) {
        getName();
        getAge();
    }


    @Override
    public void vaccinateAnimal(Disease d) {
//        for(Disease vaccin : isVaccinated.keySet()){
//            animalId++;
//            System.out.println("Is gevaccineerd van : " + vaccin);
//        }

        if(isVaccinated.containsKey(d)){
            System.out.println(getName() + " van " + getAge() +" is gevaccineerd van " + d);
        }else{
            System.out.println("Is nog niet gevaccineerd!!!");
        }
    }

    public boolean isVaccinated(Disease d){
        if(isVaccinated.containsKey(d)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void treatAnimal() {
        for(Animal animal : animals){
            isClean = true;
            System.out.println("Krijgen geen treatment");
        }
    }

    public Map<Disease, Boolean> getIsVaccinated() {
        return isVaccinated;
    }

    public void setIsVaccinated(Map<Disease, Boolean> isVaccinated) {
        this.isVaccinated = isVaccinated;
    }

    public Boolean getClean() {
        return isClean;
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
        return animalId;
    }

    public static void setAnimalId(int animalId) {
        Animal.animalId = animalId;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "isVaccinated=" + isVaccinated +
                ", isClean=" + isClean +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", animalNumber=" + animalNumber +
                '}';
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
