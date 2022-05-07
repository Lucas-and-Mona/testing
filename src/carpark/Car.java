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

    public Car(String carNumber, String owner_name, String owner_Type){
        registrationNumber =carNumber;
        owner = owner_name;
        ownerType = owner_Type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    @Override
    public String toString() {
        return "The car you search: " +
                "registrationNumber: '" + registrationNumber + '\'' +
                ", owner: '" + owner + '\'' +
                ", ownerType: '" + ownerType + '\'' +
                '.';
    }
}
