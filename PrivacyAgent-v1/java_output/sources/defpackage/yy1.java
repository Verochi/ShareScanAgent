package defpackage;

/* loaded from: classes9.dex */
public final /* synthetic */ class yy1 implements android.content.DialogInterface.OnDismissListener {
    public final /* synthetic */ com.moji.notificationpermissions.PermissionsGuideHelper n;

    public /* synthetic */ yy1(com.moji.notificationpermissions.PermissionsGuideHelper permissionsGuideHelper) {
        this.n = permissionsGuideHelper;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        com.moji.notificationpermissions.PermissionsGuideHelper.a(this.n, dialogInterface);
    }
}
