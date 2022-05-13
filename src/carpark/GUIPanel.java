package carpark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import static carpark.Application.*;

public class GUIPanel extends JFrame{
    static JFrame frame;
    static JPanel panel_content_top;
    static JPanel panel_content_bottom;
    static JPanel createSlot;
    static JPanel panel_btn;
    static JPanel panel_welcome_info;
    static JButton confirmCreate;
    static JButton[] labels;
    static Scanner sc;
    static JTextField staffSlots;
    static JTextField visitorSlots;
    static JLabel hints;

    public GUIPanel(){
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(null);
//        container.add(frame);
    }

    public static void main(String[] args){

//        define frame and set sizes
        frame = new JFrame();
        frame.setLayout(null);
//        frame.setBounds(300, 300, 1000, 800);
        frame.setMinimumSize(new Dimension(1000, 800));
        frame.setBackground(new Color(171, 180, 207));

//        define panel container
        panel_btn = new JPanel();
        panel_welcome_info = new JPanel();
        panel_content_top = new JPanel();
        panel_content_bottom = new JPanel();
        panel_content_bottom.setLayout(new FlowLayout());

        panel_btn.setBounds(0, 0, 150, 800);
        panel_welcome_info.setBounds(150, 0, 850, 100);
        panel_content_top.setBounds(150, 100, 850, 100);
        panel_content_bottom.setBounds(150, 400, 850, 500);
        panel_btn.setBackground(new Color(147, 159, 197));

        panel_content_top.setBackground(new Color(141, 119, 140));
        panel_content_bottom.setBackground(new Color(200, 170, 198));
        panel_welcome_info.setBackground(new Color(181,202,12));

//        define a label
        JLabel welcomeLabel = new JLabel("Welcome to lucas car park");
        welcomeLabel.setBounds(160, 0, 200, 100);
//        welcomeLabel.setPreferredSize(new Dimension(200, 100));

        //labels for slots
//        labels = new JButton[28];
//
//        for (int i=0; i<28; i++){
//            labels[i] = new JButton();
//            labels[i].setPreferredSize(new Dimension(400,40));
//            labels[i].setBackground(new Color(171, 180, 207));
//            labels[i].setText("label"+i);
//            panel_content_bottom.add(labels[i]);
//            labels[i].setVisible(true);
//        }


//        Define buttons and set sizes
        JButton showAll = new JButton("Show All Parking Slot");
        showAll.setPreferredSize(new Dimension(140, 90));
        JButton findCar = new JButton("Find Car");
        findCar.setPreferredSize(new Dimension(140, 90));
        JButton parkCar = new JButton("Park Car");
        parkCar.setPreferredSize(new Dimension(140, 90));
        JButton deleteSlot = new JButton("Delete Slot");
        deleteSlot.setPreferredSize(new Dimension(140, 90));
        JButton removeCar = new JButton("Remove Car");
        removeCar.setPreferredSize(new Dimension(140, 90));
        JButton addParkingSlot = new JButton("Add Parking Slot");
        addParkingSlot.setPreferredSize(new Dimension(140, 90));
        JButton exitApplication = new JButton("Exit");
        exitApplication.setPreferredSize(new Dimension(140, 90));
        JButton clearScreen = new JButton("Clear Screen");
        clearScreen.setPreferredSize(new Dimension(140, 90));

//      create multiple input window
        createSlot = new JPanel();
        createSlot.setBackground(new Color(237, 219, 235));
        createSlot.setBounds(150, 250, 790, 200);
        createSlot.setLayout(new FlowLayout());
        JLabel newStaff = new JLabel("Staff slot quantity: ");
        newStaff.setPreferredSize(new Dimension(150, 30));
        JLabel newVisitor = new JLabel("Visitor slot quantity: ");
        newVisitor.setPreferredSize(new Dimension(150, 30));
        hints = new JLabel("There is no parking slot in the car park, please enter the quantity of staff and vistor slots to be created.");
        hints.setBackground(new Color(141, 119, 140));
        hints.setPreferredSize(new Dimension(700, 30));

        confirmCreate = new JButton("confirm");
        confirmCreate.setPreferredSize(new Dimension(90, 30));

        staffSlots = new JTextField();
        staffSlots.setBackground(new Color(237, 202, 235));
        staffSlots.setPreferredSize(new Dimension(160, 30));
        visitorSlots = new JTextField();
        visitorSlots.setBackground(new Color(237, 202, 235));
        visitorSlots.setPreferredSize(new Dimension(160, 30));

        createSlot.add(hints, BorderLayout.NORTH);
        createSlot.add(newStaff);
        createSlot.add(staffSlots);
        createSlot.add(Box.createHorizontalStrut(20));
        createSlot.add(newVisitor);
        createSlot.add(visitorSlots);
        createSlot.add(confirmCreate);

//      attach event listeners to buttons
        ShowAllListener showAllListener = new ShowAllListener();
        showAll.addActionListener(showAllListener);

        FindCarListener findCarListener = new FindCarListener();
        findCar.addActionListener(findCarListener);

        ParkCarListener parkCarListener = new ParkCarListener();
        parkCar.addActionListener(parkCarListener);

        DeleteSlotListener deleteSlotListener = new DeleteSlotListener();
        deleteSlot.addActionListener(deleteSlotListener);

        RemoveCarListener removeCarListener = new RemoveCarListener();
        removeCar.addActionListener(removeCarListener);

        AddParkingSlotListener2 addParkingSlotListener2 = new AddParkingSlotListener2();
        addParkingSlot.addActionListener(addParkingSlotListener2);

        ExitApplicationListener exitApplicationListener = new ExitApplicationListener();
        exitApplication.addActionListener(exitApplicationListener);

        ClearScreenListener clearScreenListener = new ClearScreenListener();
        clearScreen.addActionListener(clearScreenListener);

        AddParkingSlotListener1 addParkingSlotListener1 = new AddParkingSlotListener1();
        confirmCreate.addActionListener(addParkingSlotListener1);


//        add buttons to panel
        panel_btn.add(showAll);
        panel_btn.add(findCar);
        panel_btn.add(parkCar);
        panel_btn.add(deleteSlot);
        panel_btn.add(removeCar);
        panel_btn.add(addParkingSlot);
        panel_btn.add(exitApplication);
        panel_btn.add(clearScreen);

        panel_welcome_info.add(welcomeLabel);
        panel_content_top.add(hints);
        panel_content_top.add(createSlot);


//        add panel to frame
        frame.add(panel_btn);
        frame.add(panel_welcome_info);
        frame.add(panel_content_top);
        frame.add(panel_content_bottom);
//        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
        windowClose(frame);

    }

    static class ShowAllListener implements ActionListener{
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
            findACar(sc);
        }
    }

    static class ParkCarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("33333333333333333333333");
            parkACar(sc);
        }
    }

    static class DeleteSlotListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("444444444444444444444444444444");
            deleteCarSlot(sc,parkingSlot);
        }
    }

    static class RemoveCarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("55555555555555555555555555");
            removeACar(sc);
        }
    }

    static class AddParkingSlotListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("6666666666666666666666");

            addCarSlot1(sc, carPark,frame);
        }
    }

    static class AddParkingSlotListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("6666666666666666666666");

            addCarSlot2(sc, carPark,frame);
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

    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
