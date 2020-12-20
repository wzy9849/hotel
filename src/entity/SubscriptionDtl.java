package entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SubscriptionDtl implements Serializable {
    private Integer id;

    private Integer rid;

    private Integer sid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date edate;
    private Integer residetype;
    private Float price;

    public SubscriptionDtl() {
    }


    private List<Room> rooms;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public Integer getResidetype() {
        return residetype;
    }

    public void setResidetype(Integer residetype) {
        this.residetype = residetype;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
