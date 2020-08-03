import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BoardPanel extends JPanel {
    ImageIcon controller = new ImageIcon();
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        g.drawImage(controller.getImage(),0,0,null);
        g.setColor(Color.BLACK);
        g.fillOval((int)(Main.leftx*25+100),(int)(Main.lefty*25+115),5,5);
        g.fillOval((int)(Main.rightx*25+320),(int)(Main.righty*25+200),5,5);
        if(Main.controller.getPov(0).toString().equalsIgnoreCase("north")) {
            g.fillRect(167, 165, 27, 30);
        }else if(Main.controller.getPov(0).toString().equalsIgnoreCase("south")) {
            g.fillRect(167, 220, 27, 30);
        }else if(Main.controller.getPov(0).toString().equalsIgnoreCase("east")) {
            g.fillRect(197, 195, 27, 30);
        }else if(Main.controller.getPov(0).toString().equalsIgnoreCase("west")) {
            g.fillRect(140, 195, 27, 30);
        }else if(Main.controller.getPov(0).toString().equalsIgnoreCase("northWest")) {
            g.fillRect(140, 195, 27, 30);
            g.fillRect(167, 165, 27, 30);
        }else if(Main.controller.getPov(0).toString().equalsIgnoreCase("southWest")) {
            g.fillRect(167, 220, 27, 30);
            g.fillRect(140, 195, 27, 30);
        }else if(Main.controller.getPov(0).toString().equalsIgnoreCase("southEast")) {
            g.fillRect(197, 195, 27, 30);
            g.fillRect(167, 220, 27, 30);
        }else if(Main.controller.getPov(0).toString().equalsIgnoreCase("northEast")) {
            g.fillRect(167, 165, 27, 30);
            g.fillRect(197, 195, 27, 30);




        }

        }
    BoardPanel(){
        super();
        try {
            controller = new ImageIcon(new URL("https://i.imgur.com/DmkGg6n.png"));
        }catch(MalformedURLException e) {
        }
        }

}
