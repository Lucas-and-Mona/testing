package carpark;
/**
 * Purpose: The class is for defining and construct a car object.
 * @author Lucas Qin
 * student id: 103527269
 * @version java version "17.0.2" 2022-01-18 LTS
 */
import java.util.ArrayList;

public class CarPark {
    //Array list for storing parking slots
    private  static ArrayList<ParkingSlot> parkingSlots= new ArrayList<>();

    /**
     * THis is a method that loop over the arraylist and find the slot that search for
     * @param slotId
     * @param slotForTest
     * @return
     */
    public static ParkingSlot findSameSlotId(String slotId, ArrayList<ParkingSlot> slotForTest){
        for (int i = 0; i < slotForTest.size(); i++) {
            ParkingSlot parkingSlot = slotForTest.get(i);
            if (parkingSlot.getSlot_id().equals(slotId)){
                return parkingSlot;
            }
        }
        return null;
    }

    /**
     * This method return an array list containing all slots
     * @return ArrayList<ParkingSlot> for storing the parking slots
     */
    public ArrayList<ParkingSlot> listAllSlots(){
        return parkingSlots;
    }

    /**
     * This method add a slot to the parking slot arraylist
     * @param parkingSlot for storing the parking slots
     */
    public void addASlot(ParkingSlot parkingSlot){
        parkingSlots.add(parkingSlot);
    }

    /**
     * This method delete a slot from parking slot array list
     * @param parkingSlot for storing the parking slots
     */
    public void deleteASlot(ParkingSlot parkingSlot){
        parkingSlots.remove(parkingSlot);
    }

    /**
     * This is a toString method for CarPark class that return all the slots in a String
     * @return String
     */
    @Override
    public String toString() {
        return "CarPark{" +
                "parkingSlots=" + parkingSlots +
                '}';
    }
}
