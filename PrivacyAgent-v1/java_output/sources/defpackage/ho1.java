package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class ho1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.view.multi.MultiChildView n;
    public final /* synthetic */ com.qq.e.ads.nativ.NativeUnifiedADData t;
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon u;

    public /* synthetic */ ho1(com.moji.mjad.common.view.multi.MultiChildView multiChildView, com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData, com.moji.mjad.common.data.AdCommon adCommon) {
        this.n = multiChildView;
        this.t = nativeUnifiedADData;
        this.u = adCommon;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.view.multi.MultiChildView.b(this.n, this.t, this.u);
    }
}
