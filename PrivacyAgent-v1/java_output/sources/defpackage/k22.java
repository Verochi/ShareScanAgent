package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class k22 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.story.ui.PictureStoryActivity n;

    public /* synthetic */ k22(com.moji.newliveview.story.ui.PictureStoryActivity pictureStoryActivity) {
        this.n = pictureStoryActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.story.ui.PictureStoryActivity.e(this.n, (com.moji.newliveview.detail.data.CommentPraiseData) obj);
    }
}
