package Employee;

import Exception.*;

import java.util.Objects;

public class Waiter extends HourlyRestaurantEmployee implements Cloneable{
    private double tips = 0;
    private int numberOfServedTables = 0;

    public Waiter() {
        super();
    }

    public Waiter(String name, String surname, int age, char gender, double experience, String hireDate) {
        super(name, surname, age, gender, experience, hireDate);
    }

    public Waiter(String waitressInfo) {
        //name,surname,age,gender,experience,hire Date, wage rate, worked hours, tips, number of served tables
        if(!waitressInfo.matches("\\w+,\\w+,\\d+,\\w+,\\d+,\\d+/\\d+/\\d+,([0-9]*[.])?[0-9]+,([0-9]*[.])?[0-9]+,([0-9]*[.])?[0-9]+,\\d+")) {
            throw new InfoFormatException();
        }
        String[] info = waitressInfo.split(",");
        setName(info[0]);
        setSurname(info[1]);
        setAge(Integer.parseInt(info[2]));
        setGender(info[3].charAt(0));
        setExperience(Integer.parseInt(info[4]));
        setHireDate(info[5]);
        setWageRate(Double.parseDouble(info[6]));
        setWorkedHours(Double.parseDouble(info[7]));
        setTips(Double.parseDouble(info[8]));
        setNumberOfServedTables(Integer.parseInt(info[9]));
    }

    public double getTips() {
        return tips;
    }

    public void setTips(double tips) {
        if(tips < 0) {
            throw new PayException();
        }
        this.tips = tips;
    }

    public int getNumberOfServedTables() {
        return numberOfServedTables;
    }

    public void setNumberOfServedTables(int numberOfServedTables) {
        if(numberOfServedTables < 0) {
            throw new NumberOfServedClientsAndTablesException();
        }
        this.numberOfServedTables = numberOfServedTables;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder("Waiter: ");
        stb.append(printGeneralInfo());
        stb.append(String.format("\ntips: %.2f,\nnumber of served tables: %d",tips,numberOfServedTables));
        return stb.toString();
    }

    public Waiter clone() {
        try {
            Waiter copy = (Waiter) super.clone();
            copy.setHireDate(getHireDate().clone());
            return copy;
        } catch(CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Waiter waiter = (Waiter) o;
        return super.equals(o) && Double.compare(waiter.tips, tips) == 0 && numberOfServedTables == waiter.numberOfServedTables;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tips, numberOfServedTables);
    }
}
