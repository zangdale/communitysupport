package com.didi.domain;


/**
 * @author: koco
 * @time: 2019-07-28 20:36
 * @table: user
 * @description: 
 */
public class UserEntity {

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer uId;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String uAccount;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String uPasswd;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String uName;

    /**
     * 
     * max-len: 10
     * not-null: yes 
     * default: ''
     */
    private Integer uAge;

    /**
     * 
     * max-len: 255
     * not-null: no 
     * default: ''
     */
    private String uTel;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String uOldtype;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String uType;

    
    public Integer getUId(){
        return this.uId;
    }

    public void setUId(Integer uId){
        this.uId = uId;
    }
    
    public String getUAccount(){
        return this.uAccount;
    }

    public void setUAccount(String uAccount){
        this.uAccount = uAccount;
    }
    
    public String getUPasswd(){
        return this.uPasswd;
    }

    public void setUPasswd(String uPasswd){
        this.uPasswd = uPasswd;
    }
    
    public String getUName(){
        return this.uName;
    }

    public void setUName(String uName){
        this.uName = uName;
    }
    
    public Integer getUAge(){
        return this.uAge;
    }

    public void setUAge(Integer uAge){
        this.uAge = uAge;
    }
    
    public String getUTel(){
        return this.uTel;
    }

    public void setUTel(String uTel){
        this.uTel = uTel;
    }
    
    public String getUOldtype(){
        return this.uOldtype;
    }

    public void setUOldtype(String uOldtype){
        this.uOldtype = uOldtype;
    }
    
    public String getUType(){
        return this.uType;
    }

    public void setUType(String uType){
        this.uType = uType;
    }
    
}
