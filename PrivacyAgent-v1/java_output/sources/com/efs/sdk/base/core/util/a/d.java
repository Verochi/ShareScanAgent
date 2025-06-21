package com.efs.sdk.base.core.util.a;

/* loaded from: classes22.dex */
public final class d {
    public com.efs.sdk.base.core.util.a.b a;
    private java.util.List<com.efs.sdk.base.core.util.concurrent.b<com.efs.sdk.base.http.HttpResponse>> b;

    public d(@androidx.annotation.NonNull java.lang.String str) {
        com.efs.sdk.base.core.util.a.b bVar = new com.efs.sdk.base.core.util.a.b();
        this.a = bVar;
        bVar.a = str;
    }

    public final com.efs.sdk.base.core.util.a.c a() {
        com.efs.sdk.base.core.util.a.c cVar = new com.efs.sdk.base.core.util.a.c(this.a);
        java.util.List<com.efs.sdk.base.core.util.concurrent.b<com.efs.sdk.base.http.HttpResponse>> list = this.b;
        if (list != null && list.size() > 0) {
            cVar.a(this.b);
        }
        java.util.List<com.efs.sdk.base.core.util.concurrent.b<com.efs.sdk.base.http.HttpResponse>> httpListenerList = com.efs.sdk.base.http.HttpEnv.getInstance().getHttpListenerList();
        if (httpListenerList != null && httpListenerList.size() > 0) {
            cVar.a(httpListenerList);
        }
        return cVar;
    }

    public final com.efs.sdk.base.core.util.a.d a(@androidx.annotation.NonNull com.efs.sdk.base.http.AbsHttpListener absHttpListener) {
        if (this.b == null) {
            this.b = new java.util.ArrayList(5);
        }
        this.b.add(absHttpListener);
        return this;
    }

    public final com.efs.sdk.base.core.util.a.d a(java.lang.String str, java.lang.String str2) {
        com.efs.sdk.base.core.util.a.b bVar = this.a;
        if (bVar.f == null) {
            bVar.f = new java.util.HashMap(5);
        }
        this.a.f.put(str, str2);
        return this;
    }

    public final com.efs.sdk.base.core.util.a.d a(@androidx.annotation.NonNull java.util.Map<java.lang.String, java.lang.String> map) {
        this.a.b = map;
        return this;
    }
}
