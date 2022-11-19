package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月16日,0016.
 * 158045632@qq.com
 */
public class CustomFieldBean {

    /**
     * Id : 14330853502499840
     * Type : 1
     * FieldName : 头像
     * FieldType : 0
     * FieldValue : Avatar
     * IsRequired : 0
     * IsUsed : 1
     * IsCustom : 0
     * CanSetRequired : 1
     * CanSetUsed : 0
     */

    private String Id;
    private int Type;
    private String FieldName;
    private int FieldType;
    private String FieldValue;
    private int IsRequired;
    private int IsUsed;
    private int IsCustom;
    private int CanSetRequired;
    private int CanSetUsed;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public String getFieldName() {
        return FieldName;
    }

    public void setFieldName(String FieldName) {
        this.FieldName = FieldName;
    }

    public int getFieldType() {
        return FieldType;
    }

    public void setFieldType(int FieldType) {
        this.FieldType = FieldType;
    }

    public String getFieldValue() {
        return FieldValue;
    }

    public void setFieldValue(String FieldValue) {
        this.FieldValue = FieldValue;
    }

    public int getIsRequired() {
        return IsRequired;
    }

    public void setIsRequired(int IsRequired) {
        this.IsRequired = IsRequired;
    }

    public int getIsUsed() {
        return IsUsed;
    }

    public void setIsUsed(int IsUsed) {
        this.IsUsed = IsUsed;
    }

    public int getIsCustom() {
        return IsCustom;
    }

    public void setIsCustom(int IsCustom) {
        this.IsCustom = IsCustom;
    }

    public int getCanSetRequired() {
        return CanSetRequired;
    }

    public void setCanSetRequired(int CanSetRequired) {
        this.CanSetRequired = CanSetRequired;
    }

    public int getCanSetUsed() {
        return CanSetUsed;
    }

    public void setCanSetUsed(int CanSetUsed) {
        this.CanSetUsed = CanSetUsed;
    }
}
