package com.efs.sdk.base.core.util.a;

/* loaded from: classes22.dex */
public final class c extends com.efs.sdk.base.core.util.concurrent.d<com.efs.sdk.base.http.HttpResponse> {
    public com.efs.sdk.base.core.util.a.b a;

    public c(@androidx.annotation.NonNull com.efs.sdk.base.core.util.a.b bVar) {
        super(bVar);
        this.a = bVar;
    }

    @androidx.annotation.NonNull
    public final com.efs.sdk.base.http.HttpResponse b() {
        this.a.e = "post";
        return a();
    }
}
