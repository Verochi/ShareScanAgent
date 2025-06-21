package com.jd.ad.sdk.jad_s_an;

/* loaded from: classes23.dex */
public class jad_s_hu implements android.view.View.OnTouchListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_hu(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getTouchService().onViewTouch(view, motionEvent, this.jad_s_an.jad_s_dq);
        return false;
    }
}
