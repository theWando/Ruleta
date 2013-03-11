package vistas;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import controladores.EventBTT;
import controladores.utils.Constantes;

public class RegistrarUsuario extends JDialog{
	private static Logger logger = Logger.getLogger(CuadroParticipante.class);
	private JLabel jlLogin;
	private JLabel jlPass;
	private JLabel jlRepass;
	private JLabel jlNombre;
	private JLabel jlApellido;
	private JLabel jlSexo;
	private JLabel jlDob;
	private JLabel jlEdad;
	
    private EventBTT bttEvent;
    private JPanel panel;

    private JTextField jlLoginTF;
    private JPasswordField jlPassTF;
    private JPasswordField jlRpassTF;
	private JTextField jlNombreTF;
	private JTextField jlApellidoTF;
	private JTextField jlDobTF;
	private JTextField jlEdadTF;
	private JComboBox jlSexoTF;
	private JButton save;
	
	public JTextField getJlLoginTF() {
		return jlLoginTF;
	}
	public void setJlLoginTF(JTextField jlLoginTF) {
		this.jlLoginTF = jlLoginTF;
	}
	public JPasswordField getJlPassTF() {
		return jlPassTF;
	}
	public void setJlPassTF(JPasswordField jlPassTF) {
		this.jlPassTF = jlPassTF;
	}
	public JPasswordField getJlRpassTF() {
		return jlRpassTF;
	}
	public void setJlRpassTF(JPasswordField jlRpassTF) {
		this.jlRpassTF = jlRpassTF;
	}
	public JTextField getJlNombreTF() {
		return jlNombreTF;
	}
	public void setJlNombreTF(JTextField jlNombreTF) {
		this.jlNombreTF = jlNombreTF;
	}
	public JTextField getJlApellidoTF() {
		return jlApellidoTF;
	}
	public void setJlApellidoTF(JTextField jlApellidoTF) {
		this.jlApellidoTF = jlApellidoTF;
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
	public JComboBox getJlSexoTF() {
		return jlSexoTF;
	}
	public void setJlSexoTF(JComboBox jlSexoTF) {
		this.jlSexoTF = jlSexoTF;
	}
	public RegistrarUsuario(WRuleta wr) {
		super(wr, Constantes.TITLE_ADD_QUESTION, true);
		
		logger.debug("Construyendo juego");
	    setSize(450, 500);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		bttEvent = new EventBTT(this, Constantes.ACCION_AGREGAR_PARTICIPANTE);
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout());

		Box izq = Box.createVerticalBox();
		jlLogin = new JLabel(Constantes.TXT_LOGIN);
		jlPass = new JLabel(Constantes.TXT_PASS);
		jlRepass = new JLabel(Constantes.TXT_REPASS);
		jlNombre = new JLabel(Constantes.TXT_NOMBRE);
		jlApellido = new JLabel(Constantes.TXT_APELLIDO);
		jlSexo = new JLabel(Constantes.TXT_SEXO);
		jlDob = new JLabel(Constantes.TXT_DOB);
		jlEdad = new JLabel(Constantes.TXT_EDAD);


		Box der = Box.createVerticalBox();
		jlLoginTF = new JTextField(8);
		jlPassTF = new JPasswordField(8);
		jlRpassTF = new JPasswordField(8);
		jlNombreTF = new JTextField(8);
		jlApellidoTF = new JTextField(8);
		jlSexoTF = new JComboBox(Constantes.ARRAY_SEXO);
		jlDobTF = new JTextField(8);
		jlDobTF.setText(Constantes.TXT_DOB_FORMAT);
		jlEdadTF = new JTextField(2);
		save = new JButton(Constantes.TXT_SAVE);
		save.addActionListener(bttEvent);

		izq.add(jlLogin);
		izq.add(jlLoginTF);
		der.add(izq);
		izq = Box.createVerticalBox();
		izq.add(jlPass);
		izq.add(jlPassTF);
		der.add(izq);
		izq = Box.createVerticalBox();
		izq.add(jlRepass);
		izq.add(jlRpassTF);
		der.add(izq);
		izq = Box.createVerticalBox();
		izq.add(jlNombre);
		izq.add(jlNombreTF);
		der.add(izq);
		izq = Box.createVerticalBox();
		izq.add(jlApellido);
		izq.add(jlApellidoTF);
		izq.add(jlSexo);
		izq.add(jlSexoTF);
		der.add(izq);
		izq = Box.createVerticalBox();
		izq.add(jlDob);
		izq.add(jlDobTF);
		der.add(izq);
		izq = Box.createVerticalBox();
		izq.add(jlEdad);
		izq.add(jlEdadTF);
		der.add(izq);

//		Box ambos = Box.createHorizontalBox();
//		ambos.add(izq);
//		ambos.add(der);

		Box cuerpo = Box.createVerticalBox();
		cuerpo.add(der);
		cuerpo.add(save);

		this.add(cuerpo);
		this.setVisible(true);

	}
	
	

}
