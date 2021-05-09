package Comparator;

import Employee.Bartender;

import java.util.Comparator;

public class SignatureDrinkComparator implements Comparator<Bartender> {
    @Override
    public int compare(Bartender o1, Bartender o2) {
        return o1.getSignatureDrink().compareTo(o2.getSignatureDrink());
    }
}
