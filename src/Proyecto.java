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
import java.lang.Math; // Para obtener números aleatorios

import javax.swing.*;
import javax.swing.event.*;

public class Proyecto extends JFrame implements ActionListener {
	//Cosos que nos van a servir
	private JButton btn1;
	private JPanel pnl1, pnl2, pnl3;
	private JLabel lblTitle, lblPregunta;
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
	private JRadioButton[] rRespuestas = new JRadioButton[4];
	private ButtonGroup bgRespuestas = new ButtonGroup();
	private int contador =  0, correctas = 0, errores = 0, preguntas = strPregunta.length, vidas = 6;

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
		strRespuestas[contador] = randomize(strRespuestas[contador]);
		for (int i = 0; i < strRespuestas[contador].length; i++){
			rRespuestas[i] = new JRadioButton(strRespuestas[contador][i]);
			bgRespuestas.add(rRespuestas[i]);
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
		// Impresión de pregunta
		JPanel pnlPregunta = new JPanel();
		pnlPregunta.setPreferredSize(new Dimension(600, 100));
		lblPregunta = new JLabel(strPregunta[contador]);
		// printPregunta(ventana, pnl2, contador, strPregunta, rRespuestas);
		pnl2.add(pnlPregunta.add(lblPregunta));
		JPanel pnlRespuesta[] = {new JPanel(), new JPanel(), new JPanel(), new JPanel()};
		for (int i = 0; i < rRespuestas.length; i++){
			pnlRespuesta[i].setPreferredSize(new Dimension(300, 50));
			pnlRespuesta[i].add(rRespuestas[i]);
			pnl2.add(pnlRespuesta[i]);
		}
		// Botón de verificación
		btn1 = new JButton("Verificar");
		btn1.setBounds(300,385,100,30);
		btn1.addActionListener(this);

		pnl3 = new JPanel();
		//pnl3.setBounds(10,360,663,70);
		pnl3.setPreferredSize(new Dimension(695, 60));
		pnl3.setBackground(Color.white);
		ventana.add(pnl3.add(btn1));
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
		int intRespuesta;
		boolean respondido = false;
		if (e.getSource() == btn1) {
			// Revisa qué radio se seleccionó
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
							JOptionPane.showMessageDialog(null, "Lo mataste ya lárgate de aquí");
							System.exit(0);
						}
						// Manejo de imágenes
					}
					int nPregunta = contador + 1;
					JOptionPane.showMessageDialog(null, "Vamos en la pregunta " + nPregunta);
					break;
				}
			}
			if(!respondido){
				JOptionPane.showMessageDialog(null, "Selecciona una opción");
			}
		}
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