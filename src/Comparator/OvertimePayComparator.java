package Comparator;

import Employee.SalariedRestaurantEmployee;

import java.util.Comparator;

public class OvertimePayComparator implements Comparator<SalariedRestaurantEmployee> {
    @Override
    public int compare(SalariedRestaurantEmployee o1, SalariedRestaurantEmployee o2) {
        return (int)(o1.getOvertimePay()-o2.getOvertimePay());
    }
}
