/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testarduino.logica;

import com.panamahitek.ArduinoException;
import jssc.SerialPortEventListener;

/**
 *
 * @author Ariel Arnedo
 */
public class Arduino {
    
    private static Arduino pArduino = null;
    
    private com.panamahitek.PanamaHitek_Arduino arduino = null;
    
    private Arduino(){
        arduino =  new com.panamahitek.PanamaHitek_Arduino();
    }
    
    public static Arduino getArduino(){
        if(pArduino == null)
            pArduino = new Arduino();
        return pArduino;
    }
    
   
    public void connectArduino(String port, int rate, SerialPortEventListener serial) throws ArduinoException{
        arduino.arduinoRXTX(port, rate, serial);
    }
    
    public void desconnectArduino() throws ArduinoException{
        arduino.killArduinoConnection();
        arduino = null;
    }
    
    public com.panamahitek.PanamaHitek_Arduino getPanamahitekArduino(){
        return arduino;
    }
}
