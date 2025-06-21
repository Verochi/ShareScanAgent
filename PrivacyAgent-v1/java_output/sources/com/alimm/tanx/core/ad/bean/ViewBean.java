package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class ViewBean extends com.alimm.tanx.core.ad.bean.BaseBean {
    private int id;
    private java.lang.String msg;
    private android.view.View view;

    public ViewBean(int i, android.view.View view, java.lang.String str) {
        this.id = i;
        this.view = view;
        this.msg = str;
    }

    public int getId() {
        return this.id;
    }

    public java.lang.String getMsg() {
        return this.msg;
    }

    public android.view.View getView() {
        return this.view;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setMsg(java.lang.String str) {
        this.msg = str;
    }

    public void setView(android.view.View view) {
        this.view = view;
    }
}
