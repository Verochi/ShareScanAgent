package com.alimm.tanx.core.ut.bean;

/* loaded from: classes.dex */
public class UtItemH5Bean extends com.alimm.tanx.core.ad.bean.BaseBean {
    public java.lang.String arg1;
    public java.lang.String arg2;
    public java.lang.String arg3;
    public java.util.Map<java.lang.String, java.lang.Object> args;
    public int eventId;
    public int eventStatus;
    public long eventTime;
    public java.lang.String page;
    public java.lang.String pid;
    public java.lang.String reqId;

    public UtItemH5Bean() {
        this.args = new java.util.HashMap();
        this.eventTime = java.lang.System.currentTimeMillis();
    }

    public UtItemH5Bean(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.args = new java.util.HashMap();
        this.page = str;
        this.eventId = i;
        this.eventTime = java.lang.System.currentTimeMillis();
        this.arg1 = str2;
        this.arg2 = str3;
        this.arg3 = str4;
        this.args = map;
    }

    public UtItemH5Bean(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, int i2, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.args = new java.util.HashMap();
        this.reqId = str;
        this.pid = str2;
        this.page = str3;
        this.eventId = i;
        this.eventTime = java.lang.System.currentTimeMillis();
        this.eventStatus = i2;
        this.arg1 = str4;
        this.arg2 = str5;
        this.arg3 = str6;
        this.args = map;
    }

    public com.alimm.tanx.core.ut.bean.UtItemH5Bean buildH5UtItemBean(com.alimm.tanx.core.ut.bean.UtItemH5Bean utItemH5Bean) {
        this.page = utItemH5Bean.page;
        this.eventId = utItemH5Bean.eventId;
        this.eventStatus = utItemH5Bean.eventStatus;
        this.arg1 = utItemH5Bean.arg1;
        this.arg2 = utItemH5Bean.arg2;
        this.arg3 = utItemH5Bean.arg3;
        this.args = utItemH5Bean.args;
        return this;
    }
}
