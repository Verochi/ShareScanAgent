package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class jr implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.control.CommonAdControl n;
    public final /* synthetic */ com.qq.e.ads.nativ.NativeUnifiedADData t;
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon u;
    public final /* synthetic */ boolean v;

    public /* synthetic */ jr(com.moji.mjad.common.control.CommonAdControl commonAdControl, com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData, com.moji.mjad.common.data.AdCommon adCommon, boolean z) {
        this.n = commonAdControl;
        this.t = nativeUnifiedADData;
        this.u = adCommon;
        this.v = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.control.CommonAdControl.e(this.n, this.t, this.u, this.v);
    }
}
