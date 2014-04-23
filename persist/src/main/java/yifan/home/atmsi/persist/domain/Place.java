package yifan.home.atmsi.persist.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * The Place domain class
 *
 *
*/
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Place extends AtmsiEntity {
	private int _id;
	private String _name;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="PlaceID")
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		_id = id;
	}

	@Column(name="Name", unique=true)
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		_name = name;
	}
}
