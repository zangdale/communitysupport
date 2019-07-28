package com.didi.domain;

import java.util.Date;

/**
 * @author: koco
 * @time: 2019-07-28 20:36
 * @table: question
 * @description: 
 */
public class QuestionEntity {

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer qId;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String qTitle;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String qText;

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer qUserid;

    /**
     * 
     * max-len: 0
     * not-null: yes 
     * default: ''
     */
    private Date qDate;

    
    public Integer getQId(){
        return this.qId;
    }

    public void setQId(Integer qId){
        this.qId = qId;
    }
    
    public String getQTitle(){
        return this.qTitle;
    }

    public void setQTitle(String qTitle){
        this.qTitle = qTitle;
    }
    
    public String getQText(){
        return this.qText;
    }

    public void setQText(String qText){
        this.qText = qText;
    }
    
    public Integer getQUserid(){
        return this.qUserid;
    }

    public void setQUserid(Integer qUserid){
        this.qUserid = qUserid;
    }
    
    public Date getQDate(){
        return this.qDate;
    }

    public void setQDate(Date qDate){
        this.qDate = qDate;
    }
    
}
