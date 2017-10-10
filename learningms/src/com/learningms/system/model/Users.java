package com.learningms.system.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_users"
    ,catalog="learningms"
)

public class Users  implements java.io.Serializable {


    // Fields    

     private String id;
     private String userName;
     private String passwd;


    // Constructors

    /** default constructor */
    public Users() {
    }

	/** minimal constructor */
    public Users(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public Users(String id, String userName, String passwd) {
        this.id = id;
        this.userName = userName;
        this.passwd = passwd;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="ID", unique=true, nullable=false, length=32)

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Column(name="USER_NAME", length=100)

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name="PASSWD", length=200)

    public String getPasswd() {
        return this.passwd;
    }
    
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
   








}