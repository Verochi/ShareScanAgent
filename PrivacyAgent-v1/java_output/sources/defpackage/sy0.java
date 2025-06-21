package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class sy0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.third.topon.LoadTopOnAd n;
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon t;
    public final /* synthetic */ com.moji.mjad.common.network.ISDKRequestCallBack u;
    public final /* synthetic */ java.lang.String v;

    public /* synthetic */ sy0(com.moji.mjad.third.topon.LoadTopOnAd loadTopOnAd, com.moji.mjad.common.data.AdCommon adCommon, com.moji.mjad.common.network.ISDKRequestCallBack iSDKRequestCallBack, java.lang.String str) {
        this.n = loadTopOnAd;
        this.t = adCommon;
        this.u = iSDKRequestCallBack;
        this.v = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.third.topon.LoadTopOnAd.a(this.n, this.t, this.u, this.v);
    }
}
