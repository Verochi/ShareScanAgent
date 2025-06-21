package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class j22 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.story.ui.PictureStoryActivity n;

    public /* synthetic */ j22(com.moji.newliveview.story.ui.PictureStoryActivity pictureStoryActivity) {
        this.n = pictureStoryActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.story.ui.PictureStoryActivity.m(this.n, (com.moji.http.snsforum.entity.PictureCommentListResult) obj);
    }
}
