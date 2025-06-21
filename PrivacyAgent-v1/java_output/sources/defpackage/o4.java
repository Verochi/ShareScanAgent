package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class o4 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.weathersence.adavatar.AdAvatarControlImpl n;
    public final /* synthetic */ java.lang.String t;
    public final /* synthetic */ com.moji.weathersence.adavatar.PlayControlData u;
    public final /* synthetic */ com.moji.weathersence.adavatar.PlayCallBack v;

    public /* synthetic */ o4(com.moji.weathersence.adavatar.AdAvatarControlImpl adAvatarControlImpl, java.lang.String str, com.moji.weathersence.adavatar.PlayControlData playControlData, com.moji.weathersence.adavatar.PlayCallBack playCallBack) {
        this.n = adAvatarControlImpl;
        this.t = str;
        this.u = playControlData;
        this.v = playCallBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.weathersence.adavatar.AdAvatarControlImpl.a(this.n, this.t, this.u, this.v);
    }
}
