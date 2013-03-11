package controladores.utils;

import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

import controladores.Crono;
import controladores.figura;

public class Ruleta extends javax.swing.JPanel{
	
    private javax.swing.JLabel jLabel1;
	private static Logger logger = Logger.getLogger(Ruleta.class);

	public Ruleta(){
		logger.debug("Construyendo ruleta....");
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBackground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(Constantes.PATH+"ruedaG1.jpg"));
        this.add(jLabel1);
	}
	
	public void play(){

        figura f[] = new figura[16];
	    f[0]=new figura(new ImageIcon(Constantes.PATH+"ruedaG1.jpg"));
		f[1]=new figura(new ImageIcon(Constantes.PATH+"ruedaG2.jpg"));
		f[2]=new figura(new ImageIcon(Constantes.PATH+"ruedaG3.jpg"));
		f[3]=new figura(new ImageIcon(Constantes.PATH+"ruedaG4.jpg"));
		f[4]=new figura(new ImageIcon(Constantes.PATH+"ruedaG5.jpg"));
		f[5]=new figura(new ImageIcon(Constantes.PATH+"ruedaG6.jpg"));
		f[6]=new figura(new ImageIcon(Constantes.PATH+"ruedaG7.jpg"));
		f[7]=new figura(new ImageIcon(Constantes.PATH+"ruedaG8.jpg"));
		new Crono(jLabel1,f);
	}

}
