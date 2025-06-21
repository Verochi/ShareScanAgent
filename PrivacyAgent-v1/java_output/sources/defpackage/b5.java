package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class b5 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.network.AdIndexPriceRequest n;
    public final /* synthetic */ com.moji.mjad.common.network.AdCommonRequestCallBack t;
    public final /* synthetic */ java.lang.String u;

    public /* synthetic */ b5(com.moji.mjad.common.network.AdIndexPriceRequest adIndexPriceRequest, com.moji.mjad.common.network.AdCommonRequestCallBack adCommonRequestCallBack, java.lang.String str) {
        this.n = adIndexPriceRequest;
        this.t = adCommonRequestCallBack;
        this.u = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.network.AdIndexPriceRequest.loadThirdAdData.1.b(this.n, this.t, this.u);
    }
}
