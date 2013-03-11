package controladores;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import modelos.Categoria;
import modelos.Participante;
import modelos.Pregunta;
import modelos.Respuesta;

import org.apache.log4j.Logger;

import vistas.CuadroParticipante;
import vistas.Ganador;
import vistas.PreguntaDialogo;
import vistas.PreguntaPopUp;
import vistas.RegistrarUsuario;
import vistas.TipoPregunta;
import vistas.WPartida;
import vistas.WRuleta;

import controladores.utils.Constantes;
import controladores.utils.Global;

public class EventBTT implements ActionListener {

    private String accion;
    private WPartida wp;
    private WRuleta wRuleta;
    private WindowManager wm;
    private CuadroParticipante cuadroParticipante;
    private PreguntaDialogo preguntaDialogo;
    private PreguntaPopUp preguntaPopUp;
    private RegistrarUsuario ru;
    private TipoPregunta tipoPregunta;
    
	private static Logger logger = Logger.getLogger(EventBTT.class);


    public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public EventBTT(WPartida wp){
        this.wp = wp;
    }

	public EventBTT(WRuleta wRuleta, String accion) {
		this.wRuleta = wRuleta;
		this.accion = accion;
	}

	public EventBTT(CuadroParticipante cuadroParticipante, String accionAgregarParticipante) {
		this.cuadroParticipante = cuadroParticipante;
		this.accion = accionAgregarParticipante;
	}

	public EventBTT(PreguntaDialogo preguntaDialogo, String accionAgregarQuestion) {
		this.preguntaDialogo = preguntaDialogo;
		this.accion = accionAgregarQuestion;
	}

	public EventBTT(PreguntaPopUp preguntaPopUp, String accionResponder) {
		this.preguntaPopUp = preguntaPopUp;
		this.accion = accionResponder;
	}

	public EventBTT(TipoPregunta tipoPregunta, String accionTipoPregunta) {
		this.tipoPregunta = tipoPregunta;
		this.accion = accionTipoPregunta;
	}

	public EventBTT(RegistrarUsuario registrarUsuario,
			String accionAgregarParticipante) {
		this.ru = registrarUsuario;
		this.accion = accionAgregarParticipante;
	}

