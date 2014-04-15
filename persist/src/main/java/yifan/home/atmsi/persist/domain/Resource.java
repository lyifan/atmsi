package yifan.home.atmsi.persist.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * The Resource domain class
 *
 *
*/
@Entity
public class Resource implements java.io.Serializable {
	private int _id;
	private String _type;
	private String _name;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="ResourceID")
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
	
	@Column(name="ResourceType")
	public String getResourceType() {
		return _type;
	}
	public void setResourceType(String type) {
		_type = type;
	}
}
