package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

import vistas.WPartida;

import controladores.utils.Constantes;
import controladores.utils.Ruleta;

public class MainEvents implements ActionListener {
	private WindowManager wm;
	private static Logger logger = Logger.getLogger(MainEvents.class);

    @Override
	public void actionPerformed(ActionEvent e) {
		wm = new WindowManager();
			if (e.getSource().toString().contains(Constantes.BTT_COMENZAR)) {
				logger.debug("levantando partida....");
//				WPartida wPartida = new WPartida();
//				wPartida.addWindowListener(wm);
			} else if(e.getSource().toString().contains(Constantes.BTT_PLAY)){
				logger.debug("Girando....");
				java.awt.EventQueue.invokeLater(new Runnable() {
		            public void run() {
		                new Ruleta().play();
		            }
		        });
			}
	}

}
