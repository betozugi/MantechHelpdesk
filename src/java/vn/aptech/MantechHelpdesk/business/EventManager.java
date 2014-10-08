/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.aptech.MantechHelpdesk.business;

import org.hibernate.Query;
import org.hibernate.Session;
import vn.aptech.MantechHelpdesk.entities.Admin;
import vn.aptech.MantechHelpdesk.entities.Member;
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
   
}
