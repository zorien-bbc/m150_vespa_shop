package ch.bzz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Produkt database table.
 * 
 */
@Entity
@Table(name="Produkt")
@NamedQuery(name="Produkt.findAll", query="SELECT p FROM Produkt p")
public class Produkt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProdukte;

	@Column(name="ArtikelNr")
	private String artikelNr;

	@Column(name="Beschreibung")
	private String beschreibung;

	@Column(name="Bezeichnung")
	private String bezeichnung;

	@Column(name="BildPfad")
	private String bildPfad;

	@Column(name="Lagerbestand")
	private int lagerbestand;

	@Column(name="Preis")
	private float preis;

	//bi-directional many-to-one association to Kategorie
	@ManyToOne
	@JoinColumn(name="KategorieID")
	private Kategorie kategorie;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	@JoinColumn(name="TagsID")
	private Tag tag;

	//bi-directional many-to-many association to Bestellung
	@ManyToMany
	@JoinTable(
		name="Warenkorb"
		, joinColumns={
			@JoinColumn(name="Produkt_idProdukte")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Bestellung_idBestellung")
			}
		)
	private List<Bestellung> bestellungs;

	public Produkt() {
	}

	public int getIdProdukte() {
		return this.idProdukte;
	}

	public void setIdProdukte(int idProdukte) {
		this.idProdukte = idProdukte;
	}

	public String getArtikelNr() {
		return this.artikelNr;
	}

	public void setArtikelNr(String artikelNr) {
		this.artikelNr = artikelNr;
	}

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getBezeichnung() {
		return this.bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getBildPfad() {
		return this.bildPfad;
	}

	public void setBildPfad(String bildPfad) {
		this.bildPfad = bildPfad;
	}

	public int getLagerbestand() {
		return this.lagerbestand;
	}

	public void setLagerbestand(int lagerbestand) {
		this.lagerbestand = lagerbestand;
	}

	public float getPreis() {
		return this.preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

	public Kategorie getKategorie() {
		return this.kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}


	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public List<Bestellung> getBestellungs() {
		return this.bestellungs;
	}

	public void setBestellungs(List<Bestellung> bestellungs) {
		this.bestellungs = bestellungs;
	}

}