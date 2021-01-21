/******
*@Programa: 	Cotizaciones.java
*Autor:    		Damian "The Magnificent" & Lenin "The Gotik"
*Fecha:    		04/12/2020
*Descripci√≥n: 	Cuestionario de 10 preguntas con 4 opciones en orden aleatorio que
 * al finalizar regresa calificaci√≥n
*
*******/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math; // Para obtener aleatorizar opciones

import javax.swing.*;
import javax.swing.event.*;

public class Proyecto extends JFrame implements ActionListener {
	//Objetos heredados de la biblioteca swing
	private JLabel lblNames, lblPr, lblTitle, lblPregunta, lblInst, lblPunt, lblVida;
	private JPanel  pnlTitle, pnlInst, pnlPunt, pnlA, pnlPr, pnlRe, pnlBu, pnl;
	private JButton btn1, btn2;
	private JRadioButton[] rRespuestas = new JRadioButton[4];
	private ButtonGroup bgRespuestas = new ButtonGroup();
	private ImageIcon coyo, unam;
	private Image conversion, tam;
	// Caracteres especiales
	private String ac = "&aacute;", ec = "&eacute;", ic = "&iacute;", oc = "&oacute;", uc = "&uacute;", ip = "&iquest;", eine = "&ntilde;";
	//Arreglo que almacena las preguntas
	private String[] strPregunta = {
					
					"<html> Pregunta 1 <br> " + ip + "Qu" + ec + " es un Sistema Operativo? </html>",
					"<html> Pregunta 2 <br> " + ip + "Cu" + ac + "l es la principal funcion de <br>un Sistema Operativo?</html>",
					"<html> Pregunta 3 <br> " + ip + "Qui" + ec + "n cre" + oc +" el primer Sistema Operativo <br>y en qu" + ec +" a" + eine + "o?</html>",
					"<html> Pregunta 4 <br> " + ip + "Cu" + ac + "l es el prop" + oc +"sito de una interfaz?</html>",
					"<html> Pregunta 5 <br> " + ip + "Cu" + ac + "ndo comenzaron a producirse interfaces <br> gr" + ac + "ficas para p"+ uc +"blico general?</html>",
					"<html> Pregunta 6 <br> " + ip + "C" + oc +"mo se clasifican las interfaces gr" + ac +"ficas que <br> permiten al usuario utilizar todos los recursos?</html>",
					"<html> Pregunta 7 <br> " + ip + "Qu" + ac + " caracter" + ic + "stica principal tiene el <br> software llamado Kernel </html>",
					"<html> Pregunta 8 <br> " + ip + "Qu" + ec + " es un archivo? </html>",
					"<html> Pregunta 9 <br> " + ip + "Cu" + ac + "les son las tres principales formas de <br> clasificar un sistema de archivos? </html>",
					"<html> Pregunta 10 <br> " + ip + "Cu" + ac + "les de los siguientes ejemplos son <br> interfaces gr" + ac + "ficas?</html>"
	};
	//Arreglo que almacena las opciones de respuesta
	private String[][] strRespuestas = {
					{
						"<html> Programa que automatiza procesos													<br> b" + ac + "sicos de un dispositivo </html>",
						"<html> Programa que administra solo el 			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<br> software de un dispositivo </html>",
						"<html> Programa que administra solo el 			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<br> hardware de un dispositivo </html>",
						"<html> Programa que es dise" + eine + "ado solo 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			<br> para el manejo de celulares </html>"
					},
					{
						"<html> Administrar recursos, archivos y tareas 												<br> tanto del hadware como del software </html>",
						"<html> Brindar una experiencia agradable al 			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<br>  usuario mediante un dise" + eine +"o simple </html>",
						"<html> Almacenar y organizar la base de datos 			&nbsp;									<br> de un dispositivo eficientemente </html>",
						"<html> Mantener  los datos del usuario seguros			&nbsp;									<br> de ataques de malware </html>"
					},
					{
						"<html> International Business Machines &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;																																	<br> en 1956 </html>",
						"<html> Netscape Communications Corporation	&nbsp;&nbsp;&nbsp; 																																																		<br> en 1996 </html>",
						"<html> Hewlett-Packard Company &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;																		<br> en 1939 </html>",
						"<html> Glaxo Smith Kline en &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<br> el 2000 </html>"
					},
					{
						"<html> Comunicar al usuario con el software &nbsp;																<br> y al software con el hadware (y el usuario) </html>",
						"<html> Organizar estructuras de datos para su &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;									<br> " + oc +"ptima utilizaci" + oc +"n </html>",
						"<html> Llevar a cabo programas realizados &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<br> con un lenguaje orientado a objetos </html>",
						"<html> Facilitar la creaci" + oc +"n de nuevos c" + oc +"digos &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			<br> del usuario </html>"
					},
					{
						"<html> Entre 1970 y 1980 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	</html>",
						"<html> Entre 1990 y 2000 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	</html>",
						"<html> Entre 1950 y 1960 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	</html>",
						"<html> Entre 1930 y 1940 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	</html>"
					},
					{
						"<html> Distribuidos &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html>",
						"<html> Centralizados &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html>",
						"<html> Multitareas  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html>",
						"<html> Jer" + ac + "rquicos &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html>"
					},
					{
						"<html> N" + uc +"cleo del sistema operativo,			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<br> se ejecuta en modo privilegiado </html>",
						"<html> Permite al sistema operativo &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			<br> interactuar con los perifericos </html>",
						"<html> Hace posible que varios usuarios &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;															<br> ejecuten programas a la vez </html>",
						"<html> Mantiene protegido al sistema de cualquier <br>  maleware que pueda presentar </html>"
					},
					{
						"<html> Conjunto de bytes o datos ordenados 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 																							<br> almacenados en un disco duro </html>",
						"<html> Grupo de informaci" + oc +"n  que se 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<br>  almacena en el Kernel </html>",
						"<html> Una base de datos comprimida al 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 														<br> m" + ac + "ximo </html>",
						"<html> Aglomeraci" + oc + "n de datos que viajan desde <br> el driver a los sistemas perifericos </html>"
					},
					{
						"<html> De disco, de red y de prop" + oc + "sito especial 				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html>",
						"<html> De uso compartido, personales y p" + uc +"blicos 				&nbsp;&nbsp;&nbsp;&nbsp;</html>",
						"<html> De periferia, de centralizaci" + oc + "n y de dualidad 			&nbsp;</html>",
						"<html> De usuario, de c" + oc + "digo y de intercomunicaci" + oc + "n </html>"
					},
					{
						"<html> Android, Linux, Windows </html>",
						"<html> Java, Python, C++ 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </html>",
						"<html> HTML, CSS, XML 			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html>",
						"<html> Pay De Queso 			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html>"
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
	// Contadores
	private int contador =  0, correctas = 0, errores = 0, preguntas = 10, vidas = 6;
	
	//Creacion de la ventana
	public static void main(String[] ar) {
		Proyecto juego = new Proyecto();
		juego.setSize(700, 500);
		juego.setBounds(70,70,700,480);
		juego.setTitle("CoyoAhorcadas");
		juego.setVisible(true);
	}

	//Creacion de los elementos de la ventana
	public Proyecto() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		// Panel del Titulo
		lblNames = new JLabel ("<html>Elaborado por: <br> Ra" + uc +"l J. Dami"+ ac +"n Maga" + eine +"a <br> Lenin Pav" + oc +"n Alvarez <html/>");
		lblNames.setBounds(300,7,170,67);
		add(lblNames);
		lblPr = new JLabel ("<html>Bajo la asesorÌa de: <br> la profesora: <br> Adriana Vega Palos <html/>");
		lblPr.setBounds(470,7,170,67);
		add(lblPr);
		lblTitle = new JLabel ("<html>Coyo Ahorcadas <html/>");
		lblTitle.setFont(new Font("Bookman Old Style", Font.ROMAN_BASELINE, 27));
		lblTitle.setForeground(new Color(52, 32, 31));
		lblTitle.setBounds(100,7,170,67);
		add(lblTitle);
		pnlTitle = new JPanel();
		pnlTitle.setBounds(10,10,660,60);
		pnlTitle.setBackground(new Color(255, 216, 177));
		add(pnlTitle);
		
		//panel de instrucciones
		lblInst = new JLabel("<html>Instrucciones: Haz click en verificar respondiendo <br> correctamente °Si te equivocas perder"+ ac +"s tus vidas!<html/>");
		lblInst.setBounds(30,83,300,30);
		add(lblInst);
		pnlInst = new JPanel();
		pnlInst.setBounds(10,80,330,40);
		pnlInst.setBackground(new Color(255, 216, 177));
		add(pnlInst);
		
		
		//panel de puntuaciOn
		lblPunt = new JLabel("Puntos: 0");
		lblPunt.setBounds(430,80,130,30);
		add(lblPunt);
		lblVida = new JLabel("Vidas: 6");
		lblVida.setBounds(550,80,130,30);
		add(lblVida);
		pnlPunt = new JPanel();
		pnlPunt.setBounds(350,80,320,30);
		pnlPunt.setBackground(new Color(255, 216, 177));
		add(pnlPunt);
		
		// Panel del dibujo del ahorcado
		pnlA = new JPanel();
		pnlA.setBounds(350,120,320,260);
		pnlA.setBackground(new Color(255, 216, 177));
		add(pnlA);

		// Panel de las Preguntas
		pnlPr = new JPanel();
		pnlPr.setBounds(10,130,330,60);
		pnlPr.setBackground(new Color(255, 216, 177));
		add(pnlPr);
		//Elaboracion de pregunta
		lblPregunta = new JLabel(strPregunta[contador]);
		pnlPr.add(lblPregunta);  
		
		//Panel para las respuestas
		pnlRe = new JPanel();
		pnlRe.setBounds(10,200,330,230);
		pnlRe.setBackground(new Color(255, 216, 177));
		add(pnlRe);
		//Elaboracion de las opciones de respuesta
		strRespuestas[contador] = randomize(strRespuestas[contador]);
		for (int i = 0; i < strRespuestas[contador].length; i++){
			rRespuestas[i] = new JRadioButton(strRespuestas[contador][i]);
			rRespuestas[i].setBackground(new Color(194, 127, 121));
			rRespuestas[i].setForeground(new Color(20, 65, 81));
			bgRespuestas.add(rRespuestas[i]);
		}
		JPanel pnlRespuesta[] = {new JPanel(), new JPanel(), new JPanel(), new JPanel()};
		for (int i = 0; i < rRespuestas.length; i++){
			pnlRespuesta[i].setPreferredSize(new Dimension(300, 50));
			pnlRespuesta[i].setBackground(new Color(194, 127, 121));
			pnlRespuesta[i].add(rRespuestas[i]);
			pnlRe.add(pnlRespuesta[i]);
		}
		
		// Panel y Boton de verificacion
		btn1 = new JButton();
		btn1.setIcon(new ImageIcon("verificar.gif"));
		btn1.setBounds(430,391,49,35);
		btn1.addActionListener(this);
		add(btn1);
		btn2 = new JButton();
		btn2.setIcon(new ImageIcon("entrar.gif"));
		btn2.setBounds(550,393,34,33);
		btn2.addActionListener(this);
		add(btn2);
		pnlBu = new JPanel();
		pnlBu.setBounds(350,390,320,37); 
		pnlBu.setBackground(new Color(255, 216, 177));
		add(pnlBu);
		
		//Panel de fondo
		pnl = new JPanel();
		pnl.setBounds(0,0,700,500); 
		pnl.setBackground(new Color(97, 0, 35));
		add(pnl);

	}
	
	//Dibujo base del ahorcado e insercion de logos
	public void paint (Graphics ahorca){
		super.paint(ahorca);
		ahorca.setColor(Color.BLACK);
		ahorca.drawRect(410, 380, 70, 10);
		ahorca.drawLine(440, 180, 440, 380);
		ahorca.drawLine(410, 180, 590, 180);
		ahorca.drawLine(440, 220, 470, 180);
		ahorca.drawLine(590, 180, 590, 210);          
	    coyo = new ImageIcon("coyo.png");
	    conversion = coyo.getImage();
	    conversion = conversion.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
	    coyo = new ImageIcon(conversion);
	    coyo.paintIcon(this,ahorca,18,41);
	    unam = new ImageIcon("unam.png");
	    conversion = unam.getImage();
	    conversion = conversion.getScaledInstance(60, 58, Image.SCALE_SMOOTH);
	    unam = new ImageIcon(conversion);
	    unam.paintIcon(this,ahorca,617,42);
	}
		
	//Corroboracion de la respuesta
	public static boolean checkPregunta(int intNPregunta, String respuesta, String[] clave){
		if(respuesta.equals(clave[intNPregunta])){
			JOptionPane.showMessageDialog(null, "Respuesta correcta");
			return true;
		}
		JOptionPane.showMessageDialog(null, "<html>Respuesta err&oacute;nea</html>");
		return false;
	}
	
	//Accion realizada al presionar un boton
	public void actionPerformed(ActionEvent e) {
		//Cuando se presiona "Verifica"
		Object origen = e.getSource();
		if (origen == btn1) {
			int intRespuesta;
			boolean respondido = false;
			// Revisa que radio se seleccion
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
							terminar();
							System.exit(0);
						}
					//la respuesta es falsa
					}else{
						errores++;
						int nVidas = vidas - errores;
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
						lblVida.setText("Vidas: " + nVidas);
						//Si has tenido 6 errores, pierdes el juego
						if(errores == vidas){
							terminar();
							System.exit(0);
						}
					}
					
					lblPunt.setText("Puntos: " + correctas);
					contador++;
					if(contador == preguntas){
						terminar();
						System.exit(0);
					}
					lblPregunta.setText(strPregunta[contador]);
					strRespuestas[contador] = randomize(strRespuestas[contador]);
					for(int j = 0; j < rRespuestas.length; j++){
						rRespuestas[j].setText(strRespuestas[contador][j]);
					}
					bgRespuestas.clearSelection();
				}
			}
			//Si el boton de verificar se ha presionado sin seleccionar una respuesta
			if(!respondido){
				JOptionPane.showMessageDialog(null, "<html>Selecciona una opci" + oc + "n </html>");
			}
		}
		//Boton de salir
		if(origen == btn2){
			System.exit(0);
		}
	}
	//Funcion para terminar
	public void terminar(){
		int calificacion = (correctas*10/preguntas);
		JOptionPane.showMessageDialog(null, "<html>Tuviste " + correctas +" respuestas correctas y " + errores + " error" + oc + "neas </html>");
		if(calificacion >= 6){
			JOptionPane.showMessageDialog(null, "<html>Aprobaste el cuestionario, el programa terminar" + ac + " ahora </html>");
		}else{
			JOptionPane.showMessageDialog(null, "Reprobaste el cuestionario, reinicia el programa");
		}
	}
	//Aleatorizacion del orde de las opciones
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