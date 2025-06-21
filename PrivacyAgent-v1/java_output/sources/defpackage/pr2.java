package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class pr2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.newliveview.story.view.StoryGroupView n;
    public final /* synthetic */ android.content.Context t;

    public /* synthetic */ pr2(com.moji.newliveview.story.view.StoryGroupView storyGroupView, android.content.Context context) {
        this.n = storyGroupView;
        this.t = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.newliveview.story.view.StoryGroupView.a(this.n, this.t);
    }
}
