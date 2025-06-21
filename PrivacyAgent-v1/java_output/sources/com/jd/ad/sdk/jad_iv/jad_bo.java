package com.jd.ad.sdk.jad_iv;

/* loaded from: classes23.dex */
public class jad_bo implements android.view.View.OnAttachStateChangeListener {
    public final /* synthetic */ android.view.View jad_an;

    public jad_bo(com.jd.ad.sdk.jad_iv.jad_dq jad_dqVar, android.view.View view) {
        this.jad_an = view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(android.view.View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(android.view.View view) {
        android.view.View view2 = this.jad_an;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
        }
    }
}
