package Employee;

import Exception.*;

import java.util.Objects;

public abstract class HourlyRestaurantEmployee extends RestaurantEmployee {
    private double wageRate = 0;
    private double workedHours = 0; //per month

    public HourlyRestaurantEmployee() {
        super();
    }

    public HourlyRestaurantEmployee(String name, String surname, int age, char gender, double experience, String hireDate) {
        super(name, surname, age, gender, experience, hireDate);
    }

    @Override
    public double getMonthlyPay() {
        return wageRate * workedHours;
    }

    public double getWageRate() {
        return wageRate;
    }

    public void setWageRate(double wageRate) {
        if(wageRate < 0) {
            throw new PayException();
        }
        this.wageRate = wageRate;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(double workedHours) {
        if(workedHours < 0) {
            throw new WorkedHoursException();
        }
        this.workedHours = workedHours;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder("Hourly Hotel Employee: ");
        stb.append(printGeneralInfo());
        stb.append(String.format("name: %s,\nage: %d\nexperience: %s,\nhire date: %s,\nwage: %d,\nhours: %d",getFullName(),getAge(),getExperience(),getHireDate(), wageRate, workedHours));
        return stb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HourlyRestaurantEmployee that = (HourlyRestaurantEmployee) o;
        return super.equals(o) && Double.compare(that.wageRate, wageRate) == 0 && Double.compare(that.workedHours, workedHours) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wageRate, workedHours);
    }
}
