/******
*@Programa: 	Cotizaciones.java
*Autor:    		Damian "The Magnificent" & Lenin "The Gotik"
*Fecha:    		04/12/2020
*DescripciÃ³n: 	Si
*
*******/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math; // Para obtener números aleatorios

import javax.swing.*;
import javax.swing.event.*;

public class Proyecto extends JFrame implements ActionListener {
	//Objetos heredados de la biblioteca swing
	private JButton btn1;
	private JPanel  pnlTitle, pnlInst, pnlPunt, pnlA, pnlPr, pnlRe, pnlBu;
	private JLabel lblTitle, lblPregunta;
	private JRadioButton[] rRespuestas = new JRadioButton[4];
	private ButtonGroup bgRespuestas = new ButtonGroup();
	private ImageIcon coyo, unam;
	private Image conversion, tam;
	//Arreglo que almacena las preguntas
	private String[] strPregunta = {
					
					"<html> Pregunta 1 <br> ¿Qué es un Sistema Operativo? <html/>",
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
									"<html> Programa que automatiza procesos <br> básicos de un dispositivo </html>",
									"<html> Programa que administra solo el <br> software de un dispositivo </html>",
									"<html> Programa que administra solo el <br> hardware de un dispositivo </html>",
									"<html> Programa que esá diseñado solo <br> para el manejo de telefonos </html>"
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
	
	//Creación de la ventana
	public static void main(String[] ar) {
		Proyecto juego = new Proyecto();
		juego.setSize(700, 500);
		juego.setBounds(70,70,700,480);
		juego.setTitle("CoyoAhorcadas");
		juego.setVisible(true);
	}

	//Creación de los elementos de la ventana
	public Proyecto() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		// Panel del Título
		lblTitle = new JLabel ("Raúl Damian Lenin Pavón.     Adriana Vega");
		lblTitle.setBounds(270,10,300,30);
		add(lblTitle);
		pnlTitle = new JPanel();
		pnlTitle.setBounds(10,10,660,60);
		pnlTitle.setBackground(Color.white);
		add(pnlTitle);
		
		//panel de instrucciones
		pnlInst = new JPanel();
		pnlInst.setBounds(10,80,330,40);
		pnlInst.setBackground(Color.white);
		add(pnlInst);
				
		//panel de puntuación
		pnlPunt = new JPanel();
		pnlPunt.setBounds(350,80,320,30);
		pnlPunt.setBackground(Color.white);
		add(pnlPunt);
		
		// Panel del dibujo del ahorcado
		pnlA = new JPanel();
		pnlA.setBounds(350,120,320,260);
		pnlA.setBackground(Color.white);
		add(pnlA);

		// Panel de las Preguntas
		pnlPr = new JPanel();
		pnlPr.setBounds(10,130,330,60);
		pnlPr.setBackground(Color.white);
		add(pnlPr);
		//Elaboración de pregunta	
		lblPregunta = new JLabel(strPregunta[contador]);
		pnlPr.add(lblPregunta);  
		
		//Panel para las respuestas
		pnlRe = new JPanel();
		pnlRe.setBounds(10,200,330,230);
		pnlRe.setBackground(Color.white);
		add(pnlRe);
		//Elaboración de las opciones de respuesta
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
		
		// Panel y Botón de verificación
		btn1 = new JButton("Verificar");
		btn1.setBounds(470,393,100,30);
		btn1.addActionListener(this);
		add(btn1);
		pnlBu = new JPanel();
		pnlBu.setBounds(350,390,320,37); 
		pnlBu.setBackground(Color.white);
		add(pnlBu);
		
	}
	
	//Dibujo base del ahorcado e inserción de logos
	public void paint (Graphics ahorca){
		super.paint(ahorca);
		ahorca.setColor(Color.BLACK);
		ahorca.drawRect(410, 380, 70, 10);
		ahorca.drawLine(440, 180, 440, 380);
		ahorca.drawLine(410, 180, 590, 180);
		ahorca.drawLine(440, 220, 470, 180);
		ahorca.drawLine(590, 180, 590, 210);          
	    coyo = new ImageIcon("coyo.jpg");
	    conversion = coyo.getImage();
	    conversion = conversion.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	    coyo = new ImageIcon(conversion);
	    coyo.paintIcon(this,ahorca,50,50);
	}
		
	//Corroboración de la respuesta
	public static boolean checkPregunta(int intNPregunta, String respuesta, String[] clave){
		if(respuesta.equals(clave[intNPregunta])){
			JOptionPane.showMessageDialog(null, "Respuesta correcta");
			return true;
		}
		JOptionPane.showMessageDialog(null, "Respuesta errónea");
		return false;
	}
	
	//Acción realizada al presionar un botón
	public void actionPerformed(ActionEvent e) {
		//Cuando se presiona "Verifica"
		if (e.getSource() == btn1) {
			int intRespuesta;
			boolean respondido = false;
			// Revisa que radio se seleccionó
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
				        		ahorca.drawOval(217, 60, 30, 30);
				        	break;
				        
				        	case 4:
				        		ahorca.drawLine(232, 90, 232, 150);
				        	break;
				        		
				        	case 3:
				        		ahorca.drawLine(231, 90, 220, 120);
				        	break;	
				        
				        	case 2:
				        		ahorca.drawLine(233, 90, 244, 120);
				        	break;
						
				        	case 1:
				        		ahorca.drawLine(231, 150, 220, 180);
				        	break;
						
				        	case 0:
				        		ahorca.drawLine(233, 150, 244, 180);
				        	break;
				        
				        	default:
				        
				        	break; 
						}
						//Si has tenido 6 errores, pierdes el juego
						if(errores == vidas){
							JOptionPane.showMessageDialog(null, "Lo mataste, ya fuchi");
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
				JOptionPane.showMessageDialog(null, "Selecciona una opción");
			}
		}
		
		//Boton de limpiar, creo
		
		//Boton de salir?
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