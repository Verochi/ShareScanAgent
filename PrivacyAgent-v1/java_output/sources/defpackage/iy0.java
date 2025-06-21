package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class iy0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.near.LiveViewNearFragment n;

    public /* synthetic */ iy0(com.moji.newliveview.near.LiveViewNearFragment liveViewNearFragment) {
        this.n = liveViewNearFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.near.LiveViewNearFragment.c(this.n, (com.moji.location.entity.MJLocation) obj);
    }
}
