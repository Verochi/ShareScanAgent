package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ox1 implements android.view.View.OnClickListener {
    public final /* synthetic */ java.util.ArrayList n;
    public final /* synthetic */ com.moji.share.pane.PaneShareView t;
    public final /* synthetic */ android.app.Activity u;
    public final /* synthetic */ com.moji.share.entity.ShareContentConfig v;
    public final /* synthetic */ com.moji.share.pane.OnPaneShareMutual w;

    public /* synthetic */ ox1(java.util.ArrayList arrayList, com.moji.share.pane.PaneShareView paneShareView, android.app.Activity activity, com.moji.share.entity.ShareContentConfig shareContentConfig, com.moji.share.pane.OnPaneShareMutual onPaneShareMutual) {
        this.n = arrayList;
        this.t = paneShareView;
        this.u = activity;
        this.v = shareContentConfig;
        this.w = onPaneShareMutual;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.share.pane.PaneShareView.a(this.n, this.t, this.u, this.v, this.w, view);
    }
}
