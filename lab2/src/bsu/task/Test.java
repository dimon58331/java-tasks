package bsu.task;

import bsu.task.rate.Rate;
import bsu.task.factorytaxicompany.FactoryTaxiCompany;
import bsu.task.yandex.taxi.company.YandexTaxiCompany;

public class Test {
    public static void main(String[] args) {
        FactoryTaxiCompany yandexTaxi = new YandexTaxiCompany();
        System.out.println("Information about order: " + yandexTaxi.orderTaxi(Rate.BUSINESS));
        System.out.println("Information about rate park: " + yandexTaxi.getRatePark());
        System.out.println("Information about total price of auto park: " + yandexTaxi.calculateAutoParkPrise());

        System.out.println("Sorted cars by average fuel consumption from lower to upper: " + yandexTaxi.getSortCarsByAverageFuelConsumptionLowerToUpper());
    }
}
