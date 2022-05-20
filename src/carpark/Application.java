package carpark;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Application extends JFrame{
    static CarPark carPark = new CarPark();
    static ArrayList<ParkingSlot> parkingSlot = carPark.listAllSlots();
    static ArrayList<JButton> displaySlots = new ArrayList<>();
    static ArrayList<String> temporarilyStore = new ArrayList<>();
    static JFrame frame;
    static JPanel panel_content_top,panel_content_bottom,createSlot,panel_btn,panel_welcome_info,right_panel;
    static JButton confirmCreate,labels,showAll,findCar,parkCar,deleteSlot,removeCar,addParkingSlot,exitApplication;
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
        right_panel = new JPanel();
        showAll = new JButton("Show All Parking Slot");
        findCar = new JButton("Find Car");
        parkCar = new JButton("Park Car");
        deleteSlot = new JButton("Delete Slot");
        removeCar = new JButton("Remove Car");
        addParkingSlot = new JButton("Add Parking Slot");
        exitApplication = new JButton("Exit");
        createSlot = new JPanel();
        jPopupMenu = new JPopupMenu("menu");
        JLabel welcomeLabel = new JLabel("Welcome to lucas car park");
        JMenuItem rightClickDelete = new JMenuItem("delete");
        JMenuItem rightClickParkCar = new JMenuItem("park a car");
        JMenuItem rightClickRemoveCar = new JMenuItem("remove car");
        JLabel newStaff = new JLabel("Staff slot quantity: ");
        JLabel newVisitor = new JLabel("Visitor slot quantity: ");
        hints = new JLabel("There is no parking slot in the car park, please enter the quantity of staff and vistor slots to be created.");
        confirmCreate = new JButton("confirm");
        staffSlots = new JTextField();
        visitorSlots = new JTextField();

//        set logo
//        ImageIcon img = new ImageIcon(".\\70006Project2\\carPark\\src\\logo.jpg");
//        frame.setIconImage(img.getImage());

//        initial status of button
        showAll.setVisible(false);
        findCar.setVisible(false);
        parkCar.setVisible(false);
        deleteSlot.setVisible(false);
        removeCar.setVisible(false);
        addParkingSlot.setVisible(false);
        exitApplication.setVisible(false);

        //set layouts
        panel_btn.setLayout(new GridLayout(7, 1));
        panel_welcome_info.setLayout(new BorderLayout());
        contentPane.setLayout(new BorderLayout());
        createSlot.setLayout(new GridLayout(2,5));
        panel_content_bottom.setLayout(new GridLayout(3, 3));
        panel_content_top.setLayout(new FlowLayout());

//        set sizes
        frame.setPreferredSize(new Dimension(1100, 900));
        panel_btn.setPreferredSize(new Dimension(150, 800));
        panel_welcome_info.setPreferredSize(new Dimension(WIDTH, 50));
        panel_content_top.setPreferredSize(new Dimension(850, 500));
        panel_content_bottom.setPreferredSize(new Dimension(850, 150));
        welcomeLabel.setPreferredSize(new Dimension(200, 100));
        createSlot.setPreferredSize(new Dimension(790, 50));

//        set background
        frame.setBackground(new Color(242, 213, 163));
        panel_btn.setBackground(new Color(242, 213, 163));
        panel_content_top.setBackground(new Color(242, 213, 163));
        panel_content_bottom.setBackground(new Color(243, 228, 176));
        panel_welcome_info.setBackground(new Color(237,195,153));
        showAll.setBackground(new Color(220,216,175));
        findCar.setBackground(new Color(220,216,175));
        parkCar.setBackground(new Color(220,216,175));
        deleteSlot.setBackground(new Color(220,216,175));
        removeCar.setBackground(new Color(220,216,175));
        addParkingSlot.setBackground(new Color(220,216,175));
        exitApplication.setBackground(new Color(220,216,175));
        createSlot.setBackground(new Color(243, 228, 176));
        hints.setBackground(new Color(243, 228, 176));
        staffSlots.setBackground(new Color(220, 216, 175));
        visitorSlots.setBackground(new Color(220, 216, 175));
        confirmCreate.setBackground(new Color(217, 162, 134));

//      attach event listeners to buttons
        ShowAllListener showAllListener = new ShowAllListener();
        FindCarListener findCarListener = new FindCarListener();
        ParkCarListener parkCarListener = new ParkCarListener();
        DeleteSlotListener deleteSlotListener = new DeleteSlotListener();
        RemoveCarListener removeCarListener = new RemoveCarListener();
        AddParkingSlotListener2 addParkingSlotListener2 = new AddParkingSlotListener2();
        ExitApplicationListener exitApplicationListener = new ExitApplicationListener();
        AddParkingSlotListener1 addParkingSlotListener1 = new AddParkingSlotListener1();
        RightClickDeleteListener rightClickDeleteListener = new RightClickDeleteListener();
        ChangeColor changeColor = new ChangeColor();
        RightClickParkCarListener rightClickParkCarListener = new RightClickParkCarListener();

        showAll.addActionListener(showAllListener);
        findCar.addActionListener(findCarListener);
        parkCar.addActionListener(parkCarListener);
        deleteSlot.addActionListener(deleteSlotListener);
        removeCar.addActionListener(removeCarListener);
        addParkingSlot.addActionListener(addParkingSlotListener2);
        exitApplication.addActionListener(exitApplicationListener);
        confirmCreate.addActionListener(addParkingSlotListener1);
        rightClickDelete.addMouseListener(rightClickDeleteListener);
        rightClickParkCar.addActionListener(rightClickParkCarListener);


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
        jPopupMenu.add(rightClickParkCar);
        jPopupMenu.add(rightClickRemoveCar);

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
            showAllSlot();
        }
    }

    static class FindCarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            findACar();
        }
    }

    static class ParkCarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            parkACar();
        }
    }

    static class DeleteSlotListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            deleteCarSlot(parkingSlot);
        }
    }

    static class RemoveCarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            removeACar();
        }
    }

    static class AddParkingSlotListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            addCarSlot1(carPark,frame);
        }
    }

    static class AddParkingSlotListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            addCarSlot2(frame);
        }
    }

    static class ExitApplicationListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
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

    static class RightClickDeleteListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String slot = temporarilyStore.get(0);
            rightClickDelete(slot);
        }

        @Override
        public void mousePressed(MouseEvent e){
            String slot = temporarilyStore.get(0);
            rightClickDelete(slot);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            String slot = temporarilyStore.get(0);
            rightClickDelete(slot);
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    static class RightClickParkCarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

        }
    }

    static class ClickedButtonListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
