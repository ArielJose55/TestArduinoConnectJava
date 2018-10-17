/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import com.panamahitek.ArduinoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import testarduino.logica.Arduino;

/**
 *
 * @author Ariel Arnedo
 */
public class SerialArduinoListener implements SerialPortEventListener{

    private JTextPane jTextArea;
    
    public SerialArduinoListener() {
    }

    public void setjTextArea(JTextPane jTextArea) {
        this.jTextArea = jTextArea;
    }

    public JTextPane getjTextArea() {
        return jTextArea;
    }
    
    @Override
    public void serialEvent(SerialPortEvent spe) {
        if(spe.isRXCHAR()){
            try {
                jTextArea.setText(Arduino.getArduino().getPanamahitekArduino().printMessage());
            } catch (    SerialPortException | ArduinoException ex) {
                Logger.getLogger(SerialArduinoListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
