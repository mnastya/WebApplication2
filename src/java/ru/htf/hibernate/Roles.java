package ru.htf.hibernate;
// Generated 27.05.2016 5:56:22 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Roles generated by hbm2java
 */
public class Roles  implements java.io.Serializable {


     private int roleId;
     private String roleName;
     private Set<Users> userses = new HashSet<Users>(0);

    public Roles() {
    }

	
    public Roles(int roleId) {
        this.roleId = roleId;
    }
    public Roles(int roleId, String roleName, Set<Users> userses) {
       this.roleId = roleId;
       this.roleName = roleName;
       this.userses = userses;
    }
   
    public int getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public Set<Users> getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set<Users> userses) {
        this.userses = userses;
    }




}


