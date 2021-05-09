package Employee;

import Exception.*;

import java.util.Objects;

public class Bartender extends HourlyRestaurantEmployee {
    private int numberOfServedClients;
    private boolean servingAlcohol;
    private String signatureDrink;

    public Bartender() {
        super();
    }

    public Bartender(String name, String surname, int age, char gender, double experience, String hireDate) {
        super(name, surname, age, gender, experience, hireDate);
    }

    public Bartender(String bartenderInfo) {
        //name,surname,age,gender,experience,hire Date, wage rate, worked hours, number of ServedClients, servedAlcohol, signature drink
        if(!bartenderInfo.matches("\\w+,\\w+,\\d+,\\w+,\\d+,\\d+/\\d+/\\d+,([0-9]*[.])?[0-9]+,([0-9]*[.])?[0-9]+,\\d+,\\w+,((\\w+)|(\\w+( +\\w+)))")) {
            throw new InfoFormatException();
        }
        String[] info = bartenderInfo.split(",");
        setName(info[0]);
        setSurname(info[1]);
        setAge(Integer.parseInt(info[2]));
        setGender(info[3].charAt(0));
        setExperience(Integer.parseInt(info[4]));
        setHireDate(info[5]);
        setWageRate(Double.parseDouble(info[6]));
        setWorkedHours(Double.parseDouble(info[7]));
        setNumberOfServedClients(Integer.parseInt(info[8]));
        setServingAlcohol(info[9].equalsIgnoreCase("yes"));
        setSignatureDrink(info[10]);
    }
    public int getNumberOfServedClients() {
        return numberOfServedClients;
    }

    public void setNumberOfServedClients(int numberOfServedClients) {
        if(numberOfServedClients < 0) {
            throw new NumberOfServedClientsAndTablesException();
        }
        this.numberOfServedClients = numberOfServedClients;
    }

    public boolean isServingAlcohol() {
        return servingAlcohol;
    }

    public void setServingAlcohol(boolean servingAlcohol) {
        this.servingAlcohol = servingAlcohol;
    }

    public String getSignatureDrink() {
        return signatureDrink;
    }

    public void setSignatureDrink(String signatureDrink) {
        if(signatureDrink == null || signatureDrink.length() == 0) {
            throw new SignatureDrinkException();
        }
        this.signatureDrink = signatureDrink;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder("Bartender: ");
        stb.append(printGeneralInfo());
        stb.append(String.format("\nnumber of served clients: %d,\nIs serving alcohol: %s,\nSignature Drink: %s",numberOfServedClients,servingAlcohol?"Yes":"No",signatureDrink));
        return stb.toString();
    }

    public Bartender clone() {
        try {
            Bartender copy = (Bartender) super.clone();
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
        Bartender bartender = (Bartender) o;
        return super.equals(o) && numberOfServedClients == bartender.numberOfServedClients && servingAlcohol == bartender.servingAlcohol && Objects.equals(signatureDrink, bartender.signatureDrink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfServedClients, servingAlcohol, signatureDrink);
    }
}
