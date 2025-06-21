package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class ax0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.liveview.home.picture.LiveNearPictureFragment n;

    public /* synthetic */ ax0(com.moji.liveview.home.picture.LiveNearPictureFragment liveNearPictureFragment) {
        this.n = liveNearPictureFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.liveview.home.picture.LiveNearPictureFragment.e(this.n, (com.moji.location.entity.MJLocation) obj);
    }
}
