package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class d5 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.network.AdIndexPriceRequest n;
    public final /* synthetic */ java.lang.String t;
    public final /* synthetic */ java.util.List u;
    public final /* synthetic */ com.moji.mjad.common.network.AdCommonRequestCallBack v;

    public /* synthetic */ d5(com.moji.mjad.common.network.AdIndexPriceRequest adIndexPriceRequest, java.lang.String str, java.util.List list, com.moji.mjad.common.network.AdCommonRequestCallBack adCommonRequestCallBack) {
        this.n = adIndexPriceRequest;
        this.t = str;
        this.u = list;
        this.v = adCommonRequestCallBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.network.AdIndexPriceRequest.sendMsg.1.k(this.n, this.t, this.u, this.v);
    }
}
