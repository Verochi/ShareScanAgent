package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class nf0 implements android.app.AppOpsManager.OnOpChangedListener {
    public final /* synthetic */ com.moji.mjfloatball.FloatBallPermissionActivity a;

    public /* synthetic */ nf0(com.moji.mjfloatball.FloatBallPermissionActivity floatBallPermissionActivity) {
        this.a = floatBallPermissionActivity;
    }

    @Override // android.app.AppOpsManager.OnOpChangedListener
    public final void onOpChanged(java.lang.String str, java.lang.String str2) {
        com.moji.mjfloatball.FloatBallPermissionActivity.access$onAppOpsChange(this.a, str, str2);
    }
}
