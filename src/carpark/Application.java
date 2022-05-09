package carpark;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    static CarPark carPark = new CarPark();
    static ArrayList<ParkingSlot> parkingSlot = carPark.listAllSlots();
    public static void main(String[] args) {
        selectMenu();
    }

    public static void selectMenu(){
        Scanner sc = new Scanner(System.in);


        addCarSlot1(sc,carPark);    //let user create car park when first entering the system
        //option hints
        while (true) {    //all the command in a loop unless user choose to exit
            System.out.println("1: List all car slots");
            System.out.println("2: Park a car");
            System.out.println("3: Find a car");
            System.out.println("4: Remove a car");
            System.out.println("5: Add a car slot");
            System.out.println("6: Delete a car slot");
            System.out.println("7: Exit");
            System.out.println();
            System.out.println("Please select an option (1-7):");
            String commandFormat = "^[1-7]{1}$";
            String command = sc.next();
            boolean flag = command.matches(commandFormat);
            boolean flag2 =true;

            if (flag) {
                int option = Integer.valueOf(command);
                switch (option) {    //use the command user input
                    case 1:
                        showAllSlot();    //call showAllSlot method
                        break;
                    case 2:
                        parkACar(sc);    //call parkACar method
                        break;
                    case 3:
                        findACar(sc);   //call findACarResult method
                        break;
                    case 4:
                        removeACar(sc);    //call removeCarResult method
                        break;
                    case 5:
                        addCarSlot2(sc,carPark);    //call addCarSlot method
                        break;
                    case 6:
                        deleteCarSlot(sc,parkingSlot);    //call deleteCarSlot method
                        break;
                    case 7:
                        System.out.println("Thank you for using, the system is now end.");
                        return;
                    default:
                        System.out.println("Please only type a number among 1-7.");
                }
            }else {
                System.out.println("Please only type 1 to 7 to choose.");
            }
        }
    }

    public static void showAllSlot() {
        for (int i = 0; i < parkingSlot.size(); i++) {
            if (parkingSlot.get(i).getCar()==null) {
                System.out.println("SlotID is: " + parkingSlot.get(i).getSlot_id() + ", is for " + parkingSlot.get(i).getSlotType()
                        + ", and is " + parkingSlot.get(i).getOccupation() + ".");
            }else {
                System.out.println("SlotID is: " + parkingSlot.get(i).getSlot_id() + ", is for " + parkingSlot.get(i).getSlotType()
                        + ", and is " + parkingSlot.get(i).getOccupation() + ", car owner name is " +
                        parkingSlot.get(i).getCar().getOwner() + " , registration number is " +
                        parkingSlot.get(i).getCar().getRegistrationNumber());
            }
        }
    }

    public static void parkACar(Scanner sc) {
        System.out.println("Please enter your car details to park the car:");

       String carNumber = null;
        boolean flag1 = true;
        while (flag1) {
            System.out.println("Enter your car registration number, must looks like \"A12345\"");
            carNumber = sc.next().toUpperCase();    //user provide a car number
            String registrationNumberFormat = "^[A-Z][0-9]{5}$";
            if (carNumber.matches(registrationNumberFormat)){
                flag1 = false;
            }
        }


        String ownerName = null;
        boolean flag2 = true;
        while (flag2) {
            System.out.println("Please enter your name, must only contains letters from a-z.");
            ownerName = sc.next();    //user provide a car number
            String ownerNameFormat = "^[A-Za-z]{1,20}$";
            if (ownerName.matches(ownerNameFormat)){
                flag2 = false;
            }
        }



        String slotType = null;
        boolean flag4 = true;
        while (flag4) {
            System.out.println("Please select slot type, 1 is staff, 2 is visitor.");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    slotType = "Staff";
                    System.out.println("Your slot type is staff.");
                    flag4 = false;
                    break;
                case 2:
                    slotType = "visitor";
                    System.out.println("Your slot type is visitor.");
                    flag4 = false;
                    break;
                default:
                    System.out.println("You should only choose 1 or 2.");
            }
        }


        String slotNumber = null;
        boolean flag3 = true;
        while (flag3) {
            System.out.println("Please enter the slot number you want to park in, must looks like \"S001\" or \"V001\"");
            slotNumber = sc.next().toUpperCase();
            for (int i = 0; i < parkingSlot.size(); i++) {
                if (slotNumber.equals(parkingSlot.get(i).getSlot_id())){
                    if (parkingSlot.get(i).getCar() == null) {
                        if (slotType.toUpperCase().startsWith("V") && slotNumber.startsWith("V") || slotType.toUpperCase().startsWith("S") && slotNumber.startsWith("S")) {
                            flag3 = false;
                        } else {
                            System.out.println("Your slot Id should match with your slot type.");
                        }
                    }else {
                        System.out.println("The slot you have entered is occupied.");
                    }
                } else if (i == parkingSlot.size() && !slotNumber.equals(parkingSlot.get(parkingSlot.size()-1).getSlot_id())){
                    System.out.println("The slot number you have enter is not exist.");
                }
            }
        }

        for (int i = 0; i < parkingSlot.size(); i++) {
            if (slotNumber.equals(parkingSlot.get(i).getSlot_id())){
                parkingSlot.get(i).setCar(new Car(carNumber,ownerName,slotType));
                parkingSlot.get(i).setOccupation("occupied");
                System.out.println("You have successfully park the car " + parkingSlot.get(i).getCar().getRegistrationNumber() + " into slot " + parkingSlot.get(i).getSlot_id() + ".");
            }
        }
    }

    public static void findACar(Scanner sc) {
        String searchCar = null;
        boolean flag1 = true;
        while (flag1) {
            System.out.println("Please enter a car number for searching, must looks like \"A12345\"");
            searchCar = sc.next().toUpperCase();    //user provide a car number
            String registrationNumberFormat = "^[A-Z][0-9]{5}$";
            if (searchCar.matches(registrationNumberFormat)){
                flag1 =false;
            }
        }
        for (int i = 0; i < parkingSlot.size(); i++) {
            if (parkingSlot.get(i).getCar() != null) {
                if (Objects.equals(parkingSlot.get(i).getCar().getRegistrationNumber(), searchCar)) {
                    System.out.println(parkingSlot.get(i).getCar().toString());
                }
            }
        }
    }



    public static void removeACar(Scanner sc) {
        String searchCar = null;
        boolean flag5 = true;
        while (flag5) {
            System.out.println("Please enter a car number for removing, must looks like \"A12345\"");
            searchCar = sc.next().toUpperCase();    //user provide a car number
            String registrationNumberFormat = "^[A-Z][0-9]{5}$";
            if (searchCar.matches(registrationNumberFormat)){
                flag5 = false;
            }
        }
        for (int i = 0; i < parkingSlot.size(); i++) {
            System.out.println("11111111111111111111111");
            if (parkingSlot.get(i).getCar() != null) {
                if (Objects.equals(parkingSlot.get(i).getCar().getRegistrationNumber(), searchCar)) {
                    System.out.println("The car information is " + parkingSlot.get(i).getCar().toString());
                    System.out.println("Removed successfully.");
                    parkingSlot.get(i).setCar(null);
                    parkingSlot.get(i).setOccupation("not occupied");
                }
            } else {
                System.out.println("No car park in here.");
            }
        }
    }


    public static void addCarSlot1(Scanner sc, CarPark carPark) {

        int staffSlot = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of slots for staff: "));
//        System.out.println("Please enter the number of slots for staff: ");
//        int staffSlot = sc.nextInt();
        System.out.println("Please enter the number of slots for staff: ");
        int visitorSlot = sc.nextInt();
        String occupation = "not occupied";
        Car car = null;
        for (int i = 0; i < staffSlot; i++) {
            String slot_id = String.format("S"+"%03d",(i+1));
            String slotType = "staff";
            carPark.addASlot(new ParkingSlot(slot_id, occupation, slotType, car));
        }

        for (int i = 0; i < visitorSlot; i++) {
            String slot_id = String.format("V"+"%03d",(i+1));
            String slotType = "visitor";
            carPark.addASlot(new ParkingSlot(slot_id, occupation, slotType, car));
        }
    }

    public static void addCarSlot2(Scanner sc, CarPark carPark) {
        boolean flag1 = true;
        boolean flag2 = true;
        String slotNumber = null;
        while (flag2) {
            while (flag2) {
                System.out.println("Please enter the slot number you want to create, must looks like \"S001\" or \"V001\"");
                slotNumber = sc.next().toUpperCase();
                String registrationNumberFormat = "^[SV][0-9]{3}$";
                if (slotNumber.matches(registrationNumberFormat)) {
                    for (int i = 0; i < parkingSlot.size(); i++) {
                        if (parkingSlot.get(i).getSlot_id().equals(slotNumber)) {
                            System.out.println("Sorry, the slot number you entered has already existed, try another one.");
                            break;
                        } else {
                            flag2 = false;
                        }
                    }
                } else {
                    System.out.println("The format is not correct.");
                }
            }

            String slotType = null;
            if (slotNumber.contains("S")) {
                slotType = "staff";
            } else {
                slotType = "visitor";
            }

            String newSlotId = slotNumber;
            String newSlotType = slotType;
            Car car = null;
            String occupation = "not occupied";
            ParkingSlot newSlot = new ParkingSlot(newSlotId, occupation, newSlotType, car);
            carPark.addASlot(newSlot);
            System.out.println("You have successfully created a new " + newSlot.getSlotType() + " slot " + newSlot.getSlot_id() + ".");
            System.out.println("Enter 'Y' to create more slots, anything else to main menu.");
            char choice = sc.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag2 = true;
                continue;
            } else {
                return;
            }
        }
    }

    public static void deleteCarSlot (Scanner sc, ArrayList < ParkingSlot > parkingSlot){
        boolean flag1 = true;
        boolean flag2 = true;
        String slotId = null;
        while (flag2) {
            while (flag1) {
                System.out.println("Please enter the slot number you want to delete, must looks like \"S001\" or \"V001\"");
                slotId = sc.next().toUpperCase();
                String slotIdFormat = "^[SV][0-9]{3}$";
                if (slotId.matches(slotIdFormat)) {
                    flag1 = false;
                } else {
                    continue;
                }
            }
            for (int i = 0; i < parkingSlot.size(); i++) {
                if (slotId.equals(parkingSlot.get(i).getSlot_id())) {
                    if (parkingSlot.get(i).getCar() == null) {
                        System.out.println("You have successfully removed " + parkingSlot.get(i) + ".");
                        parkingSlot.remove(i);
                        flag2 = false;
                    } else {
                        System.out.println("Sorry, the slot is now parking a car, remove the car before deleting the slot.");
                        System.out.println("Enter 'Y' to enter again, anything else to main menu.");
                        char choice = sc.next().charAt(0);
                        if (choice == 'Y' || choice == 'y') {
                            continue;
                        } else {
                            return;
                        }
                    }
                } else if (i != parkingSlot.size() - 1) {
                    continue;
                } else {
                    System.out.println("Sorry, the slot ID you provided is not exist.");
                    flag1 = true;

                }
            }
        }
    }


}
