package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class qr implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.view.CommonAdView n;
    public final /* synthetic */ com.qq.e.ads.nativ.NativeUnifiedADData t;
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon u;

    public /* synthetic */ qr(com.moji.mjad.common.view.CommonAdView commonAdView, com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData, com.moji.mjad.common.data.AdCommon adCommon) {
        this.n = commonAdView;
        this.t = nativeUnifiedADData;
        this.u = adCommon;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.view.CommonAdView.f(this.n, this.t, this.u);
    }
}
