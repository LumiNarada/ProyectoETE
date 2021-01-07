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
									"Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n",
									"Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n",
									"Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n",
									"Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n"
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
					},
					{
									"Respuesta 1",
									"Respuesta 2",
									"Respuesta 3",
									"Respuesta 4"
					}
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
			for (int j = 0; j < strRespuestas[i].length; j++){
				rRespuestas[i][j] = new JRadioButton(System.lineSeparator() + strRespuestas[i][j]);
				//bgRespuestas[i].add(rRespuestas[i][j]);
			}
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		// Título
		lblTitle = new JLabel ("Las preguntas de Lap Uta");
		lblTitle.setBounds(270,10,300,30);
		add(lblTitle);
		// Cuestionario
		pnl1 = new JPanel();
		pnl1.setPreferredSize(new Dimension(695, 30));
		//pnl1.setBounds(10,10,663,30);
		pnl1.setBackground(Color.white);
		pnl1.add(lblTitle);
		add(pnl1);

		// Preguntas y respuestas

		pnl2 = new JPanel();
		//pnl2.setBounds(10,50,663,300);
		pnl2.setPreferredSize(new Dimension(695, 300));
		pnl2.setBackground(Color.white);
		add(pnl2);
		printPregunta(pnl2, 1, strPregunta, rRespuestas);
		btn1 = new JButton("Aber");
		btn1.setBounds(300,385,100,30);
		add(btn1);
		btn1.addActionListener(this);

		pnl3 = new JPanel();
		pnl3.setBounds(10,360,663,70);
		pnl3.setBackground(Color.white);
		add(pnl3);
	}
	//Acción del botón
	public static void printPregunta(JPanel pnl, int intNPregunta, String preguntas[], JRadioButton respuestas[][]){
		intNPregunta--;
		pnl.removeAll();
		JPanel pnlPregunta = new JPanel();
		String strPreguntaPrint = preguntas[intNPregunta];
		System.out.println(strPreguntaPrint);
		JRadioButton[] rRespuestasPrint = respuestas[intNPregunta];
		JLabel lblPregunta = new JLabel(strPreguntaPrint);
		System.out.println(lblPregunta.getText());
		pnlPregunta.setPreferredSize(new Dimension(50, 100));
		// pnlPregunta.setBounds(10, 20, 1000, 50);
		pnl.add(pnlPregunta.add(lblPregunta));

		JPanel pnlRespuesta[] = {new JPanel(), new JPanel(), new JPanel(), new JPanel()};

		for (int i = 0; i < rRespuestasPrint.length; i++){
			pnlRespuesta[i].removeAll();
			pnlRespuesta[i].add(rRespuestasPrint[i]);
			pnl.add(pnlRespuesta[i]);
		}

	}
	public void actionPerformed(ActionEvent e) {
		
		//Variable para saber el número de pregunta
		int NumP;
		NumP = 0;
		if (e.getSource() == btn1) {
			switch (NumP) {
				case 0:
					//variable para la RESPUESTA en la caja de mensaje
					String P1;

					// Caja de mensaje de entrada de datos
					P1 = JOptionPane.showInputDialog("Te pregunto algo");

					if (P1 == "Cola"){
						JOptionPane.showMessageDialog(null, "Tu respuesta es correctísima");
					}
					else{
						JOptionPane.showMessageDialog(null, "Tu respuesta es incorrecta, me veo forzado a provocarte daños empcionales permanentes restregándote tu ineptitud");
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
						JOptionPane.showMessageDialog(null, "Tu respuesta es incorrecta, me veo forzado a provocarte da�os empcionales permanentes restregandote tu ineptitud");
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