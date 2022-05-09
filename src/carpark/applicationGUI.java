package carpark;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import static carpark.Application.*;

public class applicationGUI extends JFrame{
    static CarPark carPark = new CarPark();
    static ArrayList<ParkingSlot> parkingSlot = carPark.listAllSlots();

    private JButton showAll;
    private JButton findCar;
    private JButton parkCar;
    private JButton deleteSlot;
    private JButton removeCar;
    private JButton addParkingSlot;
    private JButton exitApplication;
    private JButton clearScreen;

    private JPanel mainPanel;
    private JPanel panelButton;
    private JList list1;
    private JPanel contentPanel;

    static Scanner sc = new Scanner(System.in);

    public applicationGUI(String title) {
        super(title);
        this.setContentPane(mainPanel);
        this.pack();

        showAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllSlot();
            }
        });

        findCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findACar(sc);
            }
        });

        parkCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parkACar(sc);
            }
        });

        deleteSlot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCarSlot(sc,parkingSlot);
            }
        });

        removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeACar(sc);
            }
        });

        addParkingSlot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCarSlot1(sc, carPark);
                System.out.println("Testing");
            }
        });

        exitApplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCarSlot(sc,parkingSlot);
            }
        });
        addParkingSlot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCarSlot1(sc, carPark);
            }
        });
    }

    public static void main(String[] args){
        addCarSlot1(sc,carPark);
        JFrame jFrame = new applicationGUI("Lucas car park");
        jFrame.setLayout(new FlowLayout());
        jFrame.setBounds(400, 300, 1200, 800);

        JPanel mainPanel = new JPanel();
        JPanel panelButton = new JPanel();


        jFrame.setVisible(true);
        Container contentPane = jFrame.getContentPane();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

//    private void createUIComponents() {
        // TODO: place custom component creation code here
//        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        btnPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//
//        JButton showAll = new JButton("Show All Parking Slot");
//        showAll.setPreferredSize(new Dimension(140, 90));
//        JButton findCar = new JButton("Find Car");
//        findCar.setPreferredSize(new Dimension(140, 90));
//        JButton parkCar = new JButton("Park Car");
//        parkCar.setPreferredSize(new Dimension(140, 90));
//        JButton deleteSlot = new JButton("Delete Slot");
//        deleteSlot.setPreferredSize(new Dimension(140, 90));
//        JButton removeCar = new JButton("Remove Car");
//        removeCar.setPreferredSize(new Dimension(140, 90));
//        JButton addParkingSlot = new JButton("Add Parking Slot");
//        addParkingSlot.setPreferredSize(new Dimension(140, 90));
//        JButton exitApplication = new JButton("Exit");
//        exitApplication.setPreferredSize(new Dimension(140, 90));
//        JButton clearScreen = new JButton("Clear Screen");
//        clearScreen.setPreferredSize(new Dimension(140, 90));
//
//        btnPanel.add(showAll);
//        btnPanel.add(findCar);
//        btnPanel.add(parkCar);
//        btnPanel.add(deleteSlot);
//        btnPanel.add(removeCar);
//        btnPanel.add(addParkingSlot);
//        btnPanel.add(exitApplication);
//        btnPanel.add(clearScreen);
//
//
//    }
}
