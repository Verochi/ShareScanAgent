package com.sensorsdata.sf.core.entity;

/* loaded from: classes19.dex */
public class SFCampaign implements java.lang.Cloneable {
    private java.lang.String content;
    private java.lang.String name;
    private java.lang.String planId;
    private com.sensorsdata.sf.core.entity.SFCampaign.Type type;

    public enum Type {
        PRESET("PRESET"),
        CUSTOMIZED("CUSTOMIZED");

        Type(java.lang.String str) {
        }
    }

    public SFCampaign(java.lang.String str, java.lang.String str2, java.lang.String str3, com.sensorsdata.sf.core.entity.SFCampaign.Type type) {
        this.planId = str;
        this.name = str2;
        this.content = str3;
        this.type = type;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.sensorsdata.sf.core.entity.SFCampaign m96clone() {
        try {
            return (com.sensorsdata.sf.core.entity.SFCampaign) super.clone();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return this;
        }
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public java.lang.String getPlanId() {
        return this.planId;
    }

    public com.sensorsdata.sf.core.entity.SFCampaign.Type getType() {
        return this.type;
    }

    public void setContent(java.lang.String str) {
        this.content = str;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public void setPlanId(java.lang.String str) {
        this.planId = str;
    }

    public void setType(com.sensorsdata.sf.core.entity.SFCampaign.Type type) {
        this.type = type;
    }

    public java.lang.String toString() {
        return "SFCampaign{planId='" + this.planId + "', name='" + this.name + "', content=" + this.content + ", type=" + this.type + '}';
    }
}
