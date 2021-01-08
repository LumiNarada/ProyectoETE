/******
*@Programa: 	Cotizaciones.java
*Autor:    		Damian "The Magnificent" & Lenin "La Qlonsisima"
*Fecha:    		04/12/2020
*Descripción: El trabajo de las Zorras
*
*******/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

public class Proyecto extends JFrame implements ActionListener {
	//Cosos que nos van a servir
	private int contador =  0;
	private JButton btn1;
	private JPanel pnl1, pnl2, pnl3;
	private JLabel lblTitle;
	private String[] strPregunta = {
					"<html>Se busca prestigiar al IMPC como una empresa a nivel nacional e internacional<br/>" +
									"mediante un plan elaborado que cumpla con valores éticos refrendando los valores<br/>" +
									"y la política de la institución y enfrentando los retos que demanda la profesión en<br/>" +
									"un espacio de trabajo</html>",
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
	private JRadioButton[][] rRespuestas = new JRadioButton[strPregunta.length][4];
	private ButtonGroup[] bgRespuestas = new ButtonGroup[strPregunta.length];


	//Creación de la ventana
	public static void main(String[] ar) {
		Proyecto juego = new Proyecto();
		juego.setSize(700, 500);
		//juego.setBounds(70,70,700,480);
		juego.setTitle("CoyoAhorcadas");
		juego.setVisible(true);
	}
	//Creación de los cosos que van en la ventana
	public Proyecto() {
		for (int i = 0; i < bgRespuestas.length; i++){
			bgRespuestas[i] = new ButtonGroup();
			for (int j = 0; j < strRespuestas[i].length; j++){
				rRespuestas[i][j] = new JRadioButton(System.lineSeparator() + strRespuestas[i][j]);
				bgRespuestas[i].add(rRespuestas[i][j]);
			}
		}
		Container ventana = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ventana.setLayout(new FlowLayout());
		// Título
		lblTitle = new JLabel ("Las preguntas de Lap Uta");
		lblTitle.setBounds(270,10,300,30);
		ventana.add(lblTitle);
		// Cuestionario
		pnl1 = new JPanel();
		pnl1.setPreferredSize(new Dimension(695, 30));
		//pnl1.setBounds(10,10,663,30);
		pnl1.setBackground(Color.white);
		pnl1.add(lblTitle);
		ventana.add(pnl1);

		// Preguntas y respuestas

		pnl2 = new JPanel();
		//pnl2.setBounds(10,50,663,300);
		pnl2.setPreferredSize(new Dimension(695, 300));
		pnl2.setBackground(Color.white);
		ventana.add(pnl2);
		printPregunta(ventana, pnl2, contador, strPregunta, rRespuestas);
		btn1 = new JButton("Verificar");
		btn1.setBounds(300,385,100,30);
		btn1.addActionListener(this);

		pnl3 = new JPanel();
		//pnl3.setBounds(10,360,663,70);
		pnl3.setPreferredSize(new Dimension(695, 60));
		pnl3.setBackground(Color.white);
		ventana.add(pnl3.add(btn1));
	}
	//Acción del botón
	public void printPregunta(Container ventana, JPanel pnl, int intNPregunta, String preguntas[], JRadioButton respuestas[][]){
		ventana = getContentPane();
		ventana.remove(pnl);
		JPanel pnlPregunta = new JPanel();
		String strPreguntaPrint = preguntas[intNPregunta];
		JRadioButton[] rRespuestasPrint = respuestas[intNPregunta];
		JLabel lblPregunta = new JLabel(strPreguntaPrint);
		pnlPregunta.setPreferredSize(new Dimension(600, 100));
		// pnlPregunta.setBounds(10, 20, 1000, 50);
		pnl.add(pnlPregunta.add(lblPregunta));
		JPanel pnlRespuesta[] = {new JPanel(), new JPanel(), new JPanel(), new JPanel()};
		for (int i = 0; i < rRespuestasPrint.length; i++){
			pnlRespuesta[i].setPreferredSize(new Dimension(300, 50));
			pnlRespuesta[i].removeAll();
			pnlRespuesta[i].add(rRespuestasPrint[i]);
			pnl.add(pnlRespuesta[i]);
		}
		ventana.add(pnl);
	}
	public static boolean checkPregunta(int intNPregunta, String respuesta, String[] clave){
		if(respuesta.equals(clave[intNPregunta])){
			JOptionPane.showMessageDialog(null, "Respuesta correcta");
			return true;
		}
		JOptionPane.showMessageDialog(null, "Respuesta errónea");
		return false;
	}

	public void actionPerformed(ActionEvent e) {
		//Variable para saber el número de pregunta
		Container ventana = getContentPane();
		int intRespuesta;
		boolean respondido = false;
		if (e.getSource() == btn1) {
			// Revisa qué radio se seleccionó
			for (int i = 0; i < rRespuestas[contador].length; i++){
				if(rRespuestas[contador][i].isSelected()){
					respondido = true;
					intRespuesta = i;
					String txt = rRespuestas[contador][intRespuesta].getText().replace("\n", "");
					boolean respuesta = checkPregunta(contador, txt, clave);
					if(respuesta){
						contador++;
						printPregunta(ventana, pnl2, contador, strPregunta, rRespuestas);

					}else{
						JOptionPane.showMessageDialog(null, "Terrible, oremos");
						// Manejo de imágenes
					}
					JOptionPane.showMessageDialog(null, "Vamos en la pregunta " + contador);
					break;
				}
			}
			if(!respondido){
				JOptionPane.showMessageDialog(null, "Selecciona una opción");
			}
		}
	} 
}