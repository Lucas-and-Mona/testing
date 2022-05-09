package carpark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import static carpark.Application.*;
import static carpark.applicationGUI.sc;

public class GUIPanel extends JFrame{
    public GUIPanel(){
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){

//        define frame and set sizes
        JFrame frame = new JFrame();
        JPanel panel_btn = new JPanel();

        frame.setLayout(null);
        frame.setBounds(300, 300, 1000, 800);
        frame.setBackground(new Color(171, 180, 207));

//        define panel container
        panel_btn.setBounds(0, 0, 150, 900);
        panel_btn.setBackground(new Color(147, 159, 197));

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

        //attach event listeners to buttons
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

        AddParkingSlotListener addParkingSlotListener = new AddParkingSlotListener();
        addParkingSlot.addActionListener(addParkingSlotListener);

        ExitApplicationListener exitApplicationListener = new ExitApplicationListener();
        exitApplication.addActionListener(exitApplicationListener);

        ClearScreenListener clearScreenListener = new ClearScreenListener();
        clearScreen.addActionListener(clearScreenListener);

//        EventMonitor eventMonitor = new EventMonitor();
//        showAll.setActionCommand("showAll");
//        findCar.setActionCommand("findCar");
//        parkCar.setActionCommand("parkCar");
//        deleteSlot.setActionCommand("deleteSlot");
//        removeCar.setActionCommand("removeCar");
//        addParkingSlot.setActionCommand("addParkingSlot");
//        exitApplication.setActionCommand("exitApplication");



//        add buttons to panel
        panel_btn.add(showAll);
        panel_btn.add(findCar);
        panel_btn.add(parkCar);
        panel_btn.add(deleteSlot);
        panel_btn.add(removeCar);
        panel_btn.add(addParkingSlot);
        panel_btn.add(exitApplication);
        panel_btn.add(clearScreen);

//        add panel to frame
        frame.add(panel_btn);
//        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        windowClose(frame);


    }
//    static class EventMonitor implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e){
//            if (e.getActionCommand().equals("showAll")){
//                System.out.println("1111111111111111");
//                showAllSlot();
//            } else if (e.getActionCommand().equals("findCar")){
//                findACar(sc);
//            }else if (e.getActionCommand().equals("parkCar")){
//                parkACar(sc);
//            }else if (e.getActionCommand().equals("deleteSlot")){
//                deleteCarSlot(sc,parkingSlot);
//            }else if (e.getActionCommand().equals("removeCar")){
//                removeACar(sc);
//            }else if (e.getActionCommand().equals("addParkingSlot")){
//                addCarSlot1(sc, carPark);
//            }else if (e.getActionCommand().equals("exitApplication")){
//                System.exit(0);
//            }
//        }
//    }

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

    static class AddParkingSlotListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("6666666666666666666666");

            addCarSlot1(sc, carPark);
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
