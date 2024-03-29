package com.didi.communitysupport.domain;


/**
 * @author: koco
 * @time: 2019-07-29 14:54
 * @table: video
 * @description: 
 */
public class VideoEntity {

    /**
     * 主键id
     * max-len: 11
     * not-null: yes 
     * default: ''
     */
    private Integer vId;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String vName;

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String vType;

    private String vImageurl;

    public String getvImageurl() {
        return vImageurl;
    }

    public void setvImageurl(String vImageurl) {
        this.vImageurl = vImageurl;
    }

    /**
     * 
     * max-len: 255
     * not-null: yes 
     * default: ''
     */
    private String vUrl;

    
    public Integer getVId(){
        return this.vId;
    }

    public void setVId(Integer vId){
        this.vId = vId;
    }
    
    public String getVName(){
        return this.vName;
    }

    public void setVName(String vName){
        this.vName = vName;
    }
    
    public String getVType(){
        return this.vType;
    }

    public void setVType(String vType){
        this.vType = vType;
    }
    
    public String getVUrl(){
        return this.vUrl;
    }

    public void setVUrl(String vUrl){
        this.vUrl = vUrl;
    }

    public VideoEntity(Integer vId, String vName, String vType, String vImageurl, String vUrl) {
        this.vId = vId;
        this.vName = vName;
        this.vType = vType;
        this.vImageurl = vImageurl;
        this.vUrl = vUrl;
    }
    public VideoEntity() {

    }
}
