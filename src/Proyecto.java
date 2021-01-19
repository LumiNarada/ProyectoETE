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
	private JLabel lblTitle, lblPregunta, lblInst;
	private JRadioButton[] rRespuestas = new JRadioButton[4];
	private ButtonGroup bgRespuestas = new ButtonGroup();
	private ImageIcon coyo, unam;
	private Image conversion, tam;
	//Arreglo que almacena las preguntas
	private String[] strPregunta = {
					
					"<html> Pregunta 1 <br> ¿Qué es un Sistema Operativo? </html>",
					"<html> Pregunta 2 <br> ¿Cuál es la principal funcion de un Sistema Operativo?</html>",
					"<html> Pregunta 3 <br> ¿Quién creó el primer Sistema Operativo y en qué año?</html>",
					"<html> Pregunta 4 <br> ¿Cuál es el propósito de una interfaz?</html>",
					"<html> Pregunta 5 <br> ¿Cuándo comenzaron a producirse interfaces gráficas <br>  para personas sin conocimiento en programación?</html>",
					"<html> Pregunta 6 <br> ¿Cómo se clasifican las interfaces gráficas que <br> permiten al usuario utilizar todos los recursos?</html>",
					"<html> Pregunta 7 <br> ¿Qué característica principal tiene el <br> software llamado Kernel </html>",
					"<html> Pregunta 8 <br> ¿Qué es un archivo? </html>",
					"<html> Pregunta 9 <br> ¿Cuáles son las tres principales formas de <br> clasificar un sistema de archivos? </html>",
					"<html> Pregunta 10 <br> ¿Cuáles de los siguientes ejemplos son <br> interfaces gráficas?</html>"
	};
	//Arreglo que almacena las opciones de respuesta
	private String[][] strRespuestas = {
					{
						"<html> Programa que automatiza procesos								<br> básicos de un dispositivo </html>",
						"<html> Programa que administra solo el &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		<br> software de un dispositivo </html>",
						"<html> Programa que administra solo el &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		<br> hardware de un dispositivo </html>",
						"<html> Programa que esá diseñado solo &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<br> para el manejo de celulares </html>"
					},
					{
						"<html> Administrar recursos, archivos y tareas 		<br> tanto del hadware como del software </html>",
						"<html> Brindar una experiencia agradable al &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			<br>  usuario mediante un diseño simple </html>",
						"<html> Almacenar y organizar la base de datos &nbsp;&nbsp;&nbsp;		<br> de un dispositivo eficientemente </html>",
						"<html> Mantener  los datos del usuario seguros &nbsp;		<br> de ataques de malware </html>"
					},
					{
						"<html> International Business Machines &nbsp;	<br> en 1956 </html>",
						"<html> Netscape Communications Corporation	&nbsp; <br> en 1996 </html>",
						"<html> Hewlett-Packard Company &nbsp;	<br> en 1939 </html>",
						"<html> GlaxoSmithKline&nbsp;	<br> en el 2000 </html>"
					},
					{
						"<html> Comunicar al usuario con el software &nbsp;	<br> y al software con el hadware (y el usuario) </html>",
						"<html> Organizar estructuras de datos para su &nbsp;	<br> óptima utilización </html>",
						"<html> Llevar a cabo programas realizados &nbsp;	<br> con un lenguaje orientado a objetos </html>",
						"<html> Facilitar la creación de nuevos códigos &nbsp;	<br> del usuario </html>"
					},
					{
						"<html> Entre 1970 y 1980</html>",
						"<html> Entre 1990 y 2000</html>",
						"<html> Entre 1950 y 1960</html>",
						"<html> Entre 1930 y 1940</html>"
					},
					{
						"<html> Distribuidos &nbsp;</html>",
						"<html> Centralizados &nbsp;</html>",
						"<html> Multitareas  &nbsp;</html>",
						"<html> Jerárquicos &nbsp;</html>"
					},
					{
						"<html> Núcleo del sistema operativo, &nbsp; <br> se ejecuta en modo privilegiado </html>",
						"<html> Permite al sistema operativo &nbsp;	<br> interactuar con los perifericos </html>",
						"<html> Hace posible que varios usuarios &nbsp;	<br> ejecuten programas a la vez </html>",
						"<html> Mantiene protegido al sistema de cualquier &nbsp;	<br>  maleware que pueda presentar </html>"
					},
					{
						"<html> Conjunto de bytes o datos ordenados &nbsp;	<br> almacenados en un disco duro </html>",
						"<html> Grupo de información  que se &nbsp;	<br>  almacena en el Kernel </html>",
						"<html> Una base de datos comprimida &nbsp;	<br>  al máximo </html>",
						"<html> Aglomeración de datos que viajan desde &nbsp;	<br> el driver a los sistemas perifericos </html>"
					},
					{
						"<html> De disco, de red y de propósito especial</html>",
						"<html> De organización, de recopilación y de distribución</html>",
						"<html> De periferia, de centralización y de dualidad</html>",
						"<html> De usuario, de código y de intercomunicación</html>"
					},
					{
						"<html> Android, Linux, Windows</html>",
						"<html> Java, Python, C++</html>",
						"<html> HTML, CSS, XML</html>",
						"<html> Pay De Queso</html>"
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
		lblTitle = new JLabel ("<html>Elaborado por: <br> Raúl J. Damian Magaña <br> Lenin A. Pavón Snoopy <html/>");
		lblTitle.setBounds(130,7,170,67);
		add(lblTitle);
		pnlTitle = new JPanel();
		pnlTitle.setBounds(10,10,660,60);
		pnlTitle.setBackground(Color.white);
		add(pnlTitle);
		
		//panel de instrucciones
		lblInst = new JLabel("Instrucciones: De tin marin de do pingue, cucaramacara");
		lblInst.setBounds(30,80,300,30);
		add(lblInst);
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
	    conversion = conversion.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
	    coyo = new ImageIcon(conversion);
	    coyo.paintIcon(this,ahorca,18,41);
	    unam = new ImageIcon("unam.png");
	    conversion = unam.getImage();
	    conversion = conversion.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
	    unam = new ImageIcon(conversion);
	    unam.paintIcon(this,ahorca,620,41);
	    
	    //ahorca.drawLine(70, 230, 70, 450);
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
							//System.exit(1);
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
							//System.exit(0);
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