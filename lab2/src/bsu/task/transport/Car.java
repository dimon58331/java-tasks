package bsu.task.transport;

public abstract class Car {
    protected double averageFuelConsumption;
    protected double price;
    protected double maxSpeed;

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setAverageFuelConsumption(double averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car=" + this.getClass().getSimpleName() +
                ", averageFuelConsumption=" + averageFuelConsumption +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}' + '\n';
    }
}
