/******
*@Programa: 	Cotizaciones.java
*Autor:    		Damian "The Magnificent" & Lenin "La Qlonsisima"
*Fecha:    		04/12/2020
*Descripción: 	Si
*
*******/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math; // Para obtener n�meros aleatorios

import javax.swing.*;
import javax.swing.event.*;

public class Proyecto extends JFrame implements ActionListener {
	//Objetos heredados de la biblioteca swing
	private JButton btn1, btn2;
	private JPanel pnlA, pnltitle, pnlPr, pnlRe, pnlBu;
	private JLabel lblTitle, lblPregunta;
	private JRadioButton[] rRespuestas = new JRadioButton[4];
	private ButtonGroup bgRespuestas = new ButtonGroup();
	//Arreglo que almacena las preguntas
	private String[] strPregunta = {
					
					"<html> Pregunta 1 <br> �Qu� es un Sistema Operativo? <html/>",
					"<html> Pregunta 2 <br> ",
					"<html> Pregunta 3 <br>",
					"<html> Pregunta 4 <br>",
					"<html> Pregunta 5 <br>",
					"<html> Pregunta 6 <br>",
					"<html> Pregunta 7 <br>",
					"<html> Pregunta 8 <br>",
					"<html> Pregunta 9 <br>",
					"<html> Pregunta 10 <br>"
	};
	//Arreglo que almacena las opciones de respuesta
	private String[][] strRespuestas = {
					{
									"<html> Programa que automatiza procesos <br> b�sicos de un dispositivo </html>",
									"<html> Programa que administra solo el <br> software de un dispositivo </html>",
									"<html> Programa que administra solo el <br> hardware de un dispositivo </html>",
									"<html> Programa que es� dise�ado solo <br> para el manejo de telefonos </html>"
					},
					{
									"Respuesta 1",
									"Respuesta 5",
									"Respuesta 3",
									"Respuesta 4"
					},
					{
									"Respuesta 1",
									"Respuesta 2",
									"Respuesta 3",
									"Respuesta 4"
					},
					{
									"Respuesta 1",
									"Respuesta 2",
									"Respuesta 3",
									"Respuesta 4"
					},
					{
									"Respuesta 1",
									"Respuesta 2",
									"Respuesta 3",
									"Respuesta 4"
					},
					{
									"Respuesta 1",
									"Respuesta 2",
									"Respuesta 3",
									"Respuesta 4"
					},
					{
									"Respuesta 1",
									"Respuesta 2",
									"Respuesta 3",
									"Respuesta 4"
					},
					{
									"Respuesta 1",
									"Respuesta 2",
									"Respuesta 3",
									"Respuesta 4"
					},
					{
									"Respuesta 1",
									"Respuesta 2",
									"Respuesta 3",
									"Respuesta 4"
					},
					{
									"Respuesta 1",
									"Respuesta 2",
									"Respuesta 3",
									"Respuesta 4"
					}
	};
	//Arreglo que almacena las respuestas correctas
	private String[] clave = {
					strRespuestas[0][0],
					strRespuestas[1][0],
					strRespuestas[2][0],
					strRespuestas[3][0],
					strRespuestas[4][0],
					strRespuestas[5][0],
					strRespuestas[6][0],
					strRespuestas[7][0],
					strRespuestas[8][0],
					strRespuestas[9][0],
	};
	private int contador =  0, correctas = 0, errores = 0, preguntas = strPregunta.length, vidas = 6;
	
	//Creaci�n de la ventana
	public static void main(String[] ar) {
		Proyecto juego = new Proyecto();
		juego.setSize(700, 500);
		juego.setBounds(70,70,700,480);
		juego.setTitle("CoyoAhorcadas");
		juego.setVisible(true);
	}

	//Creaci�n de los elementos de la ventana
	public Proyecto() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		// Panel del T�tulo
		lblTitle = new JLabel ("Las preguntas los Contadores");
		lblTitle.setBounds(270,10,300,30);
		add(lblTitle);
		pnltitle = new JPanel();
		pnltitle.setBounds(10,10,663,30);
		pnltitle.setBackground(Color.white);
		add(pnltitle);
		
		// Panel del dibujo del ahorcado
		pnlA = new JPanel();
		pnlA.setBounds(10,50,320,300);
		pnlA.setBackground(Color.white);
		add(pnlA);

		// Panel de las Preguntas
		pnlPr = new JPanel();
		pnlPr.setBounds(340,50,330,60);
		pnlPr.setBackground(Color.white);
		add(pnlPr);
		//Elaboraci�n de pregunta	
		lblPregunta = new JLabel(strPregunta[contador]);
		pnlPr.add(lblPregunta);  
		
		//Panel para las respuestas
		pnlRe = new JPanel();
		pnlRe.setBounds(340,120,330,230);
		pnlRe.setBackground(Color.white);
		add(pnlRe);
		//Elaboraci�n de las opciones de respuesta
		strRespuestas[contador] = randomize(strRespuestas[contador]);
		for (int i = 0; i < strRespuestas[contador].length; i++){
			rRespuestas[i] = new JRadioButton(strRespuestas[contador][i]);
			bgRespuestas.add(rRespuestas[i]);
		}
		JPanel pnlRespuesta[] = {new JPanel(), new JPanel(), new JPanel(), new JPanel()};
		for (int i = 0; i < rRespuestas.length; i++){
			pnlRespuesta[i].setPreferredSize(new Dimension(300, 50));
			pnlRespuesta[i].add(rRespuestas[i]);
			pnlRe.add(pnlRespuesta[i]);
		}
		
