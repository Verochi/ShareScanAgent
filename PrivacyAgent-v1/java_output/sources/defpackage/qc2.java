package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class qc2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.sdk.SDKInitHelper n;
    public final /* synthetic */ android.content.Context t;
    public final /* synthetic */ boolean u;
    public final /* synthetic */ boolean v;
    public final /* synthetic */ java.lang.String w;
    public final /* synthetic */ java.lang.String x;

    public /* synthetic */ qc2(com.moji.mjweather.sdk.SDKInitHelper sDKInitHelper, android.content.Context context, boolean z, boolean z2, java.lang.String str, java.lang.String str2) {
        this.n = sDKInitHelper;
        this.t = context;
        this.u = z;
        this.v = z2;
        this.w = str;
        this.x = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.sdk.SDKInitHelper.a(this.n, this.t, this.u, this.v, this.w, this.x);
    }
}
