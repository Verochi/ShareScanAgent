package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class hy0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.near.LiveViewNearFragment n;

    public /* synthetic */ hy0(com.moji.newliveview.near.LiveViewNearFragment liveViewNearFragment) {
        this.n = liveViewNearFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.near.LiveViewNearFragment.e(this.n, (com.moji.http.snsforum.entity.NearLiveResult) obj);
    }
}
