package com.didi.communitysupport.domain;

import java.util.Date;

/**
 * @author: koco
 * @time: 2019-07-29 14:54
 * @table: weight
 * @description: 
 */
public class WeightEntity {

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer wId;

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer wUserid;

    /**
     * 
     * max-len: 10
     * not-null: yes 
     * default: ''
     */
    private Integer wNumber;

    /**
     * 
     * max-len: 0
     * not-null: yes 
     * default: ''
     */
    private Date wDate;

    
    public Integer getWId(){
        return this.wId;
    }

    public void setWId(Integer wId){
        this.wId = wId;
    }
    
    public Integer getWUserid(){
        return this.wUserid;
    }

    public void setWUserid(Integer wUserid){
        this.wUserid = wUserid;
    }
    
    public Integer getWNumber(){
        return this.wNumber;
    }

    public void setWNumber(Integer wNumber){
        this.wNumber = wNumber;
    }
    
    public Date getWDate(){
        return this.wDate;
    }

    public void setWDate(Date wDate){
        this.wDate = wDate;
    }
    
}
