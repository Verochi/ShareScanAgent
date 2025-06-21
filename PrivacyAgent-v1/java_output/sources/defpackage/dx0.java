package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class dx0 implements android.view.View.OnClickListener {
    public final /* synthetic */ android.view.View n;
    public final /* synthetic */ com.moji.liveview.base.view.slideshow.LiveSlideshowHolder t;

    public /* synthetic */ dx0(android.view.View view, com.moji.liveview.base.view.slideshow.LiveSlideshowHolder liveSlideshowHolder) {
        this.n = view;
        this.t = liveSlideshowHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview.base.view.slideshow.LiveSlideshowHolder.a(this.n, this.t, view);
    }
}
