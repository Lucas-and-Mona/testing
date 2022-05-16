package carpark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Application extends JFrame{
    static CarPark carPark = new CarPark();
    static ArrayList<ParkingSlot> parkingSlot = carPark.listAllSlots();
    static ArrayList<JButton> diplaySlots = new ArrayList<>();
    static ArrayList<String> temporarilyStore = new ArrayList<>();
    static JFrame frame;
    static JPanel panel_content_top,panel_content_bottom,createSlot,panel_btn,panel_welcome_info;
    static JButton confirmCreate,labels;
    static Scanner sc;
    static JTextField staffSlots,visitorSlots;
    static JLabel hints;
    static JPopupMenu jPopupMenu;

    Application(){
        //        new objects
        frame = new JFrame();
        Container contentPane = frame.getContentPane();
        panel_btn = new JPanel();
        panel_welcome_info = new JPanel();
        panel_content_top = new JPanel();
        panel_content_bottom = new JPanel();
        JPanel right_panel = new JPanel();
        JButton showAll = new JButton("Show All Parking Slot");
        JButton findCar = new JButton("Find Car");
        JButton parkCar = new JButton("Park Car");
        JButton deleteSlot = new JButton("Delete Slot");
        JButton removeCar = new JButton("Remove Car");
        JButton addParkingSlot = new JButton("Add Parking Slot");
        JButton exitApplication = new JButton("Exit");
        createSlot = new JPanel();
        jPopupMenu = new JPopupMenu("menu");
        JLabel welcomeLabel = new JLabel("Welcome to lucas car park");
        JMenuItem rightClickDelete = new JMenuItem("delete");
        JLabel newStaff = new JLabel("Staff slot quantity: ");
        JLabel newVisitor = new JLabel("Visitor slot quantity: ");
        hints = new JLabel("There is no parking slot in the car park, please enter the quantity of staff and vistor slots to be created.");
        confirmCreate = new JButton("confirm");
        staffSlots = new JTextField();
        visitorSlots = new JTextField();

        //set layouts
        panel_btn.setLayout(new GridLayout(7, 1));
        panel_welcome_info.setLayout(new BorderLayout());
        contentPane.setLayout(new BorderLayout());
        createSlot.setLayout(new GridLayout(2,5));
        panel_content_bottom.setLayout(new GridLayout(2, 2));
        panel_content_top.setLayout(new FlowLayout());


//        set sizes
        frame.setPreferredSize(new Dimension(1200, 900));
        panel_btn.setPreferredSize(new Dimension(150, 800));
        panel_welcome_info.setPreferredSize(new Dimension(WIDTH, 50));
        panel_content_top.setPreferredSize(new Dimension(850, 500));
        panel_content_bottom.setPreferredSize(new Dimension(850, 100));
        welcomeLabel.setPreferredSize(new Dimension(200, 100));
        createSlot.setPreferredSize(new Dimension(790, 50));


//        set background
        frame.setBackground(new Color(171, 180, 207));
        panel_btn.setBackground(new Color(147, 159, 197));
        panel_content_top.setBackground(new Color(141, 119, 140));
        panel_content_bottom.setBackground(new Color(200, 170, 198));
        panel_welcome_info.setBackground(new Color(181,202,12));
        showAll.setBackground(new Color(213,206,201));
        findCar.setBackground(new Color(213,206,201));
        parkCar.setBackground(new Color(213,206,201));
        deleteSlot.setBackground(new Color(213,206,201));
        removeCar.setBackground(new Color(213,206,201));
        addParkingSlot.setBackground(new Color(213,206,201));
        exitApplication.setBackground(new Color(213,206,201));
        createSlot.setBackground(new Color(237, 219, 235));
        hints.setBackground(new Color(141, 119, 140));
        staffSlots.setBackground(new Color(237, 202, 235));
        visitorSlots.setBackground(new Color(237, 202, 235));

//      attach event listeners to buttons
        ShowAllListener showAllListener = new ShowAllListener();
        FindCarListener findCarListener = new FindCarListener();
        ParkCarListener parkCarListener = new ParkCarListener();
        DeleteSlotListener deleteSlotListener = new DeleteSlotListener();
        RemoveCarListener removeCarListener = new RemoveCarListener();
        AddParkingSlotListener2 addParkingSlotListener2 = new AddParkingSlotListener2();
        ExitApplicationListener exitApplicationListener = new ExitApplicationListener();
        AddParkingSlotListener1 addParkingSlotListener1 = new AddParkingSlotListener1();
        rightClickDeleteListener rightClickDeleteListener = new rightClickDeleteListener();
        ChangeColor changeColor = new ChangeColor();

        showAll.addActionListener(showAllListener);
        findCar.addActionListener(findCarListener);
        parkCar.addActionListener(parkCarListener);
        deleteSlot.addActionListener(deleteSlotListener);
        removeCar.addActionListener(removeCarListener);
        addParkingSlot.addActionListener(addParkingSlotListener2);
        exitApplication.addActionListener(exitApplicationListener);
        confirmCreate.addActionListener(addParkingSlotListener1);
        rightClickDelete.addMouseListener(rightClickDeleteListener);
//        change color listener
        showAll.addMouseListener(changeColor);
        findCar.addMouseListener(changeColor);
        parkCar.addMouseListener(changeColor);
        deleteSlot.addMouseListener(changeColor);
        removeCar.addMouseListener(changeColor);
        addParkingSlot.addMouseListener(changeColor);
        exitApplication.addMouseListener(changeColor);

//        relationship among components
        createSlot.add(hints);
        createSlot.add(newStaff);
        createSlot.add(staffSlots);
        createSlot.add(Box.createHorizontalStrut(20));
        createSlot.add(newVisitor);
        createSlot.add(visitorSlots);
        createSlot.add(confirmCreate);

        panel_btn.add(showAll);
        panel_btn.add(findCar);
        panel_btn.add(parkCar);
        panel_btn.add(deleteSlot);
        panel_btn.add(removeCar);
        panel_btn.add(addParkingSlot);
        panel_btn.add(exitApplication);
        panel_btn.revalidate();
        panel_btn.repaint();

        panel_welcome_info.add(welcomeLabel);
        panel_content_bottom.add(hints);
        panel_content_bottom.add(createSlot);

        jPopupMenu.add(rightClickDelete);

        contentPane.add(panel_welcome_info,BorderLayout.NORTH);
        contentPane.add(panel_content_top, BorderLayout.CENTER);
        contentPane.add(panel_content_bottom,BorderLayout.SOUTH);
        contentPane.add(right_panel, BorderLayout.EAST);
        contentPane.add(panel_btn, BorderLayout.WEST);

        frame.pack();
        frame.setVisible(true);
        windowClose(frame);
    }

    public static void main(String[] args){
        new Application();

    }

    static class ShowAllListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("11111111111111111");
            showAllSlot();
        }
    }

    static class FindCarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("222222222222222222222");
            findACar();
        }
    }

    static class ParkCarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("33333333333333333333333");
            parkACar();
        }
    }

    static class DeleteSlotListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("444444444444444444444444444444");
            deleteCarSlot(parkingSlot);
        }
    }

    static class RemoveCarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("55555555555555555555555555");
            removeACar();
        }
    }

    static class AddParkingSlotListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("6666666666666666666666");

            addCarSlot1(sc, carPark,frame,jPopupMenu);
        }
    }

    static class AddParkingSlotListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("6666666666666666666666");

            addCarSlot2(carPark,frame);
        }
    }

    static class ExitApplicationListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("7777777777777777777777777777");
            System.exit(0);
        }
    }

    static class ClearScreenListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("8888888888888888888888888888888");
        }
    }

    static class RightClickPopup extends JPopupMenu {
        JMenuItem jMenuItem;
        public RightClickPopup(){
            jMenuItem = new JMenuItem("delete");
            add(jMenuItem);
        }
    }

    static class ChangeColor implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            Object source = e.getSource();
            if (source instanceof JButton){
                ((JButton)source).setBackground(new Color(216,175,139));
            }
        }

        @Override
        public void mousePressed(MouseEvent e){
            Object source = e.getSource();
            if (source instanceof JButton){
                ((JButton)source).setBackground(new Color(216,175,139));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Object source = e.getSource();
            if (source instanceof JButton){
                ((JButton)source).setBackground(new Color(145,151,156));;
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            Object source = e.getSource();
            if (source instanceof JButton){
                ((JButton)source).setBackground(new Color(216,175,139));;
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            Object source = e.getSource();
            if (source instanceof JButton){
                ((JButton)source).setBackground(new Color(213,206,201));;
            }
        }
    }

    static class rightClickDeleteListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String slot = temporarilyStore.get(0);
            System.out.println(slot);
            rightClickDelete(slot);
        }

        @Override
        public void mousePressed(MouseEvent e){
            String slot = temporarilyStore.get(0);
            System.out.println(slot);
            rightClickDelete(slot);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            String slot = temporarilyStore.get(0);
            System.out.println(slot);
            rightClickDelete(slot);
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    class showAllDialog extends JDialog{
        public showAllDialog(){
            this.setVisible(true);
            this.setPreferredSize(new Dimension(400, 300));
            this.setTitle("staff parking");

            Container container = this.getContentPane();
            container.setLayout(null);
            container.add(new Label("Show All Parking Slots"));

        }
    }

    public static void showAllSlot() {
        for (int i = 0; i < diplaySlots.size(); i++) {
            diplaySlots.get(i).setVisible(true);

        }
    }

    public static void parkACar() {
        JOptionPane.showMessageDialog(frame,
                "Please enter your car details to park the car:",
                "Get started",
                JOptionPane.INFORMATION_MESSAGE
        );

       String carNumber = null;
        boolean flag1 = true;
        boolean flag5 = true;
        while (flag5) {
            while (flag1) {
                carNumber = JOptionPane.showInputDialog(frame,
                        "Enter your car registration number, must looks like \"A12345\"",
                        "Car number",
                        JOptionPane.INFORMATION_MESSAGE
                );
                if (carNumber == null) {
                    operationCancelled();
                    flag5 = false;
                } else {
                    String registrationNumberFormat = "^[A-Z][0-9]{5}$";
                    if (carNumber.matches(registrationNumberFormat)) {
                        flag1 = false;
                    }
                }
            }

            String ownerName = null;
            boolean flag2 = true;
            while (flag2) {
                ownerName = JOptionPane.showInputDialog(frame,
                        "Please enter your name, must only contains letters from a-z.",
                        "Owner name",
                        JOptionPane.INFORMATION_MESSAGE
                );
                if (ownerName == null){
                    operationCancelled();
                    flag5 = false;
                } else {
                    String ownerNameFormat = "^[A-Za-z]{1,20}$";
                    if (ownerName.matches(ownerNameFormat)) {
                        flag2 = false;
                    }
                }
            }
            String slotType = null;
            boolean flag4 = true;
            while (flag4) {
                Object[] options = {"staff", "visitor"};
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
                        JOptionPane.showMessageDialog(frame,
                                "Your slot type is staff.",
                                "Slot type",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        flag4 = false;
                        break;
                    case 1:
                        slotType = "visitor";
                        JOptionPane.showMessageDialog(frame,
                                "Your slot type is visitor.",
                                "Slot type",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        flag4 = false;
                        break;
                    default:
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
                slotNumber = JOptionPane.showInputDialog(frame,
                        "Please enter the slot number you want to park in, must looks like \"S001\" or \"V001\"",
                        "Provide slot ID",
                        JOptionPane.INFORMATION_MESSAGE
                );
                if (slotNumber == null){
                    operationCancelled();
                    flag5 = false;
                } else {
                    for (int i = 0; i < parkingSlot.size(); i++) {
                        if (slotNumber.equals(parkingSlot.get(i).getSlot_id())) {
                            if (parkingSlot.get(i).getCar() == null) {
                                if (slotType.toUpperCase().startsWith("V") && slotNumber.startsWith("V") || slotType.toUpperCase().startsWith("S") && slotNumber.startsWith("S")) {
                                    flag3 = false;
                                } else {
                                    JOptionPane.showMessageDialog(frame,
                                            "Your slot Id should match with your slot type.",
                                            "User type not matched",
                                            JOptionPane.INFORMATION_MESSAGE
                                    );
                                }
                            } else {
                                JOptionPane.showMessageDialog(frame,
                                        "The slot you have entered is occupied.",
                                        "Slot occupied",
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                            }
                        } else if (i == parkingSlot.size() && !slotNumber.equals(parkingSlot.get(parkingSlot.size() - 1).getSlot_id())) {
                            JOptionPane.showMessageDialog(frame,
                                    "The slot number you have enter is not exist.",
                                    "Slot number not exit",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                }
            }

            for (int i = 0; i < parkingSlot.size(); i++) {
                if (slotNumber.equals(parkingSlot.get(i).getSlot_id())) {
                    parkingSlot.get(i).setCar(new Car(carNumber, ownerName, slotType));
                    parkingSlot.get(i).setOccupation("occupied");
                    String content1 = "<html>" + "<body>" + "SlotID: " + parkingSlot.get(i).getSlot_id() + " Slot type: " + parkingSlot.get(i).getSlotType();
                    String content2 = " ,Status: " + parkingSlot.get(i).getOccupation() + ", car registration No.: " + parkingSlot.get(i).getCar().getRegistrationNumber()
                            + " ,owner: " + parkingSlot.get(i).getCar().getOwner() + "</body></html>";
                    diplaySlots.get(i).setText(content1 + content2);

                    diplaySlots.get(i).setBackground(new Color(225, 174, 190));
                    JOptionPane.showMessageDialog(frame,
                            "You have successfully park the car " + parkingSlot.get(i).getCar().getRegistrationNumber() + " into slot " + parkingSlot.get(i).getSlot_id() + ".",
                            "Successfully Parked",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }
    }

    public static void findACar() {
        String searchCar = null;
        boolean flag1 = true;
        while (flag1) {
            searchCar = JOptionPane.showInputDialog(frame,
                    "Please enter a car number for removing, must looks like \\\"A12345\\\"",
                    "Find the car number",
                    JOptionPane.OK_CANCEL_OPTION
            );
            if (searchCar == null){
                operationCancelled();
                flag1 = false;
            } else {
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
    }

    public static void removeACar() {
        String searchCar = null;
        boolean flag5 = true;
        while (flag5) {
            searchCar = JOptionPane.showInputDialog(frame,
                    "Please enter a car number for removing, must looks like \\\"A12345\\\"",
                    "Remove the car number",
                    JOptionPane.INFORMATION_MESSAGE
            );
            if (searchCar ==null){
                operationCancelled();
                flag5 = false;
            } else {
                String registrationNumberFormat = "^[A-Z][0-9]{5}$";
                if (searchCar.matches(registrationNumberFormat)){
                    flag5 = false;
                }
            }
            for (int i = 0; i < parkingSlot.size(); i++) {
                if (parkingSlot.get(i).getCar() != null) {
                    if (Objects.equals(parkingSlot.get(i).getCar().getRegistrationNumber(), searchCar)) {
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
    }

    public static void addCarSlot1(Scanner sc, CarPark carPark, Frame frame, JPopupMenu jPopupMenu) {

            int staffSlot = Integer.parseInt(staffSlots.getText());
            int visitorSlot = Integer.parseInt(visitorSlots.getText());
            if ((staffSlot+visitorSlot)<=28){
                String occupation = "not occupied";
                Car car = null;
                for (int i = 0; i < staffSlot; i++) {
                    String slot_id = String.format("S"+"%03d",(i+1));
                    String slotType = "staff";
                    carPark.addASlot(new ParkingSlot(slot_id, occupation, slotType, car));
                    labels = new JButton();
                    String content1 = "<html>" + "<body>" + "SlotID: " + parkingSlot.get(i).getSlot_id() + " Slot type: " + parkingSlot.get(i).getSlotType();
                    String content2 = " ,Status: " + parkingSlot.get(i).getOccupation() + "." + "</body></html>";
                    labels.setText(content1 + content2);
                    labels.setVisible(true);
                    labels.setPreferredSize(new Dimension(300,80));
                    labels.setBackground(new Color(130, 146, 195));
                    labels.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            showPopup(e);
                        }
                    });
                    labels.setName(slot_id);
                    diplaySlots.add(labels);
                    panel_content_top.add(diplaySlots.get(i));
                }

                for (int i = 0; i < visitorSlot; i++) {
                    String slot_id = String.format("V"+"%03d",(i+1));
                    String slotType = "visitor";
                    carPark.addASlot(new ParkingSlot(slot_id, occupation, slotType, car));
                    labels = new JButton();
                    String content1 = "<html>" + "<body>" + "SlotID: " + parkingSlot.get(i+staffSlot).getSlot_id() + " Slot type: " + parkingSlot.get(i+staffSlot).getSlotType();
                    String content2 = " ,Status: " + parkingSlot.get(i+staffSlot).getOccupation() + "." + "</body></html>";
                    labels.setText(content1 + content2);
                    labels.setVisible(true);
                    labels.setPreferredSize(new Dimension(300,80));
                    labels.setBackground(new Color(181, 202, 151));
                    labels.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            showPopup(e);
                        }
                    });
                    labels.setName(slot_id);
                    System.out.println(labels.getName());
                    diplaySlots.add(labels);
                    panel_content_top.add(diplaySlots.get(i+staffSlot));
                }
                createSlot.setVisible(false);
                hints.setVisible(false);
                panel_content_bottom.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Sorry, we don't have enough space for more than 28 car slots, please create less than 28 slots.",
                        "No space for slots",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
    }

    static void showPopup(MouseEvent e) {
        temporarilyStore.clear();
        if(e.isPopupTrigger()) {
            jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
            System.out.println(e.getComponent().getName());
        }
        String clickSlotId = e.getComponent().getName();
        temporarilyStore.add(clickSlotId);
    }

    public static void addCarSlot2(CarPark carPark, Frame frame) {
        if (parkingSlot.size()<= 28){
            boolean flag2 = true;
            String slotNumber = null;
            String slotType = null;
                while (flag2) {
                    slotNumber = JOptionPane.showInputDialog(frame,
                            "Please enter the slot number you want to create, must looks like \"S001\" or \"V001\"",
                            "Create a slot",
                            JOptionPane.PLAIN_MESSAGE
                    );
                    if (slotNumber == null) {
                        operationCancelled();
                        flag2 = false;
                    } else {
                        System.out.println("22222222222222222222");

                        String registrationNumberFormat = "^[SV][0-9]{3}$";
                        if (slotNumber.matches(registrationNumberFormat)) {
                            for (int i = 0; i < parkingSlot.size(); i++) {
                                if (parkingSlot.get(i).getSlot_id().equals(slotNumber)) {
                                    JOptionPane.showMessageDialog(frame,
                                            "Sorry, the slot number you entered has already existed, try another one.",
                                            "Existed slot number",
                                            JOptionPane.INFORMATION_MESSAGE
                                    );
                                    System.out.println("111111111111");
                                    break;
                                } else {
                                    flag2 = false;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame,
                                    "The format is not correct.",
                                    "Incorrect format",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                }
                if (slotNumber.contains("S")) {
                    slotType = "staff";
                    addSlotAfterChecked(slotNumber, slotType);
//                    Object[] choices = {"create more", "Quit"};
//                    String choice = (String) JOptionPane.showInputDialog(frame,
//                            "Choose continue to create more slot or quit.",
//                            "Next step",
//                            JOptionPane.PLAIN_MESSAGE,
//                            null,
//                            choices, choices[0]
//                    );
//
//                    if (choice != null && choice.length()>0){
//                        if (choice.equals("create more")){
//                            continue;
//                        }else return;
//                    }
                } else {
                    slotType = "visitor";
                    addSlotAfterChecked(slotNumber, slotType);
//                    Object[] choices = {"create more", "Quit"};
//                    String choice = (String) JOptionPane.showInputDialog(frame,
//                            "Choose continue to create more slot or quit.",
//                            "Next step",
//                            JOptionPane.PLAIN_MESSAGE,
//                            null,
//                            choices, choices[0]
//                    );
//
//                    if (choice != null && choice.length()>0){
//                        if (choice.equals("create more")){
//                            continue;
//                        }else return;
//                    }
                }
        } else {
            JOptionPane.showMessageDialog(frame,
                    "Sorry, we don't have enough space for more than 28 car slots, please create less than 28 slots.",
                    "No space for slots",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public static void addSlotAfterChecked(String newSlotId, String newSlotType){
        Car car = null;
        String occupation = "not occupied";
        ParkingSlot newSlot = new ParkingSlot(newSlotId, occupation, newSlotType, car);
        carPark.addASlot(newSlot);
        labels = new JButton();
        labels.setText("SlotID: " + parkingSlot.get(parkingSlot.size()-1).getSlot_id() + " Slot type: " + parkingSlot.get(parkingSlot.size()-1).getSlotType()
                + " Status: " + parkingSlot.get(parkingSlot.size()-1).getOccupation() + ".");
        labels.setVisible(true);
        labels.setPreferredSize(new Dimension(400,80));
        labels.setBackground(new Color(181, 202, 151));
        labels.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
        });
        labels.setName(newSlotId);
        System.out.println(labels.getName());
        diplaySlots.add(labels);
        panel_content_bottom.add(diplaySlots.get(parkingSlot.size()-1));
        JOptionPane.showMessageDialog(frame,
                "You have successfully created a new " + newSlot.getSlotType() + " slot " + newSlot.getSlot_id() + ".",
                "Successfully created",
                JOptionPane.INFORMATION_MESSAGE
        );
        System.out.println(parkingSlot);
        System.out.println(diplaySlots);
    }

    public static void rightClickDelete(String clickSlotId){
        String slot_Id = clickSlotId ;
        System.out.println("testing " + slot_Id);
        for (int i = 0; i < parkingSlot.size(); i++) {
            if (slot_Id.equals(parkingSlot.get(i).getSlot_id())) {
                if (parkingSlot.get(i).getCar() == null) {
                    JOptionPane.showMessageDialog(frame,
                            "You have successfully removed " + parkingSlot.get(i) + ".",
                            "Successfully deleted",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    parkingSlot.remove(i);
                    diplaySlots.get(i).setVisible(false);
                    panel_content_bottom.remove(diplaySlots.get(i));
                    diplaySlots.remove(i);
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

                    if (choice != null && choice.length() > 0) {
                        if (choice.equals("do it again")) {
                            continue;
                        } else return;
                    }
                }
            }
        }

    }

    public static void deleteCarSlot (ArrayList < ParkingSlot > parkingSlot){
        boolean flag1 = true;
        boolean flag2 = true;
        String slotId = null;
        while (flag2) {
            while (flag1) {
                slotId = JOptionPane.showInputDialog(frame,
                        "Please enter the slot number you want to delete, must looks like \"S001\" or \"V001\"",
                        "Delete a slot",
                        JOptionPane.INFORMATION_MESSAGE
                );
                if (slotId == null){
                    operationCancelled();
                    flag1 = false;
                } else {
                    String slotIdFormat = "^[SV][0-9]{3}$";
                    if (slotId.toUpperCase().matches(slotIdFormat)) {
                        flag1 = false;
                    } else {
                        continue;
                    }
                }
            }
            for (int i = 0; i < parkingSlot.size(); i++) {
                if (slotId.equals(parkingSlot.get(i).getSlot_id())) {
                    if (parkingSlot.get(i).getCar() == null) {
                        JOptionPane.showMessageDialog(frame,
                                "You have successfully removed " + parkingSlot.get(i) + ".",
                                "Successfully deleted",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        parkingSlot.remove(i);
                        diplaySlots.get(i).setVisible(false);
                        panel_content_bottom.remove(diplaySlots.get(i));
                        diplaySlots.remove(i);
                        flag2 = false;
                    } else {
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

    public static void operationCancelled(){
        JOptionPane.showMessageDialog(frame,
                "You have cancelled the operation.",
                "operation cancelled",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


}
