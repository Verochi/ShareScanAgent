package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class dg implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weather.window.AvatarWindowManager n;
    public final /* synthetic */ boolean t;

    public /* synthetic */ dg(com.moji.mjweather.weather.window.AvatarWindowManager avatarWindowManager, boolean z) {
        this.n = avatarWindowManager;
        this.t = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.window.AvatarWindowManager.a(this.n, this.t);
    }
}
