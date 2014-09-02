/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jkeybinding;

import com.sun.glass.events.KeyEvent;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author Ivo
 */
public class JKeyBinding {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    KeySender ks = new KeySender();
    
    ks.send("F1");
    
    System.out.println(ProcessManager.isRunning("chrome.exe"));
    
    MyKeyListener mkl = new MyKeyListener();
    
  }

}
