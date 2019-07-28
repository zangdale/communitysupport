package com.didi.domain;


/**
 * @author: koco
 * @time: 2019-07-28 20:36
 * @table: onebank
 * @description: 
 */
public class OnebankEntity {

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer oId;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String oTitle;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String oAnswer1;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String oAnswer2;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String oAnswer3;

    /**
     * 
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer oRight;

    
    public Integer getOId(){
        return this.oId;
    }

    public void setOId(Integer oId){
        this.oId = oId;
    }
    
    public String getOTitle(){
        return this.oTitle;
    }

    public void setOTitle(String oTitle){
        this.oTitle = oTitle;
    }
    
    public String getOAnswer1(){
        return this.oAnswer1;
    }

    public void setOAnswer1(String oAnswer1){
        this.oAnswer1 = oAnswer1;
    }
    
    public String getOAnswer2(){
        return this.oAnswer2;
    }

    public void setOAnswer2(String oAnswer2){
        this.oAnswer2 = oAnswer2;
    }
    
    public String getOAnswer3(){
        return this.oAnswer3;
    }

    public void setOAnswer3(String oAnswer3){
        this.oAnswer3 = oAnswer3;
    }
    
    public Integer getORight(){
        return this.oRight;
    }

    public void setORight(Integer oRight){
        this.oRight = oRight;
    }
    
}
