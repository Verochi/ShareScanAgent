package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class z12 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.story.ui.PictureStoryActivity n;

    public /* synthetic */ z12(com.moji.newliveview.story.ui.PictureStoryActivity pictureStoryActivity) {
        this.n = pictureStoryActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.story.ui.PictureStoryActivity.i(this.n, (com.moji.http.snsforum.entity.PictureDetailResult) obj);
    }
}
