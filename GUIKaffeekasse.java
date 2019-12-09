package Kaffeekasse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class GUIKaffeekasse extends JList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> myListModel = new DefaultListModel<String> ();
	

	//private class ListClickHandler extends MouseAdapter {
		/*
		public void mouseClicked(MouseEvent e) {
			
			if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
				// Ein vorhandener Student wird bearbeitet:
				int index = getSelectedIndex();
				if (index >= 0)	{
					String name = myListModel.get (index);
					JOptionPane.showMessageDialog(GUIStudentenliste.this, "Doppelklick auf " + name);
				}
			}
		}
	}
*/

	public GUIKaffeekasse () {
		
		setModel (myListModel);

	}
	
	public void setPersonen (Personen persos) {
		
		
		myListModel.removeAllElements();
		for (Person p: persos) {
			
			myListModel.addElement(p.toString());
		}
		
	}
}


