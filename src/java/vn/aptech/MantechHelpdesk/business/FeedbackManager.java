/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.MantechHelpdesk.business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import vn.aptech.MantechHelpdesk.entities.Complaint;
import vn.aptech.MantechHelpdesk.entities.Feedback;
import vn.aptech.MantechHelpdesk.util.HibernateUtil;

/**
 *
 * @author ngocyen
 */
public class FeedbackManager {
    private static FeedbackManager instance;
    public static FeedbackManager getInstance(){
        if(instance==null){
            instance= new FeedbackManager();
        }
        return instance;
    }
    public Complaint getIdComplaint(Complaint c){
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Complaint c where c.id=?");
            q.setParameter(0, c.getId());
            c= (Complaint)q.uniqueResult();
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return c;
    }
    public List<Feedback> findByIdFeedback(int id){
        List<Feedback> list= new ArrayList<Feedback>();
        
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Feedback f where f.complaint.id = ? order by f.dateFeedback");
            q.setParameter(0, id);
            list= q.list();
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        return list;
    }
    public boolean sendFeedback(Feedback feedback){
        boolean result= false;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            feedback.setDateFeedback(date);
            session.save(feedback);
            result= true;
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return result;
    }
    public List<Feedback> feedbackMemberShow(int idMem,int idCom){
        List<Feedback> list= new ArrayList<Feedback>();
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Feedback f where f.member.id=? and f.complaint.id=?");
            q.setParameter(0, idMem);
            q.setParameter(1, idCom);
            list= q.list();
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return list;
    }
     public Complaint findByIdMember(Complaint c){
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Complaint c where c.id=?");
            q.setParameter(0, c.getId());
            c= (Complaint)q.uniqueResult();
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return c;
    }
      public List<Feedback> feedbackAdminShow(int idCom){
        List<Feedback> list= new ArrayList<Feedback>();
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Feedback f where f.admin.id=? and f.complaint.id=?");
            q.setParameter(0, 1);
            q.setParameter(1, idCom);
            list= q.list();
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return list;
    }
}
