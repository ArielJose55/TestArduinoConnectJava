/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testarduino;

import com.panamahitek.ArduinoException;

import testarduino.vista.MainFrame;

/**
 *
 * @author Ariel Arnedo
 */
public class TestArduino {

    /**
     * @param args the command line arguments
     * @throws ArduinoException 
     */
    public static void main(String[] args) throws ArduinoException {
        new MainFrame().setVisible(true);
    }
    
}
