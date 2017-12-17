package ch.bzz.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-12-14T23:07:27.997+0100")
@StaticMetamodel(Bestellung.class)
public class Bestellung_ {
	public static volatile SingularAttribute<Bestellung, Integer> idBestellung;
	public static volatile SingularAttribute<Bestellung, String> bestelldatum;
	public static volatile SingularAttribute<Bestellung, Kunde> kunde;
	public static volatile ListAttribute<Bestellung, Produkt> produkts;
}
