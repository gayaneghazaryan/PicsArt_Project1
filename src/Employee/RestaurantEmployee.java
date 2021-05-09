package Employee;

import Exception.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;


public abstract class RestaurantEmployee {

    public class HireDate implements Comparable<HireDate>, Cloneable{
        Calendar calendar = Calendar.getInstance();

        public HireDate(String stringHireDate) {
            if(!stringHireDate.matches("\\d+/\\d+/\\d+")) {
               throw new InfoFormatException();
            }
            int day = Integer.parseInt(stringHireDate.substring(0,stringHireDate.indexOf("/")));
            int monthStart = stringHireDate.indexOf("/")+1;
            int monthEnd = stringHireDate.indexOf("/",monthStart+1);
            int month = Integer.parseInt(stringHireDate.substring(monthStart, monthEnd));
            int year = Integer.parseInt(stringHireDate.substring(monthEnd+1));
            calendar.set(year, month -1,day-1);
        }
        public HireDate() {
        }


        @Override
        public String toString() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.format(calendar.getTime());
        }

        @Override
        public int compareTo(HireDate o) {
            return calendar.compareTo(o.calendar);
        }
        public HireDate clone() {
            try {
                return (HireDate) super.clone();
            } catch(CloneNotSupportedException e) {
                return null;
            }
        }

    }

    private String name = "Name";
    private String surname = "Surname";
    private int age = 18;
    private char gender = 'f';
    private double experience = 0; //in years
    private HireDate hireDate = new HireDate();

    public RestaurantEmployee() {
    }

    public RestaurantEmployee(String name,String surname, int age, char gender, double experience, String stringHireDate) {
        setName(name);
        setSurname(surname);
        setAge(age);
        setGender(gender);
        setExperience(experience);
        setHireDate(stringHireDate);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.length() == 0) {
            throw new NameException();
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(surname == null || surname.length() == 0) {
            throw new NameException();
        }
        this.surname = surname;
    }

    public String getFullName() {
        return String.format("%s %s",name,surname);
    }

    public void setFullName(String fullName) {
        if(!fullName.matches(".*( +.*)")) {
            throw new InfoFormatException();
        }
        setName(fullName.substring(0,fullName.indexOf(" ")));
        setSurname(fullName.substring(fullName.indexOf(" ")));
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if(gender == 'm' || gender == 'f') {
            this.gender = gender;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 16) {
            throw new AgeException();
        }
        this.age = age;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        if(experience < 0) {
            throw new ExperienceException();
        }
        this.experience = experience;
    }

    public HireDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(String stringHireDate) {
        if(stringHireDate != null && stringHireDate.length() > 0) {
            this.hireDate = new HireDate(stringHireDate);
        }
    }

    public void setHireDate(HireDate hireDate) {
        if(hireDate != null) {
            this.hireDate = hireDate;
        }
    }

    public abstract double getMonthlyPay();

    public String printGeneralInfo() {
        String genderString = gender == 'f'? "Female":"Male";
        String experienceString = experience == 1? "1 year": experience + " years";
        return String.format("\nName: %s,\nSurname: %s,\nAge: %d,\nGender: %s,\nExperience: %s,\nHire date: %s",name,surname,age,genderString,experienceString,hireDate);
    }
    @Override
    public String toString() {
        return "Hotel Employee: " + printGeneralInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RestaurantEmployee that = (RestaurantEmployee) o;
        return age == that.age && gender == that.gender && Double.compare(that.experience, experience) == 0 && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(hireDate, that.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, gender, experience, hireDate);
    }
}
