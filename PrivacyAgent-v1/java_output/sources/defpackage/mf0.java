package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class mf0 implements java.lang.Runnable {
    public final /* synthetic */ java.lang.String n;
    public final /* synthetic */ com.moji.mjfloatball.FloatBallPermissionActivity t;
    public final /* synthetic */ java.lang.String u;

    public /* synthetic */ mf0(java.lang.String str, com.moji.mjfloatball.FloatBallPermissionActivity floatBallPermissionActivity, java.lang.String str2) {
        this.n = str;
        this.t = floatBallPermissionActivity;
        this.u = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjfloatball.FloatBallPermissionActivity.b(this.n, this.t, this.u);
    }
}
