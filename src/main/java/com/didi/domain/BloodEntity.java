package com.didi.domain;

import java.util.Date;

/**
 * @author: koco
 * @time: 2019-07-28 20:36
 * @table: blood
 * @description: 
 */
public class BloodEntity {

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer bId;

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer bUserid;

    /**
     * 
     * max-len: 10
     * not-null: yes 
     * default: ''
     */
    private Integer bNumber;

    /**
     * 
     * max-len: 0
     * not-null: yes 
     * default: ''
     */
    private Date bDate;

    
    public Integer getBId(){
        return this.bId;
    }

    public void setBId(Integer bId){
        this.bId = bId;
    }
    
    public Integer getBUserid(){
        return this.bUserid;
    }

    public void setBUserid(Integer bUserid){
        this.bUserid = bUserid;
    }
    
    public Integer getBNumber(){
        return this.bNumber;
    }

    public void setBNumber(Integer bNumber){
        this.bNumber = bNumber;
    }
    
    public Date getBDate(){
        return this.bDate;
    }

    public void setBDate(Date bDate){
        this.bDate = bDate;
    }
    
}
