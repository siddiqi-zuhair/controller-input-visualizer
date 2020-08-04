import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BoardPanel extends JPanel {
    public static ImageIcon xboxController = new ImageIcon();
    public static ImageIcon xboxLeftbumper = new ImageIcon();
    public static ImageIcon xboxRightbumper = new ImageIcon();
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        g.drawImage(xboxController.getImage(), 0, 10, null);
        g.setColor(Color.BLACK);

        g.fillOval((int) (Main.leftx * 25 + 100), (int) (Main.lefty * 25 + 115+10), 5, 5);
        g.fillOval((int) (Main.rightx * 25 + 320), (int) (Main.righty * 25 + 200+10), 5, 5);

        g.fillRect(75, 0+10, (int) (Main.ltrigger * 85), 15);
        g.fillRect(410, 0+10, -(int) (Main.rtrigger * 85), 15);

        if (Main.controller.getPov(0).toString().equalsIgnoreCase("north")) {
            g.fillRect(167, 165+10, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("south")) {
            g.fillRect(167, 220+10, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("east")) {
            g.fillRect(197, 195+10, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("west")) {
            g.fillRect(140, 195+10, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("northWest")) {
            g.fillRect(140, 195+10, 27, 30);
            g.fillRect(167, 165+10, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("southWest")) {
            g.fillRect(167, 220+10, 27, 30);
            g.fillRect(140, 195+10, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("southEast")) {
            g.fillRect(197, 195+10, 27, 30);
            g.fillRect(167, 220+10, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("northEast")) {
            g.fillRect(167, 165+10, 27, 30);
            g.fillRect(197, 195+10, 27, 30);
        }
        if (Main.controller.getButton(0)) {
            g.fillOval(367, 143+10, 30, 30);
            g.setColor(Color.GREEN);
            g.drawString("A",379,162+10);
            g.setColor(Color.BLACK);
        }
        if (Main.controller.getButton(1)) {
            g.fillOval(400, 110+10, 30, 30);
            g.setColor(Color.RED);
            g.drawString("B",413,129+10);
            g.setColor(Color.BLACK);

        }
        if (Main.controller.getButton(2)) {
            g.fillOval(333, 110+10, 30, 30);
            g.setColor(Color.CYAN);
            g.drawString("X",346,129+10);
            g.setColor(Color.BLACK);
        }
        if (Main.controller.getButton(3)) {
            g.fillOval(368, 74+10, 30, 30);
            g.setColor(Color.YELLOW);
            g.drawString("Y",379,10+93);
            g.setColor(Color.BLACK);
        }
        if (Main.controller.getButton(4)) {
            g.fillOval(195 - 9, 158 - 43+10, 20, 20);
        }
        if (Main.controller.getButton(6)) {
            g.fillOval(279 - 9, 158 - 43+10, 20, 20);
        }
        if (Main.controller.getButton(7)) {
            g.fillOval(166 - 9, 330 - 43+10, 50, 50);
            g.setColor(Color.WHITE);
            g.drawString("LS",183-9,360-43+10);
        }
        if (Main.controller.getButton(8)) {
            g.setColor(Color.BLACK);
            g.fillOval(306 - 9, 330 - 43+10, 50, 50);
            g.setColor(Color.WHITE);
            g.drawString("RS", 324 - 9, 360 - 43+10);
        }
        if(Main.controller.getButton(9)){
            g.drawImage(xboxLeftbumper.getImage(), 62-8, 49-33+10, null);
        }
        if(Main.controller.getButton(10)){
            g.drawImage(xboxRightbumper.getImage(), 305-8, 49-33+10, null);
        }

        }
    BoardPanel(){
        super();
        try {
            xboxController = new ImageIcon(new URL("https://i.imgur.com/ebt6Rxk.png"));
            xboxLeftbumper = new ImageIcon(new URL("https://i.imgur.com/4pMtOND.png"));
            xboxRightbumper = new ImageIcon(new URL("https://i.imgur.com/oInlRrI.png"));
        }catch(MalformedURLException e) {
        }
        Main.frame.setIconImage(BoardPanel.xboxController.getImage());

    }

}
