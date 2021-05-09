package Comparator;

import Employee.Bartender;

import java.util.Comparator;

public class ServingAlcoholComparator implements Comparator<Bartender> {
    @Override
    public int compare(Bartender o1, Bartender o2) {
        return Boolean.compare(o1.isServingAlcohol(),o2.isServingAlcohol());
    }
}
