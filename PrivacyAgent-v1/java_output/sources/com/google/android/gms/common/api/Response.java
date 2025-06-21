package com.google.android.gms.common.api;

/* loaded from: classes22.dex */
public class Response<T extends com.google.android.gms.common.api.Result> {
    public T a;

    public Response() {
    }

    public Response(@androidx.annotation.RecentlyNonNull T t) {
        this.a = t;
    }

    @androidx.annotation.NonNull
    public T getResult() {
        return this.a;
    }

    public void setResult(@androidx.annotation.RecentlyNonNull T t) {
        this.a = t;
    }
}