	public void actionPerformed(ActionEvent e) {
		logger.debug("accion realizada... " + e);
		logger.debug(accion);
		if(wp != null && e.getSource().toString().contains(Constantes.BTT_PLAY)){
        	logger.debug("girando...");
            this.wp.getRuleta().play();
            Global.play.setEnabled(false);
		}else if(ru != null && accion.matches(Constantes.ACCION_AGREGAR_PARTICIPANTE)){
			Participante par = new Participante();
			par.setNombre(ru.getJlNombreTF().getText());
			par.setApellido(ru.getJlApellidoTF().getText());
			par.setNick(ru.getJlLoginTF().getText());
			par.setContrasena(ru.getJlPassTF().getText());
			par.setSexo((ru.getJlSexoTF().getSelectedIndex() == 0)?true:false);
			par.setFdn(ru.getJlDobTF().getText());
			par.setEdad(Integer.parseInt(ru.getJlEdadTF().getText()));
			AccionesParticipante ap = new AccionesParticipante();
			boolean creado = ap.crearParticipante(par);
			logger.debug("Usuario creado? " + creado);
		}else if(wRuleta != null  && e.getSource().toString().contains(Constantes.BTT_ADD_PARTICIPANTE)){
			RegistrarUsuario ru = new RegistrarUsuario(wRuleta);
			ru.addWindowListener(wm);
		}else if (wRuleta != null && e.getSource().toString().contains(Constantes.BTT_COMENZAR)){
			Global.cantUser = Integer.parseInt((String) wRuleta.getComboCantJugadores().getSelectedItem());
			Global.cantRondas = Integer.parseInt((String) wRuleta.getComboCantRondas().getSelectedItem());
			
			logger.debug("Cant. de jugadores: " + Global.cantUser);
			WPartida wRuleta = new WPartida(Global.cantUser, Global.cantCat);
			wRuleta.addWindowListener(wm);
		} else if (wRuleta != null && e.getSource().toString().contains(Constantes.BTT_ADD_PREGUNTA)){
			logger.debug("dialogo para agregar preguntas");
			PreguntaDialogo pd = new PreguntaDialogo(wRuleta);
			pd.addWindowListener(wm);
		} else if (cuadroParticipante != null && this.getAccion().matches(Constantes.ACCION_AGREGAR_PARTICIPANTE)) {
			JButton btt = (JButton) e.getSource();
			CuadroParticipante cp = (CuadroParticipante) btt.getParent().getParent();
//			p = new Participante(cp);
			AccionesParticipante ap = new AccionesParticipante();
			Participante p = ap.buscarUsuarioxLoginPass(cp.getJlNombreTF().getText(), cp.getJlApellidoTF().getText());
			if(p.validarParticipante()){
				logger.debug("llenado el participante... " + p);
				cp.removeAll();
				logger.debug("removido todo...");
				cp.redibujar(p);
				cp.revalidate();
				Global.usuarioRegistrado++;
			}
			if(Global.usuarioRegistrado == Global.cantUser)
				Global.play.setEnabled(true);
		} else if (preguntaDialogo != null && e.getSource().toString().contains(Constantes.BTT_ADD_PREGUNTA)){
			preguntaDialogo.dispose();
			Categoria cat = new Categoria();
			Pregunta pre = new Pregunta();
			List<Pregunta> preguntas = new ArrayList<Pregunta>();
			List<Respuesta> respuesta = new ArrayList<Respuesta>();
			Respuesta res1 = new Respuesta(preguntaDialogo.getRespuestaTXT1().getText(),preguntaDialogo.getResp1().isSelected()?true:false);
			Respuesta res2 = new Respuesta(preguntaDialogo.getRespuestaTXT2().getText(),preguntaDialogo.getResp2().isSelected()?true:false);
			Respuesta res3 = new Respuesta(preguntaDialogo.getRespuestaTXT3().getText(),preguntaDialogo.getResp3().isSelected()?true:false);
			Respuesta res4 = new Respuesta(preguntaDialogo.getRespuestaTXT4().getText(),preguntaDialogo.getResp4().isSelected()?true:false);

			respuesta.add(res1);
			respuesta.add(res2);
			respuesta.add(res3);
			respuesta.add(res4);

			pre.setPregunta(preguntaDialogo.getPreguntaTXT().getText());
			pre.setOpciones(respuesta);
			logger.debug("categoria"+preguntaDialogo.getComboCategoria().getSelectedItem());
			int categoria = preguntaDialogo.getComboCategoria().getSelectedIndex();
			pre.setIdCategoria(categoria);
			preguntas.add(pre);
			cat.setIdCategoria(categoria);
			cat.setNombreCategoria((String)preguntaDialogo.getComboCategoria().getSelectedItem());
			cat.setPreguntas(preguntas);
			
			Global.asignarPregunta(cat);
			
			logger.debug(pre);
		}else if(tipoPregunta != null && accion.matches(Constantes.ACCION_TIPO_PREGUNTA)){
			tipoPregunta.dispose();
			if(e.getSource().toString().contains(Constantes.TXT_SELECCION)){
				PreguntaPopUp preguntaPopUp = new PreguntaPopUp(true);
			}else{
				PreguntaPopUp preguntaPopUp = new PreguntaPopUp(false);
			}
		}else if(preguntaPopUp != null && accion.matches(Constantes.ACCION_RESPONDER)){
			logger.debug("Seleccion " +e.getSource().toString().contains(Constantes.TXT_SELECCION) + " completacion: " +  e.getSource().toString().contains(Constantes.TXT_COMPLETACION));

			preguntaPopUp.dispose();
			boolean correcto = false;
			AccionesPregunta ap = new AccionesPregunta();
			AccionesParticipante accionesParticipante = new AccionesParticipante();
			Pregunta pre = ap.buscarPregunta(Global.tipo, Global.posRuleta);
			logger.debug(pre);
			logger.debug("pre.getRespuestaCorrecta():" + pre.getRespuestaCorrecta());
			if(!Global.tipo){
				logger.debug("preguntaPopUp.getRespuestaTXT().getText(): " + preguntaPopUp.getRespuestaTXT().getText());
				correcto = (preguntaPopUp.getRespuestaTXT().getText().toLowerCase().matches(pre.getRespuestaCorrecta().toLowerCase()))?true:false;
			}else{
				JButton respuesta = (JButton) e.getSource();
				logger.debug("texto de boton: " + respuesta.getText());
				correcto = (pre.getRespuestaCorrecta().matches(respuesta.getText()))?true:false;
			}
			ap.cambiarTurnoPregunta(pre);
			if(Global.nRondas <= Global.cantRondas){
				Global.play.setEnabled(true);
			}

			logger.debug("turno: "+Global.turnoUser);
			if(correcto){
				logger.debug("punto!");
				CuadroParticipante cp;
				if(Global.turnoUser == 1){
					cp = Global.cp1;
				} else if (Global.turnoUser == 2) {
					cp = Global.cp2;
				} else if (Global.turnoUser == 3) {
					cp = Global.cp3;
				} else {
					cp = Global.cp4;
				}
				cp.setBackground(Color.WHITE);
				Participante p = new Participante(cp);
//				p = accionesParticipante.buscarUsuarioxLoginPass(p.getNick(), p.getContrasena());
				logger.debug(p);
				p.puntoGanado((Global.tipo)?50:100);
				
				accionesParticipante.calcularPromedioParticipante(p);
				cp.removeAll();
				logger.debug("removido todo...");
				cp.redibujar(p);
				cp.revalidate();

				if(Global.turnoUser == 1){
					logger.debug("asignando a participante global");
					Global.cp1 = cp;
				} else if (Global.turnoUser == 2) {
					logger.debug("asignando a participante global");
					Global.cp2 = cp;
				} else if (Global.turnoUser == 3) {
					logger.debug("asignando a participante global");
					Global.cp3 = cp;
				} else {
					logger.debug("asignando a participante global");
					Global.cp4 = cp;
				}
			}
			Global.turnoUser++;
			if(Global.turnoUser > Global.cantUser){
				Global.turnoUser = 1;
				Global.nRondas++;
				if(Global.nRondas > Global.cantRondas){
					Ganador g = new Ganador(wp);
				}else{
					Global.ronda.setText(Global.nRondas+Constantes.TXT_RONDAS+Global.cantRondas+ "           ");
				}
			}

			CuadroParticipante cp;
			if(Global.turnoUser == 1){
				cp = Global.cp1;
			} else if (Global.turnoUser == 2) {
				cp = Global.cp2;
			} else if (Global.turnoUser == 3) {
				cp = Global.cp3;
			} else {
				cp = Global.cp4;
			}
			cp.setBackground(Color.LIGHT_GRAY);
			Participante p = new Participante(cp);
//			p = accionesParticipante.buscarUsuarioxLoginPass(p.getNick(), p.getContrasena());
			cp.removeAll();
			logger.debug("removido todo...");
			cp.redibujar(p);
			cp.revalidate();
		}
    }
}
