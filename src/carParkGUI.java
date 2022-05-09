import carpark.CarPark;
import carpark.ParkingSlot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import static carpark.Application.*;


public class carParkGUI extends JFrame {

    private JPanel panel1;
    private JPanel mainPanel;
    private JButton removeCar;
    private JButton clearScreen;
    private JButton addParkingSpot;
    private JButton showAll;
    private JButton findCar;
    private JButton deleteSpot;
    private JButton parkCar;
    private JButton exitApplication;
    private JList list1;
    static CarPark carPark = new CarPark();
    static ArrayList<ParkingSlot> parkingSlot = carPark.listAllSlots();
    Scanner sc = new Scanner(System.in);

    public carParkGUI(String title){
        super(title);
        this.setContentPane(mainPanel);
        this.pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<ParkingSlot> parkingSlots = new ArrayList<>();
                showAllSlot();
                for (int i = 0; i < parkingSlots.size(); i++) {
                    System.out.println(parkingSlots.get(i).getSlot_id());
                }
            }
        });
        addParkingSpot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCarSlot1(sc, carPark);
            }
        });
    }

    public static void main(String[] args){
        JFrame jFrame = new JFrame("Lucas car park");
        jFrame.setVisible(true);
        Container contentPane = jFrame.getContentPane();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

}
