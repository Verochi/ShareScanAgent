package com.meizu.cloud.pushsdk.b;

/* loaded from: classes23.dex */
public class h<T> {
    private T a;
    private T b;

    public h(T t) {
        if (t == null) {
            throw new java.lang.RuntimeException("proxy must be has a default implementation");
        }
        this.b = t;
    }

    public T c() {
        T t = this.a;
        return t != null ? t : this.b;
    }
}
