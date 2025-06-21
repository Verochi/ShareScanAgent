package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class mf implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weather.avatar.AvatarFixHelper n;
    public final /* synthetic */ int t;
    public final /* synthetic */ java.util.concurrent.ArrayBlockingQueue u;

    public /* synthetic */ mf(com.moji.mjweather.weather.avatar.AvatarFixHelper avatarFixHelper, int i, java.util.concurrent.ArrayBlockingQueue arrayBlockingQueue) {
        this.n = avatarFixHelper;
        this.t = i;
        this.u = arrayBlockingQueue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.avatar.AvatarFixHelper.a(this.n, this.t, this.u);
    }
}
