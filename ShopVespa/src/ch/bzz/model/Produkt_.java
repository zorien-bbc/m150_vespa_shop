package ch.bzz.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-07T11:48:45.683+0100")
@StaticMetamodel(Produkt.class)
public class Produkt_ {
	public static volatile SingularAttribute<Produkt, Integer> idProdukt;
	public static volatile SingularAttribute<Produkt, String> artikelNr;
	public static volatile SingularAttribute<Produkt, String> beschreibung;
	public static volatile SingularAttribute<Produkt, String> bezeichnung;
	public static volatile SingularAttribute<Produkt, Integer> lagerbestand;
	public static volatile SingularAttribute<Produkt, Float> preis;
	public static volatile ListAttribute<Produkt, Bild> bilds;
	public static volatile SingularAttribute<Produkt, Kategorie> kategorie;
	public static volatile ListAttribute<Produkt, Tag> tags;
	public static volatile ListAttribute<Produkt, Bestellung> bestellungs;
}
