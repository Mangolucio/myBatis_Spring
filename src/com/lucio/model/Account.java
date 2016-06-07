package com.lucio.model;
import java.io.Serializable;


public class Account implements Serializable {
    private static final long serialVersionUID = -7970848646314840509L;
    private String id;
    private String username;
    private String password;
    private String email;
    private String  address;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    
    @Override
    public String toString() {
        return this.id + "#" + this.username +  "#" + 
            this.password +  "#" + this.email +  "#" + this.address;
    }
    
}
