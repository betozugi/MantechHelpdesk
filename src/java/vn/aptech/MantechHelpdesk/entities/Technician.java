package vn.aptech.MantechHelpdesk.entities;
// Generated Oct 4, 2014 4:48:05 PM by Hibernate Tools 3.6.0


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
 * Technician generated by hbm2java
 */
@Entity
@Table(name="Technician"
    ,schema="dbo"
    ,catalog="MantechHelpdesks"
)
public class Technician  implements java.io.Serializable {


     private int id;
     private String username;
     private String password;
     private String email;
     private String fullname;
     private String phone;
     private String statusTechnician;
     private String avatar;
     private Set<Complaint> complaints = new HashSet<Complaint>(0);

    public Technician() {
    }

	
    public Technician(int id) {
        this.id = id;
    }
    public Technician(int id, String username, String password, String email, String fullname, String phone, String statusTechnician, String avatar, Set<Complaint> complaints) {
       this.id = id;
       this.username = username;
       this.password = password;
       this.email = email;
       this.fullname = fullname;
       this.phone = phone;
       this.statusTechnician = statusTechnician;
       this.avatar = avatar;
       this.complaints = complaints;
    }
   
     @Id 

    
    @Column(name="Id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="Username")
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="Password")
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="Email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="Fullname")
    public String getFullname() {
        return this.fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    
    @Column(name="Phone")
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="Status_technician")
    public String getStatusTechnician() {
        return this.statusTechnician;
    }
    
    public void setStatusTechnician(String statusTechnician) {
        this.statusTechnician = statusTechnician;
    }

    
    @Column(name="Avatar")
    public String getAvatar() {
        return this.avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="member")
    public Set<Complaint> getComplaints() {
        return this.complaints;
    }
    
    public void setComplaints(Set<Complaint> complaints) {
        this.complaints = complaints;
    }




}


