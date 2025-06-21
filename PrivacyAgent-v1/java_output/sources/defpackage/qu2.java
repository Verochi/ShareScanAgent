package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class qu2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weather.avatar.TabAvatarView n;
    public final /* synthetic */ com.moji.mjweather.weather.avatar.AvatarBridge.AvatarModel t;

    public /* synthetic */ qu2(com.moji.mjweather.weather.avatar.TabAvatarView tabAvatarView, com.moji.mjweather.weather.avatar.AvatarBridge.AvatarModel avatarModel) {
        this.n = tabAvatarView;
        this.t = avatarModel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.avatar.TabAvatarView.p0(this.n, this.t);
    }
}
