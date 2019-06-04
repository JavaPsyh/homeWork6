package tasks.clone.override;

import sun.reflect.Reflection;

import java.lang.reflect.Field;

public class Car implements Cloneable {

    private int quantityOfWheels;
    private String name;
    private String body;
    private String color;
    private Engine engine;

    public Car(int quantityOfWheels, String name, String body, String color, Engine engine) {
        this.quantityOfWheels = quantityOfWheels;
        this.name = name;
        this.body = body;
        this.color = color;
        this.engine = engine;
    }

    public int getQuantityOfWheels() {
        return quantityOfWheels;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "This car has " + this.getQuantityOfWheels() + " wheels" + "\n" +
                "its name is " + this.getName() + "\n" +
                "its body is " + this.getBody() + "\n" +
                "its color is " + this.getColor() + "\n" +
                "its engine named " + (this.getEngine() == null ?
                "Nothing! It is Car without engine." : this.getEngine());
    }


    @Override
    public Car clone() throws CloneNotSupportedException {
        return new Car(this.getQuantityOfWheels(),
                this.getName(), this.getBody(), this.getColor(),
                (this.getEngine() != null ?
                        new Engine(this.getEngine().getName(), this.getEngine().getEngineType()) :
                        this.getEngine()));
    }

    public static void main(String[] args) {
        Car car = new Car(4,
                "Tesla", "Hatchback", "red",
                new Engine("Tesla", "electric"));
        Car carClone = null;
        try {
            carClone = car.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(car);
        System.out.println();
        System.out.println(carClone);
        System.out.println();
        carClone.getEngine().setEngineType("diesel");
        System.out.println(car.getEngine());
        System.out.println();
        System.out.println(carClone.getEngine());
        System.out.println();
        System.out.println(car);
        System.out.println();
        System.out.println(carClone);
    }
}
