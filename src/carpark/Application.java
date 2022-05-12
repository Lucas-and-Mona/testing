package carpark;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static carpark.GUIPanel.*;
import static carpark.GUIPanel.frame;

public class Application {
    static CarPark carPark = new CarPark();
    static ArrayList<ParkingSlot> parkingSlot = carPark.listAllSlots();
    static ArrayList<JLabel> displaySlots = carPark.displaySlots();

    class showAllDialog extends JDialog{
        public showAllDialog(){
            this.setVisible(true);
            this.setBounds(300, 300, 400, 300);
            this.setTitle("staff parking");

            Container container = this.getContentPane();
            container.setLayout(null);
            container.add(new Label("Show All Parking Slots"));

        }
    }

//    public static void selectMenu(){
//        Scanner sc = new Scanner(System.in);
//        addCarSlot1(sc,carPark, frame);
//        while (true) {
//            System.out.println("1: List all car slots");
//            System.out.println("2: Park a car");
//            System.out.println("3: Find a car");
//            System.out.println("4: Remove a car");
//            System.out.println("5: Add a car slot");
//            System.out.println("6: Delete a car slot");
//            System.out.println("7: Exit");
//            System.out.println();
//            System.out.println("Please select an option (1-7):");
//            String commandFormat = "^[1-7]{1}$";
//            String command = sc.next();
//            boolean flag = command.matches(commandFormat);
//            boolean flag2 =true;
//
//            if (flag) {
//                int option = Integer.valueOf(command);
//                switch (option) {    //use the command user input
//                    case 1:
//                        showAllSlot();    //call showAllSlot method
//                        break;
//                    case 2:
//                        parkACar(sc);    //call parkACar method
//                        break;
//                    case 3:
//                        findACar(sc);   //call findACarResult method
//                        break;
//                    case 4:
//                        removeACar(sc);    //call removeCarResult method
//                        break;
//                    case 5:
//                        addCarSlot2(sc,carPark, frame);    //call addCarSlot method
//                        break;
//                    case 6:
//                        deleteCarSlot(sc,parkingSlot);    //call deleteCarSlot method
//                        break;
//                    case 7:
//                        System.out.println("Thank you for using, the system is now end.");
//                        return;
//                    default:
//                        System.out.println("Please only type a number among 1-7.");
//                }
//            }else {
//                System.out.println("Please only type 1 to 7 to choose.");
//            }
//        }
//    }

    public static void showAllSlot() {
        for (int i = 0; i < parkingSlot.size(); i++) {
//            if (parkingSlot.get(i).getCar()==null) {
                labels[i].setVisible(true);
//                new JButton("SlotID is: " + parkingSlot.get(i).getSlot_id() + ", is for " + parkingSlot.get(i).getSlotType()
//                        + ", and is " + parkingSlot.get(i).getOccupation() + ".").setPreferredSize(new Dimension(120, 100));
//
//                panel_content_bottom.add( new JButton("SlotID is: " + parkingSlot.get(i).getSlot_id() + ", is for " + parkingSlot.get(i).getSlotType()
//                        + ", and is " + parkingSlot.get(i).getOccupation() + "."));
//                frame.add(panel_content_bottom);


//                System.out.println("SlotID is: " + parkingSlot.get(i).getSlot_id() + ", is for " + parkingSlot.get(i).getSlotType()
//                        + ", and is " + parkingSlot.get(i).getOccupation() + ".");

//            }else {
//                System.out.println("SlotID is: " + parkingSlot.get(i).getSlot_id() + ", is for " + parkingSlot.get(i).getSlotType()
//                        + ", and is " + parkingSlot.get(i).getOccupation() + ", car owner name is " +
//                        parkingSlot.get(i).getCar().getOwner() + " , registration number is " +
//                        parkingSlot.get(i).getCar().getRegistrationNumber());
//                JButton slot_2 = new JButton("SlotID is: " + parkingSlot.get(i).getSlot_id() + ", is for " + parkingSlot.get(i).getSlotType()
//                        + ", and is " + parkingSlot.get(i).getOccupation() + ", car owner name is " +
//                        parkingSlot.get(i).getCar().getOwner() + " , registration number is " +
//                        parkingSlot.get(i).getCar().getRegistrationNumber());
//                slot_2.setPreferredSize(new Dimension(120, 100));
//                panel_content_bottom.add(slot_2);
//            }
        }
    }

