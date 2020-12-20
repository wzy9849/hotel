package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Subscription implements Serializable {
    private Integer id;
    private Member member;
    private Integer mid;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    private String no;
    private String linkman;
    private String email;
    private String phone;
    private String status;
    private Date cretime;
    private String remark;


    private Set<SubscriptionDtl> subscriptionDtls;

    public Subscription() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCretime() {
        return cretime;
    }

    public void setCretime(Date cretime) {
        this.cretime = cretime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<SubscriptionDtl> getSubscriptionDtls() {
        return subscriptionDtls;
    }

    public void setSubscriptionDtls(Set<SubscriptionDtl> subscriptionDtls) {
        this.subscriptionDtls = subscriptionDtls;
    }


}
