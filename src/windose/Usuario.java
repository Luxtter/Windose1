/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package windose;

import java.io.File;

/**
 *
 * @author luxte
 */
public class Usuario {
    
    private String user;
    private String pass;

    public Usuario(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

   

    public Usuario() {
    }

  

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return user;
    }
    
}
