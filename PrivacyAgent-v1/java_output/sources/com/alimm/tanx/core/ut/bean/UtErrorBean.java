package com.alimm.tanx.core.ut.bean;

/* loaded from: classes.dex */
public class UtErrorBean extends com.alimm.tanx.core.ad.bean.BaseBean {
    public int errorCode;
    public java.lang.String msg;
    public com.alimm.tanx.core.net.bean.RequestBean requestBean;

    public UtErrorBean() {
    }

    public UtErrorBean(com.alimm.tanx.core.net.bean.RequestBean requestBean, int i, java.lang.String str) {
        this.requestBean = requestBean;
        this.errorCode = i;
        this.msg = str;
    }

    public java.lang.String toString() {
        return "UtErrorBean{requestBean=" + this.requestBean + ", errorCode='" + this.errorCode + "', msg='" + this.msg + "'} ";
    }
}
