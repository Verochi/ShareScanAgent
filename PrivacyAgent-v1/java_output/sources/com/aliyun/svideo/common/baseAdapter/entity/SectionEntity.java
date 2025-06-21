package com.aliyun.svideo.common.baseAdapter.entity;

/* loaded from: classes.dex */
public abstract class SectionEntity<T> implements java.io.Serializable {
    public java.lang.String header;
    public boolean isHeader;
    public T t;

    public SectionEntity(T t) {
        this.isHeader = false;
        this.header = null;
        this.t = t;
    }

    public SectionEntity(boolean z, java.lang.String str) {
        this.isHeader = z;
        this.header = str;
        this.t = null;
    }

    public void setT(T t) {
        this.t = t;
    }
}
