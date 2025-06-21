package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes12.dex */
public class EffectBody<T> {
    private boolean isLoading = false;
    private boolean isLocal;
    private T mData;

    public EffectBody(T t, boolean z) {
        this.mData = t;
        this.isLocal = z;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.aliyun.svideo.editor.effectmanager.EffectBody effectBody = (com.aliyun.svideo.editor.effectmanager.EffectBody) obj;
        T t = this.mData;
        return t != null ? t.equals(effectBody.mData) : super.equals(obj);
    }

    public T getData() {
        return this.mData;
    }

    public int hashCode() {
        T t = this.mData;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public boolean isLocal() {
        return this.isLocal;
    }

    public void setData(T t) {
        this.mData = t;
    }

    public void setLoading(boolean z) {
        this.isLoading = z;
    }

    public void setLocal(boolean z) {
        this.isLocal = z;
    }
}
