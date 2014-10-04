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
import vn.aptech.MantechHelpdesk.ulti.HibernateUtil;
import vn.aptech.MantechHelpdesk.entities.Admin;
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
    public Admin checkUser(Admin u) {
        Admin admin = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Admin u where u.Adname = ? and u.Adpass = ?");
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
