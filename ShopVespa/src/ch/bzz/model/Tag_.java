package ch.bzz.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="Dali", date="2018-01-14T20:00:49.785+0100")
=======
@Generated(value="Dali", date="2018-01-14T20:57:32.106+0100")
>>>>>>> branch 'master' of https://github.com/zorien-bbc/m150_vespa_shop
@StaticMetamodel(Tag.class)
public class Tag_ {
	public static volatile SingularAttribute<Tag, Integer> idTags;
	public static volatile SingularAttribute<Tag, String> name;
	public static volatile ListAttribute<Tag, Produkt> produkts;
}
