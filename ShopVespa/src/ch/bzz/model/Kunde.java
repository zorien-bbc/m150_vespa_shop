package ch.bzz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kunde database table.
 * 
 */
@Entity
@NamedQuery(name="Kunde.findAll", query="SELECT k FROM Kunde k")
public class Kunde implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idKunde;

	private String adresse;

	private String mail;

	private String nachname;

	private String ort;

	private String plz;

	private String telefonnummer;

	private String vorname;

	//bi-directional many-to-one association to Bestellung
	@OneToMany(mappedBy="kunde")
	private List<Bestellung> bestellungs;

	public Kunde() {
	}

	public int getIdKunde() {
		return this.idKunde;
	}

	public void setIdKunde(int idKunde) {
		this.idKunde = idKunde;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getOrt() {
		return this.ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPlz() {
		return this.plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getTelefonnummer() {
		return this.telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public List<Bestellung> getBestellungs() {
		return this.bestellungs;
	}

	public void setBestellungs(List<Bestellung> bestellungs) {
		this.bestellungs = bestellungs;
	}

	public Bestellung addBestellung(Bestellung bestellung) {
		getBestellungs().add(bestellung);
		bestellung.setKunde(this);

		return bestellung;
	}

	public Bestellung removeBestellung(Bestellung bestellung) {
		getBestellungs().remove(bestellung);
		bestellung.setKunde(null);

		return bestellung;
	}

}