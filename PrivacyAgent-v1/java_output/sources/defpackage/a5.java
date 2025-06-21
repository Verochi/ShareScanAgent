package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class a5 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon n;
    public final /* synthetic */ com.moji.mjad.common.network.AdIndexPriceRequest t;
    public final /* synthetic */ com.moji.mjad.common.network.AdCommonRequestCallBack u;
    public final /* synthetic */ java.lang.String v;

    public /* synthetic */ a5(com.moji.mjad.common.data.AdCommon adCommon, com.moji.mjad.common.network.AdIndexPriceRequest adIndexPriceRequest, com.moji.mjad.common.network.AdCommonRequestCallBack adCommonRequestCallBack, java.lang.String str) {
        this.n = adCommon;
        this.t = adIndexPriceRequest;
        this.u = adCommonRequestCallBack;
        this.v = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.network.AdIndexPriceRequest.doPriceIndexAd.1.a(this.n, this.t, this.u, this.v);
    }
}
