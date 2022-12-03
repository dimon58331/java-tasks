package bsu.task.transport.type;

import bsu.task.transport.Car;

public class PublicTransport extends Car {
    private int amountPassengerPlace;

    public PublicTransport(double averageFuelConsumption, double price, double maxSpeed, String model
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
        return "PublicTransport{" +
                "amountPassengerPlace=" + amountPassengerPlace +
                ", averageFuelConsumption=" + averageFuelConsumption +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
