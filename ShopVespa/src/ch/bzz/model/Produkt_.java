package ch.bzz.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-12-28T10:29:33.571+0100")
@StaticMetamodel(Produkt.class)
public class Produkt_ {
	public static volatile SingularAttribute<Produkt, Integer> idProdukte;
	public static volatile SingularAttribute<Produkt, String> artikelNr;
	public static volatile SingularAttribute<Produkt, String> beschreibung;
	public static volatile SingularAttribute<Produkt, String> bezeichnung;
	public static volatile SingularAttribute<Produkt, String> bildPfad;
	public static volatile SingularAttribute<Produkt, Integer> lagerbestand;
	public static volatile SingularAttribute<Produkt, Float> preis;
	public static volatile SingularAttribute<Produkt, Kategorie> kategorie;
	public static volatile SingularAttribute<Produkt, Tag> tag;
	public static volatile ListAttribute<Produkt, Bestellung> bestellungs;
}
