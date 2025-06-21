package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class e5 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.network.AdIndexPriceRequest n;
    public final /* synthetic */ java.util.List t;
    public final /* synthetic */ java.lang.String u;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef v;
    public final /* synthetic */ com.moji.mjad.common.network.AdCommonRequestCallBack w;

    public /* synthetic */ e5(com.moji.mjad.common.network.AdIndexPriceRequest adIndexPriceRequest, java.util.List list, java.lang.String str, kotlin.jvm.internal.Ref.ObjectRef objectRef, com.moji.mjad.common.network.AdCommonRequestCallBack adCommonRequestCallBack) {
        this.n = adIndexPriceRequest;
        this.t = list;
        this.u = str;
        this.v = objectRef;
        this.w = adCommonRequestCallBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.network.AdIndexPriceRequest.sendMsg.1.l(this.n, this.t, this.u, this.v, this.w);
    }
}
