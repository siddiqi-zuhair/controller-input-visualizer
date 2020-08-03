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


public class Main {
    public static JFrame frame = new JFrame("S Input Display");
    public static BoardPanel panel = new BoardPanel();
    public static SDL2ControllerManager controllerManager;
    public static boolean loop = true;
    public static SDL2Controller controller;
    public static float leftx;
    public static float lefty;
    public static float rightx;
    public static float righty;
    private static void init() {
        try {
            controllerManager = new SDL2ControllerManager();
            controller = (SDL2Controller) controllerManager.getControllers().get(0);
            while (loop) {
                controllerManager.pollState();
                String strPower = controller.getPowerLevel().toString();
                System.out.println(strPower);
                 leftx = controller.getAxis(0);
                 lefty = controller.getAxis(1);
                 rightx = controller.getAxis(2);
                 righty = controller.getAxis(3);
                System.out.println("Left X: " +leftx);
                System.out.println("Left Y: "+lefty);
                System.out.println("Right X: "+rightx);
                System.out.println("Right Y: "+righty);
                System.out.println(controller.getPov(0));
                panel.repaint();
            }
        }catch(SDL_Error e) {
        }
        }
    public static void main(String[] args) {

        panel.setPreferredSize(new Dimension(500,400));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        panel.setBackground(Color.WHITE);
        frame.setVisible(true);
        panel.repaint();
        init();



    }
}