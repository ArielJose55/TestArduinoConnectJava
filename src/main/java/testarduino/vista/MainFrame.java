/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testarduino.vista;

import java.awt.BorderLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import com.panamahitek.ArduinoException;

import controlador.SerialArduinoListener;
import testarduino.logica.Arduino;

/**
 *
 * @author Ariel Arnedo
 */
public class MainFrame extends JFrame{
    
	private static final long serialVersionUID = 1L;
	
	public MainFrame() throws ArduinoException {
		super("TestArduino");
		setDefaultCloseOperation(0);
		setSize(400, 300);
		setLocationRelativeTo(null);
		port = "3300";
		init();
	}
	
	
	private void init() throws ArduinoException {
		arduino = Arduino.getArduino();
		arduinoListener = new SerialArduinoListener();
		this.arduino.connectArduino(port, 9600, arduinoListener);
		
		panel = new JPanel(new java.awt.BorderLayout());
		textPanel = new JTextPane();
		arduinoListener.setjTextArea(textPanel);
		panel.add(textPanel, BorderLayout.CENTER);
		getContentPane().add(panel);
	}
	
	private final String port;
	private Arduino arduino;
	private SerialArduinoListener arduinoListener;
	private JPanel panel;
	private JTextPane textPanel;
}
