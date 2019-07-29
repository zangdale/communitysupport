package com.didi.communitysupport.domain;

import java.util.Date;

/**
 * @author: koco
 * @time: 2019-07-29 14:54
 * @table: ill
 * @description: 
 */
public class IllEntity {

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer iId;

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer iUserid;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String iTitle;

    /**
     * 
     * max-len: 0
     * not-null: yes 
     * default: ''
     */
    private Date iDate;

    
    public Integer getIId(){
        return this.iId;
    }

    public void setIId(Integer iId){
        this.iId = iId;
    }
    
    public Integer getIUserid(){
        return this.iUserid;
    }

    public void setIUserid(Integer iUserid){
        this.iUserid = iUserid;
    }
    
    public String getITitle(){
        return this.iTitle;
    }

    public void setITitle(String iTitle){
        this.iTitle = iTitle;
    }
    
    public Date getIDate(){
        return this.iDate;
    }

    public void setIDate(Date iDate){
        this.iDate = iDate;
    }
    
}
