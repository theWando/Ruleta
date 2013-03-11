package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelos.Categoria;
import modelos.Pregunta;
import modelos.Respuesta;

import org.apache.log4j.Logger;

import controladores.AccionesPregunta;
import controladores.EventBTT;
import controladores.utils.Constantes;
import controladores.utils.Global;

public class PreguntaPopUp extends JDialog {
	private static Logger logger = Logger.getLogger(PreguntaPopUp.class);
	private JLabel pregunta;
	private JLabel respuestaL;
	private List<JButton> respuestas;
	private JButton comp;
	private JButton sel;
	private EventBTT bttEvent;
	private JTextField respuestaTXT;
	private JTextField categoria;
	private JPanel panel;
	
	public PreguntaPopUp(boolean tipo){
		super();
		logger.debug("Tipo recibido: " + tipo);
		Global.tipo = tipo;
		this.setTitle(Constantes.TITLE_RESPONDE);
		
		logger.debug("Construyendo ventana de respuesta");
		setSize(650, 270);
//		setSize(270,160);
	    setDefaultCloseOperation(HIDE_ON_CLOSE);
	    bttEvent = new EventBTT(this, Constantes.ACCION_RESPONDER);
		panel = new JPanel();
		getContentPane().add(panel);
		
//		panel.setLayout(new FlowLayout());
		panel.setLayout(new BorderLayout());
		
		AccionesPregunta ap = new AccionesPregunta();
		Pregunta pre = ap.buscarPregunta(Global.tipo, Global.posRuleta);
		logger.debug(pre);
		Box cuerpo = Box.createVerticalBox();
		pregunta = new JLabel("<html>"+Constantes.TXT_POR_CATEGORIA + pre.getNombreCategoria() + "<br>" + pre.getPregunta()+"</html>");
//		pregunta.setSize(pregunta.getPreferredSize());
//		pregunta.setBackground(Color.RED);
		cuerpo.add(pregunta);
//		respuestas = new ArrayList<JButton>();
		if(Global.tipo){
			for(int i = 0; i < pre.getOpciones().size(); i++){
				Respuesta res = pre.getOpciones().get(i);
				JButton respuesta = new JButton(res.getRespuesta());
				respuesta.setSize(600, 50);
				respuesta.addActionListener(bttEvent);
//				respuestas.add(respuesta);
				cuerpo.add(respuesta);
			}
		} else {
			respuestaL = new JLabel(Constantes.TXT_RESPUESTA);
			cuerpo.add(respuestaL);
			
			respuestaTXT = new JTextField(15);
			cuerpo.add(respuestaTXT);
			JButton boton = new JButton(Constantes.BTT_RESPONDER);
			boton.addActionListener(bttEvent);
			cuerpo.add(boton);
		}
		panel.add(cuerpo);
		
		this.setVisible(true);
	}
	
	public JTextField getRespuestaTXT() {
		return respuestaTXT;
	}

	public void setRespuestaTXT(JTextField respuestaTXT) {
		this.respuestaTXT = respuestaTXT;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
}
