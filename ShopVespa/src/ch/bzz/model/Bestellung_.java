package ch.bzz.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-12T10:29:50.121+0100")
@StaticMetamodel(Bestellung.class)
public class Bestellung_ {
	public static volatile SingularAttribute<Bestellung, Integer> idBestellung;
	public static volatile SingularAttribute<Bestellung, String> bestelldatum;
	public static volatile SingularAttribute<Bestellung, Kunde> kunde;
	public static volatile ListAttribute<Bestellung, Produkt> produkts;
}
