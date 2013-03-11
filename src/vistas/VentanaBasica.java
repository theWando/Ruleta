package vistas;

import javax.swing.JFrame;

public class VentanaBasica extends JFrame implements AccionesBasicasVentana {
	@Override
	public void reiniciarCampos() {};
	@Override
	public void cerrarVentana() {
		this.setVisible(false);
        this.dispose();
	}
}
