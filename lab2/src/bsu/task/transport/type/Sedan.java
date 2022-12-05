package bsu.task.transport.type;

import bsu.task.transport.Car;

public class Sedan extends Car {
    private boolean childSeat;

    public Sedan(){
    }
    
    public Sedan(double averageFuelConsumption, double price, double maxSpeed, String model, boolean childSeat) {
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
        return "Sedan{" +
                "childSeat=" + childSeat +
                ", averageFuelConsumption=" + getAverageFuelConsumption() +
                ", price=" + getPrice() +
                ", maxSpeed=" + getMaxSpeed() +
                ", model='" + getModel() + '\'' +
                '}';
    }
}
