package carpark;

/**
 * Purpose: The class is for defining and construct a parking slot object.
 * @author Lucas Qin
 * student id: 103527269
 * @version java version "17.0.2" 2022-01-18 LTS
 */
public class ParkingSlot {
    private String slot_id;
    private String occupation;
    private String slotType;
    private Car car;


    public ParkingSlot(String slot_id, String occupation, String slotType, Car car) {
        this.slot_id = slot_id;
        this.occupation = occupation;
        this.slotType = slotType;
        this.car = car;
    }

    public String getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(String slot_id) {
        this.slot_id = slot_id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "The ParkingSlot you are operating is: " +
                "slot_id:'" + slot_id + '\'' +
                ", occupation:'" + occupation + '\'' +
                ", slotType:'" + slotType + '\'' +
                ", car:" + car +
                '}';
    }
}
