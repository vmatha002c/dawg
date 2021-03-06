package com.comcast.video.dawg.common.security.model;

import java.util.Set;

/**
 * Combines the dawg user with the roles that are assigned to it
 * @author kpears201
 *
 */
public class DawgUserAndRoles extends DawgUser {
	private Set<String> roles;
	
	public DawgUserAndRoles() {
	    
	}
    
    public DawgUserAndRoles(String uid, String firstName, String lastName, String mail, String password, Set<String> roles) {
        super(uid, firstName, lastName, mail, password);
        this.roles = roles;
    }

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
}
