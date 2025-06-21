package com.jd.ad.sdk.jad_zm;

/* loaded from: classes23.dex */
public class jad_hu implements javax.net.ssl.HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return !java.util.Arrays.asList(com.jd.ad.sdk.jad_zm.jad_iv.jad_cp).contains(str);
    }
}
