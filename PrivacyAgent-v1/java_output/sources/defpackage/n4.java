package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class n4 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.weathersence.adavatar.AdAvatarControlImpl n;
    public final /* synthetic */ com.moji.common.area.AreaInfo t;

    public /* synthetic */ n4(com.moji.weathersence.adavatar.AdAvatarControlImpl adAvatarControlImpl, com.moji.common.area.AreaInfo areaInfo) {
        this.n = adAvatarControlImpl;
        this.t = areaInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.weathersence.adavatar.AdAvatarControlImpl.c(this.n, this.t);
    }
}
