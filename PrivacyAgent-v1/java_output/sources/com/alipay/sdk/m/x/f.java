package com.alipay.sdk.m.x;

/* loaded from: classes.dex */
public class f {
    public java.util.Stack<com.alipay.sdk.m.x.e> a = new java.util.Stack<>();

    public void a() {
        if (b()) {
            return;
        }
        java.util.Iterator<com.alipay.sdk.m.x.e> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.a.clear();
    }

    public void a(com.alipay.sdk.m.x.e eVar) {
        this.a.push(eVar);
    }

    public boolean b() {
        return this.a.isEmpty();
    }

    public com.alipay.sdk.m.x.e c() {
        return this.a.pop();
    }
}
