package com.qq.e.ads.nativ;

/* loaded from: classes19.dex */
public abstract class NativeADEventListenerWithClickInfo implements com.qq.e.ads.nativ.NativeADEventListener {
    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public final void onADClicked() {
    }

    public abstract void onADClicked(android.view.View view);
}
