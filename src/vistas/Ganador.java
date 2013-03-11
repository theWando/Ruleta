package vistas;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import controladores.utils.Constantes;
import controladores.utils.Global;

import modelos.Participante;

public class Ganador extends JDialog {
	
	private static Logger logger = Logger.getLogger(Ganador.class);
	private JPanel panel;
	private JLabel winnerIs;
	private JLabel pGanador;

	public Ganador(WPartida wp){
		super(wp, Constantes.TXT_GANADOR, true);
		
		logger.debug("Construyendo juego");
	    setSize(450, 500);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout());

	    Box cuerpo = Box.createVerticalBox();
	    winnerIs = new JLabel(Constantes.TXT_GANADOR);
	    cuerpo.add(winnerIs);
	    
	    Participante par = Global.obtenerGanador();
	    pGanador = new JLabel(par.getNombre() + " " + par.getApellido() + " con " + par.getPuntaje());
	    cuerpo.add(pGanador);
	    
	    panel.add(cuerpo);
	    this.setVisible(true);
	    
	}

}
