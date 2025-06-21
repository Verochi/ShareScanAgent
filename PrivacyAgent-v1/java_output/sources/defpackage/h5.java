package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class h5 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjad.view.AdLastFrameView n;
    public final /* synthetic */ com.moji.mjad.view.AbsAdLastFrameView.ILastFrameClick t;

    public /* synthetic */ h5(com.moji.mjad.view.AdLastFrameView adLastFrameView, com.moji.mjad.view.AbsAdLastFrameView.ILastFrameClick iLastFrameClick) {
        this.n = adLastFrameView;
        this.t = iLastFrameClick;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjad.view.AdLastFrameView.b(this.n, this.t, view);
    }
}
