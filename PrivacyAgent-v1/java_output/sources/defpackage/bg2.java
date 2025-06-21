package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class bg2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.share.view.newview.SharePlatformNew.IShareClickCallback n;
    public final /* synthetic */ com.moji.share.view.newview.SharePlatformNew t;

    public /* synthetic */ bg2(com.moji.share.view.newview.SharePlatformNew.IShareClickCallback iShareClickCallback, com.moji.share.view.newview.SharePlatformNew sharePlatformNew) {
        this.n = iShareClickCallback;
        this.t = sharePlatformNew;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.share.view.newview.SharePlatformNew.a(this.n, this.t, view);
    }
}
