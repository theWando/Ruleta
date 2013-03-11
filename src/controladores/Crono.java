package controladores;


import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Random;

import javax.swing.*;

import org.apache.log4j.Logger;

import vistas.PreguntaPopUp;
import vistas.TipoPregunta;

import controladores.utils.Global;
import controladores.utils.Ruleta;

public class Crono implements Runnable{
	
	private static Logger logger = Logger.getLogger(Ruleta.class);

   Thread crono;
   javax.swing.JLabel tiempo = new javax.swing.JLabel();
   figura [] giros;
	Random random = new Random((new Date()).getTime());
//   int retardo = random.nextInt(5);//5;
//   int segundos=8;// random.nextInt(8);
   /** Creando  cronometro */
  public Crono(JLabel t, figura[] tem) {
     crono = new Thread(this);
     crono.start();
     tiempo  =t;
     giros =  tem;
   //  map =new Mapas();
    // v1=v;
  }


  public void run(){
    try {
      for(;;){
        if (Global.retardo>=100){
        	random = new Random((new Date()).getTime());
        	Global.retardo = random.nextInt(15);
        	Global.posRuleta = Global.frame;
           logger.info("Rueda detenida, categoria: " + Global.posRuleta + " nuevo retardo: " + Global.retardo);
           
           TipoPregunta tipoPregunta = new TipoPregunta();
           crono.stop();
        }
        else{
        	Global.frame--;
           logger.info("segundos: "+Global.frame);
//           logger.info("giros: "+ giros);
//           logger.info("tiempo: " + tiempo);
           tiempo.setIcon(giros[Global.frame].imagen);
           crono.sleep(Global.retardo);
           Global.retardo = Global.retardo+5;
           if (Global.frame<=0){
        	   Global.frame = 8;//random.nextInt(8);
//        		if(segundos == 0)
//        			segundos++;
        	   logger.debug("retardo:" + Global.retardo);
        	   crono.sleep(Global.retardo);
           }
        }
     }
   }
   catch (InterruptedException e) {
 	  System.out.println(e.getMessage());
   }
}
}
