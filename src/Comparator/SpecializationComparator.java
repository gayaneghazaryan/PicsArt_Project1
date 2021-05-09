package Comparator;

import Employee.Chef;

import java.util.Comparator;

public class SpecializationComparator implements Comparator<Chef> {
    @Override
    public int compare(Chef o1, Chef o2) {
        return o1.getSpecialization().compareTo(o2.getSpecialization());
    }
}
