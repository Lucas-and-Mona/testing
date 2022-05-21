package carpark;
/**
 * Purpose: The class is for creating and managing GUI components and its listener methods.
 * @author Lucas Qin
 * student id: 103527269
 * @version java version "17.0.2" 2022-01-18 LTS
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

public class GUIApplication extends JFrame{
    static CarPark carPark = new CarPark();
    static ArrayList<ParkingSlot> parkingSlot = carPark.listAllSlots();
    static ArrayList<JButton> displaySlots = new ArrayList<>();
    static JFrame frame;
    static JPanel panel_content_top,panel_content_bottom,createSlot,panel_btn,panel_welcome_info;
    static JButton confirmCreate,slots,showAll,findCar,parkCar,deleteSlot,removeCar,addParkingSlot,exitApplication;
    static JTextField staffSlots,visitorSlots;
    static JLabel hints;

    /**
     * This is constructor for Application class
     */
    GUIApplication(){
        //        new JComponent objects
        frame = new JFrame();
        Container contentPane = frame.getContentPane();
        panel_btn = new JPanel();
        panel_welcome_info = new JPanel();
        panel_content_top = new JPanel();
        panel_content_bottom = new JPanel();
        showAll = new JButton("Show All Parking Slot");
        findCar = new JButton("Find Car");
        parkCar = new JButton("Park Car");
        deleteSlot = new JButton("Delete Slot");
        removeCar = new JButton("Remove Car");
        addParkingSlot = new JButton("Add Parking Slot");
        exitApplication = new JButton("Exit");
        createSlot = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to lucas car park");
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
        frame.setPreferredSize(new Dimension(950, 758));
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

// new listener object
        ShowAllListener showAllListener = new ShowAllListener();
        FindCarListener findCarListener = new FindCarListener();
        ParkCarListener parkCarListener = new ParkCarListener();
        DeleteSlotListener deleteSlotListener = new DeleteSlotListener();
        RemoveCarListener removeCarListener = new RemoveCarListener();
        AddParkingSlotListener2 addParkingSlotListener2 = new AddParkingSlotListener2();
        ExitApplicationListener exitApplicationListener = new ExitApplicationListener();
        AddParkingSlotListener1 addParkingSlotListener1 = new AddParkingSlotListener1();
        ChangeColor changeColor = new ChangeColor();

        //      attach event listeners to buttons
        showAll.addActionListener(showAllListener);
        findCar.addActionListener(findCarListener);
        parkCar.addActionListener(parkCarListener);
        deleteSlot.addActionListener(deleteSlotListener);
        removeCar.addActionListener(removeCarListener);
        addParkingSlot.addActionListener(addParkingSlotListener2);
        exitApplication.addActionListener(exitApplicationListener);
        confirmCreate.addActionListener(addParkingSlotListener1);


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

        //panel for containing buttons on the left side
        panel_btn.add(showAll);
        panel_btn.add(findCar);
        panel_btn.add(parkCar);
        panel_btn.add(deleteSlot);
        panel_btn.add(removeCar);
        panel_btn.add(addParkingSlot);
        panel_btn.add(exitApplication);
        panel_btn.revalidate();   //refresh the layout
        panel_btn.repaint();

        //panel for showing welcome infomation on the top
        panel_welcome_info.add(welcomeLabel);
        panel_content_bottom.add(hints);  //panel on the buttom
        panel_content_bottom.add(createSlot);

        //contentPane container for all 5 panels in JFrame
        contentPane.add(panel_welcome_info,BorderLayout.NORTH);
        contentPane.add(panel_content_top, BorderLayout.CENTER);
        contentPane.add(panel_content_bottom,BorderLayout.SOUTH);
        contentPane.add(panel_btn, BorderLayout.WEST);

        frame.pack();
        frame.setVisible(true);
        windowClose(frame);
    }

    /*
    Main function for Application GUI
     */
    public static void main(String[] args){
        new GUIApplication();
    }

    /**
     * A listener for show all slots button on the left-side
     */
    static class ShowAllListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            showAllSlot();
        }
    }

    /**
     * A listener for removing the car button on the left-side
     */
    static class FindCarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            findACar();  //refer to the method
        }
    }

    /**
     * A listener for parking car button on the left-side
     */
    static class ParkCarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            parkACar();
        }
    }

    /**
     * A listener for deleting a slot button on the left-side
     */
    static class DeleteSlotListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            deleteCarSlot(parkingSlot);
        }
    }

    /**
     * A listener for removing the car button on the left-side
     */
    static class RemoveCarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            removeACar();
        }
    }

    /**
     * A listener for adding parking slot the first time using the system
     */
    static class AddParkingSlotListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            addCarSlot1(carPark,frame);
        }
    }

    /**
     * A listner for adding parking slot button on the left-side
     */
    static class AddParkingSlotListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            addCarSlot2(frame);
        }
    }

    /**
     * A listener for exit button to exit the system
     */
    static class ExitApplicationListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    /**
     * A listener for changing colors of the left-side buttons in different operations
     */
    static class ChangeColor implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {    //when mouse click
            Object source = e.getSource();
            if (source instanceof JButton){
                ((JButton)source).setBackground(new Color(216,175,139));
            }
        }

        @Override
        public void mousePressed(MouseEvent e){    //when mouse press the button
            Object source = e.getSource();
            if (source instanceof JButton){
                ((JButton)source).setBackground(new Color(216,175,139));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {  //when mouse focus enter
            Object source = e.getSource();
            if (source instanceof JButton){
                ((JButton)source).setBackground(new Color(216,175,139));;
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {    //when mouse focus leave
            Object source = e.getSource();
            if (source instanceof JButton){
                ((JButton)source).setBackground(new Color(220,216,175));
            }
        }
    }

    /**
     * A listener for clicking a slot
     */
    static class ClickedSlotListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String slot_id = ((JComponent) e.getSource()).getName();    //get the slot's ID from click
            //operation select choice for user
            Object[] choices = {"Park a car", "Remove a car", "Delete a slot"};
            String choice = (String) JOptionPane.showInputDialog(frame,
                    "Please select your operations?",
                    "operations selection",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    choices, choices[0]
            );
            //user's different choice lead to different executions
            if (choice != null && choice.length() > 0) {
                if (choice.equals("Park a car")) {
                    clickParkcar(slot_id);
                } else if (choice.equals("Remove a car")){
                    clickRemoveCar(slot_id);
                } else if (choice.equals("Delete a slot")){
                    clickDeleteSlot(slot_id);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e){    //same as above mouse clicked
            String slot_id = ((JComponent) e.getSource()).getName();
            Object[] choices = {"Park a car", "Remove a car", "Delete a slot"};
            String choice = (String) JOptionPane.showInputDialog(frame,
                    "Please select your operations?",
                    "operations selection",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    choices, choices[0]
            );
            if (choice != null && choice.length() > 0) {
                if (choice.equals("Park a car")) {
                    clickParkcar(slot_id);
                } else if (choice.equals("Remove a car")){
                    clickRemoveCar(slot_id);
                } else if (choice.equals("Delete a slot")){
                    clickDeleteSlot(slot_id);
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

    /**
     * A method to close the JFrame window
     * @param frame
     */
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);    //when execute, system quit
            }
        });
    }

    /**
     * A method to display all slots
     */
    public static void showAllSlot() {
        panel_content_top.removeAll();    //remove all component in the panel first
        int count = 0; //counting how many staff slots in the arraylist
        for (int i = 0; i < displaySlots.size(); i++) {
            if (displaySlots.get(i).getName().contains("S")) {
                panel_content_top.add(displaySlots.get(i));  //readd the component
                panel_content_top.revalidate();//refresh the component after adding
                panel_content_top.repaint();
                count++;    //count add 1
            }
        }
        //loop to add visitor slot to panel again
        for (int i = 0; i < (displaySlots.size()-count); i++) {
            if (displaySlots.get(i+count).getName().contains("V")){
                panel_content_top.add(displaySlots.get(i+count));
                panel_content_top.revalidate();
                panel_content_top.repaint();
            }
        }


    }

    /**
     * A method for parking a car into a slot
     */
    public static void parkACar() {
        JOptionPane.showMessageDialog(frame,
                "Please enter your car details to park the car:",
                "Get started",
                JOptionPane.INFORMATION_MESSAGE
        );
        //ask user to enter car details
       String carNumber = null;
        boolean flag1 = true;
        while (flag1) {
            carNumber = JOptionPane.showInputDialog(frame,
                    "Enter your car registration number1, must looks like \"A12345\"",
                    "Car number",
                    JOptionPane.INFORMATION_MESSAGE
            );
            if (carNumber == null) {    //in case user cancel cause null false
                operationCancelled();
                return;
            } else {
                String registrationNumberFormat = "^[A-Z][0-9]{5}$";
                if (carNumber.matches(registrationNumberFormat)) {
                    flag1 =false;
                }
            }
        }
            //ask user to enter their name
            String ownerName = null;
            boolean flag2 = true;
            while (flag2) {
                ownerName = JOptionPane.showInputDialog(frame,
                        "Please enter your name, must only contains letters from a-z.",
                        "Owner name",
                        JOptionPane.INFORMATION_MESSAGE
                );
                if (ownerName == null){  //if user cancel the operation
                    operationCancelled();  //in case of null false, execute this
                    return;
                } else {
                    String ownerNameFormat = "^[A-Za-z]{1,20}$";
                    if (ownerName.matches(ownerNameFormat)) {
                        flag2 = false;
                    }
                }
            }
            //ask user to select a slot type
            String slotType = null;
            boolean flag4 = true;
            while (flag4) {
                //ask user to choose slot type
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
                        slotType = "Staff";  //if user choose staff type
                        JOptionPane.showMessageDialog(frame,
                                "Your slot type is staff.",
                                "Slot type",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        flag4 = false;
                        break;
                    case 1:
                        slotType = "visitor";    //if user choose visitor type
                        JOptionPane.showMessageDialog(frame,
                                "Your slot type is visitor.",
                                "Slot type",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        flag4 = false;
                        break;
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
                if (slotNumber == null){    //in case of null false if user cancel
                    operationCancelled();
                    return;
                } else {
                    for (int i = 0; i < parkingSlot.size(); i++) {    //loop over parkingSlot arraylist
                        if (slotNumber.equals(parkingSlot.get(i).getSlot_id())) {    //if the slot with provided slot id found
                            if (parkingSlot.get(i).getCar() == null) {    //check if the slot have a car parking
                                //check slot name is match with its slot type
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
                            //if it's the last object on the arraylist but still not equal, the slot not exist
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
                if (slotNumber.equals(parkingSlot.get(i).getSlot_id())) {    //get the slot id entered
                    parkingSlot.get(i).setCar(new Car(carNumber, ownerName, slotType));    //add a new car object to the slot
                    parkingSlot.get(i).setOccupation("occupied");    //set occupation status to occupied at the same time
                    //break the Jbutton's text into 2 parts to change line
                    String content1 = "<html>" + "<body>" + "SlotID: " + parkingSlot.get(i).getSlot_id() + " Slot type: " + parkingSlot.get(i).getSlotType();
                    String content2 = " ,Status: " + parkingSlot.get(i).getOccupation() + ", car registration No.: " + parkingSlot.get(i).getCar().getRegistrationNumber()
                            + " ,owner: " + parkingSlot.get(i).getCar().getOwner() + "</body></html>";
                    displaySlots.get(i).setText(content1 + content2);    //connect 2 parts of texts

                    displaySlots.get(i).setBackground(new Color(225, 174, 190));    //set the new button's color based on its type
                    //notify user that the car has been parked successfully
                    JOptionPane.showMessageDialog(frame,
                            "You have successfully park the car " + parkingSlot.get(i).getCar().getRegistrationNumber() + " into slot " + parkingSlot.get(i).getSlot_id() + ".",
                            "Successfully Parked",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                }
            }
        }

    /**
     * A method for park a car when user directly click the slot
     * @param clickSlotId
     */
    public static void clickParkcar(String clickSlotId){
        String carNumber = null;
        boolean flag1 = true;
        boolean flag2 = true;

        for (int i = 0; i < parkingSlot.size(); i++) {
            if (parkingSlot.get(i).getSlot_id() == clickSlotId){    //find the slot
                String slotType = parkingSlot.get(i).getSlotType();    //get the slot type
                if (parkingSlot.get(i).getCar()==null){    //if no car parking
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
                            operationCancelled();    //user cancel operation
                            return;
                        } else {
                            String registrationNumberFormat = "^[A-Z][0-9]{5}$";
                            if (carNumber.matches(registrationNumberFormat)) {
                                flag1 = false;
                            }
                        }
                    }
                    String ownerName = null;    //initiate owner's name

                    while (flag2) {
                        ownerName = JOptionPane.showInputDialog(frame,
                                "Enter your name, must only contains letters from a-z.",
                                "Owner's name",
                                JOptionPane.PLAIN_MESSAGE
                        );
                        if (ownerName == null){
                            operationCancelled();    //in case user cancell cause the null false
                            return;
                        } else {
                            String ownerNameFormat = "^[A-Za-z]{1,20}$";
                            if (ownerName.matches(ownerNameFormat)) {
                                flag2 = false;
                            }else {    //format not match
                                JOptionPane.showMessageDialog(frame,
                                        "Name must be 1 to 20 characters, try again.",
                                        "Try again",
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                            }
                        }
                    }
                    parkingSlot.get(i).setCar(new Car(carNumber, ownerName, slotType));    //add the car to a slot
                    parkingSlot.get(i).setOccupation("occupied");
                    String content1 = "<html>" + "<body>" + "SlotID: " + parkingSlot.get(i).getSlot_id() + " Slot type: " + parkingSlot.get(i).getSlotType();
                    String content2 = " ,Status: " + parkingSlot.get(i).getOccupation() + ", car registration No.: " + parkingSlot.get(i).getCar().getRegistrationNumber()
                            + " ,owner: " + parkingSlot.get(i).getCar().getOwner() + "</body></html>";
                    displaySlots.get(i).setText(content1 + content2);    //connect the 2 parts of text
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

    /**
     * A method for search a car in the whole parking site
     */
    public static void findACar() {
        String searchCar = null;
        boolean flag1 = true;
        while (flag1) {
            searchCar = JOptionPane.showInputDialog(frame,
                    "Please enter a car number for removing, must looks like \"A12345\"",
                    "Find the car number",
                    JOptionPane.OK_CANCEL_OPTION
            );
            if (searchCar == null){    //user cancel the search
                operationCancelled();
                return;
            } else {
                String registrationNumberFormat = "^[A-Z][0-9]{5}$";    //car registration information format
                if (searchCar.matches(registrationNumberFormat)){    //check if match format
                    for (int i = 0; i < parkingSlot.size(); i++) {    //loop over all parking slots
                        if (parkingSlot.get(i).getCar() != null) {    //if the slot is parking a car
                            if (Objects.equals(parkingSlot.get(i).getCar().getRegistrationNumber(), searchCar)) {
                                JOptionPane.showMessageDialog(frame,
                                        parkingSlot.get(i).getCar().getRegistrationNumber()+ " is now parking in "+ parkingSlot.get(i).getSlot_id()+", owner is "
                                        + parkingSlot.get(i).getCar().getOwner() + ".",
                                        "Parking place",
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                                return;
                                //if it's last parking that search but can't find the car that match
                            }else if (!Objects.equals(parkingSlot.get(i).getCar().getRegistrationNumber(), searchCar) && i == (parkingSlot.size()-1)){
                                JOptionPane.showMessageDialog(frame,
                                        "The car you have search was not found, try again.",
                                        "No car found",
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                            } else {

                            }
                            //if it's last parking slot that search but there is no car currently parking
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

    /**
     * A method for removing a car from a car slot
     */
    public static void removeACar() {
        String searchCar = null;
        boolean flag5 = true;
        while (flag5) {
            //ask user to provide car number
            searchCar = JOptionPane.showInputDialog(frame,
                    "Please enter a car number for removing, must looks like \\\"A12345\\\"",
                    "Remove the car number",
                    JOptionPane.INFORMATION_MESSAGE
            );
            if (searchCar ==null){    //if user cancel
                operationCancelled();
                return;
            } else {
                String registrationNumberFormat = "^[A-Z][0-9]{5}$";    //car number format
                if (searchCar.matches(registrationNumberFormat)){    //check if match
                    flag5 = false;
                }
            }
            for (int i = 0; i < parkingSlot.size(); i++) {
                if (parkingSlot.get(i).getCar() != null) {    //check if the parking slot have a car
                    if (Objects.equals(parkingSlot.get(i).getCar().getRegistrationNumber(), searchCar)) {
                        JOptionPane.showMessageDialog(frame,
                                "The car " + parkingSlot.get(i).getCar().getRegistrationNumber().toString() + " has been removed successfully",
                                "No car in the slot",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        parkingSlot.get(i).setOccupation("not occupied");  //recover the occupation to not occupied
                        //break text into a new line
                        String content1 = "<html>" + "<body>" + "SlotID: " + parkingSlot.get(i).getSlot_id() + " Slot type: " + parkingSlot.get(i).getSlotType();
                        String content2 = " ,Status: " + parkingSlot.get(i).getOccupation() + "." + "</body></html>";
                        displaySlots.get(i).setText(content1 + content2);    //connect the text and give it to the 'Slots' button
                        parkingSlot.get(i).setCar(null);    //remove the car object from a slot
                        if (parkingSlot.get(i).getSlotType() == "staff"){    //change color based on different type of user slot
                            displaySlots.get(i).setBackground(new Color(130, 146, 195));
                        }else {
                            displaySlots.get(i).setBackground(new Color(181, 202, 151));
                        }
                        panel_content_top.revalidate();
                        panel_content_top.repaint();    //refresh the component
                        return;
                        //if it's last slot and there is a car parking but the car not match with searched car
                    }else if (!Objects.equals(parkingSlot.get(i).getCar().getRegistrationNumber(), searchCar) && i == (parkingSlot.size()-1)){
                        JOptionPane.showMessageDialog(frame,
                                "Sorry, no such car park in here, try another one.",
                                "No car in the slot",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                    //if it's last slot but no car inside, then no such car parking
                } else if (parkingSlot.get(i).getCar() == null && i ==(parkingSlot.size()-1)){
                    JOptionPane.showMessageDialog(frame,
                            "Sorry, no such car park in here, try another one.",
                            "No car in the slot",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }
    }

    /**
     * A method for directly remove a car when clicking the slot
     * @param slot_id
     */
    public static void clickRemoveCar(String slot_id){
        for (int i = 0; i < parkingSlot.size(); i++) {
            if (parkingSlot.get(i).getSlot_id()==slot_id){    //get the slot
                if (parkingSlot.get(i).getCar() != null) {    //check if the slot has a car
                        JOptionPane.showMessageDialog(frame,
                                "The car " + parkingSlot.get(i).getCar().getRegistrationNumber() + " has been removed successfully",
                                "removed successfully",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        parkingSlot.get(i).setOccupation("not occupied");  //recover the occupation to not occupied
                        String content1 = "<html>" + "<body>" + "SlotID: " + parkingSlot.get(i).getSlot_id() + " Slot type: " + parkingSlot.get(i).getSlotType();
                        String content2 = " ,Status: " + parkingSlot.get(i).getOccupation() + "." + "</body></html>";
                        displaySlots.get(i).setText(content1 + content2);
                        parkingSlot.get(i).setCar(null);
                        //recover the color based on its type
                        if (parkingSlot.get(i).getSlotType() == "staff"){
                            displaySlots.get(i).setBackground(new Color(130, 146, 195));
                        }else {
                            displaySlots.get(i).setBackground(new Color(181, 202, 151));
                        }
                        panel_content_top.revalidate();
                        panel_content_top.repaint();    //refresh the components
                        return;
                } else if (parkingSlot.get(i).getCar() == null){
                    JOptionPane.showMessageDialog(frame,
                            "There is no car parking in this slot, try another one.",
                            "Empty slot",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }
    }

    /**
     * A method for initially adding car slot when open the system the first time
     * @param carPark
     * @param frame
     */
    public static void addCarSlot1(CarPark carPark, Frame frame) {
        String numberFormat = "^[0-9]{0,2}$";
        if (!staffSlots.getText().matches(numberFormat) || !visitorSlots.getText().matches(numberFormat)){
            JOptionPane.showMessageDialog(frame,
                    "Please only enter a number less than 100",
                    "quantity input error",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }else if (visitorSlots.getText().isEmpty() || staffSlots.getText().isEmpty()){
            JOptionPane.showMessageDialog(frame,
                    "Please enter quantity for staff and visitor slots, must less than 100",
                    "Empty input",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else{
            int staffSlot = Integer.parseInt(staffSlots.getText());    //get the number from text field
            int visitorSlot = Integer.parseInt(visitorSlots.getText());
            if ((staffSlot+visitorSlot)<=33){    //assumption that the premise can only contain 28 car park
                String occupation = "not occupied";    //initiate occupation status
                Car car = null;
                ClickedSlotListener ClickedSlotListener = new ClickedSlotListener();
                //for loop for creating staff type slots
                for (int i = 0; i < staffSlot; i++) {
                    String slot_id = String.format("S"+"%03d",(i+1));    //slot id format
                    String slotType = "staff";
                    carPark.addASlot(new ParkingSlot(slot_id, occupation, slotType, car));
                    slots = new JButton();    //a button that represents a slot
                    String content1 = "<html>" + "<body>" + "SlotID: " + parkingSlot.get(i).getSlot_id() + " Slot type: " + parkingSlot.get(i).getSlotType();
                    String content2 = " ,Status: " + parkingSlot.get(i).getOccupation() + "." + "</body></html>";
                    slots.setText(content1 + content2);    //slot button's content
                    slots.setVisible(true);    //make it visible
                    slots.setPreferredSize(new Dimension(245,52));    //initiate slot size
                    slots.setBackground(new Color(130, 146, 195));    //initiate slot color
                    slots.setName(slot_id);    //give a new Jbutton a unique name
                    slots.addMouseListener(ClickedSlotListener);    //add the button a listener
                    displaySlots.add(slots);    //add the button to a <JButton> type arraylist for displaying slots
                    panel_content_top.add(displaySlots.get(i));    //add the button to a panel
                }
                //for loop for creating visitor type slots
                for (int i = 0; i < visitorSlot; i++) {
                    String slot_id = String.format("V"+"%03d",(i+1));
                    String slotType = "visitor";
                    carPark.addASlot(new ParkingSlot(slot_id, occupation, slotType, car));
                    slots = new JButton();
                    String content1 = "<html>" + "<body>" + "SlotID: " + parkingSlot.get(i+staffSlot).getSlot_id() + " Slot type: " + parkingSlot.get(i+staffSlot).getSlotType();
                    String content2 = " ,Status: " + parkingSlot.get(i+staffSlot).getOccupation() + "." + "</body></html>";
                    slots.setText(content1 + content2);
                    slots.setVisible(true);
                    slots.setPreferredSize(new Dimension(245,52));
                    slots.setBackground(new Color(181, 202, 151));
                    slots.setName(slot_id);
                    slots.addMouseListener(ClickedSlotListener);
                    displaySlots.add(slots);
                    panel_content_top.add(displaySlots.get(i+staffSlot));
                }
                createSlot.setVisible(false);   //hide the panel after using
                hints.setVisible(false);    //hide the hint after using
                panel_content_bottom.setVisible(false);    //hide the panel on the bottom
                //show all buttons on the left side
                showAll.setVisible(true);
                findCar.setVisible(true);
                parkCar.setVisible(true);
                deleteSlot.setVisible(true);
                removeCar.setVisible(true);
                addParkingSlot.setVisible(true);
                exitApplication.setVisible(true);
            } else {    //if too many slots has been created, notify user there is no space
                JOptionPane.showMessageDialog(frame,
                        "Sorry, we don't have enough space for more than 33 car slots, please create less than 33 slots.",
                        "No space for slots",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }

    }

    /**
     * A method for adding a car slot and allow user to manually enter slot id
     * @param frame
     */
    public static void addCarSlot2(Frame frame) {
        if (parkingSlot.size()<= 33){
            boolean flag2 = true;
            String slotNumber = null;
            String slotType = null;
                while (flag2) {
                    //ask user to enter a slot number
                    slotNumber = JOptionPane.showInputDialog(frame,
                            "Please enter the slot number you want to create, must looks like \"S001\" or \"V001\"",
                            "Create a slot",
                            JOptionPane.PLAIN_MESSAGE
                    );
                    if (slotNumber == null) {    //in case user cancel cause null false
                        operationCancelled();
                        return;    //stop the while loop
                    } else {
                        String slotFormat = "^[SV][0-9]{3}$";    //slot id format
                        if (slotNumber.matches(slotFormat)) {
                            for (int i = 0; i < parkingSlot.size(); i++) {
                                if (parkingSlot.get(i).getSlot_id().equals(slotNumber)) {    //check if slot id already exist
                                    JOptionPane.showMessageDialog(frame,
                                            "Sorry, the slot number you entered has already existed, try another one.",
                                            "Existed slot number",
                                            JOptionPane.INFORMATION_MESSAGE
                                    );
                                    break;
                                } else if (!parkingSlot.get(i).getSlot_id().equals(slotNumber) && i != parkingSlot.size()-1){

                                } else if (!parkingSlot.get(i).getSlot_id().equals(slotNumber) && i == parkingSlot.size()-1){
                                        //add the slot
                                        if (slotNumber.contains("S")) {
                                            slotType = "staff";
                                            addSlotAfterChecked(slotNumber, slotType);  //this method add the slot to arraylists
                                        } else {
                                            slotType = "visitor";
                                            addSlotAfterChecked(slotNumber, slotType);
                                        }
                                        return;
                                    }
                                }
                            } else {    //slot id format not right
                            JOptionPane.showMessageDialog(frame,
                                    "The format is not correct.",
                                    "Incorrect format",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                }
        } else {
            //check total capacity of the car park
            JOptionPane.showMessageDialog(frame,
                    "Sorry, we don't have enough space for more than 33 car slots, please create less than 33 slots.",
                    "No space for slots",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    /**
     * A method purely for adding a slot without checking, checking parts in other methods
     * @param newSlotId
     * @param newSlotType
     */
    public static void addSlotAfterChecked(String newSlotId, String newSlotType){
        Car car = null;    //initiate car object to null
        String occupation = "not occupied";    //initiate car occupation status
        ParkingSlot newSlot = new ParkingSlot(newSlotId, occupation, newSlotType, car);    //create a new car object
        carPark.addASlot(newSlot);
        slots = new JButton();
        //initiate the button text in two lines
        String content1 = "<html>" + "<body>" + "SlotID: " + newSlotId + " Slot type: " + newSlotType;
        String content2 = " ,Status: " + occupation + "." + "</body></html>";
        slots.setText(content1 + content2);
        slots.setVisible(true);
        slots.setPreferredSize(new Dimension(245,52));
        if (newSlotType == "staff"){    //change color based on slot type
            slots.setBackground(new Color(130, 146, 195));
        }else {
            slots.setBackground(new Color(181, 202, 151));
        }
        
        slots.setName(newSlotId);
        ClickedSlotListener clickedSlotListener = new ClickedSlotListener();
        slots.addMouseListener(clickedSlotListener);
        displaySlots.add(slots);
        panel_content_top.add(displaySlots.get(displaySlots.size()-1));    //add newly created slot
        panel_content_top.revalidate();
        panel_content_top.repaint();  //refresh the components
        //notify user that the slot has been successfully created
        JOptionPane.showMessageDialog(frame,
                "You have successfully created a new " + newSlot.getSlotType() + " slot " + newSlot.getSlot_id() + ".",
                "Successfully created",
                JOptionPane.INFORMATION_MESSAGE
        );

    }

    /**
     * A method for user to directly delete a slot when click the slot
     * @param clickSlotId
     */
    public static void clickDeleteSlot(String clickSlotId){
        for (int i = 0; i < parkingSlot.size(); i++) {
            if (clickSlotId.equals(parkingSlot.get(i).getSlot_id())) {    //find the slot with the provided slot id
                if (parkingSlot.get(i).getCar() == null) {    //check if the slot is empty now,if empty, remove
                    JOptionPane.showMessageDialog(frame,
                            "You have successfully removed " + parkingSlot.get(i).getSlot_id() + ".",
                            "Successfully deleted",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    parkingSlot.remove(i);
                    displaySlots.get(i).setVisible(false);
                    panel_content_top.remove(displaySlots.get(i));
                    panel_content_top.revalidate();
                    panel_content_top.repaint();
                    displaySlots.remove(i);
                } else {
                    //if the slot has a car parking
                    JOptionPane.showMessageDialog(frame,
                            "Sorry, the slot is now parking a car, remove the car before deleting the slot.",
                            "Successfully deleted",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }

    }

    /**
     * A method for deleting a car slot through left-side button
     * @param parkingSlot
     */
    public static void deleteCarSlot (ArrayList < ParkingSlot > parkingSlot){
        boolean flag1 = true;
        boolean flag2 = true;
        String slotId = null;
        while (flag2) {
            while (flag1) {
                //ask user to provide the slot id to be deleted
                slotId = JOptionPane.showInputDialog(frame,
                        "Please enter the slot number you want to delete, must looks like \"S001\" or \"V001\"",
                        "Delete a slot",
                        JOptionPane.INFORMATION_MESSAGE
                );
                if (slotId == null){    //if user cancel the operation
                    operationCancelled();
                    flag1 = false;
                } else {
                    String slotIdFormat = "^[SV][0-9]{3}$";    //slot id format
                    if (slotId.toUpperCase().matches(slotIdFormat)) {    //if format match
                        flag1 = false;
                    } else {
                        continue;
                    }
                }
            }
            for (int i = 0; i < parkingSlot.size(); i++) {
                if (slotId.equals(parkingSlot.get(i).getSlot_id())) {    //find the slot with provided slot id
                    if (parkingSlot.get(i).getCar() == null) {    //if the slot is empty, remove
                        JOptionPane.showMessageDialog(frame,
                                "You have successfully removed " + parkingSlot.get(i).getSlot_id() + ".",
                                "Successfully deleted",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        panel_content_top.remove(displaySlots.get(i));
                        panel_content_top.revalidate();
                        panel_content_top.repaint();
                        parkingSlot.remove(i);    //remove the slot from arraylist
                        displaySlots.remove(i);  //remove the slot from button arraylist
                        flag2 = false;
                    } else {
                        //if there is a car parking in the slot
                        JOptionPane.showMessageDialog(frame,
                                "Sorry, the slot is now parking a car, remove the car before deleting the slot.",
                                "Successfully deleted",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        return;
                    }
                } else if (i != parkingSlot.size() - 1) {

                } else if (slotId.equals(parkingSlot.get(i).getSlot_id())&&i == parkingSlot.size()-1){
                    //if provided slot id not exist
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

    /**
     * A method for notify user that the operation has been cancelled
     */
    public static void operationCancelled(){
        //a notification dialog to let user know that they cancel the opreation
        JOptionPane.showMessageDialog(frame,
                "You have cancelled the operation.",
                "operation cancelled",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
