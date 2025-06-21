package defpackage;

/* loaded from: classes10.dex */
public final /* synthetic */ class px1 implements android.view.View.OnClickListener {
    public final /* synthetic */ java.util.ArrayList n;
    public final /* synthetic */ com.moji.postcard.share.PaneShareView t;
    public final /* synthetic */ android.app.Activity u;
    public final /* synthetic */ com.moji.share.entity.ShareContentConfig v;
    public final /* synthetic */ com.moji.postcard.share.OnShareClick w;

    public /* synthetic */ px1(java.util.ArrayList arrayList, com.moji.postcard.share.PaneShareView paneShareView, android.app.Activity activity, com.moji.share.entity.ShareContentConfig shareContentConfig, com.moji.postcard.share.OnShareClick onShareClick) {
        this.n = arrayList;
        this.t = paneShareView;
        this.u = activity;
        this.v = shareContentConfig;
        this.w = onShareClick;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.postcard.share.PaneShareView.a(this.n, this.t, this.u, this.v, this.w, view);
    }
}
