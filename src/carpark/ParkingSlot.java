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

    /**
     * This is a constructor with no variable
     */
    public ParkingSlot() {
    }

    /**
     * This is a constructor with variables for ParkingSlot class
     * @param slot_id  slot's id
     * @param occupation  slot's occupation status
     * @param slotType slot's type
     * @param car car object
     */
    public ParkingSlot(String slot_id, String occupation, String slotType, Car car) {
        this.slot_id = slot_id;
        this.occupation = occupation;
        this.slotType = slotType;
        this.car = car;
    }

    /**
     * This is a getter method for getting slot id
     * @return a String type slot_id
     */
    public String getSlot_id() {
        return slot_id;
    }

    /**
     * This is a setter method for setting slot id
     * @param slot_id slot's id
     */
    public void setSlot_id(String slot_id) {
        this.slot_id = slot_id;
    }

    /**
     * This is a getter method for getting occupation status
     * @return a String type occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * This is a setter method for setting occupation status
     * @param occupation slot's occupation status
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * This is a getter method for getting slot type
     * @return a String type slotType
     */
    public String getSlotType() {
        return slotType;
    }

    /**
     * This is a setter method for setting a slot type
     * @param slotType slot's type
     */
    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    /**
     * This is a getter method for getting Car object
     * @return a Car type car object
     */
    public Car getCar() {
        return car;
    }

    /**
     * This is a setter method for setting a car object
     * @param car car object
     */
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
