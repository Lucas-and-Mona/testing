package carpark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

        public class JPopupMenuTest extends JFrame {
            private JPopupMenu popup;
            public JPopupMenuTest() {
                setTitle("JPopupMenu Test");
                Container contentPane = getContentPane() ;
                popup = new JPopupMenu();
                // add menu items to popup
                popup.add(new JMenuItem("Cut"));
                popup.add(new JMenuItem("Copy"));
                popup.add(new JMenuItem("Paste"));
                popup.addSeparator();
                popup.add(new JMenuItem("SelectAll"));

                contentPane.addMouseListener(new MouseAdapter() {
                    public void mouseReleased(MouseEvent me) {
                        showPopup(me); // showPopup() is our own user-defined method
                    }
                }) ;

                setSize(200, 250);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
                setVisible(true);
            }

            void showPopup(MouseEvent me) {
                if(me.isPopupTrigger())
                    popup.show(me.getComponent(), me.getX(), me.getY());
            }
            public static void main(String args[]) {
                new JPopupMenuTest();
            }
        }
