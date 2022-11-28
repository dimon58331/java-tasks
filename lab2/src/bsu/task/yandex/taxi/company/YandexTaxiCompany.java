package bsu.task.yandex.taxi.company;

import bsu.task.rate.Rate;
import bsu.task.factorytaxicompany.FactoryTaxiCompany;
import bsu.task.transport.Car;
import bsu.task.yandex.taxi.cars.MercedesBenzW222;
import bsu.task.yandex.taxi.cars.RenoLogan;
import bsu.task.yandex.taxi.cars.VolkswagenPolo;

import java.util.*;

public class YandexTaxiCompany extends FactoryTaxiCompany {

    public YandexTaxiCompany() {

        ratePark = new HashMap<>();

        ArrayList<Car> renoLogan = new ArrayList<>();
        Collections.addAll(renoLogan, new RenoLogan());
        ratePark.put(Rate.ECONOMY, renoLogan);

        ArrayList<Car> volkswagenPolo = new ArrayList<>();
        Collections.addAll(volkswagenPolo, new VolkswagenPolo());
        ratePark.put(Rate.STANDARD, volkswagenPolo);

        ArrayList<Car> mercedesBenzW222 = new ArrayList<>();
        Collections.addAll(mercedesBenzW222, new MercedesBenzW222());
        ratePark.put(Rate.BUSINESS, mercedesBenzW222);
    }


    @Override
    public List<Car> sortCarsByAverageFuelConsumptionLowerToUpper() {
        List<Car> carsSortedByAverageFuelConsumptionLowerToUpper = new ArrayList<>();

        for (Map.Entry<Rate, ArrayList<Car>> entry : ratePark.entrySet()) {
            carsSortedByAverageFuelConsumptionLowerToUpper.addAll(entry.getValue());
        }

        Collections.sort(carsSortedByAverageFuelConsumptionLowerToUpper);

        return carsSortedByAverageFuelConsumptionLowerToUpper;
    }

    @Override
    protected Car giveCar(Rate rate) {
        return ratePark.get(rate).get(0);
    }

    @Override
    public double calculateAutoParkPrise() {
        double autoParkPrice = 0;
        for (Map.Entry<Rate, ArrayList<Car>> entry : ratePark.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++){
                autoParkPrice += entry.getValue().get(i).getPrice();
            }
        }
        return autoParkPrice;
    }
}
