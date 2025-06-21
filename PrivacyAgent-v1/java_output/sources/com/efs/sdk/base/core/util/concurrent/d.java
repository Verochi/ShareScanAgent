package com.efs.sdk.base.core.util.concurrent;

/* loaded from: classes22.dex */
public class d<T> implements java.lang.Runnable {
    private java.util.List<com.efs.sdk.base.core.util.concurrent.b<T>> a = new java.util.ArrayList(5);
    private com.efs.sdk.base.core.util.concurrent.c<T> b;

    public d(@androidx.annotation.NonNull com.efs.sdk.base.core.util.concurrent.c<T> cVar) {
        this.b = cVar;
    }

    public final T a() {
        T t = null;
        try {
            java.util.Iterator<com.efs.sdk.base.core.util.concurrent.b<T>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            t = this.b.a();
            java.util.Iterator<com.efs.sdk.base.core.util.concurrent.b<T>> it2 = this.a.iterator();
            while (it2.hasNext()) {
                it2.next().a(this.b, t);
            }
            java.util.Iterator<com.efs.sdk.base.core.util.concurrent.b<T>> it3 = this.a.iterator();
            while (it3.hasNext()) {
                it3.next().result(t);
            }
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.w("efs.util.concurrent", th);
            java.util.Iterator<com.efs.sdk.base.core.util.concurrent.b<T>> it4 = this.a.iterator();
            while (it4.hasNext()) {
                it4.next();
            }
        }
        return t;
    }

    public final void a(@androidx.annotation.NonNull java.util.List<com.efs.sdk.base.core.util.concurrent.b<T>> list) {
        this.a.addAll(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
