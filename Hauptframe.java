package Kaffeekasse;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;




public class Hauptframe extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static Hauptframe layout;
	
	Personen persos = new Personen();
	private GUIKaffeekasse guikaffe = new GUIKaffeekasse();
	
	JMenuBar leiste = new JMenuBar();
	
	JMenu dateiMenu = new JMenu("Datei");
	JMenuItem dateiBeenden = new JMenuItem("Beenden");
	
	JPanel linksPanel = new JPanel();
	JPanel boxPanel = new JPanel();
	JPanel felderPanel = new JPanel();
	JPanel untenPanel = new JPanel();
	//JPanel ausgabePanel = new JPanel();
	
	JLabel labelVorname = new JLabel(" Vorname");
	JLabel labelNachname = new JLabel(" Nachname");
	JLabel labelZuZahlenderBetrag = new JLabel(" Zu zahlender Betrag");
	JLabel labelbezahlt = new JLabel(" Bezahlt?");
	JTextField textFeldVorname = new JTextField(18);
	JTextField textFeldNachname = new JTextField(18);
	JTextField textFeldZuZahlenderBetrag = new JTextField(18);
	JTextField textFeldbezahlt = new JTextField(18);
		
	
	JRadioButton ja = new JRadioButton("ja", true);
	JRadioButton nein = new JRadioButton("nein", false);
	
	
	JLabel id = new JLabel();
	JLabel vorname = new JLabel();
	JLabel nachname = new JLabel();
	JLabel zuZahlenderBetrag = new JLabel();
	JLabel bezahlt = new JLabel();
	
	JButton loeschenButton = new JButton("Löschen");
	JButton speichernButton = new JButton("Speichern");
	JButton aendernButton = new JButton("Ändern");
	
	public Hauptframe(){
		
		super("Kaffeekasse");
		
		setLayout(new BorderLayout());
		
		this.setJMenuBar(leiste);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		leiste.add(dateiMenu);		
	
		dateiMenu.add(dateiBeenden);
			
		this.add(linksPanel,BorderLayout.WEST);		
		
		linksPanel.setPreferredSize(new Dimension(150,200));
		linksPanel.setLayout(new GridLayout(20,0));
		
		linksPanel.add(labelVorname);
		linksPanel.add(textFeldVorname);
		linksPanel.add(labelNachname);
		linksPanel.add(textFeldNachname);
		linksPanel.add(labelZuZahlenderBetrag);
		linksPanel.add(textFeldZuZahlenderBetrag);
		linksPanel.add(labelbezahlt);
		linksPanel.add(ja);
		linksPanel.add(nein);
				
		this.add(untenPanel,BorderLayout.SOUTH);
		untenPanel.setLayout(new GridLayout(0,4));
		
		untenPanel.add(speichernButton);
		untenPanel.add(aendernButton);
		untenPanel.add(loeschenButton);
		
		guikaffe.setPersonen(persos);
		this.add(guikaffe,BorderLayout.CENTER);
				
		dateiBeenden.addActionListener(this);
		loeschenButton.addActionListener(this);
		speichernButton.addActionListener(this);
		aendernButton.addActionListener(this);
				
		this.setSize(600,600);
		this.setVisible(true);
		zentrieren();
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource().equals(dateiBeenden)){
			System.out.println("Anwendung wird geschlossen");
			System.exit(0);
		}
		
		if(arg0.getSource().equals(speichernButton)){			
			
			Person person = new Person();
			
			try {
				persos.set(Double.parseDouble(textFeldbezahlt.getText())
			}
						
			/*double bezahlt = labelbezahlt.get
			boolean radiobutton;
			
			if (ja.isSelected()) {
				radiobutton = true;
			}
			else
				radiobutton = false;
				
			
			Person person = new Person (labelVorname.getText(),labelNachname.getText(),);
			persos.add(person);
			anzeigen();
			*/
			
			System.out.println("Person speichern wurde geklickt");
		}
		
		if(arg0.getSource().equals(loeschenButton)){
			guikaffe.getSelectedIndex();
			System.out.println("Person löschen wurde geklickt");			
			
		}
		
		if(arg0.getSource().equals(aendernButton)){
			guikaffe.getSelectedIndex();
			System.out.println("Person ändern wurde geklickt");
		}
		
	}
	
	private void zentrieren() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int w = this.getSize().width;
	    int h = this.getSize().height;
	    int x = (dimension.width-w)/2;
	    int y = (dimension.height-h)/2;
		this.setLocation(x,y);
	}
	


	
	
	
	@SuppressWarnings("unchecked")
	public void laden() {
		
		try {
			
			FileInputStream ips = new FileInputStream("Datei");
			ObjectInputStream ois = new ObjectInputStream(ips);
			persos = (Personen) ois.readObject();
			ois.close();
			ips.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			return;
		}
		catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;}
		}
		
		
		public void speichern() {
			try {
				FileOutputStream fos = new FileOutputStream("Datei");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(persos);
				oos.close();
				fos.close();
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	
		public void anzeigen() {

		guikaffe.setPersonen(persos);
		
		}


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			layout = new Hauptframe();
			
		}
	
	
}
	
	

