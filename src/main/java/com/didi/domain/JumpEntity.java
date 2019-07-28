package com.didi.domain;

import java.util.Date;

/**
 * @author: koco
 * @time: 2019-07-28 20:36
 * @table: jump
 * @description: 
 */
public class JumpEntity {

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer jId;

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer jUserid;

    /**
     * 
     * max-len: 10
     * not-null: yes 
     * default: ''
     */
    private Integer jNumber;

    /**
     * 
     * max-len: 0
     * not-null: yes 
     * default: ''
     */
    private Date jDate;

    
    public Integer getJId(){
        return this.jId;
    }

    public void setJId(Integer jId){
        this.jId = jId;
    }
    
    public Integer getJUserid(){
        return this.jUserid;
    }

    public void setJUserid(Integer jUserid){
        this.jUserid = jUserid;
    }
    
    public Integer getJNumber(){
        return this.jNumber;
    }

    public void setJNumber(Integer jNumber){
        this.jNumber = jNumber;
    }
    
    public Date getJDate(){
        return this.jDate;
    }

    public void setJDate(Date jDate){
        this.jDate = jDate;
    }
    
}
