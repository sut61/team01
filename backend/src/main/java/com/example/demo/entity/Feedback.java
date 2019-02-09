package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class Feedback {
    @Id
    @SequenceGenerator(name = "feedback_seq",sequenceName = "feedback_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "feedback_seq")

    private Long feedbackid;
    private String comment;
    private String oid;


    @ManyToOne(fetch = FetchType.EAGER)
    private Vibe vibe;

    @ManyToOne(fetch = FetchType.EAGER)
    private Taste taste;

    @ManyToOne(fetch = FetchType.EAGER)
    private Service service;

    @ManyToOne(fetch = FetchType.EAGER)
    private Price price;

    public Feedback(){}

    public Feedback(Taste taste,Service service,Vibe vibe,Price price,String comment,String oid){
        this.taste = taste;
        this.service = service;
        this.vibe = vibe;
        this.price = price;
        this.comment = comment;
        this.oid = oid;
    }

    public void setFeedbackid(Long feedbackid) {
        this.feedbackid = feedbackid;
    }

    public Long getFeedbackid() {
        return feedbackid;
    }


    public void setTaste(Taste taste) {
        this.taste = taste;
    }

    public Taste getTaste() {
        return taste;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Service getService() {
        return service;
    }

    public void setVibe(Vibe vibe) {
        this.vibe = vibe;
    }

    public Vibe getVibe() {
        return vibe;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

}
