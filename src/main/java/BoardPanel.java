import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BoardPanel extends JPanel {
    public static ImageIcon xboxController = new ImageIcon();
    public static ImageIcon xboxLeftbumper = new ImageIcon();
    public static ImageIcon xboxRightbumper = new ImageIcon();
    public static ImageIcon ps4Controller = new ImageIcon();
    public static Font calibri = new Font("Dialog",Font.PLAIN,15);
    public static Font biggerCalibri = calibri.deriveFont(20f);
    public static Color ps4Blue = new Color(3, 173, 252);
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        if (Main.controllerType.equalsIgnoreCase("XBOXONE") || Main.controllerPref.equals("XBOXONE")) {
            g.drawImage(xboxController.getImage(), 12, 10, null);
            g.setColor(Color.BLACK);

            g.fillOval((int) (Main.leftx * 26 + 101+12), (int) (Main.lefty * 25 + 114 + 10), 10, 10);
            g.fillOval((int) (Main.rightx * 26 + 321+12), (int) (Main.righty * 25 + 241 + 10 - 44), 10, 10);

            g.fillRect(75+12, 0 + 10, (int) (Main.ltrigger * 85), 15);
            g.fillRect(410+12, 0 + 10, -(int) (Main.rtrigger * 85), 15);

            if (Main.controller.getPov(0).toString().equalsIgnoreCase("north")) {
                g.fillRect(167+12, 165 + 10, 29, 30);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("south")) {
                g.fillRect(167+12, 220 + 10, 29, 30);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("east")) {
                g.fillRect(197+12, 195 + 10, 29, 30);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("west")) {
                g.fillRect(140+12, 195 + 10, 29, 30);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("northWest")) {
                g.fillRect(140+12, 195 + 10, 29, 30);
                g.fillRect(167+12, 165 + 10, 29, 30);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("southWest")) {
                g.fillRect(167+12, 220 + 10, 29, 30);
                g.fillRect(140+12, 195 + 10, 29, 30);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("southEast")) {
                g.fillRect(197+12, 195 + 10, 29, 30);
                g.fillRect(167+12, 220 + 10, 29, 30);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("northEast")) {
                g.fillRect(167+12, 165 + 10, 29, 30);
                g.fillRect(197+12, 195 + 10, 29, 30);
            }
            if (Main.controller.getButton(0)) {
                g.fillOval(367+12, 143 + 10, 30, 30);
                g.setColor(Color.GREEN);
                g.drawString("A", 379+12, 162 + 10);
                g.setColor(Color.BLACK);
            }
            if (Main.controller.getButton(1)) {
                g.fillOval(400+12, 110 + 10, 30, 30);
                g.setColor(Color.RED);
                g.drawString("B", 413+12, 129 + 10);
                g.setColor(Color.BLACK);

            }
            if (Main.controller.getButton(2)) {
                g.fillOval(333+12, 110 + 10, 30, 30);
                g.setColor(Color.CYAN);
                g.drawString("X", 346+12, 129 + 10);
                g.setColor(Color.BLACK);
            }
            if (Main.controller.getButton(3)) {
                g.fillOval(368+12, 74 + 10, 30, 30);
                g.setColor(Color.YELLOW);
                g.drawString("Y", 379+12, 10 + 93);
                g.setColor(Color.BLACK);
            }
            if (Main.controller.getButton(4)) {
                g.fillOval(195 - 9+12, 158 - 43 + 10, 20, 20);
            }
            if (Main.controller.getButton(6)) {
                g.fillOval(279 - 9+12, 158 - 43 + 10, 20, 20);
            }
            if (Main.controller.getButton(7)) {
                g.fillOval(166 - 9+12, 330 - 43 + 10, 50, 50);
                g.setColor(Color.WHITE);
                g.drawString("LS", 183 - 9+12, 360 - 43 + 10);
            }
            if (Main.controller.getButton(8)) {
                g.setColor(Color.BLACK);
                g.fillOval(306 - 9+12, 330 - 43 + 10, 50, 50);
                g.setColor(Color.WHITE);
                g.drawString("RS", 324 - 9+12, 360 - 43 + 10);
            }
            if (Main.controller.getButton(9)) {
                g.drawImage(xboxLeftbumper.getImage(), 62 - 8+12, 49 - 33 + 10, null);
            }
            if (Main.controller.getButton(10)) {
                g.drawImage(xboxRightbumper.getImage(), 305 - 8+12, 49 - 33 + 10, null);
            }

        } else if (Main.controllerType.equalsIgnoreCase("PS4") || Main.controllerPref.equals("PS4")) {
            g.setFont(biggerCalibri);
            g.drawImage(ps4Controller.getImage(), 7, 30, null);
            g.setColor(Color.BLACK);

            g.fillOval((int) (Main.leftx * 27 + 167+7), (int) (Main.lefty * 27 + 165 + 10), 10, 10);
            g.fillOval((int) (Main.rightx * 27 + 325+7), (int) (Main.righty * 27 + 165 + 10 ), 10, 10);

            g.fillRect(75, 0 + 10+5, (int) (Main.ltrigger * 85), 15);
            g.fillRect(410+27, 0 + 10+5, -(int) (Main.rtrigger * 85), 15);

            if (Main.controller.getPov(0).toString().equalsIgnoreCase("north")) {
                g.fillRect(82+7, 63 + 10, 29, 34);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("south")) {
                g.fillRect(82+7, 68+63, 29, 34);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("east")) {
                g.fillRect(82-31+7+56, 70+34, 33, 30);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("west")) {
                g.fillRect(82-31+7, 70+34, 33, 30);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("northWest")) {
                g.fillRect(82+7, 63 + 10, 29, 34);
                g.fillRect(82-31+7, 70+34, 33, 30);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("southWest")) {
                g.fillRect(82+7, 68+63, 29, 34);
                g.fillRect(82-31+7, 70+34, 33, 30);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("southEast")) {
                g.fillRect(82+7, 68+63, 29, 34);
                g.fillRect(82-31+7+56, 70+34, 33, 30);
            } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("northEast")) {
                g.fillRect(82+7, 63 + 10, 29, 34);
                g.fillRect(82-31+7+56, 70+34, 33, 30);
            }
            if (Main.controller.getButton(0)) {
                g.fillOval(367+26, 143 + 10-21, 38, 38);
                g.setColor(ps4Blue);
                g.drawString("X", 379+28, 162-15 + 10);
                g.setColor(Color.BLACK);
            }
            if (Main.controller.getButton(1)) {
                g.fillOval(400+27, 110 + 10-25, 38, 38);
                g.setColor(Color.RED);
                g.drawString("○", 413+26, 129-17 + 10);
                g.setColor(Color.BLACK);

            }
            if (Main.controller.getButton(2)) {

                g.fillOval(333+25, 110 + 10-25, 38, 38);
                g.setColor(Color.RED);
                g.drawString("☐", 346+24, 129-18 + 10);
                g.setColor(Color.BLACK);
            }
            if (Main.controller.getButton(3)) {
                g.fillOval(368+25, 74 + 10-19, 38, 38);
                g.setColor(Color.GREEN);
                g.drawString("△", 379+24, 10 -15+ 93);
                g.setColor(Color.BLACK);
            }
            if (Main.controller.getButton(4)) {
                g.fillRoundRect(149,57,15,25,12,20);
            }
            if (Main.controller.getButton(6)) {
                g.fillRoundRect(350,57,15,25,12,20);
            }
            if (Main.controller.getButton(7)) {
                g.fillOval(166 - 9, 330 - 43 + 10, 50, 50);
                g.setColor(Color.WHITE);
                g.drawString("L3", 183-12, 360 - 43 + 10);
                g.setColor(Color.BLACK);
            }
            if (Main.controller.getButton(8)) {
                g.setColor(Color.BLACK);
                g.fillOval(306 - 9, 330 - 43 + 10, 50, 50);
                g.setColor(Color.WHITE);
                g.drawString("R3", 324-12, 360 - 43 + 10);
                g.setColor(Color.BLACK);
            }
            if (Main.controller.getButton(9)) {
                g.fillArc(77,36,60,20,5,175);
            }
            if (Main.controller.getButton(10)) {
                g.fillArc(374,36,60,20,5,175);
            }
        }
    }
    BoardPanel(){
        super();
        try {
            xboxController = new ImageIcon(new URL("https://i.imgur.com/ebt6Rxk.png"));
            xboxLeftbumper = new ImageIcon(new URL("https://i.imgur.com/4pMtOND.png"));
            xboxRightbumper = new ImageIcon(new URL("https://i.imgur.com/oInlRrI.png"));
            ps4Controller = new ImageIcon(new URL("https://i.imgur.com/LkT738e.png"));
        }catch(MalformedURLException e) {
        }
        Main.frame.setIconImage(BoardPanel.xboxController.getImage());

    }

}
