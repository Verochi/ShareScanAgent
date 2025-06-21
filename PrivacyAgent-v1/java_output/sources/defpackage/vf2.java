package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class vf2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.newliveview.story.utils.ShareHelper n;
    public final /* synthetic */ com.moji.base.MJActivity t;
    public final /* synthetic */ java.lang.String u;
    public final /* synthetic */ com.moji.http.snsforum.entity.PictureDetail v;
    public final /* synthetic */ android.graphics.Bitmap w;
    public final /* synthetic */ java.lang.String x;
    public final /* synthetic */ java.lang.String y;

    public /* synthetic */ vf2(com.moji.newliveview.story.utils.ShareHelper shareHelper, com.moji.base.MJActivity mJActivity, java.lang.String str, com.moji.http.snsforum.entity.PictureDetail pictureDetail, android.graphics.Bitmap bitmap, java.lang.String str2, java.lang.String str3) {
        this.n = shareHelper;
        this.t = mJActivity;
        this.u = str;
        this.v = pictureDetail;
        this.w = bitmap;
        this.x = str2;
        this.y = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.newliveview.story.utils.ShareHelper.a(this.n, this.t, this.u, this.v, this.w, this.x, this.y);
    }
}
