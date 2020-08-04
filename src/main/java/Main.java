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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class Main extends Component implements ActionListener {
    public static JFrame frame = new JFrame("Gamepad Input Display");
    public static BoardPanel panel = new BoardPanel();
    public static JMenuBar optionBar  = new JMenuBar();
    public static JMenu optionsMenu = new JMenu("Options");
    public static JMenuItem colorChooser = new JMenuItem("Color Chooser");

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

    public static String controllerType;
    public Timer time = new Timer(1000/60, this);

    public  void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == time) {
            try {
                System.out.println(controllerType);
                PointerInfo a = MouseInfo.getPointerInfo();
                Point b = a.getLocation();

                double mousex = b.getX();
                double mousey = b.getY();
                //    System.out.println("Mouse X: " + mousex);
                //  System.out.println("Mouse Y: " +mousey);
                controllerManager.pollState();
                String strPower = controller.getPowerLevel().toString();
                System.out.println(controller.getPlayerIndex());
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
        }
    }
        public Main(){
                panel.setPreferredSize(new Dimension(495,400));
                panel.setLayout(null);
                optionBar.setLocation(0,0);
                optionBar.setSize(495,15);
                optionBar.add(optionsMenu);
                optionsMenu.add(colorChooser);
                panel.add(optionBar);
                colorChooser.addActionListener(this);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(panel);
                frame.pack();

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