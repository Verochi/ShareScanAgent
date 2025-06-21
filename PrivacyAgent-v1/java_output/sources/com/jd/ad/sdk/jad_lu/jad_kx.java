package com.jd.ad.sdk.jad_lu;

/* loaded from: classes23.dex */
public class jad_kx implements java.util.concurrent.Callable<com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt>> {
    public final /* synthetic */ java.lang.ref.WeakReference jad_an;
    public final /* synthetic */ android.content.Context jad_bo;
    public final /* synthetic */ int jad_cp;
    public final /* synthetic */ java.lang.String jad_dq;

    public jad_kx(java.lang.ref.WeakReference weakReference, android.content.Context context, int i, java.lang.String str) {
        this.jad_an = weakReference;
        this.jad_bo = context;
        this.jad_cp = i;
        this.jad_dq = str;
    }

    @Override // java.util.concurrent.Callable
    public com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> call() {
        android.content.Context context = (android.content.Context) this.jad_an.get();
        if (context == null) {
            context = this.jad_bo;
        }
        return com.jd.ad.sdk.jad_lu.jad_hu.jad_an(context, this.jad_cp, this.jad_dq);
    }
}
