package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class g5 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjad.view.AdLastFrameView n;
    public final /* synthetic */ com.moji.mjad.view.AdLastFrameView.IGoOnPlayingVideo t;

    public /* synthetic */ g5(com.moji.mjad.view.AdLastFrameView adLastFrameView, com.moji.mjad.view.AdLastFrameView.IGoOnPlayingVideo iGoOnPlayingVideo) {
        this.n = adLastFrameView;
        this.t = iGoOnPlayingVideo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjad.view.AdLastFrameView.a(this.n, this.t, view);
    }
}
