package com.capgemini.project.microsevice_apigateway.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class CommonMan {
    @Id
    private String id;
    private String user_id;
    private String password;
    private String role;
    public CommonMan() {
    }
    public CommonMan(String id, String user_id, String password, String role) {
        this.id = id;
        this.user_id = user_id;
        this.password = password;
        this.role = role;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "CommonMan [id=" + id + ", password=" + password + ", role=" + role + ", user_id=" + user_id + "]";
    }
}
