package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class bg implements java.lang.Runnable {
    public final /* synthetic */ java.util.concurrent.atomic.AtomicBoolean n;
    public final /* synthetic */ com.moji.mjweather.weather.avatar.AvatarView.PrepareShareListener t;

    public /* synthetic */ bg(java.util.concurrent.atomic.AtomicBoolean atomicBoolean, com.moji.mjweather.weather.avatar.AvatarView.PrepareShareListener prepareShareListener) {
        this.n = atomicBoolean;
        this.t = prepareShareListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.avatar.AvatarView.a(this.n, this.t);
    }
}
