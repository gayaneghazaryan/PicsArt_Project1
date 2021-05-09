package Comparator;

import Employee.Chef;

import java.util.Comparator;

public class MichelinStarsComparator implements Comparator<Chef> {
    @Override
    public int compare(Chef o1, Chef o2) {
        return o1.getStarsOfMichelin() - o2.getStarsOfMichelin();
    }
}
