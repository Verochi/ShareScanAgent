package com.jd.ad.sdk.jad_lu;

/* loaded from: classes23.dex */
public class jad_ly implements java.util.concurrent.Callable<com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt>> {
    public final /* synthetic */ java.io.InputStream jad_an;
    public final /* synthetic */ java.lang.String jad_bo;

    public jad_ly(java.io.InputStream inputStream, java.lang.String str) {
        this.jad_an = inputStream;
        this.jad_bo = str;
    }

    @Override // java.util.concurrent.Callable
    public com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> call() {
        return com.jd.ad.sdk.jad_lu.jad_hu.jad_an(this.jad_an, this.jad_bo);
    }
}
