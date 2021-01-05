/******
*@Programa: Cotizaciones.java
*Autor:    Damian "The Magnificent" & Lenin "La Qlonsisima"
*Fecha:    04/12/2020
*Descripción: El trabajo de las Zorras
*
*******/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

public class Proyecto extends JFrame 
	implements ActionListener {
	
	//Cosos que nos van a servir
	private JButton boton1;
    private JPanel panel1, panel2, panel3;
    private JLabel title;
    
    //Creación de la ventana
    public static void main(String[] ar) {
    	Proyecto juego = new Proyecto();
    	juego.setBounds(70,70,700,480);
    	juego.setTitle("CoyoAhorcadas");
    	juego.setVisible(true);
    }
    
    //Creación de los cosos que van en la ventana
    public Proyecto() {
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setLayout(null);
        
        title = new JLabel ("Las preguntas de Lap Uta");
        title.setBounds(270,10,300,30);
        add(title);
        
        panel1 = new JPanel();
        panel1.setBounds(10,10,663,30);
        panel1.setBackground(Color.white);
        add(panel1);
        
        panel2 = new JPanel();
        panel2.setBounds(10,50,663,300);
        panel2.setBackground(Color.white);
        add(panel2);
        
        boton1 = new JButton("Aber");
        boton1.setBounds(300,385,100,30);
        add(boton1);
        boton1.addActionListener(this);
        
        panel3 = new JPanel();
        panel3.setBounds(10,360,663,70);
        panel3.setBackground(Color.white);
        add(panel3);
        
    }
    
    //Acción del botón
	public void actionPerformed(ActionEvent e) {
		
		//Variable para saber el número de pregunta 
		int NumP;
		NumP = 0;
		
		    if (e.getSource() == boton1) {
		    	
		    	switch (NumP) {
			    	case 0:
			    		//variable para la RESPUESTA en la caja de mensaje
				        String P1;
				        
				        // Caja de mensaje de entrada de datos 
				        P1 = JOptionPane.showInputDialog("Te pregunto algo");
				        
				        if (P1 == "Cola"){
				        	JOptionPane.showMessageDialog(null, "Tu respuesta es correctisima");
				        }
				        else{
				        	JOptionPane.showMessageDialog(null, "Tu respuesta es incorrecta, me veo forzado a provocarte daños empcionales permanentes restregandote tu ineptitud");
				        }
			    		
				        NumP += 1;
			        break;
			        
			        case 1:
			        	
			        	//variable para la RESPUESTA en la caja de mensaje
				        String P2;
				        
				        // Caja de mensaje de entrada de datos 
				        P2 = JOptionPane.showInputDialog("Te pregunto algo");
				        
				        if (P2 == "Cola"){
				        	JOptionPane.showMessageDialog(null, "Tu respuesta es correctisima");
				        }
				        else{
				        	JOptionPane.showMessageDialog(null, "Tu respuesta es incorrecta, me veo forzado a provocarte daños empcionales permanentes restregandote tu ineptitud");
				        }
			        	NumP += 1;
			        break;
			        
			        default:
			        	JOptionPane.showMessageDialog(null, "No");
			        break;
		    	}

	    }
	} 
}