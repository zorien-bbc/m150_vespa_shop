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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProdukt;

	@Column(name="ArtikelNr")
	private String artikelNr;

	@Column(name="Beschreibung")
	private String beschreibung;

	@Column(name="Bezeichnung")
	private String bezeichnung;

	@Column(name="Lagerbestand")
	private int lagerbestand;

	@Column(name="Preis")
	private float preis;

	//bi-directional many-to-one association to Bild
	@OneToMany(mappedBy="produkt", cascade=CascadeType.PERSIST)
	private List<Bild> bilds;

	//bi-directional many-to-one association to Kategorie
	@ManyToOne
	@JoinColumn(name="KategorieID")
	private Kategorie kategorie;

	//bi-directional many-to-many association to Tag
	@ManyToMany(mappedBy="produkts")
	private List<Tag> tags;

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

	public int getIdProdukt() {
		return this.idProdukt;
	}

	public void setIdProdukt(int idProdukt) {
		this.idProdukt = idProdukt;
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

	public List<Bild> getBilds() {
		return this.bilds;
	}

	public void setBilds(List<Bild> bilds) {
		this.bilds = bilds;
	}

	public Bild addBild(Bild bild) {
		getBilds().add(bild);
		bild.setProdukt(this);

		return bild;
	}

	public Bild removeBild(Bild bild) {
		getBilds().remove(bild);
		bild.setProdukt(null);

		return bild;
	}

	public Kategorie getKategorie() {
		return this.kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}

	public List<Tag> getTags() {
		return this.tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Bestellung> getBestellungs() {
		return this.bestellungs;
	}

	public void setBestellungs(List<Bestellung> bestellungs) {
		this.bestellungs = bestellungs;
	}

}