package bsu.task.transport.type;

import bsu.task.transport.Car;

public class PersonalCar extends Car {
    private boolean childSeat;

    public PersonalCar(double averageFuelConsumption, double price, double maxSpeed, String model, boolean childSeat) {
        super(averageFuelConsumption, price, maxSpeed, model);
        this.childSeat = childSeat;
    }

    public boolean isChildSeat() {
        return childSeat;
    }

    public void setChildSeat(boolean childSeat) {
        this.childSeat = childSeat;
    }

    @Override
    public String toString() {
        return "PersonalCar{" +
                "childSeat=" + childSeat +
                ", averageFuelConsumption=" + averageFuelConsumption +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                ", model='" + model + '\'' +
                '}';
    }
}
