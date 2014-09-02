/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jkeybinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivo
 */
public class ProcessManager {
//      try {
//      String process;
//      Process p = Runtime.getRuntime().exec("TASKLIST /FI \"IMAGENAME eq chrome.exe\"");
//      BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
//      System.out.println(input.read());
//      while ((process = input.readLine()) != null) {
//        System.out.println(process);
//      }
//    } catch (IOException ex) {
//      Logger.getLogger(JKeyBinding.class.getName()).log(Level.SEVERE, null, ex);
//    }

  public static boolean isRunning(String processName) {
    try {
      String process;
      StringBuilder sb = new StringBuilder();
      String command = "TASKLIST /FI \"IMAGENAME eq chrome.exe\"";
      Process p = Runtime.getRuntime().exec(command);
      BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
      
      
      while ((process = input.readLine()) != null) {
        sb.append(process);
      }
      
      return sb.toString().contains(processName);

    } catch (IOException ex) {
      Logger.getLogger(JKeyBinding.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

}
