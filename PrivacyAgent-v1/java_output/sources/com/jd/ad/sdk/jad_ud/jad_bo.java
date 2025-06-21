package com.jd.ad.sdk.jad_ud;

/* loaded from: classes23.dex */
public class jad_bo {
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_ud.jad_an jad_an(@androidx.annotation.NonNull java.lang.String str) {
        javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) new java.net.URL(str).openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.connect();
        return new com.jd.ad.sdk.jad_ud.jad_an(httpsURLConnection);
    }
}
