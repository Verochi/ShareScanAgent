package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class q20 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.rainclould.databinding.ActivityDisasterBinding n;
    public final /* synthetic */ android.graphics.Bitmap t;
    public final /* synthetic */ android.graphics.Bitmap u;
    public final /* synthetic */ java.lang.String v;
    public final /* synthetic */ com.moji.rainclould.DisasterActivity w;

    public /* synthetic */ q20(com.moji.rainclould.databinding.ActivityDisasterBinding activityDisasterBinding, android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2, java.lang.String str, com.moji.rainclould.DisasterActivity disasterActivity) {
        this.n = activityDisasterBinding;
        this.t = bitmap;
        this.u = bitmap2;
        this.v = str;
        this.w = disasterActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.rainclould.DisasterActivity.share.1.a(this.n, this.t, this.u, this.v, this.w);
    }
}
