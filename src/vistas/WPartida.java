package vistas;

import java.awt.Dimension;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelos.Participante;

import org.apache.log4j.Logger;

import java.util.List;

import controladores.EventBTT;
import controladores.MainEvents;
import controladores.utils.Constantes;
import controladores.utils.Global;
import controladores.utils.Ruleta;


public class WPartida extends VentanaBasica {
	private static Logger logger = Logger.getLogger(WPartida.class);
	private Toolkit toolkit;
	private List<JFrame> frames;
    private Ruleta ruleta;
    private EventBTT bttEvent;
    private List<Participante> participantes;
	
	public WPartida(int cantP, int canC){
		logger.debug("Construyendo juego");
		setLayout(new FlowLayout());
	    setSize(800, 400);
	    setTitle(Constantes.TITLE_MAIN_WINDOW);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    
	    bttEvent = new EventBTT(this);
		logger.debug("Centralizando pantalla...");
		toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout());
		
		Box participantes = Box.createHorizontalBox();
		Box p1 = Box.createVerticalBox();
		Global.cp1 = new CuadroParticipante();
		Global.cp1.setBackground(Color.LIGHT_GRAY);
		p1.add(Global.cp1);
		Global.cp2 = new CuadroParticipante();
		Global.cp2.setBackground(Color.WHITE);
		p1.add(Global.cp2);
		participantes.add(p1);
		if(cantP > 2){
			Box p2 = Box.createVerticalBox();
			if(cantP >= 3){
				Global.cp3 = new CuadroParticipante();
				Global.cp3.setBackground(Color.WHITE);
				p2.add(Global.cp3);
			}
			if(cantP == 4){
				Global.cp4 = new CuadroParticipante();
				Global.cp4.setBackground(Color.WHITE);
				p2.add(Global.cp4);
			}
			participantes.add(p2);
		}


		Box segunda = Box.createVerticalBox();
		ruleta = new Ruleta();
		segunda.add(ruleta);
		
		Box rondaPlay = Box.createHorizontalBox();
		Global.ronda = new JLabel(Global.nRondas+Constantes.TXT_RONDAS+Global.cantRondas+ "           ");
		rondaPlay.add(Global.ronda);
		Global.play = new JButton(Constantes.BTT_PLAY);
		Global.play.setBounds(50, 25, Constantes.bttWidth, Constantes.bttHeight);
		Global.play.setEnabled(false);
		Global.play.addActionListener(bttEvent);
		rondaPlay.add(Global.play);
		segunda.add(rondaPlay);


		Box cuerpo = Box.createHorizontalBox();
		cuerpo.add(participantes);
		cuerpo.add(segunda);
		
		panel.add(cuerpo);
		this.setVisible(true);

	}

	public Ruleta getRuleta() {
		return ruleta;
	}

	public void setRuleta(Ruleta ruleta) {
		this.ruleta = ruleta;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}
}
