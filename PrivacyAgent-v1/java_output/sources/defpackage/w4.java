package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class w4 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.network.AdIndexPriceRequest n;
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon t;
    public final /* synthetic */ java.util.List u;
    public final /* synthetic */ java.lang.String v;
    public final /* synthetic */ com.moji.mjad.common.network.AdCommonRequestCallBack w;

    public /* synthetic */ w4(com.moji.mjad.common.network.AdIndexPriceRequest adIndexPriceRequest, com.moji.mjad.common.data.AdCommon adCommon, java.util.List list, java.lang.String str, com.moji.mjad.common.network.AdCommonRequestCallBack adCommonRequestCallBack) {
        this.n = adIndexPriceRequest;
        this.t = adCommon;
        this.u = list;
        this.v = str;
        this.w = adCommonRequestCallBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.network.AdIndexPriceRequest.e(this.n, this.t, this.u, this.v, this.w);
    }
}