		// Panel y Bot�n de verificaci�n
		btn1 = new JButton("Verificar");
		btn1.setBounds(300,385,100,30);
		btn1.addActionListener(this);
		add(btn1);
		btn2 = new JButton("Salida");
		btn2.setBounds(500,385,100,30);
		btn2.addActionListener(this);
		add(btn2);
		pnlBu = new JPanel();
		pnlBu.setBounds(10,360,663,70);
		pnlBu.setBackground(Color.white);
		add(pnlBu);


	}
	
	//Corroboraci�n de la respuesta
	public static boolean checkPregunta(int intNPregunta, String respuesta, String[] clave){
		//JOptionPane.showMessageDialog(null, respuesta);
		//JOptionPane.showMessageDialog(null, clave);
		if(respuesta.equals(clave[intNPregunta])){
			JOptionPane.showMessageDialog(null, "Respuesta correcta");
			return true;
		}
		JOptionPane.showMessageDialog(null, "Respuesta errónea");
		return false;
	}
	
	//Acci�n realizada al presionar un bot�n
	public void actionPerformed(ActionEvent e) {
		//Cuando se presiona "Verifica"
		Object origen = e.getSource();
		if (origen == btn1) {
			int intRespuesta;
			boolean respondido = false;
			// Revisa que radio se seleccion�
			for (int i = 0; i < rRespuestas.length; i++){
				if(rRespuestas[i].isSelected()){
					respondido = true;
					intRespuesta = i;
					String txt = rRespuestas[intRespuesta].getText().replace("\n", "");
					boolean respuesta = checkPregunta(contador, txt, clave);
					//La respuesta es correcta
					if(respuesta){
						correctas++;
						if(correctas == preguntas){
							JOptionPane.showMessageDialog(null, "Ganaste uwuwuwuwuwuwu");
							System.exit(1);
						}
						contador++;
						lblPregunta.setText(strPregunta[contador]);
						strRespuestas[contador] = randomize(strRespuestas[contador]);
						for(int j = 0; j < rRespuestas.length; j++){
							rRespuestas[j].setText(strRespuestas[contador][j]);
						}
						bgRespuestas.clearSelection();
					//la respuesta es falsa
					}else{
						errores++;
						int nVidas = vidas - errores;
						JOptionPane.showMessageDialog(null, "Has cometido un error, llevas " + errores + " error(es)\nTe quedan " + nVidas + " vidas");
						Graphics ahorca = pnlA.getGraphics();
						ahorca.setColor(Color.BLACK);
						switch (nVidas) {				        
				        	case 5:
				        		ahorca.drawOval(217, 80, 30, 30);
				        	break;
				        
				        	case 4:
				        		ahorca.drawLine(232, 110, 232, 170);
				        	break;
				        		
				        	case 3:
				        		ahorca.drawLine(231, 110, 220, 140);
				        	break;	
				        
				        	case 2:
				        		ahorca.drawLine(233, 110, 244, 140);
				        	break;
						
				        	case 1:
				        		ahorca.drawLine(231, 170, 220, 200);
				        	break;
						
				        	case 0:
				        		ahorca.drawLine(233, 170, 244, 200);
				        	break;
				        
				        	default:
				        
				        	break; 
						}
						//Si has tenido 6 errores, pierdes el juego
						if(errores == vidas){
							JOptionPane.showMessageDialog(null, "Lo mataste, ya l�rgate de aqu�");
							System.exit(0);
						}
					}
					int nPregunta = contador + 1;
					JOptionPane.showMessageDialog(null, "Vamos en la pregunta " + nPregunta);
					break;
				}
			}
			//Si el boton de verificar se ha presionado sin seleccionar una respuesta
			if(!respondido){
				JOptionPane.showMessageDialog(null, "Selecciona una opci�n");
			}
		}
		//Boton de salir
		if(origen == btn2){
			System.exit(0);
		}
	}
	//Dibujo base del ahorcado
	public void terminar(){
		float calificacion = correctas/preguntas;
		JOptionPane.showMessageDialog(null, "Tuviste " + correctas +" respuestas correctas y " + errores + " errores\nTuviste " + calificacion + " de calificacion");
	}
	public void paint (Graphics ahorca){
		super.paint(ahorca);
		ahorca.setColor(Color.BLACK);
		ahorca.drawRect(70, 330, 70, 10);
		ahorca.drawLine(100, 130, 100, 330);
		ahorca.drawLine(70, 130, 250, 130);
		ahorca.drawLine(100, 170, 130, 130);
		ahorca.drawLine(250, 130, 250, 160);
	}
	//nOsEkEsestA
	public static String[] randomize(String[] arreglo){
		for(int i = 0; i < arreglo.length; i++){
			int maximo = arreglo.length;
			int indiceQueCambia = (int)(Math.random()*(maximo));
			String temporal = arreglo[indiceQueCambia];
			arreglo[indiceQueCambia] = arreglo [i];
			arreglo[i] = temporal;
		}
		return arreglo;
	}
}