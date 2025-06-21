package com.efs.sdk.base.core.util.a;

/* loaded from: classes22.dex */
public final class b implements com.efs.sdk.base.core.util.concurrent.c<com.efs.sdk.base.http.HttpResponse> {
    java.lang.String a;
    java.util.Map<java.lang.String, java.lang.String> b;
    public byte[] c;
    public java.io.File d;
    public java.lang.String e;
    public java.util.Map<java.lang.String, java.lang.String> f;
    public boolean g = false;

    @Override // com.efs.sdk.base.core.util.concurrent.c
    @androidx.annotation.Nullable
    public final /* synthetic */ com.efs.sdk.base.http.HttpResponse a() {
        java.lang.String str = this.e;
        str.hashCode();
        if (str.equals(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET)) {
            return com.efs.sdk.base.http.HttpEnv.getInstance().getHttpUtil().get(this.a, this.b);
        }
        if (str.equals("post")) {
            byte[] bArr = this.c;
            return (bArr == null || bArr.length <= 0) ? com.efs.sdk.base.http.HttpEnv.getInstance().getHttpUtil().post(this.a, this.b, this.d) : this.g ? com.efs.sdk.base.http.HttpEnv.getInstance().getHttpUtil().postAsFile(this.a, this.b, this.c) : com.efs.sdk.base.http.HttpEnv.getInstance().getHttpUtil().post(this.a, this.b, this.c);
        }
        com.efs.sdk.base.core.util.Log.e("efs.util.http", "request not support method '" + this.e + "'");
        return null;
    }
}
