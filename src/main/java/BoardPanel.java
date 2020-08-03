import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BoardPanel extends JPanel {
    ImageIcon controller = new ImageIcon();
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        g.drawImage(controller.getImage(), 0, 0, null);
        g.setColor(Color.BLACK);

        g.fillOval((int) (Main.leftx * 25 + 100), (int) (Main.lefty * 25 + 115), 5, 5);
        g.fillOval((int) (Main.rightx * 25 + 320), (int) (Main.righty * 25 + 200), 5, 5);

        g.fillRect(75, 0, (int) (Main.ltrigger * 85), 15);
        g.fillRect(410, 0, -(int) (Main.rtrigger * 85), 15);

        if (Main.controller.getPov(0).toString().equalsIgnoreCase("north")) {
            g.fillRect(167, 165, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("south")) {
            g.fillRect(167, 220, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("east")) {
            g.fillRect(197, 195, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("west")) {
            g.fillRect(140, 195, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("northWest")) {
            g.fillRect(140, 195, 27, 30);
            g.fillRect(167, 165, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("southWest")) {
            g.fillRect(167, 220, 27, 30);
            g.fillRect(140, 195, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("southEast")) {
            g.fillRect(197, 195, 27, 30);
            g.fillRect(167, 220, 27, 30);
        } else if (Main.controller.getPov(0).toString().equalsIgnoreCase("northEast")) {
            g.fillRect(167, 165, 27, 30);
            g.fillRect(197, 195, 27, 30);
        }
        if (Main.controller.getButton(1)) {
            g.fillOval(400, 110, 30, 30);
        }
        if (Main.controller.getButton(0)) {
            g.fillOval(367, 145, 30, 30);
        }
        if (Main.controller.getButton(2)) {
            g.fillOval(333, 110, 30, 30);
        }
        if (Main.controller.getButton(3)) {
            g.fillOval(368, 74, 30, 30);
        }
        if (Main.controller.getButton(4)) {
            g.fillOval(195 - 9, 158 - 43, 20, 20);
        }
        if (Main.controller.getButton(6)) {
            g.fillOval(279 - 9, 158 - 43, 20, 20);
        }
        if (Main.controller.getButton(7)) {
            g.fillOval(166 - 9, 330 - 43, 50, 50);
            g.setColor(Color.WHITE);
            g.drawString("LS",183-9,360-43);
        }
        if (Main.controller.getButton(8)) {
            g.setColor(Color.BLACK);
            g.fillOval(306 - 9, 330 - 43, 50, 50);
            g.setColor(Color.WHITE);
            g.drawString("RS", 324 - 9, 360 - 43);
        }

        }
    BoardPanel(){
        super();
        try {
            controller = new ImageIcon(new URL("https://i.imgur.com/KdEBQMA.png"));
        }catch(MalformedURLException e) {
        }
        }

}
