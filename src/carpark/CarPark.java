package carpark;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CarPark {
    private  static ArrayList<ParkingSlot> parkingSlots= new ArrayList<>();
    public static ArrayList<JLabel> diplaySlots = new ArrayList<>();
    public static ParkingSlot findSameSlotId(String slotId, ArrayList<ParkingSlot> slotForTest){
        for (int i = 0; i < slotForTest.size(); i++) {
            ParkingSlot parkingSlot = slotForTest.get(i);
            if (parkingSlot.getSlot_id().equals(slotId)){
                return parkingSlot;
            }
        }
        return null;
    }

    public ArrayList<ParkingSlot> listAllSlots(){
        return parkingSlots;
    }

    public ArrayList<JLabel> displaySlots(){
        return diplaySlots;
    }

    public ParkingSlot findASlot(String slotID){
        for (ParkingSlot parkingSlot : parkingSlots){
            if (parkingSlot.getSlot_id().equals(slotID)){
                return parkingSlot;
            }
        }
        return null;
    }

    public void addASlot(ParkingSlot parkingSlot){
        parkingSlots.add(parkingSlot);
    }

    public void deleteASlot(ParkingSlot parkingSlot){
        parkingSlots.remove(parkingSlot);
    }

    @Override
    public String toString() {
        return "CarPark{" +
                "parkingSlots=" + parkingSlots +
                '}';
    }
}
