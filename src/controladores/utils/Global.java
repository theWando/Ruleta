package controladores.utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

import controladores.AccionesCategoria;

import vistas.CuadroParticipante;

import modelos.Categoria;
import modelos.Participante;
import modelos.Pregunta;

public class Global {
	private static Logger logger = Logger.getLogger(Global.class);
	public static List<Pregunta> preguntas;
	public static int cantRondas = 4;
	public static int nRondas = 1;
	public static int cantUser = 2;
	public static int usuarioRegistrado = 0;
	public static int cantCat = 0;
	public static int turnoUser = 1;
	public static int nextUser = 2;
	public static int retardo = 5;
	public static int posRuleta = 0;
	public static int frame = 8;
	public static boolean tipo = true;
	public static List<Categoria> categorias;
	public static JButton play;
	public static CuadroParticipante cp1;
	public static CuadroParticipante cp2;
	public static CuadroParticipante cp3;
	public static CuadroParticipante cp4;
	public static Participante par1;
	public static Participante par2;
	public static Participante par3;
	public static Participante par4;
	public static JLabel ronda;
    
	
	public static List<Categoria> getCategorias(){
		categorias = new ArrayList<Categoria>();
		AccionesCategoria ac = new AccionesCategoria();
		categorias = ac.buscarCategorias();
		return categorias;
	}
	
	public static Pregunta obtenerPregunta(){
		Categoria cat = new Categoria();
		Pregunta pre = new Pregunta();
		logger.debug(Global.categorias);
		try {
			logger.debug("Global.posRuleta: " + Global.posRuleta + " Global.categorias.size(): " + Global.categorias.size());
			if(Global.categorias != null && Global.posRuleta <= Global.categorias.size()){
				cat = Global.categorias.get(Global.posRuleta-1);
				int prePos = (cat.getTurnoPregunta()< cat.getPreguntas().size())?cat.getTurnoPregunta():0;
				logger.debug("turno pregunta: " + prePos);
				pre = cat.getPreguntas().get(prePos);
				pre.setNombreCategoria(cat.getNombreCategoria());
				logger.debug(pre);
			}
		} catch (NullPointerException e) {
			logger.fatal("Error de nullPointer: liberando boton para seguir la partida...Ops!", e);
			Global.play.setEnabled(true);
		}
		return pre;
	}
	
	public static void asignarPregunta(Categoria cat){
		if(Global.categorias != null && !Global.categorias.isEmpty() && Global.categorias.size() >= cat.getIdCategoria()){
			logger.debug("AsignandoCategoria");
			Categoria categoria = Global.categorias.get(cat.getIdCategoria());
			if(categoria.getPreguntas().isEmpty()){
				logger.debug("esta vacia...");
				Global.categorias.set(cat.getIdCategoria(), cat);
			}else{
				logger.debug("categoria: " + categoria);
				logger.debug("cat: " + cat);
				if(categoria.getNombreCategoria().matches(cat.getNombreCategoria())){
					logger.debug("agregando a las existantes");
					List<Pregunta> preguntas = categoria.getPreguntas();
					for(int i = 0; i < cat.getPreguntas().size(); i++){
						logger.debug("Entro en el for");
						preguntas.add(cat.getPreguntas().get(i));
					}
					categoria.setPreguntas(preguntas);
					logger.debug("asignando a: " + cat.getIdCategoria());
					Global.categorias.set(cat.getIdCategoria(), categoria);
					logger.debug("Categorias: " + Global.categorias);
				}else{
					Global.categorias.set(cat.getIdCategoria(), cat);
				}
			}
		}
	}
	
	public static Participante obtenerGanador(){
		Participante p1 = new Participante(Global.cp1);
		Participante p2 = new Participante(Global.cp2);
		Participante p3 = (Global.cp3 != null)?new Participante(Global.cp3):null;
		Participante p4 = (Global.cp4 != null)?new Participante(Global.cp4):null;
		
		if(p1.getNPuntaje() > p2.getNPuntaje() && p1.getNPuntaje() > p3.getNPuntaje() && p1.getNPuntaje() > p4.getNPuntaje())
			return p1;
		else if(p2.getNPuntaje() > p1.getNPuntaje() && p2.getNPuntaje() > p3.getNPuntaje() && p2.getNPuntaje() > p4.getNPuntaje())
			return p2;
		else if(p3.getNPuntaje() > p1.getNPuntaje() && p3.getNPuntaje() > p2.getNPuntaje() && p3.getNPuntaje() > p4.getNPuntaje())
			return p3;
		else
			return p4;
	}

}
