package ch.bzz.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-14T20:46:34.562+0100")
@StaticMetamodel(Kunde.class)
public class Kunde_ {
	public static volatile SingularAttribute<Kunde, Integer> idKunde;
	public static volatile SingularAttribute<Kunde, String> adresse;
	public static volatile SingularAttribute<Kunde, String> mail;
	public static volatile SingularAttribute<Kunde, String> nachname;
	public static volatile SingularAttribute<Kunde, String> ort;
	public static volatile SingularAttribute<Kunde, String> passwort;
	public static volatile SingularAttribute<Kunde, String> plz;
	public static volatile SingularAttribute<Kunde, String> telefonnummer;
	public static volatile SingularAttribute<Kunde, String> vorname;
	public static volatile SingularAttribute<Kunde, Boolean> isAdmin;
	public static volatile ListAttribute<Kunde, Bestellung> bestellungs;
}
