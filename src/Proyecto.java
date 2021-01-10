/******
*@Programa: 	Cotizaciones.java
*Autor:    		Damian "The Magnificent" & Lenin "La Qlonsisima"
*Fecha:    		04/12/2020
*Descripci贸n: 	Si
*
*******/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math; // Para obtener n鷐eros aleatorios

import javax.swing.*;
import javax.swing.event.*;

public class Proyecto extends JFrame implements ActionListener {
	//Cosos que nos van a servir
	private JButton btn1;
	private JPanel pnlA, pnltitle, pnlPr, pnlRe, pnlBu;
	private JLabel lblTitle, lblPregunta;
	private JRadioButton[] rRespuestas = new JRadioButton[4];
	private ButtonGroup bgRespuestas = new ButtonGroup();
	private String[] strPregunta = {
					
					"<html> Ay no	<br> que	<br> flojera	<br><html/>",
					"Pregunta 2",
					"Pregunta 3",
					"Pregunta 4",
					"Pregunta 5",
					"Pregunta 6",
					"Pregunta 7",
					"Pregunta 8",
					"Pregunta 9",
					"Pregunta 10"
	};
	private String[][] strRespuestas = {
					{
									"<html>" + "Respuesta 1" + "</html>",
									"<html>" + "Respuesta 2" + "</html>",
									"<html>" + "Respuesta 3" + "</html>",
									"<html>" + "Respuesta 4" + "</html>"
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
	private String[] clave = {
					strRespuestas[0][1],
					strRespuestas[1][1],
					strRespuestas[2][1],
					strRespuestas[3][1],
					strRespuestas[4][1],
					strRespuestas[5][1],
					strRespuestas[6][1],
					strRespuestas[7][1],
					strRespuestas[8][1],
					strRespuestas[9][1],
	};
	private int contador =  0, correctas = 0, errores = 0, preguntas = strPregunta.length, vidas = 6;
	
	//Creaci髇 de la ventana
	public static void main(String[] ar) {
		Proyecto juego = new Proyecto();
		juego.setSize(700, 500);
		juego.setBounds(70,70,700,480);
		juego.setTitle("CoyoAhorcadas");
		juego.setVisible(true);
	}

	//Creaci髇 de los elementos de la ventana
	public Proyecto() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		// Panel del T韙ulo
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
		//Elaboraci髇 de pregunta	
		lblPregunta = new JLabel(strPregunta[contador]);
		pnlPr.add(lblPregunta);  
		
		//Panel para las respuestas
		pnlRe = new JPanel();
		pnlRe.setBounds(340,120,330,230);
		pnlRe.setBackground(Color.white);
		add(pnlRe);
		//Elaboraci髇 de las opciones de respuesta
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
		
		// Panel y Bot髇 de verificaci髇
		btn1 = new JButton("Verificar");
		btn1.setBounds(300,385,100,30);
		btn1.addActionListener(this);
		add(btn1);
		pnlBu = new JPanel();
		pnlBu.setBounds(10,360,663,70);
		pnlBu.setBackground(Color.white);
		add(pnlBu);
		
	}
	
	public static boolean checkPregunta(int intNPregunta, String respuesta, String[] clave){
		if(respuesta.equals(clave[intNPregunta])){
			JOptionPane.showMessageDialog(null, "Respuesta correcta");
			return true;
		}
		JOptionPane.showMessageDialog(null, "Respuesta err贸nea");
		return false;
	}

	public void actionPerformed(ActionEvent e) {
		int intRespuesta;
		boolean respondido = false;
		if (e.getSource() == btn1) {
			// Revisa qu茅 radio se seleccion贸
			for (int i = 0; i < rRespuestas.length; i++){
				if(rRespuestas[i].isSelected()){
					respondido = true;
					intRespuesta = i;
					String txt = rRespuestas[intRespuesta].getText().replace("\n", "");
					boolean respuesta = checkPregunta(contador, txt, clave);
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
					}else{
						errores++;
						int nVidas = vidas - errores;
						JOptionPane.showMessageDialog(null, "Has cometido un error, llevas " + errores + " error(es)\nTe quedan " + nVidas + " vidas");
						if(errores == vidas){
							JOptionPane.showMessageDialog(null, "Lo mataste ya l谩rgate de aqu铆");
							System.exit(0);
						}
						// Manejo de im谩genes
					}
					int nPregunta = contador + 1;
					JOptionPane.showMessageDialog(null, "Vamos en la pregunta " + nPregunta);
					break;
				}
			}
			if(!respondido){
				JOptionPane.showMessageDialog(null, "Selecciona una opci贸n");
			}
		}
		
		/*Graphics ahorca = pnlA.getGraphics();
		ahorca.setColor(Color.BLACK);
		ahorca.setColor(new Color(90, 41, 11 ));
		//ahorca.clearRect(442, 0, 16, 450);
		ahorca.drawLine(10, 10, 100, 100);
		ahorca.setColor(Color.GRAY);
		ahorca.drawOval(20, 20, 150, 150);*/
	}
	
	public void paint (Graphics ahorca){
		super.paint(ahorca);
		ahorca.setColor(Color.BLACK);
		//ahorca.setColor(new Color(90, 41, 11 ));
		//ahorca.clearRect(442, 0, 16, 450);
		ahorca.drawLine(70, 130, 70, 300);
		//ahorca.setColor(Color.GRAY);
		//ahorca.drawOval(20, 20, 150, 150);
	}
	
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