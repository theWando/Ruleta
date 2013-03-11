package vistas;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import controladores.EventBTT;
import controladores.utils.Constantes;

public class PreguntaDialogo extends JDialog {
	
	private static Logger logger = Logger.getLogger(PreguntaDialogo.class);
	private JLabel preguntaLabel;
	private JLabel respuestaLabel1;
	private JLabel respuestaLabel2;
	private JLabel respuestaLabel3;
	private JLabel respuestaLabel4;
	private JLabel respuestaCorrecta;
	
	private JComboBox comboCategoria;
	private JComboBox comboTipoPregunta;
	
	private JButton save;
	
	private JTextField preguntaTXT;
	private JTextField respuestaTXT1;
	private JTextField respuestaTXT2;
	private JTextField respuestaTXT3;
	private JTextField respuestaTXT4;
	
	private JRadioButton resp1;
	private JRadioButton resp2;
	private JRadioButton resp3;
	private JRadioButton resp4;
	private ButtonGroup bg;
	
	private EventBTT bttEvent;
	private ComboListener cl;
	private JPanel panel;
	
	public PreguntaDialogo(WRuleta wr){
		super(wr, Constantes.TITLE_ADD_QUESTION, true);
		
		logger.debug("Construyendo juego");
	    setSize(450, 500);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    
	    
	    bttEvent = new EventBTT(this, Constantes.ACCION_AGREGAR_QUESTION);
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout());

		Box cuerpo = Box.createVerticalBox();
		Box pregunta = Box.createHorizontalBox();
		preguntaLabel = new JLabel(Constantes.TXT_PREGUNTA);
		preguntaTXT = new JTextField(30);
		pregunta.add(preguntaLabel);
		pregunta.add(preguntaTXT);
		cuerpo.add(pregunta);
		
		comboCategoria = new JComboBox(Constantes.ARRAY_CATEGORIAS);
		comboTipoPregunta = new JComboBox(Constantes.ARRAY_TIPO_PREGUNTA);
		cl = new ComboListener(this);
		comboTipoPregunta.addItemListener(cl);
		cuerpo.add(comboCategoria);
		cuerpo.add(comboTipoPregunta);
		
		
		
		respuestaLabel1 = new JLabel(Constantes.TXT_RESPUESTA);
		respuestaTXT1 = new JTextField(30);
		
		respuestaLabel2 = new JLabel(Constantes.TXT_RESPUESTA);
		respuestaTXT2 = new JTextField(30);

		respuestaLabel3 = new JLabel(Constantes.TXT_RESPUESTA);
		respuestaTXT3 = new JTextField(30);

		respuestaLabel4 = new JLabel(Constantes.TXT_RESPUESTA);
		respuestaTXT4 = new JTextField(30);

		panel.add(cuerpo);
		panel.add(respuestaLabel1);
		panel.add(respuestaTXT1);
		panel.add(respuestaLabel2);
		panel.add(respuestaTXT2);
		panel.add(respuestaLabel3);
		panel.add(respuestaTXT3);
		panel.add(respuestaLabel4);
		panel.add(respuestaTXT4);
		
		respuestaCorrecta = new JLabel(Constantes.TXT_RESPUESTA_CORRECTA);
		JLabel spacio = new JLabel("                                           ");
		resp1 = new JRadioButton(Constantes.TXT_OPCION1);
		resp2 = new JRadioButton(Constantes.TXT_OPCION2);
		resp3 = new JRadioButton(Constantes.TXT_OPCION3);
		resp4 = new JRadioButton(Constantes.TXT_OPCION4);
		panel.add(respuestaCorrecta);
		panel.add(spacio);
		panel.add(new JSeparator(SwingConstants.HORIZONTAL));
		panel.add(resp1);
		panel.add(resp2);
		panel.add(resp3);
		panel.add(resp4);
		
		bg = new ButtonGroup();
		bg.add(resp1);
		bg.add(resp2);
		bg.add(resp3);
		bg.add(resp4);
		
