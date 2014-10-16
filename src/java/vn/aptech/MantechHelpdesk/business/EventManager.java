/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.aptech.MantechHelpdesk.business;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import vn.aptech.MantechHelpdesk.entities.Admin;
import vn.aptech.MantechHelpdesk.entities.Complaint;
import vn.aptech.MantechHelpdesk.entities.Member;
import vn.aptech.MantechHelpdesk.entities.Technician;
import vn.aptech.MantechHelpdesk.util.HibernateUtil;
/**
 *
 * @author Beto
 */
public class EventManager {
    private static EventManager instance;
    public static EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }
        return instance;
    }
    public Admin checkAdmin(Admin u) {
        Admin admin = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Admin u where  u.adname=? and u.adpass = ?");
            q.setParameter(0, u.getAdname());
            q.setParameter(1, u.getAdpass());

            admin = (Admin) q.uniqueResult();
            session.getTransaction().commit();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().commit();
        } finally {
            session.close();
        }

        return admin;
    }
    public boolean insertMember(Member member) {
    boolean insertResult = false;
    Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
//            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            Date date = new Date();
//            member.setBirthday(date);
            session.save(member);
            insertResult = true;

            session.getTransaction().commit();
        }catch( Exception ex ){
            ex.printStackTrace();
            insertResult = false;
        }finally{
            session.close();
        }
        return insertResult;
   }
   public List<Complaint> findNewComplaint(){
        List<Complaint> list= new ArrayList<Complaint>();
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Complaint c where c.status=?");
            q.setParameter(0, "0");
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
   public List<Complaint> findHistoryComplaint(){
        List<Complaint> list= new ArrayList<Complaint>();
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Complaint c where c.status=?");
            q.setParameter(0, "2");
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
   public List<Technician> getFreeTechnician(){
        List<Technician> list= new ArrayList<Technician>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Technician t where t.statusTechnician=?");
            q.setParameter(0, "0");
            list=q.list();
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
       return list;
   }
    public boolean updateComplaint(Complaint c){
        boolean result = false;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Technician tech = (Technician) session.get(Technician.class, c.getTechnician().getId());
            c.setTechnician(tech);
            session.saveOrUpdate(c);
            session.getTransaction().commit();
            result=true;
            return true;
        }catch(Exception ex){
            result=false;
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
   }
}
