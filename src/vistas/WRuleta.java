package vistas;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import controladores.EventBTT;
import controladores.MainEvents;
import controladores.utils.Constantes;
import controladores.utils.Global;

public class WRuleta extends JFrame{
	
	private Toolkit toolkit;
	private static Logger logger = Logger.getLogger(MainEvents.class);
    private EventBTT eb;
    
    private JLabel labelCantJugadores;
    private JLabel labelCantRondas;
    
    private JComboBox comboCantJugadores;
    private JComboBox comboCantCategorias;
    private JComboBox comboCantRondas;
    
    private JButton start;
    private JButton agregarPregunta;
    private JButton registrarParticipante;
	
	public EventBTT getEb() {
		return eb;
	}

	public void setEb(EventBTT eb) {
		this.eb = eb;
	}

	public JComboBox getComboCantJugadores() {
		return comboCantJugadores;
	}

	public void setComboCantJugadores(JComboBox comboCantJugadores) {
		this.comboCantJugadores = comboCantJugadores;
	}

	public JComboBox getComboCantCategorias() {
		return comboCantCategorias;
	}

	public void setComboCantCategorias(JComboBox comboCantCategorias) {
		this.comboCantCategorias = comboCantCategorias;
	}

	public JComboBox getComboCantRondas() {
		return comboCantRondas;
	}

	public void setComboCantRondas(JComboBox comboCantRondas) {
		this.comboCantRondas = comboCantRondas;
	}

	public WRuleta(){
		logger.info("Construyendo ventana");
		setSize(300, 160);
		setTitle("Ruleta");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		logger.debug("Centralizando pantalla...");
		toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		
		Global.categorias = Global.getCategorias();

		JPanel panel = new JPanel();
		getContentPane().add(panel);

		panel.setLayout(new FlowLayout());

		eb = new EventBTT(this, Constantes.CREAR_PARTIDA);
		
		labelCantJugadores = new JLabel(Constantes.TXT_CANT_JUGADORES);
		panel.add(labelCantJugadores);
		comboCantJugadores = new JComboBox(Constantes.ARRAY_CANT_JUGADORES);
		panel.add(comboCantJugadores);
		
		labelCantRondas = new JLabel(Constantes.TXT_CANT_RONDAS);
		panel.add(labelCantRondas);
		comboCantRondas = new JComboBox(Constantes.ARRAY_CANT_RONDAS);
		panel.add(comboCantRondas);
		
		agregarPregunta = new JButton(Constantes.BTT_ADD_PREGUNTA);
		agregarPregunta.setBounds(50, 25, Constantes.bttWidth, Constantes.bttHeight);
		agregarPregunta.addActionListener(eb);
		panel.add(agregarPregunta);
		
		registrarParticipante = new JButton(Constantes.BTT_ADD_PARTICIPANTE);
		registrarParticipante.setBounds(50, 25, Constantes.bttWidth, Constantes.bttHeight);
		registrarParticipante.addActionListener(eb);
		panel.add(registrarParticipante);
		
		start = new JButton(Constantes.BTT_COMENZAR);
		start.setBounds(50, 25, Constantes.bttWidth, Constantes.bttHeight);
		start.addActionListener(eb);
		panel.add(start);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WRuleta ruleta = new WRuleta();
		ruleta.setVisible(true);
	}

}
