package Render;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SplashScreen {

    private JWindow window;

    public SplashScreen() {
        this.window = new JWindow();
        try {
            window.getContentPane().add(new JLabel("Loading...", new ImageIcon(new URL("http://docs.oracle.com/javase/tutorial/uiswing/examples/misc/SplashDemoProject/src/misc/images/splash.gif")), SwingConstants.CENTER));
        } catch (MalformedURLException e) {e.printStackTrace();}
        window.setBounds(500, 150, 300, 200);
        window.setVisible(true);
        try {
            Thread.sleep(5000); // 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
    }
}
