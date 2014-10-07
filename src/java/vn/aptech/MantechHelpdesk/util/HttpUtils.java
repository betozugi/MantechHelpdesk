/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.aptech.MantechHelpdesk.util;

import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Beto
 */
public class HttpUtils {

    public static String getFullURL() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        StringBuilder sb = new StringBuilder();
        sb.append(request.getScheme());
        sb.append("://");
        sb.append(request.getServerName());
        sb.append(":");
        sb.append(request.getServerPort());
        sb.append(request.getContextPath());

        return sb.toString();
    }
    public static Object getFromSession(String name) {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        return sessionMap.get(name);
    }
    public static void putToSession(String name, Object value) {
       
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put(name, value);
    }
    //add success message
    public static void addSuccessMessgae(String summary, String detail) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
            FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    public static void addErrorMessgae(String summary, String detail) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
            FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
}