//            String slot_id = ((JComponent) e.getSource()).getName();

//            Object[] choices = {"Park a car", "Remove a car"};
//            JOptionPane.showOptionDialog(frame,
//                    "Please select your operations?",
//                    "operations selection",
//                    JOptionPane.DEFAULT_OPTION,
//                    JOptionPane.QUESTION_MESSAGE,
//                    null,
//                    choices,
//                    choices[0]
//            );
            String slot_id = ((JComponent) e.getSource()).getName();

            Object[] choices = {"Park a car", "Remove a car"};
            String choice = (String) JOptionPane.showInputDialog(frame,
                    "Please select your operations?",
                    "operations selection",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    choices, choices[0]
            );

            if (choice != null && choice.length() > 0) {
                if (choice.equals("Park a car")) {
                    rightClickParkcar(slot_id);
                } else if (choice.equals("Remove a car")){
                    rightClickRemoveCar(slot_id);
                }
            }

        }

        @Override
        public void mousePressed(MouseEvent e){
            String slot_id = ((JComponent) e.getSource()).getName();

            Object[] choices = {"Park a car", "Remove a car"};
            String choice = (String) JOptionPane.showInputDialog(frame,
                    "Please select your operations?",
                    "operations selection",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    choices, choices[0]
            );

            if (choice != null && choice.length() > 0) {
                if (choice.equals("Park a car")) {
                    rightClickParkcar(slot_id);
                } else if (choice.equals("Remove a car")){
                    rightClickRemoveCar(slot_id);
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    static class RightClickRemoveCarListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e){
            String slot_Id = this.getClass().getName();

            rightClickRemoveCar(slot_Id);
        }

        @Override
        public void mouseReleased(MouseEvent e) {

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

    public static void showAllSlot() {
        for (int i = 0; i < displaySlots.size(); i++) {
            panel_content_top.revalidate();
            panel_content_top.repaint();
            displaySlots.get(i).setVisible(true);
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
                    return;
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
                    return;
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
                    return;
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
                    displaySlots.get(i).setText(content1 + content2);

                    displaySlots.get(i).setBackground(new Color(225, 174, 190));
                    JOptionPane.showMessageDialog(frame,
                            "You have successfully park the car " + parkingSlot.get(i).getCar().getRegistrationNumber() + " into slot " + parkingSlot.get(i).getSlot_id() + ".",
                            "Successfully Parked",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    flag5 = false;
                }
            }
        }
    }

    public static void rightClickParkcar(String clickSlotId){
        String carNumber = null;
        boolean flag1 = true;
        boolean flag2 = true;

        for (int i = 0; i < parkingSlot.size(); i++) {
            if (parkingSlot.get(i).getSlot_id() == clickSlotId){
                String slotType = parkingSlot.get(i).getSlotType();
                if (parkingSlot.get(i).getCar()==null){
                    JOptionPane.showMessageDialog(frame,
                            "Please enter your car details to park the car:",
                            "Get started",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    while (flag1) {
                        carNumber = JOptionPane.showInputDialog(frame,
                                "Enter your car registration number, must looks like \"A12345\"",
                                "Car number",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        if (carNumber == null) {
                            operationCancelled();
                            return;
                        } else {
                            String registrationNumberFormat = "^[A-Z][0-9]{5}$";
                            if (carNumber.matches(registrationNumberFormat)) {
                                flag1 = false;
                            }
                        }
                    }
                    String ownerName = null;

                    while (flag2) {
                        ownerName = JOptionPane.showInputDialog(frame,
                                "Enter your name, must only contains letters from a-z.",
                                "Owner's name",
                                JOptionPane.PLAIN_MESSAGE
                        );
                        if (ownerName == null){
                            operationCancelled();
                            return;
                        } else {
                            String ownerNameFormat = "^[A-Za-z]{1,20}$";
                            if (ownerName.matches(ownerNameFormat)) {
                                flag2 = false;
                            }else {
                                JOptionPane.showMessageDialog(frame,
                                        "Name must be 1 to 20 characters, try again.",
                                        "Try again",
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                            }
                        }
                    }
                    parkingSlot.get(i).setCar(new Car(carNumber, ownerName, slotType));
                    parkingSlot.get(i).setOccupation("occupied");
                    String content1 = "<html>" + "<body>" + "SlotID: " + parkingSlot.get(i).getSlot_id() + " Slot type: " + parkingSlot.get(i).getSlotType();
                    String content2 = " ,Status: " + parkingSlot.get(i).getOccupation() + ", car registration No.: " + parkingSlot.get(i).getCar().getRegistrationNumber()
                            + " ,owner: " + parkingSlot.get(i).getCar().getOwner() + "</body></html>";
                    displaySlots.get(i).setText(content1 + content2);

                    displaySlots.get(i).setBackground(new Color(225, 174, 190));
                    JOptionPane.showMessageDialog(frame,
                            "You have successfully park the car " + parkingSlot.get(i).getCar().getRegistrationNumber() + " into slot " + parkingSlot.get(i).getSlot_id() + ".",
                            "Successfully Parked",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                }else{
                    JOptionPane.showMessageDialog(frame,
                            "The slot you have entered is occupied.",
                            "Slot occupied",
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
                    "Please enter a car number for removing, must looks like \"A12345\"",
                    "Find the car number",
                    JOptionPane.OK_CANCEL_OPTION
            );
            if (searchCar == null){
                operationCancelled();
                return;
            } else {
                String registrationNumberFormat = "^[A-Z][0-9]{5}$";
                if (searchCar.matches(registrationNumberFormat)){
                    for (int i = 0; i < parkingSlot.size(); i++) {
                        if (parkingSlot.get(i).getCar() != null) {
                            if (Objects.equals(parkingSlot.get(i).getCar().getRegistrationNumber(), searchCar)) {
                                JOptionPane.showMessageDialog(frame,
                                        "parkingSlot.get(i).getCar().toString()"+ " is now parking in "+ parkingSlot.get(i).getSlot_id()+", owner is "
                                        + parkingSlot.get(i).getCar().getOwner() + ".",
                                        "Parking place",
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                                return;
                            }else if (!Objects.equals(parkingSlot.get(i).getCar().getRegistrationNumber(), searchCar) && i == (parkingSlot.size()-1)){
                                JOptionPane.showMessageDialog(frame,
                                        "The car you have search was not found, try again.",
                                        "No car found",
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                            } else {

                            }
                        }else if (parkingSlot.get(i).getCar() == null && i ==(parkingSlot.size()-1)){
                            JOptionPane.showMessageDialog(frame,
                                    "The car you have search was not found, try again.",
                                    "No car found",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            continue;
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(frame,
                            "Format must looks like \"A00005\", please try again.",
                            "Format error",
                            JOptionPane.INFORMATION_MESSAGE
                    );
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
                        String content1 = "<html>" + "<body>" + "SlotID: " + parkingSlot.get(i).getSlot_id() + " Slot type: " + parkingSlot.get(i).getSlotType();
                        String content2 = " ,Status: " + parkingSlot.get(i).getOccupation() + "." + "</body></html>";
                        displaySlots.get(i).setText(content1 + content2);
                        parkingSlot.get(i).setCar(null);
                        if (parkingSlot.get(i).getSlotType() == "staff"){
                            displaySlots.get(i).setBackground(new Color(130, 146, 195));
                        }else {
                            displaySlots.get(i).setBackground(new Color(181, 202, 151));
                        }
                        panel_content_top.revalidate();
                        panel_content_top.repaint();
                        parkingSlot.get(i).setOccupation("not occupied");
                        return;
                    }else if (!Objects.equals(parkingSlot.get(i).getCar().getRegistrationNumber(), searchCar) && i == (parkingSlot.size()-1)){
                        JOptionPane.showMessageDialog(frame,
                                "Sorry, No such car park in here, try another one.",
                                "No car in the slot",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                } else if (parkingSlot.get(i).getCar() == null && i ==(parkingSlot.size()-1)){
                    JOptionPane.showMessageDialog(frame,
                            "Sorry, No such car park in here, try another one.",
                            "No car in the slot",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }
    }

    public static void rightClickRemoveCar(String slot_id){
        for (int i = 0; i < parkingSlot.size(); i++) {
            if (parkingSlot.get(i).getSlot_id()==slot_id){
                if (parkingSlot.get(i).getCar() != null) {
                        JOptionPane.showMessageDialog(frame,
                                "The car " + parkingSlot.get(i).getCar().getRegistrationNumber() + " has been removed successfully",
                                "removed successfully",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        String content1 = "<html>" + "<body>" + "SlotID: " + parkingSlot.get(i).getSlot_id() + " Slot type: " + parkingSlot.get(i).getSlotType();
                        String content2 = " ,Status: " + parkingSlot.get(i).getOccupation() + "." + "</body></html>";
                        displaySlots.get(i).setText(content1 + content2);
                        parkingSlot.get(i).setCar(null);
                        if (parkingSlot.get(i).getSlotType() == "staff"){
                            displaySlots.get(i).setBackground(new Color(130, 146, 195));
                        }else {
                            displaySlots.get(i).setBackground(new Color(181, 202, 151));
                        }
                        panel_content_top.revalidate();
                        panel_content_top.repaint();
                        parkingSlot.get(i).setOccupation("not occupied");
                        return;
                } else if (parkingSlot.get(i).getCar() == null){
                    continue;
                }
            }
        }
    }

    public static void addCarSlot1(CarPark carPark, Frame frame) {
            int staffSlot = Integer.parseInt(staffSlots.getText());
            int visitorSlot = Integer.parseInt(visitorSlots.getText());
            if ((staffSlot+visitorSlot)<=28){
                String occupation = "not occupied";
                Car car = null;
                ClickedButtonListener clickedButtonListener = new ClickedButtonListener();
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
                    labels.addMouseListener(clickedButtonListener);
                    displaySlots.add(labels);
                    panel_content_top.add(displaySlots.get(i));
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
                    labels.addMouseListener(clickedButtonListener);
                    displaySlots.add(labels);
                    panel_content_top.add(displaySlots.get(i+staffSlot));
                }
                createSlot.setVisible(false);
                hints.setVisible(false);
                panel_content_bottom.setVisible(false);
                showAll.setVisible(true);
                findCar.setVisible(true);
                parkCar.setVisible(true);
                deleteSlot.setVisible(true);
                removeCar.setVisible(true);
                addParkingSlot.setVisible(true);
                exitApplication.setVisible(true);
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
        }
        String clickSlotId = e.getComponent().getName();
        temporarilyStore.add(clickSlotId);
    }

    public static void addCarSlot2(Frame frame) {
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
                        return;
                    } else {
                        String registrationNumberFormat = "^[SV][0-9]{3}$";
                        if (slotNumber.matches(registrationNumberFormat)) {
                            for (int i = 0; i < parkingSlot.size(); i++) {
                                if (parkingSlot.get(i).getSlot_id().equals(slotNumber)) {
                                    JOptionPane.showMessageDialog(frame,
                                            "Sorry, the slot number you entered has already existed, try another one.",
                                            "Existed slot number",
                                            JOptionPane.INFORMATION_MESSAGE
                                    );
                                    break;
                                } else {
                                    if (slotNumber.contains("S")) {
                                        slotType = "staff";
                                        addSlotAfterChecked(slotNumber, slotType);
                                    } else {
                                        slotType = "visitor";
                                        addSlotAfterChecked(slotNumber, slotType);
                                    }
                                   return;
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
        String content1 = "<html>" + "<body>" + "SlotID: " + newSlotId + " Slot type: " + newSlotType;
        String content2 = " ,Status: " + occupation + "." + "</body></html>";
        labels.setText(content1 + content2);
        labels.setVisible(true);
        labels.setPreferredSize(new Dimension(300,80));
        if (newSlotType == "staff"){
            labels.setBackground(new Color(130, 146, 195));
        }else {
            labels.setBackground(new Color(181, 202, 151));
        }

        labels.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
        });
        labels.setName(newSlotId);
        displaySlots.add(labels);
        panel_content_top.add(displaySlots.get(displaySlots.size()-1));
        panel_content_top.revalidate();
        panel_content_top.repaint();
        JOptionPane.showMessageDialog(frame,
                "You have successfully created a new " + newSlot.getSlotType() + " slot " + newSlot.getSlot_id() + ".",
                "Successfully created",
                JOptionPane.INFORMATION_MESSAGE
        );

    }

    public static void rightClickDelete(String clickSlotId){
        for (int i = 0; i < parkingSlot.size(); i++) {
            if (clickSlotId.equals(parkingSlot.get(i).getSlot_id())) {
                if (parkingSlot.get(i).getCar() == null) {
                    JOptionPane.showMessageDialog(frame,
                            "You have successfully removed " + parkingSlot.get(i) + ".",
                            "Successfully deleted",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    parkingSlot.remove(i);
                    displaySlots.get(i).setVisible(false);
                    panel_content_bottom.remove(displaySlots.get(i));
                    displaySlots.remove(i);
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
                                "You have successfully removed " + parkingSlot.get(i).getSlot_id() + ".",
                                "Successfully deleted",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        parkingSlot.remove(i);
                        displaySlots.get(i).setVisible(false);
                        panel_content_bottom.remove(displaySlots.get(i));
                        displaySlots.remove(i);
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
                    JOptionPane.showMessageDialog(frame,
                            "Sorry, the slot ID you provided is not exist.",
                            "Not existed",
                            JOptionPane.INFORMATION_MESSAGE
                    );
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
