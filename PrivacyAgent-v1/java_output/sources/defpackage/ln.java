package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class ln implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon n;
    public final /* synthetic */ com.moji.launchserver.AdCommonInterface.AdPosition t;
    public final /* synthetic */ com.moji.mjad.third.CheckAdMaterial u;
    public final /* synthetic */ java.util.List v;
    public final /* synthetic */ java.lang.String w;
    public final /* synthetic */ com.moji.mjad.common.network.ISDKRequestCallBack x;

    public /* synthetic */ ln(com.moji.mjad.common.data.AdCommon adCommon, com.moji.launchserver.AdCommonInterface.AdPosition adPosition, com.moji.mjad.third.CheckAdMaterial checkAdMaterial, java.util.List list, java.lang.String str, com.moji.mjad.common.network.ISDKRequestCallBack iSDKRequestCallBack) {
        this.n = adCommon;
        this.t = adPosition;
        this.u = checkAdMaterial;
        this.v = list;
        this.w = str;
        this.x = iSDKRequestCallBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.third.CheckAdMaterial.a(this.n, this.t, this.u, this.v, this.w, this.x);
    }
}
