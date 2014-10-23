/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.aptech.MantechHelpdesk.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import vn.aptech.MantechHelpdesk.business.EventManager;
import vn.aptech.MantechHelpdesk.business.FeedbackManager;
import vn.aptech.MantechHelpdesk.entities.Admin;
import vn.aptech.MantechHelpdesk.entities.Feedback;
import vn.aptech.MantechHelpdesk.util.HttpUtils;

/**
 *
 * @author Beto
 */
@ManagedBean
@SessionScoped
public class FeedbackBean {
     private Feedback feedback;

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

   
    public  String sendFeedback(){
        
        if(EventManager.getInstance().insertFeedback(feedback)){
          HttpUtils.addSuccessMessgae("Success", "Send mail successfully!");
        }
        else{
             HttpUtils.addErrorMessgae("Error", "Send mail fail.");
        }
         return null;
        
    }
     
}
