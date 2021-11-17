package com.nagarro.common;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;


@ManagedBean
@SessionScoped
public class UserCache implements Serializable {
	private static final long serialVersionUID = 1L;
    private User currentUser;
    

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void removeCurrentUser() {
        this.currentUser = null;
    }
}
