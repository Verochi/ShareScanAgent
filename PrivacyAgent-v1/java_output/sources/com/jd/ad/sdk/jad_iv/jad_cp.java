package com.jd.ad.sdk.jad_iv;

/* loaded from: classes23.dex */
public class jad_cp implements android.view.View.OnAttachStateChangeListener {
    public final /* synthetic */ android.view.View jad_an;
    public final /* synthetic */ com.jd.ad.sdk.jad_iv.jad_dq jad_bo;

    public jad_cp(com.jd.ad.sdk.jad_iv.jad_dq jad_dqVar, android.view.View view) {
        this.jad_bo = jad_dqVar;
        this.jad_an = view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(android.view.View view) {
        com.jd.ad.sdk.jad_iv.jad_er jad_erVar = this.jad_bo.jad_bo;
        if (jad_erVar != null) {
            jad_erVar.sendEmptyMessage(1);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(android.view.View view) {
        android.view.View view2 = this.jad_an;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
        }
    }
}
