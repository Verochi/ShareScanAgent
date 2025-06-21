package com.umeng.umzid;

/* loaded from: classes19.dex */
public class b implements javax.net.ssl.HostnameVerifier {
    public final /* synthetic */ java.lang.String a;

    public b(java.lang.String str) {
        this.a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return this.a.equalsIgnoreCase(str) || "pre-aaid.umeng.com".equalsIgnoreCase(str);
    }
}
