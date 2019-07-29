package com.didi.communitysupport.domain;

import java.util.Date;

/**
 * @author: koco
 * @time: 2019-07-29 14:54
 * @table: keepage
 * @description: 
 */
public class KeepageEntity {

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer kId;

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer kUserid;

    /**
     * 
     * max-len: 10
     * not-null: yes 
     * default: ''
     */
    private Integer kNumber;

    /**
     * 
     * max-len: 0
     * not-null: yes 
     * default: ''
     */
    private Date kDate;

    
    public Integer getKId(){
        return this.kId;
    }

    public void setKId(Integer kId){
        this.kId = kId;
    }
    
    public Integer getKUserid(){
        return this.kUserid;
    }

    public void setKUserid(Integer kUserid){
        this.kUserid = kUserid;
    }
    
    public Integer getKNumber(){
        return this.kNumber;
    }

    public void setKNumber(Integer kNumber){
        this.kNumber = kNumber;
    }
    
    public Date getKDate(){
        return this.kDate;
    }

    public void setKDate(Date kDate){
        this.kDate = kDate;
    }
    
}