		JButton save = new JButton(Constantes.BTT_ADD_PREGUNTA);
		save.setBounds(50, 25, Constantes.bttWidth, Constantes.bttHeight);
		save.addActionListener(bttEvent);
		panel.add(save);

		
		save = new JButton(Constantes.BTT_ADD_PREGUNTA);
		
		
		this.setVisible(true);
	}
	
	public JPanel redibujar(int selected){
		if(selected == 1){
			Box cuerpo = Box.createVerticalBox();
			Box pregunta = Box.createHorizontalBox();
			preguntaLabel = new JLabel(Constantes.TXT_PREGUNTA);
			preguntaTXT = new JTextField(30);
			pregunta.add(preguntaLabel);
			pregunta.add(preguntaTXT);
			cuerpo.add(pregunta);
			
			comboCategoria = new JComboBox(Constantes.ARRAY_CATEGORIAS);
			comboTipoPregunta = new JComboBox(Constantes.ARRAY_TIPO_PREGUNTA);
			comboTipoPregunta.setSelectedIndex(selected);
			cl = new ComboListener(this);
			comboTipoPregunta.addItemListener(cl);
			cuerpo.add(comboCategoria);
			cuerpo.add(comboTipoPregunta);
			
			respuestaLabel1 = new JLabel(Constantes.TXT_RESPUESTA);
			respuestaTXT1 = new JTextField(30);
			
			panel.add(cuerpo);
			panel.add(respuestaLabel1);
			panel.add(respuestaTXT1);
			
			JButton save = new JButton(Constantes.BTT_ADD_PREGUNTA);
			save.setBounds(50, 25, Constantes.bttWidth, Constantes.bttHeight);
			save.addActionListener(bttEvent);
			panel.add(save);
	
			
			save = new JButton(Constantes.BTT_ADD_PREGUNTA);
			
			this.setVisible(true);
			return panel;
		}else{
			Box cuerpo = Box.createVerticalBox();
			Box pregunta = Box.createHorizontalBox();
			preguntaLabel = new JLabel(Constantes.TXT_PREGUNTA);
			preguntaTXT = new JTextField(30);
			pregunta.add(preguntaLabel);
			pregunta.add(preguntaTXT);
			cuerpo.add(pregunta);
			
			comboCategoria = new JComboBox(Constantes.ARRAY_CATEGORIAS);
			comboTipoPregunta = new JComboBox(Constantes.ARRAY_TIPO_PREGUNTA);
			cl = new ComboListener(this);
			comboTipoPregunta.addItemListener(cl);
			cuerpo.add(comboCategoria);
			cuerpo.add(comboTipoPregunta);
			
			respuestaLabel1 = new JLabel(Constantes.TXT_RESPUESTA);
			respuestaTXT1 = new JTextField(30);
			
			respuestaLabel2 = new JLabel(Constantes.TXT_RESPUESTA);
			respuestaTXT2 = new JTextField(30);

			respuestaLabel3 = new JLabel(Constantes.TXT_RESPUESTA);
			respuestaTXT3 = new JTextField(30);

			respuestaLabel4 = new JLabel(Constantes.TXT_RESPUESTA);
			respuestaTXT4 = new JTextField(30);

			panel.add(cuerpo);
			panel.add(respuestaLabel1);
			panel.add(respuestaTXT1);
			panel.add(respuestaLabel2);
			panel.add(respuestaTXT2);
			panel.add(respuestaLabel3);
			panel.add(respuestaTXT3);
			panel.add(respuestaLabel4);
			panel.add(respuestaTXT4);
			
			respuestaCorrecta = new JLabel(Constantes.TXT_RESPUESTA_CORRECTA);
			JLabel spacio = new JLabel("                                           ");
			resp1 = new JRadioButton(Constantes.TXT_OPCION1);
			resp2 = new JRadioButton(Constantes.TXT_OPCION2);
			resp3 = new JRadioButton(Constantes.TXT_OPCION3);
			resp4 = new JRadioButton(Constantes.TXT_OPCION4);
			panel.add(respuestaCorrecta);
			panel.add(spacio);
			panel.add(new JSeparator(SwingConstants.HORIZONTAL));
			panel.add(resp1);
			panel.add(resp2);
			panel.add(resp3);
			panel.add(resp4);
			
			bg = new ButtonGroup();
			bg.add(resp1);
			bg.add(resp2);
			bg.add(resp3);
			bg.add(resp4);
			
			JButton save = new JButton(Constantes.BTT_ADD_PREGUNTA);
			save.setBounds(50, 25, Constantes.bttWidth, Constantes.bttHeight);
			save.addActionListener(bttEvent);
			panel.add(save);
			
			save = new JButton(Constantes.BTT_ADD_PREGUNTA);
			
			this.setVisible(true);
			return panel;
		}
	}

	public JTextField getRespuestaTXT1() {
		return respuestaTXT1;
	}

	public void setRespuestaTXT1(JTextField respuestaTXT1) {
		this.respuestaTXT1 = respuestaTXT1;
	}

	public JTextField getRespuestaTXT2() {
		return respuestaTXT2;
	}

	public void setRespuestaTXT2(JTextField respuestaTXT2) {
		this.respuestaTXT2 = respuestaTXT2;
	}

	public JTextField getRespuestaTXT3() {
		return respuestaTXT3;
	}

	public void setRespuestaTXT3(JTextField respuestaTXT3) {
		this.respuestaTXT3 = respuestaTXT3;
	}

	public JTextField getRespuestaTXT4() {
		return respuestaTXT4;
	}

	public void setRespuestaTXT4(JTextField respuestaTXT4) {
		this.respuestaTXT4 = respuestaTXT4;
	}

	public JComboBox getComboCategoria() {
		return comboCategoria;
	}

	public void setComboCategoria(JComboBox comboCategoria) {
		this.comboCategoria = comboCategoria;
	}

	public JRadioButton getResp1() {
		return resp1;
	}

	public void setResp1(JRadioButton resp1) {
		this.resp1 = resp1;
	}

	public JRadioButton getResp2() {
		return resp2;
	}

	public void setResp2(JRadioButton resp2) {
		this.resp2 = resp2;
	}

	public JRadioButton getResp3() {
		return resp3;
	}

	public void setResp3(JRadioButton resp3) {
		this.resp3 = resp3;
	}

	public JRadioButton getResp4() {
		return resp4;
	}

	public void setResp4(JRadioButton resp4) {
		this.resp4 = resp4;
	}

	public ButtonGroup getBg() {
		return bg;
	}

	public void setBg(ButtonGroup bg) {
		this.bg = bg;
	}

	public JTextField getPreguntaTXT() {
		return preguntaTXT;
	}

	public void setPreguntaTXT(JTextField preguntaTXT) {
		this.preguntaTXT = preguntaTXT;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JComboBox getComboTipoPregunta() {
		return comboTipoPregunta;
	}

	public void setComboTipoPregunta(JComboBox comboTipoPregunta) {
		this.comboTipoPregunta = comboTipoPregunta;
	}
	
}
