package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class uy0 implements java.lang.Runnable {
    public final /* synthetic */ com.bytedance.sdk.openadsdk.TTAdManager n;
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon t;
    public final /* synthetic */ android.content.Context u;
    public final /* synthetic */ com.moji.mjad.common.network.ISDKRequestCallBack v;
    public final /* synthetic */ java.lang.String w;

    public /* synthetic */ uy0(com.bytedance.sdk.openadsdk.TTAdManager tTAdManager, com.moji.mjad.common.data.AdCommon adCommon, android.content.Context context, com.moji.mjad.common.network.ISDKRequestCallBack iSDKRequestCallBack, java.lang.String str) {
        this.n = tTAdManager;
        this.t = adCommon;
        this.u = context;
        this.v = iSDKRequestCallBack;
        this.w = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.third.toutiao.loader.LoadTouTiaoAd.b(this.n, this.t, this.u, this.v, this.w);
    }
}
