package vn.aptech.MantechHelpdesk.entities;
// Generated Oct 7, 2014 4:39:05 PM by Hibernate Tools 3.6.0


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Admin generated by hbm2java
 */
@Entity
@Table(name="Admin"
    ,schema="dbo"
    ,catalog="MantechHelpdesks"
)
public class Admin  implements java.io.Serializable {


     private int id;
     private String adname;
     private String adpass;
     private String avatar;
     private Set<Feedback> feedbacks = new HashSet<Feedback>(0);

    public Admin() {
    }

	
    public Admin(int id) {
        this.id = id;
    }
    public Admin(int id, String adname, String adpass, String avatar, Set<Feedback> feedbacks) {
       this.id = id;
       this.adname = adname;
       this.adpass = adpass;
       this.avatar = avatar;
       this.feedbacks = feedbacks;
    }
   
     @Id 

    
    @Column(name="Id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="Adname")
    public String getAdname() {
        return this.adname;
    }
    
    public void setAdname(String adname) {
        this.adname = adname;
    }

    
    @Column(name="Adpass")
    public String getAdpass() {
        return this.adpass;
    }
    
    public void setAdpass(String adpass) {
        this.adpass = adpass;
    }

    
    @Column(name="Avatar")
    public String getAvatar() {
        return this.avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="admin")
    public Set<Feedback> getFeedbacks() {
        return this.feedbacks;
    }
    
    public void setFeedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }




}

