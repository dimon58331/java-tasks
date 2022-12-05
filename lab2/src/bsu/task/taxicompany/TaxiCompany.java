package bsu.task.taxicompany;

import bsu.task.rate.Rate;
import bsu.task.transport.Car;
import bsu.task.transport.type.Sedan;

import java.util.*;

public class TaxiCompany {
    private Map<Rate, ArrayList<Car>> ratePark;

    public TaxiCompany() {

        ratePark = new HashMap<>();

        ArrayList<Car> businessCars = new ArrayList<>();
        Collections.addAll(businessCars, new Sedan(17, 70000, 360, "MERCEDES-BENZ W222"
                , true));
        ratePark.put(Rate.BUSINESS, businessCars);

        ArrayList<Car> economyCars = new ArrayList<>();
        Collections.addAll(economyCars, new Sedan(7, 10000, 180
                , "RENO LOGAN", false));
        ratePark.put(Rate.ECONOMY, economyCars);

        ArrayList<Car> standardCars = new ArrayList<>();
        Collections.addAll(standardCars, new Sedan(11, 18000, 240
                , "VOLKSWAGEN POLO", true));
        ratePark.put(Rate.STANDARD, standardCars);
    }

    public List<Car> getSortCarsByAverageFuelConsumptionLowerToUpper(){
        List<Car> carsSortedByAverageFuelConsumptionLowerToUpper = new ArrayList<>();

        for (Map.Entry<Rate, ArrayList<Car>> entry : ratePark.entrySet()) {
            carsSortedByAverageFuelConsumptionLowerToUpper.addAll(entry.getValue());
        }

        Collections.sort(carsSortedByAverageFuelConsumptionLowerToUpper);

        return carsSortedByAverageFuelConsumptionLowerToUpper;
    }

    public double calculateAutoParkPrise() {
        double autoParkPrice = 0;
        for (Map.Entry<Rate, ArrayList<Car>> entry : ratePark.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++){
                autoParkPrice += entry.getValue().get(i).getPrice();
            }
        }
        return autoParkPrice;
    }

    private Car giveCar(Rate rate) {
        return ratePark.get(rate).get(0);
    }

    public Car orderTaxi(Rate rate){
        return giveCar(rate);
    }

    public Map<Rate, ArrayList<Car>> getRatePark() {
        return ratePark;
    }

    public void setRatePark(Map<Rate, ArrayList<Car>> ratePark) {
        this.ratePark = ratePark;
    }
}
