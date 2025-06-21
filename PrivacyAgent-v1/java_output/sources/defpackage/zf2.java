package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class zf2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.share.view.SharePlatform n;
    public final /* synthetic */ com.moji.share.view.SharePlatform.IShareClickCallback t;

    public /* synthetic */ zf2(com.moji.share.view.SharePlatform sharePlatform, com.moji.share.view.SharePlatform.IShareClickCallback iShareClickCallback) {
        this.n = sharePlatform;
        this.t = iShareClickCallback;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.share.view.SharePlatform.b(this.n, this.t, view);
    }
}
