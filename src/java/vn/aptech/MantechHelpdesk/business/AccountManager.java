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
    public boolean updateMember(Member m){
        Boolean result=false;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("update Member m set m.username = ?, m.email = ?, m.fullname = ?, m.birthday = ?, m. address = ?, m.sex = ?, m.phone = ?, m.department = ? where m.id=? ");
            q.setParameter(0, m.getUsername());
            q.setParameter(0, m.getEmail());
            q.setParameter(0, m.getFullname());
            q.setParameter(0, m.getBirthday());
            q.setParameter(0, m.getAddress());
            q.setParameter(0, m.getSex());
            q.setParameter(0, m.getPhone());
            q.setParameter(0, m.getDepartment());
            q.setParameter(0, m.getId());
            q.executeUpdate();
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
}
