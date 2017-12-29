package ch.bzz.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Bild database table.
 * 
 */
@Entity
@Table(name="Bild")
@NamedQuery(name="Bild.findAll", query="SELECT b FROM Bild b")
public class Bild implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBild;

	@Column(name="Pfad")
	private String pfad;

	//bi-directional many-to-one association to Produkt
	@ManyToOne
	@JoinColumn(name="ProduktID")
	private Produkt produkt;

	public Bild() {
	}

	public int getIdBild() {
		return this.idBild;
	}

	public void setIdBild(int idBild) {
		this.idBild = idBild;
	}

	public String getPfad() {
		return this.pfad;
	}

	public void setPfad(String pfad) {
		this.pfad = pfad;
	}

	public Produkt getProdukt() {
		return this.produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

}