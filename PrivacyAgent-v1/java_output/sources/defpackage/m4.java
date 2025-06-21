package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class m4 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.weathersence.adavatar.AdAvatarControlImpl n;
    public final /* synthetic */ java.lang.String t;
    public final /* synthetic */ java.lang.String u;
    public final /* synthetic */ java.lang.String v;
    public final /* synthetic */ com.moji.weathersence.adavatar.LoadAdMonaResourceCallback w;

    public /* synthetic */ m4(com.moji.weathersence.adavatar.AdAvatarControlImpl adAvatarControlImpl, java.lang.String str, java.lang.String str2, java.lang.String str3, com.moji.weathersence.adavatar.LoadAdMonaResourceCallback loadAdMonaResourceCallback) {
        this.n = adAvatarControlImpl;
        this.t = str;
        this.u = str2;
        this.v = str3;
        this.w = loadAdMonaResourceCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.weathersence.adavatar.AdAvatarControlImpl.b(this.n, this.t, this.u, this.v, this.w);
    }
}
