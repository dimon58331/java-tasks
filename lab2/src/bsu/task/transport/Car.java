package bsu.task.transport;

public abstract class Car implements Comparable<Car>{
    private double averageFuelConsumption;
    private double price;
    private double maxSpeed;
    private String model;

    protected Car(){
    }

    protected Car(double averageFuelConsumption, double price, double maxSpeed, String model) {
        this.averageFuelConsumption = averageFuelConsumption;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public double getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    public double getPrice() {
        return price;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setAverageFuelConsumption(double averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public int compareTo(Car o) {
        double result = (this.getAverageFuelConsumption() - o.getAverageFuelConsumption());
        if (result < 1 && result > 0){
            return 1;
        } else if (result < 0) {
            return -1;
        }

        return (int)result;
    }
}
