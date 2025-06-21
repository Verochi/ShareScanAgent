package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class z4 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.network.AdIndexPriceRequest n;
    public final /* synthetic */ com.moji.mjad.common.network.AdCommonRequestCallBack t;
    public final /* synthetic */ java.lang.String u;
    public final /* synthetic */ com.moji.mjad.enumdata.ERROR_CODE v;

    public /* synthetic */ z4(com.moji.mjad.common.network.AdIndexPriceRequest adIndexPriceRequest, com.moji.mjad.common.network.AdCommonRequestCallBack adCommonRequestCallBack, java.lang.String str, com.moji.mjad.enumdata.ERROR_CODE error_code) {
        this.n = adIndexPriceRequest;
        this.t = adCommonRequestCallBack;
        this.u = str;
        this.v = error_code;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.network.AdIndexPriceRequest.doPriceIndexAd.1.b(this.n, this.t, this.u, this.v);
    }
}
