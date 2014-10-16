package vn.aptech.MantechHelpdesk.entities;
// Generated Oct 7, 2014 4:39:05 PM by Hibernate Tools 3.6.0


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Complaint generated by hbm2java
 */
@Entity
@Table(name="Complaint"
    ,schema="dbo"
    ,catalog="MantechHelpdesks"
)
public class Complaint  implements java.io.Serializable {


     private int id;
     private Member member;
     private Technician technician=new Technician();
     private Integer idUser;
     private String title;
     private String contents;
     private String status;
     private Date dateComplaint;
     private Set<Feedback> feedbacks = new HashSet<Feedback>(0);

    public Complaint() {
    }

	
    public Complaint(int id) {
        this.id = id;
    }
    public Complaint(int id, Member member, Technician technician, Integer idUser, String title, String contents, String status, Date dateComplaint, Set<Feedback> feedbacks) {
       this.id = id;
       this.member = member;
       this.technician = technician;
       this.idUser = idUser;
       this.title = title;
       this.contents = contents;
       this.status = status;
       this.dateComplaint = dateComplaint;
       this.feedbacks = feedbacks;
    }
   
     @Id 
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="Id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Id_user",insertable=false, updatable=false)
    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="Id_technician", insertable=true, updatable=true)
    public Technician getTechnician() {
        return this.technician;
    }
    
    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    
    @Column(name="Id_user")
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    
    @Column(name="Title")
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    
    @Column(name="Contents")
    public String getContents() {
        return this.contents;
    }
    
    public void setContents(String contents) {
        this.contents = contents;
    }

    
    @Column(name="Status")
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Date_complaint", length=23)
    public Date getDateComplaint() {
        return this.dateComplaint;
    }
    
    public void setDateComplaint(Date dateComplaint) {
        this.dateComplaint = dateComplaint;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="complaint")
    public Set<Feedback> getFeedbacks() {
        return this.feedbacks;
    }
    
    public void setFeedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }




}


