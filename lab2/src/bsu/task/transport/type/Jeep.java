package bsu.task.transport.type;

import bsu.task.transport.Car;

public class Jeep extends Car {
    private double maxLoadCapacity;

    public Jeep() {
    }

    public Jeep(double averageFuelConsumption, double price, double maxSpeed, String model, double maxLoadCapacity) {
        super(averageFuelConsumption, price, maxSpeed, model);
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public double getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public void setMaxLoadCapacity(double maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
    }

    @Override
    public String toString() {
        return "Jeep{" +
                "maxLoadCapacity=" + maxLoadCapacity +
                ", averageFuelConsumption=" + getAverageFuelConsumption() +
                ", price=" + getPrice() +
                ", maxSpeed=" + getMaxSpeed() +
                ", model='" + getModel() + '\'' +
                '}';
    }
}
