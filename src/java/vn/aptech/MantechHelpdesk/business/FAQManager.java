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
import vn.aptech.MantechHelpdesk.entities.Faq;
import vn.aptech.MantechHelpdesk.util.HibernateUtil;

/**
 *
 * @author ngocyen
 */
public class FAQManager {
    private static FAQManager instance;
    public static FAQManager getInstance(){
        if(instance==null){
            instance= new FAQManager();
        }
        return instance;
    }
    public List<Faq> getListFAQ(){
        List<Faq> list= new ArrayList<Faq>();
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q= session.createQuery("from Faq");
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
    public boolean insertFAQ(Faq faq){
        boolean result= false;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(faq);
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
}
