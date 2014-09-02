/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jkeybinding

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException
import org.jnativehook.keyboard.NativeKeyEvent
import org.jnativehook.keyboard.NativeKeyListener

/**
 *
 * @author Ivo
 */
class KeyMacro implements NativeKeyListener{
  
  String key
  String app
  Closure closure
  
  public KeyMacro(app, key, closure) {
    this.key = key
    this.closure = closure
    this.app = app
    
    try {
      GlobalScreen.registerNativeHook();
    } catch (NativeHookException ex) {
      System.err.println("There was a problem registering the native hook.");
      System.err.println(ex.getMessage());
      System.exit(1);
    }
    GlobalScreen.getInstance().addNativeKeyListener(this);
  }

  @Override
  public void nativeKeyPressed(NativeKeyEvent e) {
    if(ProcessManager.isRunning(app)){
      if (e.getKeyCode() == key.toInteger()) {
        println true
        closure.call()
      }    
    }
    
    if (e.getKeyCode() == NativeKeyEvent.VK_ESCAPE) {
      GlobalScreen.unregisterNativeHook();
    }
  }

  @Override
  public void nativeKeyReleased(NativeKeyEvent e) {
    //System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
  }

  @Override
  public void nativeKeyTyped(NativeKeyEvent e) {
    //System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
  }
	
}

