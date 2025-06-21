package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class l12 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.detail.PictureDetailFragmentV2 n;

    public /* synthetic */ l12(com.moji.newliveview.detail.PictureDetailFragmentV2 pictureDetailFragmentV2) {
        this.n = pictureDetailFragmentV2;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.detail.PictureDetailFragmentV2.c(this.n, (com.moji.newliveview.detail.data.PicturePraiseData) obj);
    }
}
