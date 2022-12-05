package bsu.task.transport.type;

import bsu.task.transport.Car;

public class Bus extends Car {
    private int amountPassengerPlace;

    public Bus() {
    }

    public Bus(double averageFuelConsumption, double price, double maxSpeed, String model
            , int amountPassengerPlace) {
        super(averageFuelConsumption, price, maxSpeed, model);
        this.amountPassengerPlace = amountPassengerPlace;
    }

    public int getAmountPassengerPlace() {
        return amountPassengerPlace;
    }

    public void setAmountPassengerPlace(int amountPassengerPlace) {
        this.amountPassengerPlace = amountPassengerPlace;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "amountPassengerPlace=" + amountPassengerPlace +
                ", averageFuelConsumption=" + getAverageFuelConsumption() +
                ", price=" + getPrice() +
                ", maxSpeed=" + getMaxSpeed() +
                ", model='" + getModel() + '\'' +
                '}';
    }
}
