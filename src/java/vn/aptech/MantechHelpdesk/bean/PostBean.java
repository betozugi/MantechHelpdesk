/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.MantechHelpdesk.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vn.aptech.MantechHelpdesk.business.MemberEventManager;
import vn.aptech.MantechHelpdesk.entities.Post;

/**
 *
 * @author ngocyen
 */
@ManagedBean
@RequestScoped
public class PostBean {
    private Post post;
    public PostBean(){
        post= new Post();
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    public List<Post> getAllPost(){
        return MemberEventManager.getInstance().getAllPost();
    }
    public String insertPost(){
        if(MemberEventManager.getInstance().insertPost(post)){
            return "/Admin_Mantech_Helpdesk/ManagerPost.xhtml";
        }
        else{
            return null;
        }
        
    }
    
}
