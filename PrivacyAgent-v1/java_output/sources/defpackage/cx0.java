package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class cx0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.liveview.home.picture.LivePictureFragment n;

    public /* synthetic */ cx0(com.moji.liveview.home.picture.LivePictureFragment livePictureFragment) {
        this.n = livePictureFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.liveview.home.picture.LivePictureFragment.d(this.n, (com.moji.liveview.home.picture.LivePictureListData) obj);
    }
}
