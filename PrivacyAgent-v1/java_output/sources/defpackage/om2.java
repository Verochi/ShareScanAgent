package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class om2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.skywatchers.home.ui.SkyWatchersPictureFragment n;

    public /* synthetic */ om2(com.moji.skywatchers.home.ui.SkyWatchersPictureFragment skyWatchersPictureFragment) {
        this.n = skyWatchersPictureFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.skywatchers.home.ui.SkyWatchersPictureFragment.a(this.n, (com.moji.http.skywatchers.entity.SkyWatchersPictureListResult) obj);
    }
}
