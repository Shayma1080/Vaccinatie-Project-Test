package be.intecbrussel.vaccinatie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class VaccinateApp {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.addAnimal(new Cat("Minoes", 4));
        shelter.addAnimal(new Dog("Bello", 6));
        shelter.addAnimal(new Monkey("George", 10));

        //shelter.vaccinateAnimal(Disease.CHICKENPOCKS);
        System.out.println("Behandelt alle dieren: ");
        shelter.treatAllAnimals(); // behandelt alle dieren
        System.out.println("Sorteer dieren op leeftijd: ");
        shelter.sortAnimalsByAge(); // sorteert op leeftijd
        System.out.println(" Aantal dieren niet gevaccineerd tegen ziekte: ");
        shelter.printAnimalsNotVaccinated(Disease.CHICKENPOCKS);// toont nietgevaccineerde dieren
        System.out.println("Welke dier wordt behandelt? ");
        shelter.treatAnimal("Bello");// behandelt specifiek dier op naam

        Animal oudste = shelter.findOldestAnimal(); // zoekt oudste dier
        System.out.println("Oudste dier: " + oudste);
        System.out.println("Aantal dieren in het asiel: " + shelter.countAnimals());



    }
}
