/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.MantechHelpdesk.business;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import vn.aptech.MantechHelpdesk.entities.Complaint;
import vn.aptech.MantechHelpdesk.entities.Feedback;
import vn.aptech.MantechHelpdesk.entities.Member;
import vn.aptech.MantechHelpdesk.entities.Post;
import vn.aptech.MantechHelpdesk.entities.Technician;
import vn.aptech.MantechHelpdesk.util.HibernateUtil;

/**
 *
 * @author ngocyen
 */
public class MemberEventManager {
    private static MemberEventManager instance;
    public static MemberEventManager getInstance(){
        if(instance==null){
            instance= new MemberEventManager();
        }
        return instance;
    }
    public Member getUser(Member m){
//        Member member= null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Member m where m.username=? and m.password=?");
            q.setParameter(0, m.getUsername());
            q.setParameter(1, m.getPassword());
            m= (Member)q.uniqueResult();
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return m;
    }
    public Technician getTech(Technician t){
//        Member member= null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Technician m where m.username=? and m.password=?");
            q.setParameter(0, t.getUsername());
            q.setParameter(1, t.getPassword());
            t= (Technician)q.uniqueResult();
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return t;
    }
    public List<Complaint> getListComplaint(String id){
        List<Complaint> list= new ArrayList<Complaint>();
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Complaint c where c.idUser=?");
            q.setParameter(0, Integer.parseInt(id));
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
//    public List<Feedback> findByidFeedback(){
//        List<Feedback> list= new ArrayList<Feedback>();
//        Session session= HibernateUtil.getSessionFactory().openSession();
//        try{
//            session.beginTransaction();
//            Query q= session.createQuery("from Feedback f where f.")
//        }catch(Exception ex){
//            ex.printStackTrace();
//            session.getTransaction().rollback();
//        }finally{
//            session.close();
//        }
//        return list;
//    }
    public List<Post> getAllPost(){
        List<Post> list= new ArrayList<Post>();
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Post");
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
//    public static void main(String[] args) {
//        List<Feedback> findByIdFeedback = MemberEventManager.getInstance().findByIdFeedback(15);
//        System.out.println(findByIdFeedback);
//    }
}
