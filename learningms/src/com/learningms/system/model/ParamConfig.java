package com.learningms.system.model;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * ParamConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_param_config")

public class ParamConfig  implements java.io.Serializable {


    // Fields    

     private String id;
     private String typeName;
     private String displayName;
     private String displayValue;
     private String creator;
     private String creatorName;
     private Date createDate;
     private String modifier;
     private String modifierName;
     private Date modifyDate;
     private String deleter;
     private String deleterName;
     private Date delDate;
     private Integer lifeCycle;
     private Integer displaySeq;
     private String chineseWord;


    // Constructors

    /** default constructor */
    public ParamConfig() {
    }

	/** minimal constructor */
    public ParamConfig(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public ParamConfig(String id, String typeName, String displayName, String displayValue, String creator, String creatorName, Date createDate, String modifier, String modifierName, Date modifyDate, String deleter, String deleterName, Date delDate, Integer lifeCycle, Integer displaySeq, String chineseWord) {
        this.id = id;
        this.typeName = typeName;
        this.displayName = displayName;
        this.displayValue = displayValue;
        this.creator = creator;
        this.creatorName = creatorName;
        this.createDate = createDate;
        this.modifier = modifier;
        this.modifierName = modifierName;
        this.modifyDate = modifyDate;
        this.deleter = deleter;
        this.deleterName = deleterName;
        this.delDate = delDate;
        this.lifeCycle = lifeCycle;
        this.displaySeq = displaySeq;
        this.chineseWord = chineseWord;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="ID", unique=true, nullable=false, length=32)

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Column(name="TYPE_NAME", length=100)

    public String getTypeName() {
        return this.typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    @Column(name="DISPLAY_NAME", length=1000)

    public String getDisplayName() {
        return this.displayName;
    }
    
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    @Column(name="DISPLAY_VALUE", length=100)

    public String getDisplayValue() {
        return this.displayValue;
    }
    
    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }
    
    @Column(name="CREATOR", length=32)

    public String getCreator() {
        return this.creator;
    }
    
    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    @Column(name="CREATOR_NAME", length=100)

    public String getCreatorName() {
        return this.creatorName;
    }
    
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
    
    @Column(name="CREATE_DATE", length=19)

    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    @Column(name="MODIFIER", length=32)

    public String getModifier() {
        return this.modifier;
    }
    
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
    
    @Column(name="MODIFIER_NAME", length=100)

    public String getModifierName() {
        return this.modifierName;
    }
    
    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }
    
    @Column(name="MODIFY_DATE", length=19)

    public Date getModifyDate() {
        return this.modifyDate;
    }
    
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    
    @Column(name="DELETER", length=32)

    public String getDeleter() {
        return this.deleter;
    }
    
    public void setDeleter(String deleter) {
        this.deleter = deleter;
    }
    
    @Column(name="DELETER_NAME", length=100)

    public String getDeleterName() {
        return this.deleterName;
    }
    
    public void setDeleterName(String deleterName) {
        this.deleterName = deleterName;
    }
    
    @Column(name="DEL_DATE", length=19)

    public Date getDelDate() {
        return this.delDate;
    }
    
    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }
    
    @Column(name="LIFE_CYCLE")

    public Integer getLifeCycle() {
        return this.lifeCycle;
    }
    
    public void setLifeCycle(Integer lifeCycle) {
        this.lifeCycle = lifeCycle;
    }
    
    @Column(name="DISPLAY_SEQ")

    public Integer getDisplaySeq() {
        return this.displaySeq;
    }
    
    public void setDisplaySeq(Integer displaySeq) {
        this.displaySeq = displaySeq;
    }
    
    @Column(name="CHINESE_WORD", length=500)

    public String getChineseWord() {
        return this.chineseWord;
    }
    
    public void setChineseWord(String chineseWord) {
        this.chineseWord = chineseWord;
    }
   








}