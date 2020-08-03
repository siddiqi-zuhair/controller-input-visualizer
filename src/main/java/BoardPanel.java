import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    ImageIcon controller = new ImageIcon();
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillOval((int)(Main.leftx*25+125),(int)(Main.lefty*25+250),5,5);
        g.fillOval((int)(Main.rightx*25+375),(int)(Main.righty*25+250),5,5);

    }
    BoardPanel(){
        super();
    }
}
