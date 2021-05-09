package Employee;

import Exception.*;

import java.util.Objects;

public class Chef extends SalariedRestaurantEmployee implements Cloneable{
    private int starsOfMichelin = 0;
    private String specialization = "Prep";
    private String cuisine = "Armenian";


    public Chef() {
        super();
    }

    public Chef(String name,String surname, int age, char gender, double experience, String hireDate) {
        super(name,surname, age, gender, experience, hireDate);
    }

    public Chef(String chefInfo) {
        //name,surname,age,gender,experience,hire Date, salary, overtime pay, overtime hours, stars of Michelin, specialization,cuisine
        if(!chefInfo.matches("\\w+,\\w+,\\d+,\\w+,\\d+,\\d+/\\d+/\\d+,([0-9]*[.])?[0-9]+,([0-9]*[.])?[0-9]+,([0-9]*[.])?[0-9]+,\\d+,\\w+,\\w+")) {
            throw new InfoFormatException();
        }
        String[] info = chefInfo.split(",");
        setName(info[0]);
        setSurname(info[1]);
        setAge(Integer.parseInt(info[2]));
        setGender(info[3].charAt(0));
        setExperience(Integer.parseInt(info[4]));
        setHireDate(info[5]);
        setSalary(Double.parseDouble(info[6]));
        setOvertimePayRate(Double.parseDouble(info[7]));
        setOvertimeHours(Double.parseDouble(info[8]));
        setStarsOfMichelin(Integer.parseInt(info[9]));
        setSpecialization(info[10]);
        setCuisine(info[11]);
    }

    public int getStarsOfMichelin() {
        return starsOfMichelin;
    }

    public void setStarsOfMichelin(int starsOfMichelin) {
        if(starsOfMichelin < 0 || starsOfMichelin > 3) {
            throw new MichelinStarsException();
        }
        this.starsOfMichelin = starsOfMichelin;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if(specialization == null || specialization.length() == 0) {
            throw new SpecializationException();
        }
        this.specialization = specialization;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        if(cuisine == null || cuisine.length() == 0) {
            throw new CuisineException();
        }
        this.cuisine = cuisine;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder("Chef: ");
        stb.append(printGeneralInfo());
        stb.append(String.format("\nstars of Michelin: %d,\nspecialization: %s,\ncuisine: %s",starsOfMichelin,specialization,cuisine));
        return stb.toString();
    }

    public Chef clone() {
        try {
            Chef copy = (Chef) super.clone();
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
        Chef chef = (Chef) o;
        return super.equals(o) && starsOfMichelin == chef.starsOfMichelin && Objects.equals(specialization, chef.specialization) && Objects.equals(cuisine, chef.cuisine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), starsOfMichelin, specialization, cuisine);
    }
}
