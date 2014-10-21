/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.MantechHelpdesk.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vn.aptech.MantechHelpdesk.business.FAQManager;
import vn.aptech.MantechHelpdesk.entities.Faq;
import vn.aptech.MantechHelpdesk.util.HttpUtils;

/**
 *
 * @author ngocyen
 */
@ManagedBean
@RequestScoped
public class FAQBean {
    private Faq faq;
    public FAQBean(){
        faq= new Faq();
    }

    public Faq getFaq() {
        return faq;
    }

    public void setFaq(Faq faq) {
        this.faq = faq;
    }
    public List<Faq> getListFAQ(){
        return FAQManager.getInstance().getListFAQ();
    }
    public String insertFAQ(){
        if(FAQManager.getInstance().insertFAQ(faq)){
            HttpUtils.addSuccessMessgae("Success", "Create new FAQ successfully!");
        }else{
            HttpUtils.addErrorMessgae("Error", "Create new FAQ fail!");
        }
        return "/Member_Mantech_Helpdesk/FAQ.xhtml";
    }
}
