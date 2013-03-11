package vistas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import controladores.EventBTT;
import controladores.utils.Constantes;

import modelos.Participante;

public class CuadroParticipante extends JPanel{
	private static Logger logger = Logger.getLogger(CuadroParticipante.class);
	private JLabel jlLogin;
	private JLabel jlPass;
	private JLabel jlSexo;
	private JLabel jlPuntaje;
	private JLabel jlDob;
	private JLabel jlEdad;
	
	private JLabel jlNombreP;
	private JLabel jlSexoP;
	private JLabel jlPuntajeP;
	private JLabel jlDobP;
	private JLabel jlEdadP;
    private EventBTT bttEvent;

	private JTextField jlLoginTF;
	private JPasswordField jlPassTF;
	private JTextField jlDobTF;
	private JTextField jlEdadTF;
	private boolean jlSexoTF;
	private JButton save;


	public CuadroParticipante() {
		bttEvent = new EventBTT(this, Constantes.ACCION_AGREGAR_PARTICIPANTE);

		Box izq = Box.createVerticalBox();
		jlLogin = new JLabel(Constantes.TXT_LOGIN);
		jlPass = new JLabel(Constantes.TXT_PASS);


		Box der = Box.createVerticalBox();
		jlLoginTF = new JTextField(8);
		jlPassTF = new JPasswordField(8);
		save = new JButton(Constantes.TXT_SAVE);
		save.addActionListener(bttEvent);

		izq.add(jlLogin);
		der.add(jlLoginTF);
		izq.add(jlPass);
		der.add(jlPassTF);

		Box ambos = Box.createHorizontalBox();
		ambos.add(izq);
		ambos.add(der);

		Box cuerpo = Box.createVerticalBox();
		cuerpo.add(ambos);
		cuerpo.add(save);

		this.add(cuerpo);
		this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		this.setVisible(true);
	}
	
	public Participante nullParticipant(){
		logger.info("Participante null, llenando a pedro perez");
		Participante participante = new Participante();
		participante.setNombre("Pedro");
		participante.setApellido("Perez");
		participante.setSexo(true);
		participante.setPuntaje(0);
		return participante;
	}
	
	public void redibujar(Participante participante){
		Box izq = Box.createVerticalBox();
		jlLogin = new JLabel(Constantes.TXT_NOMBRE);
		jlSexo = new JLabel(Constantes.TXT_SEXO);
		jlDob = new JLabel(Constantes.TXT_DOB);
		jlEdad = new JLabel(Constantes.TXT_EDAD);
		jlPuntaje = new JLabel(Constantes.TXT_SCORE);
		
		Box der = Box.createVerticalBox();
		logger.debug("participante: " + participante);
		jlNombreP = new JLabel(participante.getNombre() + " " + participante.getApellido());
		jlSexoP = new JLabel(participante.getSexo());
		jlPuntajeP = new JLabel(participante.getPuntaje());
//		Font font = jlPuntajeP.getFont();
//		font = new Font(font.getFontName(), Font.ITALIC, font.getSize());
//		jlPuntajeP.setFont(font);
		jlDobP = new JLabel(participante.getFdn());
		jlEdadP = new JLabel(participante.getEdad());
		izq.add(jlLogin);
		der.add(jlNombreP);
		izq.add(jlSexo);
		der.add(jlSexoP);
		izq.add(jlDob);
		der.add(jlDobP);
		izq.add(jlEdad);
		der.add(jlEdadP);
		izq.add(jlPuntaje);
		der.add(jlPuntajeP);
		
		Box ambos = Box.createHorizontalBox();
		ambos.add(izq);
		ambos.add(der);
		
		this.add(ambos);
	}

	public JTextField getJlNombreTF() {
		return jlLoginTF;
	}

	public void setJlNombreTF(JTextField jlNombreTF) {
		this.jlLoginTF = jlNombreTF;
	}

	public JPasswordField getJlApellidoTF() {
		return jlPassTF;
	}

	public void setJlApellidoTF(JPasswordField jlApellidoTF) {
		this.jlPassTF = jlApellidoTF;
	}

	public boolean getJlSexoTF() {
		return jlSexoTF;
	}

	public void setJlSexoTF(boolean jlSexoTF) {
		this.jlSexoTF = jlSexoTF;
	}

	public JLabel getJlPuntajeP() {
		return jlPuntajeP;
	}

	public void setJlPuntajeP(JLabel jlPuntajeP) {
		this.jlPuntajeP = jlPuntajeP;
	}

	public JLabel getJlNombreP() {
		return jlNombreP;
	}

	public void setJlNombreP(JLabel jlNombreP) {
		this.jlNombreP = jlNombreP;
	}

	public JLabel getJlDobP() {
		return jlDobP;
	}

	public void setJlDobP(JLabel jlDobP) {
		this.jlDobP = jlDobP;
	}

	public JLabel getJlEdadP() {
		return jlEdadP;
	}

	public void setJlEdadP(JLabel jlEdadP) {
		this.jlEdadP = jlEdadP;
	}

	public JTextField getJlDobTF() {
		return jlDobTF;
	}

	public void setJlDobTF(JTextField jlDobTF) {
		this.jlDobTF = jlDobTF;
	}

	public JTextField getJlEdadTF() {
		return jlEdadTF;
	}

	public void setJlEdadTF(JTextField jlEdadTF) {
		this.jlEdadTF = jlEdadTF;
	}
	
	
}
