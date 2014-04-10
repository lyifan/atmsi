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
public class PlannedVisit implements java.io.Serializable {

    private int _id;
    private Date _start, _end;
    private PlannedJob _plannedJob;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="PlannedVisitID")
    public int getId() {
        return _id;
    }
    public void setId(int id) {
        _id = id;
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

}
