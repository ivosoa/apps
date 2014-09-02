/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jkeybinding

import javax.swing.KeyStroke
import org.codehaus.groovy.control.CompilerConfiguration

/**
 *
 * @author Ivo
 */
class Main {
  
  public static void main(String[] args) {
    
    def binding = new Binding()
    def shell = new GroovyShell(binding)
    binding.send = { key ->
      KeySender ks = new KeySender();
      ks.send(key);
    }
    binding.listen = { app, key, cl ->
      KeyStroke ks = KeyStroke.getKeyStroke(key)
      KeyMacro km = new KeyMacro(app, ks.getKeyCode(), cl)
      println "listen"
    }
    
    File scriptFile = new File('scripts/myScript.groovy')
    if(scriptFile.exists()) {
      scriptFile.withReader('UTF-8') { Reader reader ->
        shell.evaluate(reader, scriptFile.name)
      }
    }    
  }
	
}