    public static void parkACar(Scanner sc) {
//        System.out.println("Please enter your car details to park the car:");
        JOptionPane.showMessageDialog(frame,
                "Please enter your car details to park the car:",
                "Get started",
                JOptionPane.INFORMATION_MESSAGE
        );

       String carNumber = null;
        boolean flag1 = true;
        while (flag1) {
//            System.out.println("Enter your car registration number, must looks like \"A12345\"");
//            carNumber = sc.next().toUpperCase();    //user provide a car number
            carNumber = JOptionPane.showInputDialog(frame,
                    "Enter your car registration number, must looks like \"A12345\"",
                    "Car number",
                    JOptionPane.INFORMATION_MESSAGE
            );

            String registrationNumberFormat = "^[A-Z][0-9]{5}$";
            if (carNumber.matches(registrationNumberFormat)){
                flag1 = false;
            }
        }


        String ownerName = null;
        boolean flag2 = true;
        while (flag2) {
//            System.out.println("Please enter your name, must only contains letters from a-z.");
//            ownerName = sc.next();    //user provide a car number
            ownerName = JOptionPane.showInputDialog(frame,
                    "Please enter your name, must only contains letters from a-z.",
                    "Owner name",
                    JOptionPane.INFORMATION_MESSAGE
            );

            String ownerNameFormat = "^[A-Za-z]{1,20}$";
            if (ownerName.matches(ownerNameFormat)){
                flag2 = false;
            }
        }

        String slotType = null;
        boolean flag4 = true;
        while (flag4) {
//            System.out.println("Please select slot type, 1 is staff, 2 is visitor.");
//            int option = sc.nextInt();
            Object[] options = {"staff","visitor"};
            int option = JOptionPane.showOptionDialog(frame,
                    "Please select slot type, staff or visitor.",
                    "Slot type",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
                    );

            switch (option) {
                case 0:
                    slotType = "Staff";
//                    System.out.println("Your slot type is staff.");
                    JOptionPane.showMessageDialog(frame,
                            "Your slot type is staff.",
                            "Slot type",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    flag4 = false;
                    break;
                case 1:
                    slotType = "visitor";
//                    System.out.println("Your slot type is visitor.");
                    JOptionPane.showMessageDialog(frame,
                            "Your slot type is visitor.",
                            "Slot type",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    flag4 = false;
                    break;
                default:
//                    System.out.println("You should only choose 1 or 2.");
                    JOptionPane.showMessageDialog(frame,
                            "You should only choose 1 or 2.",
                            "Wrong Input",
                            JOptionPane.INFORMATION_MESSAGE
                    );
            }
        }


        String slotNumber = null;
        boolean flag3 = true;
        while (flag3) {
//            System.out.println("Please enter the slot number you want to park in, must looks like \"S001\" or \"V001\"");
//            slotNumber = sc.next().toUpperCase();
            slotNumber = JOptionPane.showInputDialog(frame,
                    "Please enter the slot number you want to park in, must looks like \"S001\" or \"V001\"",
                    "Provide slot ID",
                    JOptionPane.INFORMATION_MESSAGE
            );
            for (int i = 0; i < parkingSlot.size(); i++) {
                if (slotNumber.equals(parkingSlot.get(i).getSlot_id())){
                    if (parkingSlot.get(i).getCar() == null) {
                        if (slotType.toUpperCase().startsWith("V") && slotNumber.startsWith("V") || slotType.toUpperCase().startsWith("S") && slotNumber.startsWith("S")) {
                            flag3 = false;
                        } else {
//                            System.out.println("Your slot Id should match with your slot type.");
                            JOptionPane.showMessageDialog(frame,
                                    "Your slot Id should match with your slot type.",
                                    "User type not matched",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }else {
//                        System.out.println("The slot you have entered is occupied.");
                        JOptionPane.showMessageDialog(frame,
                                "The slot you have entered is occupied.",
                                "Slot occupied",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                } else if (i == parkingSlot.size() && !slotNumber.equals(parkingSlot.get(parkingSlot.size()-1).getSlot_id())){
//                    System.out.println("The slot number you have enter is not exist.");
                    JOptionPane.showMessageDialog(frame,
                            "The slot number you have enter is not exist.",
                            "Slot number not exit",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }

        for (int i = 0; i < parkingSlot.size(); i++) {
            if (slotNumber.equals(parkingSlot.get(i).getSlot_id())){
                parkingSlot.get(i).setCar(new Car(carNumber,ownerName,slotType));
                parkingSlot.get(i).setOccupation("occupied");
                labels[i].setBackground(new Color(200, 170, 198));
//                System.out.println("You have successfully park the car " + parkingSlot.get(i).getCar().getRegistrationNumber() + " into slot " + parkingSlot.get(i).getSlot_id() + ".");
                JOptionPane.showMessageDialog(frame,
                        "You have successfully park the car " + parkingSlot.get(i).getCar().getRegistrationNumber() + " into slot " + parkingSlot.get(i).getSlot_id() + ".",
                        "Successfully Parked",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }

    public static void findACar(Scanner sc) {
        String searchCar = null;
        boolean flag1 = true;
        while (flag1) {
//            System.out.println("Please enter a car number for searching, must looks like \"A12345\"");
//            searchCar = sc.next().toUpperCase();    //user provide a car number
            searchCar = JOptionPane.showInputDialog(frame,
                    "Please enter a car number for removing, must looks like \\\"A12345\\\"",
                    "Find the car number",
                    JOptionPane.INFORMATION_MESSAGE
            );

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
//            System.out.println("Please enter a car number for removing, must looks like \"A12345\"");
//            searchCar = sc.next().toUpperCase();    //user provide a car number
            searchCar = JOptionPane.showInputDialog(frame,
                    "Please enter a car number for removing, must looks like \\\"A12345\\\"",
                    "Remove the car number",
                    JOptionPane.INFORMATION_MESSAGE
            );

            String registrationNumberFormat = "^[A-Z][0-9]{5}$";
            if (searchCar.matches(registrationNumberFormat)){
                flag5 = false;
            }
        }
        for (int i = 0; i < parkingSlot.size(); i++) {
            if (parkingSlot.get(i).getCar() != null) {
                if (Objects.equals(parkingSlot.get(i).getCar().getRegistrationNumber(), searchCar)) {
//                    System.out.println("The car information is " + parkingSlot.get(i).getCar().toString());
//                    System.out.println("Removed successfully.");
                    JOptionPane.showMessageDialog(frame,
                            "The car " + parkingSlot.get(i).getCar().getRegistrationNumber().toString() + " has been removed successfully",
                            "No car in the slot",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    parkingSlot.get(i).setCar(null);
                    parkingSlot.get(i).setOccupation("not occupied");
                }
            } else {
//                System.out.println("No car park in here.");
                JOptionPane.showMessageDialog(frame,
                        "Sorry, No car park in here, try another one.",
                        "No car in the slot",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }


    public static void addCarSlot1(Scanner sc, CarPark carPark, Frame frame) {
//        int staffSlot = Integer.parseInt(JOptionPane.showInputDialog(frame,
//                "Please enter the number of slots for staff: ",
//                "Create staff slots",
//                JOptionPane.INFORMATION_MESSAGE
//                ));
//        int visitorSlot = Integer.parseInt(JOptionPane.showInputDialog(frame,
//                "Please enter the number of slots for visitor: ",
//                "Create visitor slots",
//                JOptionPane.INFORMATION_MESSAGE
//        ));

//        System.out.println("Please enter the number of slots for staff: ");
//        int staffSlot = sc.nextInt();
//        System.out.println("Please enter the number of slots for staff: ");
//        int visitorSlot = sc.nextInt();

            int staffSlot = Integer.parseInt(staffSlots.getText());
            int visitorSlot = Integer.parseInt(visitorSlots.getText());
            if ((staffSlot+visitorSlot)<=28){
                String occupation = "not occupied";
                Car car = null;
                for (int i = 0; i < staffSlot; i++) {
                    String slot_id = String.format("S"+"%03d",(i+1));
                    String slotType = "staff";
                    carPark.addASlot(new ParkingSlot(slot_id, occupation, slotType, car));
                    labels[i].setText("SlotID: " + parkingSlot.get(i).getSlot_id() + " Slot type:" + parkingSlot.get(i).getSlotType()
                            + " Status: " + parkingSlot.get(i).getOccupation() + ".");
                    labels[i].setVisible(true);
                    labels[i].setBackground(new Color(130, 146, 195));
                }

                for (int i = 0; i < visitorSlot; i++) {
                    String slot_id = String.format("V"+"%03d",(i+1));
                    String slotType = "visitor";
                    carPark.addASlot(new ParkingSlot(slot_id, occupation, slotType, car));
                    labels[i+staffSlot].setText("SlotID: " + parkingSlot.get(i+staffSlot).getSlot_id() + " Slot type: " + parkingSlot.get(i+staffSlot).getSlotType()
                            + " Status: " + parkingSlot.get(i+staffSlot).getOccupation() + ".");
                    labels[i+staffSlot].setVisible(true);
                    labels[i+staffSlot].setBackground(new Color(181, 202, 151));
                }
                createSlot.setVisible(false);
                hints.setVisible(false);
                panel_content_top.setBounds(150, 100, 850, 0);
                panel_content_bottom.setBounds(150, 100, 850, 700);
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Sorry, we don't have enough space for more than 28 car slots, please create less than 28 slots.",
                        "No space for slots",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
    }

    public static void addCarSlot2(Scanner sc, CarPark carPark, Frame frame) {
        if (parkingSlot.size()<= 28){
        } else {
            JOptionPane.showMessageDialog(frame,
                    "Sorry, we don't have enough space for more than 28 car slots, please create less than 28 slots.",
                    "No space for slots",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
        boolean flag1 = true;
        boolean flag2 = true;
        String slotNumber = null;
        while (flag2) {
            while (flag2) {
//                System.out.println("Please enter the slot number you want to create, must looks like \"S001\" or \"V001\"");
//                slotNumber = sc.next().toUpperCase();
                slotNumber = JOptionPane.showInputDialog(frame,
                        "Please enter the slot number you want to create, must looks like \"S001\" or \"V001\"",
                        "Create a slot",
                        JOptionPane.INFORMATION_MESSAGE
                        );
                String registrationNumberFormat = "^[SV][0-9]{3}$";
                if (slotNumber.matches(registrationNumberFormat)) {
                    for (int i = 0; i < parkingSlot.size(); i++) {
                        if (parkingSlot.get(i).getSlot_id().equals(slotNumber)) {
//                            System.out.println("Sorry, the slot number you entered has already existed, try another one.");
                            JOptionPane.showMessageDialog(frame,
                                    "Sorry, the slot number you entered has already existed, try another one.",
                                    "Existed slot number",
                                    JOptionPane.INFORMATION_MESSAGE
                                    );
                            break;
                        } else {
                            flag2 = false;
                        }
                    }
                } else {
//                    System.out.println("The format is not correct.");
                    JOptionPane.showMessageDialog(frame,
                            "The format is not correct.",
                            "Incorrect format",
                            JOptionPane.INFORMATION_MESSAGE
                    );
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
//            System.out.println("You have successfully created a new " + newSlot.getSlotType() + " slot " + newSlot.getSlot_id() + ".");
            JOptionPane.showMessageDialog(frame,
                    "You have successfully created a new " + newSlot.getSlotType() + " slot " + newSlot.getSlot_id() + ".",
                    "Successfully created",
                    JOptionPane.INFORMATION_MESSAGE
            );
//            System.out.println("Enter 'Y' to create more slots, anything else to main menu.");
//            char choice = sc.next().charAt(0);
            Object[] choices = {"create more", "Quit"};
            String choice = (String) JOptionPane.showInputDialog(frame,
                    "Choose continue to create more slot or quit.",
                    "Next step",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    choices, choices[0]
            );

            if (choice != null && choice.length()>0){
                if (choice.equals("create more")){
                    continue;
                }else return;
            }
        }
    }


    public static void deleteCarSlot (Scanner sc, ArrayList < ParkingSlot > parkingSlot){
        boolean flag1 = true;
        boolean flag2 = true;
        String slotId = null;
        while (flag2) {
            while (flag1) {
//                System.out.println("Please enter the slot number you want to delete, must looks like \"S001\" or \"V001\"");
//                slotId = sc.next().toUpperCase();
                slotId = JOptionPane.showInputDialog(frame,
                        "Please enter the slot number you want to delete, must looks like \"S001\" or \"V001\"",
                        "Delete a slot",
                        JOptionPane.INFORMATION_MESSAGE
                );
                String slotIdFormat = "^[SV][0-9]{3}$";
                if (slotId.toUpperCase().matches(slotIdFormat)) {
                    flag1 = false;
                } else {
                    continue;
                }
            }
            for (int i = 0; i < parkingSlot.size(); i++) {
                if (slotId.equals(parkingSlot.get(i).getSlot_id())) {
                    if (parkingSlot.get(i).getCar() == null) {
//                        System.out.println("You have successfully removed " + parkingSlot.get(i) + ".");
                        JOptionPane.showMessageDialog(frame,
                                "You have successfully removed " + parkingSlot.get(i) + ".",
                                "Successfully deleted",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        parkingSlot.remove(i);
//                        labels[i].setText("label"+i);
//                        labels[i].setVisible(false);
                        flag2 = false;
                    } else {
//
                        JOptionPane.showMessageDialog(frame,
                                "Sorry, the slot is now parking a car, remove the car before deleting the slot.",
                                "Successfully deleted",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        Object[] choices = {"do it again", "Quit"};
                        String choice = (String) JOptionPane.showInputDialog(frame,
                                "Do you want to try again or quit?",
                                "Next step",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                choices, choices[0]
                        );

                        if (choice != null && choice.length()>0){
                            if (choice.equals("do it again")){
                                continue;
                            }else return;
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
