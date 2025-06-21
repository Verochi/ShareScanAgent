package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class c5 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon n;
    public final /* synthetic */ com.moji.mjad.common.network.AdIndexPriceRequest t;
    public final /* synthetic */ java.lang.String u;
    public final /* synthetic */ com.moji.mjad.common.network.AdCommonRequestCallBack v;
    public final /* synthetic */ java.util.List w;

    public /* synthetic */ c5(com.moji.mjad.common.data.AdCommon adCommon, com.moji.mjad.common.network.AdIndexPriceRequest adIndexPriceRequest, java.lang.String str, com.moji.mjad.common.network.AdCommonRequestCallBack adCommonRequestCallBack, java.util.List list) {
        this.n = adCommon;
        this.t = adIndexPriceRequest;
        this.u = str;
        this.v = adCommonRequestCallBack;
        this.w = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.network.AdIndexPriceRequest.loadThirdAdData.1.a(this.n, this.t, this.u, this.v, this.w);
    }
}
