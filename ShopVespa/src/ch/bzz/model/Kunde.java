package ch.bzz.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the Kunde database table.
 * 
 */
@Entity
@Table(name = "Kunde")
@NamedQuery(name = "Kunde.findAll", query = "SELECT k FROM Kunde k")
public class Kunde implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idKunde;

	@Column(name = "Adresse")
	private String adresse;

	@Column(name = "Mail")
	private String mail;
	
	@Column(name = "Nachname")
	private String nachname;

	@Column(name = "Ort")
	private String ort;

	@Column(name = "Passwort")
	private String passwort;

	@Column(name = "PLZ")
	private String plz;

	@Column(name = "Telefonnummer")
	private String telefonnummer;

	@Column(name = "Vorname")
	private String vorname;

	@Column(name = "isAdmin")
	private Boolean isAdmin;

	// bi-directional many-to-one association to Bestellung
	@OneToMany(mappedBy = "kunde", cascade = CascadeType.PERSIST)
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

	public String getPasswort() {
		return this.passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
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