package bsu.task.factorytaxicompany;

import bsu.task.rate.Rate;
import bsu.task.transport.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class FactoryTaxiCompany {
    protected Map<Rate, ArrayList<Car>> ratePark;
    public Car orderTaxi(Rate rate){
        return giveCar(rate);
    }

    public abstract List<Car> sortCarsByAverageFuelConsumptionLowerToUpper();

    protected abstract Car giveCar(Rate rate);

    public abstract double calculateAutoParkPrise();

    public Map<Rate, ArrayList<Car>> getRatePark() {
        return ratePark;
    }

    public void setRatePark(Map<Rate, ArrayList<Car>> ratePark) {
        this.ratePark = ratePark;
    }
}
