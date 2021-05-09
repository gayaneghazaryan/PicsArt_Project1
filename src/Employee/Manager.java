package Employee;

import Exception.*;

import java.util.Objects;

public class Manager extends SalariedRestaurantEmployee implements Cloneable {
    private String role = "executive";
    private int numberOfWorkersUnderSupervision = 0;

    public Manager() {
        super();
    }

    public Manager(String name, String surname, int age, char gender, double experience, String hireDate) {
        super(name, surname, age, gender, experience, hireDate);
    }

    public Manager(String managerInfo) {
        //name,surname,age,gender,experience,hire Date, salary, overtime pay, overtime hours, specialization,number of workers under supervision
        if(!managerInfo.matches("\\w+,\\w+,\\d+,\\w+,\\d+,\\d+/\\d+/\\d+,([0-9]*[.])?[0-9]+,([0-9]*[.])?[0-9]+,([0-9]*[.])?[0-9]+,\\w+,\\d+")) {
            throw new InfoFormatException();
        }
        String[] info = managerInfo.split(",");
        setName(info[0]);
        setSurname(info[1]);
        setAge(Integer.parseInt(info[2]));
        setGender(info[3].charAt(0));
        setExperience(Integer.parseInt(info[4]));
        setHireDate(info[5]);
        setSalary(Double.parseDouble(info[6]));
        setOvertimePayRate(Double.parseDouble(info[7]));
        setOvertimeHours(Double.parseDouble(info[8]));
        setRole(info[9]);
        setNumberOfWorkersUnderSupervision(Integer.parseInt(info[10]));
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if(role == null || role.length() == 0) {
            throw new RoleException();
        }
        this.role = role;
    }

    public int getNumberOfWorkersUnderSupervision() {
        return numberOfWorkersUnderSupervision;
    }

    public void setNumberOfWorkersUnderSupervision(int numberOfWorkersUnderSupervision) {
        if(numberOfWorkersUnderSupervision < 0) {
            throw new NumberOfWorkersException();
        }
        this.numberOfWorkersUnderSupervision = numberOfWorkersUnderSupervision;
    }

    @Override
    public String toString() {
        StringBuilder sbd = new StringBuilder("Manager ");
        sbd.append(printGeneralInfo());
        sbd.append(String.format("\nrole: %s,\nnumber of workers under supervision: %d\n", role,numberOfWorkersUnderSupervision));
        return sbd.toString();
    }

    public Manager clone() {
        try {
            Manager copy = (Manager) super.clone();
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
        Manager manager = (Manager) o;
        return super.equals(o) && numberOfWorkersUnderSupervision == manager.numberOfWorkersUnderSupervision && Objects.equals(role, manager.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, numberOfWorkersUnderSupervision);
    }
}
