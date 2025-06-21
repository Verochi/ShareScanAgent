package com.alimm.tanx.core.net.bean;

/* loaded from: classes.dex */
public class BaseResponseBean<T> extends com.alimm.tanx.core.ad.bean.BaseBean {

    @com.alibaba.fastjson.annotation.JSONField(name = "seat")
    private T data;

    @com.alibaba.fastjson.annotation.JSONField(name = "id")
    private int id;
    private int status;

    public T getData() {
        return this.data;
    }

    public int getStatus() {
        return this.status;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
