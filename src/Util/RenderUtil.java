package Util;

import javax.swing.*;
import java.awt.*;

public class RenderUtil {

    public static void setupComponent(JComponent button, Dimension<Integer> dimension, Color color) {
        button.setVisible(true);
        button.setBounds(dimension.getX(),dimension.getY(), dimension.getWidth(), dimension.getHeight());
        button.setBackground(color);
    }

    public static void setupComponent(JComponent button, Dimension<Integer> dimension) {
        button.setVisible(true);
        button.setBounds(dimension.getX(), dimension.getY(), dimension.getWidth(), dimension.getHeight());
    }

    public static void setDimensions(JComponent button, Dimension<Integer> dimension) {
        button.setBounds(dimension.getX(), dimension.getY(), dimension.getWidth(), dimension.getHeight());
    }

    public static void handleColouring(JComponent button, Color foreground, Color background) {
        button.setBackground(background);
        button.setForeground(foreground);
    }

    public static void handleColouring(JComponent button, Color background) {
        button.setBackground(background);
    }
}
