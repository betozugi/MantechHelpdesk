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
import vn.aptech.MantechHelpdesk.entities.Member;
import vn.aptech.MantechHelpdesk.util.HibernateUtil;

/**
 *
 * @author ngocyen
 */
public class AccountManager {
    private static AccountManager instance;
    public static AccountManager getInstance(){
        if(instance==null){
            instance= new AccountManager();
        }
        return instance;
    }
    public List<Member> getListMember(){
        List<Member> list = new ArrayList<Member>();
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Member");
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
    public Member getIdMember(Member m){
//        Member m= null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Member m where m.id = ?");
            q.setParameter(0, m.getId());
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
    public boolean updateMember(Member mOld){
        Boolean result=false;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Member m where m.id = ?");
            q.setParameter(0, mOld.getId());
            Member m = (Member)q.uniqueResult();
            System.out.println(m +""+ mOld.getId());
            m.setAddress(mOld.getAddress());
//            m.setAvatar(mOld.getAvatar());
            m.setBirthday(mOld.getBirthday());
            m.setComplaints(mOld.getComplaints());
            m.setDepartment(mOld.getDepartment());
            m.setEmail(mOld.getEmail());
            m.setFeedbacks(mOld.getFeedbacks());
            m.setFullname(mOld.getFullname());
            m.setId(mOld.getId());
            m.setPassword("123456");
            m.setPhone(mOld.getPhone());
            m.setSex(mOld.getSex());
            m.setUsername(mOld.getUsername());
            
            
            session.saveOrUpdate(m);
            result=true;
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return result;
    }
//    public static void main(String[] args) {        
//        System.out.println(AccountManager.getInstance().getIdMember();
//    }
    public Member findIdMember(int id){
        Member m= null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Member m where m.id = ?");
            q.setParameter(0, id);
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
    public boolean updatePassword(Member mOld){
        Boolean result=false;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Member m where m.id = ?");
            q.setParameter(0, mOld.getId());
            Member m = (Member)q.uniqueResult();
            System.out.println(m +""+ mOld.getId());
            m.setPassword(mOld.getPassword());
            
            
            session.saveOrUpdate(m);
            result=true;
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return result;
    }
}
