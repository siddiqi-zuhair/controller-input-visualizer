import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;
import org.libsdl.SDL;
import org.libsdl.SDL_Error;
import org.libsdl.SDL_GameController;
import uk.co.electronstudio.sdl2gdx.SDL2Controller;
import uk.co.electronstudio.sdl2gdx.SDL2ControllerManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class Main extends Component implements ActionListener {
    public static JFrame frame = new JFrame("Gamepad Input Display");
    public static BoardPanel panel = new BoardPanel();
    public static JMenuBar optionBar  = new JMenuBar();
    public static JMenu optionsMenu = new JMenu("Options");
    public static JMenuItem colorChooser = new JMenuItem("Color Chooser");
    public static JMenu controllerMenu = new JMenu("Controller Type");
    public static JMenuItem xboxoneControlleritem = new JMenuItem("Xbox One");
    public static JMenuItem ps4Controlleritem = new JMenuItem("PS4");
    public static SDL2ControllerManager controllerManager;
    public static SDL2Controller controller;

    public static float leftx;
    public static float lefty;
    public static float rightx;
    public static float righty;
    public static float ltrigger;
    public static float rtrigger;

    Color initColor = Color.WHITE;
    Color bgColor = Color.WHITE;

    public static String controllerType = "Fart";
    public static String controllerPref = "Fart";
    public Timer time = new Timer(1000/60, this);

    public  void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == time) {
            try {
                PointerInfo a = MouseInfo.getPointerInfo();
                Point b = a.getLocation();

                double mousex = b.getX();
                double mousey = b.getY();
                controllerManager.pollState();
                String strPower = controller.getPowerLevel().toString();
                ;
                //System.out.println(strPower);
                leftx = controller.getAxis(0);
                lefty = controller.getAxis(1);
                rightx = controller.getAxis(2);
                righty = controller.getAxis(3);
                ltrigger = controller.getAxis(4);
                rtrigger = controller.getAxis(5);
                //System.out.println(ltrigger);
                //     System.out.println("Left X: " +leftx);
                //  System.out.println("Left Y: "+lefty);
                //System.out.println("Right X: "+rightx);
                // System.out.println("Right Y: "+righty);
                // System.out.println(controller.getPov(0));
                panel.repaint();
            } catch (SDL_Error e) {
            }
        }
        if (evt.getSource() == colorChooser) {
            bgColor = JColorChooser.showDialog(this, "Pick a background color", initColor);
            panel.setBackground(bgColor);
        } else if (evt.getSource() == xboxoneControlleritem) {
            controllerPref = "XBOXONE";
            time.stop();
            time.start();
        } else if (evt.getSource() == ps4Controlleritem) {
            controllerPref = "PS4";
            time.stop();
            time.start();
        }
    }
    public void windowClosinng(WindowEvent evt){

    }
        public Main(){
                panel.setPreferredSize(new Dimension(515,400));
                panel.setLayout(null);
                optionBar.setLocation(0,0);
                optionBar.setSize(515,15);
                optionBar.add(optionsMenu);
                optionsMenu.add(colorChooser);
                panel.add(optionBar);
                panel.add(controllerMenu);
                optionBar.add(controllerMenu);
                controllerMenu.add(xboxoneControlleritem);
                controllerMenu.add(ps4Controlleritem);
                colorChooser.addActionListener(this);
                xboxoneControlleritem.addActionListener(this);
                ps4Controlleritem.addActionListener(this);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(panel);
                frame.pack();
                panel.setBackground(initColor);

                frame.setResizable(false);
                frame.setVisible(true);
                panel.repaint();
                controllerManager = new SDL2ControllerManager(SDL2ControllerManager.InputPreference.XINPUT);
                controller = (SDL2Controller) controllerManager.getControllers().get(0);
                controllerType = controller.getType().toString();
                time.start();
            }
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName()); //setLookandFeel for modern Windows 10 look on buttons and other JComponents

        new Main();



    }
}