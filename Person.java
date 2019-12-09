package Kaffeekasse;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String vorname;
	private double ZuZahlenderBetrag;
	private Boolean bezahlt;

	private static int anzahlPersonen = 0;

	Person() {

	}

	Person(String name, String vorname, double ZuZahlenderBetrag, Boolean bezahlt) {
		this.name = name;
		this.vorname = vorname;
		this.ZuZahlenderBetrag = ZuZahlenderBetrag;
		this.bezahlt = bezahlt;
		Person.anzahlPersonen++;
		this.setId(anzahlPersonen);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Boolean getBezahlt() {
		return bezahlt;
	}

	public void setBezahlt(Boolean bezahlt) {
		this.bezahlt = bezahlt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getZuZahlenderBetrag() {
		return ZuZahlenderBetrag;
	}

	public void setZuZahlenderBetrag(double zuZahlenderBetrag) {
		ZuZahlenderBetrag = zuZahlenderBetrag;
	}

	public String toString() {
		String s = "";
		if (bezahlt) {
			s = "" + id + ". " + name + ", " 
		+ vorname + ", " + ZuZahlenderBetrag + "€ bezahlt";
		} else {
			s = "" + id + ". " + name + ", " 
			+ vorname + ", " + ZuZahlenderBetrag + "€ nicht bezahlt";
		}
		return s;
	}

}
