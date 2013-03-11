package vistas;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelos.Pregunta;

import org.apache.log4j.Logger;

import controladores.EventBTT;
import controladores.utils.Constantes;
import controladores.utils.Global;

public class TipoPregunta extends VentanaBasica {
	private static Logger logger = Logger.getLogger(TipoPregunta.class);
	private JLabel pregunta;
	private JButton comp;
	private JButton sel;
	private EventBTT bttEvent;
	private JPanel panel;

	public TipoPregunta() {
		super();
		this.setTitle(Constantes.TITLE_TIPO_PREGUNTA);
		
		logger.debug("Construyendo ventana de respuesta");
		setSize(270,160);
	    setDefaultCloseOperation(HIDE_ON_CLOSE);
	    bttEvent = new EventBTT(this, Constantes.ACCION_TIPO_PREGUNTA);
		panel = new JPanel();
		getContentPane().add(panel);
		
//		panel.setLayout(new FlowLayout());
		panel.setLayout(new BorderLayout());
		
		Box cuerpo = Box.createVerticalBox();
		pregunta = new JLabel(Constantes.TXT_TIPO_PREGUNTA);
		comp = new JButton(Constantes.TXT_SELECCION);
		comp.addActionListener(bttEvent);
		sel = new JButton(Constantes.TXT_COMPLETACION);
		sel.addActionListener(bttEvent);
		cuerpo.add(pregunta);
		cuerpo.add(comp);
		cuerpo.add(sel);

		panel.add(cuerpo);
		
		this.setVisible(true);
	}

	public JLabel getPregunta() {
		return pregunta;
	}

	public void setPregunta(JLabel pregunta) {
		this.pregunta = pregunta;
	}

	public JButton getComp() {
		return comp;
	}

	public void setComp(JButton comp) {
		this.comp = comp;
	}

	public JButton getSel() {
		return sel;
	}

	public void setSel(JButton sel) {
		this.sel = sel;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	


}
