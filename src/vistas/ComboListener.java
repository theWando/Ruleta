package vistas;

import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboListener implements ItemListener {
	
	private PreguntaDialogo pd;
	public ComboListener(PreguntaDialogo pd){
		this.pd = pd;
	}

	@Override
	public void itemStateChanged(ItemEvent itemEvent) {
		int state = itemEvent.getStateChange();
//        System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
        System.out.println("Item: " + itemEvent.getItem());
        ItemSelectable is = itemEvent.getItemSelectable();
        System.out.println(", Selected: " + selectedString(is));
        JComboBox combo = (JComboBox) itemEvent.getSource();
        JPanel panel = this.pd.getPanel();
        panel.removeAll();
        panel = this.pd.redibujar(combo.getSelectedIndex());
        panel.revalidate();
	}
	
	static private String selectedString(ItemSelectable is) {
	    Object selected[] = is.getSelectedObjects();
	    return ((selected.length == 0) ? "null" : (String) selected[0]);
	 }

}
