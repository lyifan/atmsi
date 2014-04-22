package yifan.home.atmsi.persist.domain;

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * The PlannedVisit domain class
 *
 *
*/
@Entity
public class PlannedVisit extends AtmsiEntity {

    private int 			_id;
    private Date 			_start, _end;
    private PlannedJob 		_plannedJob;
    private Place 			_place;
    private PlannedVisit	_nextVisit;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="PlannedVisitID")
    public int getId() {
        return _id;
    }
    public void setId(int id) {
        _id = id;
    }

	@OneToOne
	@JoinColumn(name = "PlaceID", nullable = false)
    public Place getPlace() {
        return _place;
    }
    public void setPlace(Place place) {
        _place = place;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PlannedJobID", nullable = false)
    public PlannedJob getPlannedJob() {
        return _plannedJob;
    }
    public void setPlannedJob(PlannedJob plannedJob) {
        _plannedJob = plannedJob;
    }

    @Column(name = "StartTime", nullable = false)
    public Date getStart() {
        return _start;
    }
    public void setStart(Date start) {
        _start = start;
    }

    @Column(name = "EndTime", nullable = false)
    public Date getEnd() {
        return _end;
    }
    public void setEnd(Date end) {
        _end = end;
    }

	@OneToOne
	@JoinColumn(name = "NextVisit", nullable = true)
	public PlannedVisit getNextVisit() {
		return _nextVisit;
	}
	public void setNextVisit(PlannedVisit nextVisit) {
		_nextVisit = nextVisit;
	}
}
