package com.jd.ad.sdk.jad_lu;

/* loaded from: classes23.dex */
public class jad_jw implements java.util.concurrent.Callable<com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt>> {
    public final /* synthetic */ android.content.Context jad_an;
    public final /* synthetic */ java.lang.String jad_bo;
    public final /* synthetic */ java.lang.String jad_cp;

    public jad_jw(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.jad_an = context;
        this.jad_bo = str;
        this.jad_cp = str2;
    }

    @Override // java.util.concurrent.Callable
    public com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> call() {
        return com.jd.ad.sdk.jad_lu.jad_hu.jad_an(this.jad_an, this.jad_bo, this.jad_cp);
    }
}
