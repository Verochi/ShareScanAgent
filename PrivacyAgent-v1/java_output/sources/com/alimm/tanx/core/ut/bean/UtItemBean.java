package com.alimm.tanx.core.ut.bean;

/* loaded from: classes.dex */
public class UtItemBean extends com.alimm.tanx.core.ad.bean.BaseBean {
    public java.lang.String arg1;
    public java.lang.String arg2;
    public java.lang.String arg3;
    public java.util.Map args;
    public int eventId;
    public int eventStatus;
    public long eventTime = java.lang.System.currentTimeMillis();
    public java.lang.String page;
    public java.lang.String pid;
    public java.lang.String reqId;
    public java.lang.String sessionId;

    public UtItemBean() {
    }

    public UtItemBean(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.page = str;
        this.eventId = i;
        this.arg1 = str2;
        this.arg2 = str3;
        this.arg3 = str4;
        this.args = map;
    }

    public UtItemBean(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, int i2, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str7) {
        this.reqId = str;
        this.pid = str2;
        this.page = str3;
        this.eventId = i;
        this.eventStatus = i2;
        this.arg1 = str4;
        this.arg2 = str5;
        this.arg3 = str6;
        this.args = map;
        this.sessionId = str7;
    }

    public boolean equals(com.alimm.tanx.core.ut.bean.UtItemBean utItemBean) {
        return hashCode() == utItemBean.hashCode();
    }

    public int hashCode() {
        return java.util.Objects.hash(this.reqId, this.pid, this.page, java.lang.Integer.valueOf(this.eventId), java.lang.Integer.valueOf(this.eventStatus), this.arg1, this.arg2, this.arg3, this.args, this.sessionId);
    }

    public java.lang.String toString() {
        return "UtItemBean{ eventId=" + this.eventId + ", reqId='" + this.reqId + "', pid='" + this.pid + "', page='" + this.page + "', eventTime=" + this.eventTime + ", eventStatus=" + this.eventStatus + ", arg1='" + this.arg1 + "', arg2='" + this.arg2 + "', arg3='" + this.arg3 + "', args='" + this.args + "', sessionId='" + this.sessionId + "'} " + super.toString();
    }
}
