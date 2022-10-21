package com.example.spring_ripper_java_config.screen_saver;

import java.awt.Color;
import java.awt.HeadlessException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.springframework.stereotype.Component;

@Component
public abstract class ColorFrame extends JFrame {

  public ColorFrame() throws HeadlessException {
    setSize(200, 200);
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public void showOnRandomPlace() {
    Random random = new Random();
    setLocation(random.nextInt(1200), random.nextInt(700));
    getContentPane().setBackground(getColor());
    repaint();
  }

  // Lookup метод
  protected abstract Color getColor();

}