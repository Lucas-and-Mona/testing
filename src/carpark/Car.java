package carpark;
/**
 * Purpose: The class is for defining and construct a car object.
 * @author Lucas Qin
 * student id: 103527269
 * @version java version "17.0.2" 2022-01-18 LTS
 */
public class Car {
    private String registrationNumber;
    private String owner;
    private String ownerType;

    /**
     * A constructor with no variable
     */
    public Car() {}

    /**
     * A constructor with variables for Car class
     * @param carNumber
     * @param owner_name
     * @param owner_Type
     */
    public Car(String carNumber, String owner_name, String owner_Type){
        registrationNumber =carNumber;
        owner = owner_name;
        ownerType = owner_Type;
    }

    /**
     * Getter method for getting registration number
     * @return String
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Setter method for setting registration number
     * @param registrationNumber
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * Getter method for getting owner's name
     * @return String
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Setter method for setting owner name
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Getter method for getting owner type
     * @return String
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * Setter method for setting owner type
     * @param ownerType
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    /**
     * toString method for Car class
     * @return String
     */
    @Override
    public String toString() {
        return
                " registrationNumber: '" + registrationNumber + '\'' +
                ", owner: '" + owner + '\'' +
                ", ownerType: '" + ownerType + '\'' +
                '.';
    }
}
