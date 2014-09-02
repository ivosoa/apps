/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jkeybinding;

import com.sun.glass.events.KeyEvent;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.KeyStroke;

/**
 *
 * @author Ivo
 */
public class KeySender {

  private Robot robot;

  public KeySender() {
    try {
      robot = new Robot();
    } catch (AWTException ex) {
      Logger.getLogger(KeySender.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void send(String key) {
    KeyStroke ks = KeyStroke.getKeyStroke(key);
    robot.keyPress(ks.getKeyCode());
  }
}
