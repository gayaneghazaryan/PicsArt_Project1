package Comparator;

import Employee.HourlyRestaurantEmployee;

import java.util.Comparator;

public class WageRateComparator implements Comparator<HourlyRestaurantEmployee> {
    @Override
    public int compare(HourlyRestaurantEmployee o1, HourlyRestaurantEmployee o2) {
        return (int)(o1.getWageRate()-o2.getWageRate());
    }
}
