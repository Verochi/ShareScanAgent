package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class jm2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.skywatchers.home.ui.SkyWatchersHomeActivity n;

    public /* synthetic */ jm2(com.moji.skywatchers.home.ui.SkyWatchersHomeActivity skyWatchersHomeActivity) {
        this.n = skyWatchersHomeActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.skywatchers.home.ui.SkyWatchersHomeActivity.e(this.n, (com.moji.http.skywatchers.entity.SkyWatchersHomeResult) obj);
    }
}
