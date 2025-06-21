package com.jd.ad.sdk.jad_n_an;

/* loaded from: classes23.dex */
public class jad_n_bo implements android.view.View.OnAttachStateChangeListener {
    public final /* synthetic */ com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_an;

    public jad_n_bo(com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_anVar) {
        this.jad_n_an = jad_n_anVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(android.view.View view) {
        this.jad_n_an.jad_n_an();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(android.view.View view) {
        this.jad_n_an.jad_n_bo();
    }
}
