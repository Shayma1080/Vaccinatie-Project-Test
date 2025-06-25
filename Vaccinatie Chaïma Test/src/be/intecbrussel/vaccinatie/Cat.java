package be.intecbrussel.vaccinatie;

public class Cat extends Animal{
    private boolean hasLongNails= false;

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void treatAnimal() {
        super.treatAnimal();
    }

    @Override
    public Boolean getClean() {
        return super.getClean();
    }

    @Override
    public String toString() {
        return " name= " + name +
                " age= " + age;
    }
}
