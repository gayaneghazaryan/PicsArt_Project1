package Employee;

import Exception.*;

import java.util.Objects;

public abstract class SalariedRestaurantEmployee extends RestaurantEmployee {
    private double salary = 0; //per year
    private double overtimeHours = 0; //per month
    private double overtimePayRate = 0;

    public SalariedRestaurantEmployee() {
        super();
    }

    public SalariedRestaurantEmployee(String name, String surname, int age, char gender, double experience, String hireDate) {
        super(name, surname, age, gender,experience, hireDate);
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary < 0) {
            throw new PayException();
        }
        this.salary = salary;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        if(overtimeHours < 0) {
            throw new WorkedHoursException();
        }
        this.overtimeHours = overtimeHours;
    }

    public double getOvertimePayRate() {
        return overtimePayRate;
    }

    public void setOvertimePayRate(double overtimePayRate) {
        if(overtimePayRate < 0) {
            throw new PayException();
        }
        this.overtimePayRate = overtimePayRate;
    }

    @Override
    public double getMonthlyPay() {
        return salary/12 + getOvertimePay();
    }

    public double getOvertimePay() {
        return overtimePayRate * overtimeHours;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder("Salaried Restaurant Employee: ");
        stb.append(printGeneralInfo());
        stb.append(String.format("\nsalary: %.2f,\novertime hours %.2f,\novertime pay rate: %.2f",salary,overtimeHours, overtimePayRate));
        return stb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SalariedRestaurantEmployee that = (SalariedRestaurantEmployee) o;
        return super.equals(o) && Double.compare(that.salary, salary) == 0 && Double.compare(that.overtimeHours, overtimeHours) == 0 && Double.compare(that.overtimePayRate, overtimePayRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, overtimeHours, overtimePayRate);
    }
}
