package com.alimm.tanx.core.ut.bean;

/* loaded from: classes.dex */
public class UtBean extends com.alimm.tanx.core.ad.bean.BaseBean {
    public com.alimm.tanx.core.ut.bean.BaseUtBean device;
    public java.util.List<com.alimm.tanx.core.ut.bean.UtItemBean> events;
    public java.lang.String reqId;

    public UtBean() {
        this.reqId = uuid();
    }

    public UtBean(com.alimm.tanx.core.ut.bean.BaseUtBean baseUtBean, java.util.List<com.alimm.tanx.core.ut.bean.UtItemBean> list) {
        this.reqId = uuid();
        this.device = baseUtBean;
        this.events = list;
    }

    public UtBean(com.alimm.tanx.core.ut.bean.UtItemBean utItemBean) {
        this.reqId = uuid();
        this.device = new com.alimm.tanx.core.ut.bean.BaseUtBean();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(utItemBean);
        this.events = arrayList;
    }

    public UtBean(java.util.List<com.alimm.tanx.core.ut.bean.UtItemBean> list) {
        this.reqId = uuid();
        this.device = new com.alimm.tanx.core.ut.bean.BaseUtBean();
        this.events = list;
    }

    private java.lang.String uuid() {
        return java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "") + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + (java.lang.System.currentTimeMillis() / 1000);
    }

    public java.lang.String toString() {
        return "UtBean{device=" + this.device + ", events=" + this.events + "} " + super.toString();
    }
}
