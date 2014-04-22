package yifan.home.atmsi.persist.domain;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import org.hibernate.annotations.Cascade;

/**
 *
 * The PlannedJob domain class
 *
 *
*/
@Entity
public class PlannedJob extends AtmsiEntity {
    private int _id;
    private String _ref;
    private Date _start, _end;
    private Set<PlannedVisit> _visits = new HashSet<PlannedVisit>();

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="PlannedJobID")
    public int getId() {
        return _id;
    }
    public void setId(int id) {
        _id = id;
    }

	@Column(name="JobReference", unique=true)
    public String getReference() {
        return _ref;
    }
    public void setReference(String ref) {
        _ref = ref;
    }

	@Column(name="StartTime")
    public Date getStart() {
        return _start;
    }
    public void setStart(Date start) {
        _start = start;
    }

	@Column(name="EndTime")
    public Date getEnd() {
        return _end;
    }
    public void setEnd(Date end) {
        _end = end;
    }

	@OneToMany(mappedBy = "plannedJob")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})	
    public Set<PlannedVisit> getVisits() {
        return _visits;
    }
    public void setVisits(Set<PlannedVisit> visits) {
        _visits = visits;
    }
}
