package Udemy.CompleteJavaMastercalss.OOP2;

public class Animal
{
    private String name;
    private int brain;
    private int body;
    private int size;
    private int weight;

    public void move(int speed){
        System.out.println("Animal.move("+speed+")");
    }
    public void eat(){
        System.out.println("This is eat method in class Animalc");
    }

    public Animal(String name, int brain, int body, int size, int weight) {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getBrain() {
        return brain;
    }

    public int getBody() {
        return body;
    }

    public int getSize() {
        return size;
    }

    public int getWeigth() {
        return weight;
    }
}
