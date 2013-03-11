package controladores;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class figura{
	public String nombre = "";
	public ImageIcon imagen = null;

	public figura(ImageIcon b){
		//nombre=a;
		imagen=b;
	}
	
	public String toString(){
		StringBuffer str = new StringBuffer(this.getClass().toString() + "[");
		str.append("imagen: ");
		str.append(imagen);
		str.append("]");
		return str.toString();
	}
}
