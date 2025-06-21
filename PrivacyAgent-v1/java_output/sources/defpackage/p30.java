package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class p30 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.snsforum.v9.entity.LiveDiscoverResult n;
    public final /* synthetic */ int t;
    public final /* synthetic */ androidx.fragment.app.FragmentActivity u;

    public /* synthetic */ p30(com.moji.http.snsforum.v9.entity.LiveDiscoverResult liveDiscoverResult, int i, androidx.fragment.app.FragmentActivity fragmentActivity) {
        this.n = liveDiscoverResult;
        this.t = i;
        this.u = fragmentActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview.home.discover.ui.DiscoverFragment.i(this.n, this.t, this.u, view);
    }
}
