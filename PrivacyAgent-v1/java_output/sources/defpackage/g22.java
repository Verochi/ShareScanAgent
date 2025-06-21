package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class g22 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.story.ui.PictureStoryActivity n;

    public /* synthetic */ g22(com.moji.newliveview.story.ui.PictureStoryActivity pictureStoryActivity) {
        this.n = pictureStoryActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.story.ui.PictureStoryActivity.o(this.n, (com.moji.newliveview.detail.data.PicturePraiseData) obj);
    }
}
