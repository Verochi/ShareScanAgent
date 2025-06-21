package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class h22 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.story.ui.PictureStoryActivity n;

    public /* synthetic */ h22(com.moji.newliveview.story.ui.PictureStoryActivity pictureStoryActivity) {
        this.n = pictureStoryActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.story.ui.PictureStoryActivity.k(this.n, (com.moji.newliveview.detail.data.AddPictureCommentData) obj);
    }
}
