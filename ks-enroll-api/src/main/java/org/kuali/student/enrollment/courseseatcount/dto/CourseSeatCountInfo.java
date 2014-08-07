

package org.kuali.student.enrollment.courseseatcount.dto;

import org.kuali.student.enrollment.courseseatcount.infc.CourseSeatCount;
import org.kuali.student.r2.common.dto.IdNamelessEntityInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageInfo", propOrder = {"id", "typeKey", "stateKey",
        "activityOfferingId","totalSeats","usedSeats","availableSeats","timestamp","meta", "attributes", "_futureElements" })
public class CourseSeatCountInfo extends IdNamelessEntityInfo implements CourseSeatCount {

    @XmlAnyElement
    private String activityOfferingId;
    @XmlAnyElement
    private Integer totalSeats;
    @XmlAnyElement
    private Integer usedSeats;
    @XmlAnyElement
    private Integer availableSeats;
    @XmlAnyElement
    private Date timestamp;
    @XmlAnyElement
    private List<Object> _futureElements;

    public CourseSeatCountInfo(){

    }
    public CourseSeatCountInfo(CourseSeatCount courseSeatCount){

        super(courseSeatCount);

        if (courseSeatCount != null){

            this.activityOfferingId = courseSeatCount.getActivityOfferingId();
            this.totalSeats = courseSeatCount.getTotalSeats();
            this.usedSeats = courseSeatCount.getUsedSeats();
            this.availableSeats = courseSeatCount.getAvailableSeats();
            this.timestamp = courseSeatCount.getTimestamp();

        }

    }



    @Override
    public String getActivityOfferingId() {
        return activityOfferingId;
    }

    public void setActivityOfferingId(String activityOfferingId) {
        this.activityOfferingId = activityOfferingId;
    }
    @Override
    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }
    @Override
    public Integer getUsedSeats() {
        return usedSeats;
    }

    public void setUsedSeats(Integer usedSeats) {
        this.usedSeats = usedSeats;
    }
    @Override
    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
    @Override
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
