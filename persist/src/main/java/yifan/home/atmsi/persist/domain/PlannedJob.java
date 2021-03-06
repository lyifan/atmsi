package yifan.home.atmsi.persist.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
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
    /**
	 * 
	 */
	private static final long serialVersionUID = 368590166145879297L;
	private int _id;
    private String _ref;
    private Date _start, _end;
    private List<PlannedVisit> _visits = new ArrayList<PlannedVisit>();

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
    public List<PlannedVisit> getVisits() {
        return _visits;
    }
    public void setVisits(List<PlannedVisit> visits) {
        _visits = visits;
    }
}
