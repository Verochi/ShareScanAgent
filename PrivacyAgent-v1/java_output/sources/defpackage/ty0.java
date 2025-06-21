package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class ty0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.third.toutiao.loader.LoadTouTiaoAd n;
    public final /* synthetic */ android.content.Context t;
    public final /* synthetic */ java.lang.String u;
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon v;
    public final /* synthetic */ com.moji.mjad.common.network.ISDKRequestCallBack w;

    public /* synthetic */ ty0(com.moji.mjad.third.toutiao.loader.LoadTouTiaoAd loadTouTiaoAd, android.content.Context context, java.lang.String str, com.moji.mjad.common.data.AdCommon adCommon, com.moji.mjad.common.network.ISDKRequestCallBack iSDKRequestCallBack) {
        this.n = loadTouTiaoAd;
        this.t = context;
        this.u = str;
        this.v = adCommon;
        this.w = iSDKRequestCallBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.third.toutiao.loader.LoadTouTiaoAd.a(this.n, this.t, this.u, this.v, this.w);
    }
}
