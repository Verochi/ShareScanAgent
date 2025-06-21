package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class vw0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.liveview.home.picture.LiveDiscoverPictureFragment n;

    public /* synthetic */ vw0(com.moji.liveview.home.picture.LiveDiscoverPictureFragment liveDiscoverPictureFragment) {
        this.n = liveDiscoverPictureFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.liveview.home.picture.LiveDiscoverPictureFragment.e(this.n, (com.moji.liveview.home.picture.LiveDiscoverPictureListData) obj);
    }
}
