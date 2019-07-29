package com.didi.communitysupport.domain;

import java.util.Date;

/**
 * @author: koco
 * @time: 2019-07-29 14:54
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

    private String uName;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

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

    public QuestionEntity(Integer qId, String qTitle, String qText, Integer qUserid, Date qDate) {
        this.qId = qId;
        this.qTitle = qTitle;
        this.qText = qText;
        this.qUserid = qUserid;
        this.qDate = qDate;
    }

    public QuestionEntity() {
    }

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "qId=" + qId +
                ", qTitle='" + qTitle + '\'' +
                ", qText='" + qText + '\'' +
                ", qUserid=" + qUserid +
                ", uName='" + uName + '\'' +
                ", qDate=" + qDate +
                '}';
    }
}
